package com.vigna.business.sys.service.impl;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.vigna.business.sys.domain.SysRole;
import com.vigna.business.sys.mapper.SysRoleMapper;
import com.vigna.business.sys.service.SysRoleService;
import com.vigna.business.sys.vo.SysRoleVO;
import com.vigna.common.api.Result;
import com.vigna.common.enums.StatusEnums;
import com.vigna.common.exception.GlobalException;
import com.vigna.common.exception.GlobalExceptionEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole>
        implements SysRoleService {

    @Override
    public Page<SysRole> getPage(Map<String, Object> params) {
        return null;
    }

    @Override
    public Result<List<SysRoleVO>> getAllRoles(String authorizationHeader) {
//        if (authorizationHeader == null || !authorizationHeader.startsWith(jwtTokenUtil.getTokenHead())) {
//            throw new GlobalException(GlobalExceptionEnum.ERROR_UNAUTHORIZED.getMessage());
//        }

        List<SysRoleVO> sysRoleVOS = new ArrayList<>();

//        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(SysRole::getStatus, StatusEnums.ENABLE.getKey());

//        List<SysRole> list = list(wrapper);
//        if (!list.isEmpty()) {
//            for (SysRole sysRole : list) {
//                SysRoleVO sysRoleVO = new SysRoleVO();
//                sysRoleVO.setRoleName(sysRole.getRoleName());
//                sysRoleVO.setRoleCode(sysRole.getRoleCode());
//                sysRoleVO.setRoleDesc(sysRole.getRoleDesc());
//                sysRoleVOS.add(sysRoleVO);
//            }
//            return Result.success(sysRoleVOS);
//        }
        return Result.success();
    }

}