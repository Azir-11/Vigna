package com.vigna.business.sys.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
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

//    final SysRoleService sysRoleService;
    private final SysUserMapper sysUserMapper;

//    加密盐
    String EncryptionKey = "Azir-11";

    public SysUserServiceImpl(SysUserMapper sysUserMapper){
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
        sysUser.setLastLoginIp(IpUtil.getHostIp());
        sysUser.setLastLoginTime(DateUtil.date().toLocalDateTime());
        updateById(sysUser);
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
        }
        catch (Exception e) {
            log.error("登录异常: {}", e.getMessage());
            throw new GlobalException(e.getMessage());
        }

    }

    public SysUser getByName(String nickName) {
//        return getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getNickName, nickName));
        return new SysUser();
    }

    public SysUser getByUsername(String userName) {
//        return getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUserName, userName));
        return new SysUser();
    }

    private Result<String> checkoutUser(CreateUserParam userParam) {
        String password = userParam.getPassword();
        if (StrUtil.isEmpty(password)) {
            return Result.failed(ResultCode.ERROR_USER_NAME_REPEAT);
        }

        SysUser dbUserNameInfo;

        dbUserNameInfo = getByName(userParam.getNickName());
        if (dbUserNameInfo != null) {
            return Result.failed(ResultCode.ERROR_NAME_REPEAT);
        }

        dbUserNameInfo = getByUsername(userParam.getUserName());
        if (dbUserNameInfo != null) {
            return Result.failed(ResultCode.ERROR_USER_NAME_REPEAT);
        }
        return Result.success();
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean insertUser(CreateUserParam createUserParam) {
        SysUser user = new SysUser();
        String password = createUserParam.getPassword();
        // 处理加密密码
//        String enPassword = encoder.encode(password);

        user.setNickName(createUserParam.getNickName());
        user.setUserName(createUserParam.getUserName());
//        user.setPassword(enPassword);
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
    public Result<UserInfoVO> getUserInfo(String authorizationHeader) {
//        if (authorizationHeader == null || !authorizationHeader.startsWith(jwtTokenUtil.getTokenHead())) {
//            throw new GlobalException(GlobalExceptionEnum.ERROR_UNAUTHORIZED.getMessage());
//        }

        UserInfoVO userInfoVO = new UserInfoVO();

//        try {
//            String authToken = authorizationHeader.substring(jwtTokenUtil.getTokenHead().length());
//            String username = jwtTokenUtil.getUserNameFromToken(authToken);
//            if (username != null) {
//                // 从数据库中获取用户信息
//                SysUserDetail userDetails = (SysUserDetail) this.userDetailsService
//                        .loadUserByUsername(username);
//
//                userInfoVO.setRoles(userDetails.getRoles());
//                userInfoVO.setUserName(userDetails.getUsername());
//                userInfoVO.setUserId(userDetails.getSysUser().getId());
//
//                return Result.success(userInfoVO);
//            }
//        } catch (Exception e) {
//            log.info("获取用户信息失败: {}", e.getMessage());
//            ExceptionUtil.throwEx(GlobalExceptionEnum.ERROR_UNABLE_GET_USER);
//        }
        return Result.failed();
    }
}
