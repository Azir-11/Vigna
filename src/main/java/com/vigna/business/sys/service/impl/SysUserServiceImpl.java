package com.vigna.business.sys.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.update.UpdateChain;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.vigna.business.auth.vo.LoginResult;
import com.vigna.business.sys.domain.SysUser;
import com.vigna.business.sys.mapper.SysUserMapper;
import com.vigna.business.sys.param.CreateUserParam;
import com.vigna.business.sys.service.SysUserService;
import com.vigna.business.sys.vo.SysUserVO;
import com.vigna.business.sys.vo.UserInfoVO;
import com.vigna.common.api.Result;
import com.vigna.common.api.ResultCode;
import com.vigna.common.enums.CacheConstants;
import com.vigna.common.enums.StatusEnums;
import com.vigna.common.exception.GlobalException;
import com.vigna.common.utils.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Objects;

import static com.vigna.business.sys.tables.TSysUserDef.T_SYS_USER;

@Slf4j
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
        implements SysUserService {

    private final SysUserMapper sysUserMapper;

    //    加密盐
    String EncryptionKey = "Azir-11";

    public SysUserServiceImpl(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    public SysUserVO convertToVO(SysUser sysUser) {
        SysUserVO sysUserVO = new SysUserVO();
        BeanUtil.copyProperties(sysUser, sysUserVO);
        return sysUserVO;
    }

    /**
     * 更新最后一次登录时间/登录IP
     */
    private void updateLastLoginInfo(SysUser sysUser) {
        boolean update = UpdateChain.of(SysUser.class)
                .set(T_SYS_USER.LAST_LOGIN_IP, IpUtil.getHostIp())
                .set(T_SYS_USER.LAST_LOGIN_TIME, DateUtil.date().toLocalDateTime())
                .where(SysUser::getId).eq(sysUser.getId())
                .update();

        if (!update) {
            log.error("更新用户最后登录时间失败");
        }
    }

    @Override
    public Page<SysUserVO> getList(Map<String, Object> params) {
        return null;
    }

    @Override
    @CacheEvict(value = CacheConstants.USER_DETAILS, key = "#username")
    public LoginResult login(String username, String password) {
        try {
            String EncryptionPassword = SaSecureUtil.aesEncrypt(EncryptionKey, password);
            SysUser loginUser = sysUserMapper.selectOneByQuery(QueryWrapper.create()
                    .select()
                    .from(T_SYS_USER)
                    .where(T_SYS_USER.USER_NAME.eq(username))
                    .and(T_SYS_USER.PASSWORD.eq(EncryptionPassword)));

            if (loginUser == null) {
                throw new GlobalException("账号或密码错误");
            }

            StpUtil.login(loginUser.getId());
            String token = StpUtil.getTokenValue();

            // 更新最后一次登录时间
            updateLastLoginInfo(loginUser);

            return new LoginResult(token, token);
        } catch (Exception e) {
            log.error("登录异常: {}", e.getMessage());
            throw new GlobalException(e.getMessage());
        }

    }

    /**
     * 刷新token
     * @param refreshToken 刷新token
     */
    @Override
    public LoginResult refreshToken(String refreshToken) {
        throw new GlobalException("功能暂未开放");
    }

    public SysUser getByName(String nickName) {
        return sysUserMapper.selectOneByQuery(QueryWrapper.create()
                .select()
                .from(T_SYS_USER)
                .where(T_SYS_USER.USER_NAME.eq(nickName)));
    }

    public SysUser getByUsername(String userName) {
        return sysUserMapper.selectOneByQuery(QueryWrapper.create()
                .select()
                .from(T_SYS_USER)
                .where(T_SYS_USER.USER_NAME.eq(userName)));
    }

    private Result<String> checkoutUser(CreateUserParam userParam) {
        String password = userParam.getPassword();
        if (StrUtil.isEmpty(password)) {
            return Result.failed(ResultCode.ERROR_USER_NAME_REPEAT);
        }

//        校验用户名和昵称是否重复
        if (getByName(userParam.getNickName()) != null) {
            return Result.failed(ResultCode.ERROR_NAME_REPEAT);
        }

        if (getByUsername(userParam.getUserName()) != null) {
            return Result.failed(ResultCode.ERROR_USER_NAME_REPEAT);
        }
        return Result.success();
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean insertUser(CreateUserParam createUserParam) {
        SysUser user = new SysUser();
        String password = createUserParam.getPassword();
        // 处理加密密码
        String enPassword = SaSecureUtil.aesEncrypt(EncryptionKey, password);

        user.setNickName(createUserParam.getNickName());
        user.setUserName(createUserParam.getUserName());
        user.setPassword(enPassword);
        user.setStatus(StatusEnums.ENABLE.getKey());

        return save(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<String> createUser(CreateUserParam createUserParam) {
        Result<String> checkoutResult = checkoutUser(createUserParam);
        if (!Objects.equals(checkoutResult.getCode(), ResultCode.SUCCESS.getCode())) {
            return checkoutResult;
        }
        return insertUser(createUserParam) ? Result.success() : Result.failed();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<UserInfoVO> getUserInfo() {
        UserInfoVO userInfoVO = new UserInfoVO();

        Long userId = StpUtil.getLoginIdAsLong();
        SysUser sysUser = sysUserMapper.selectOneById(userId);
        if (sysUser == null) {
            log.error("系统异常，有个用户通过了登录验证，但是在数据库中找不到他的用户信息");
            throw new GlobalException("用户不存在");
        }

        userInfoVO.setRoles(StpUtil.getRoleList());
        userInfoVO.setUserName(sysUser.getUserName());
        userInfoVO.setUserId(userId);

        return Result.success(userInfoVO);
    }
}
