package com.vigna.business.auth.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.hutool.core.util.StrUtil;
import com.vigna.business.auth.param.SysUserLoginParam;
import com.vigna.business.auth.param.SysUserRefreshTokenParam;
import com.vigna.business.auth.vo.LoginResult;
import com.vigna.business.sys.service.SysUserService;
import com.vigna.business.sys.vo.UserInfoVO;
import com.vigna.common.annotation.SysLogInterface;
import com.vigna.common.api.Result;
import com.vigna.common.enums.BusinessType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "权限模块")
@RequestMapping("/auth")
public class SysUserLoginController {

    private final SysUserService sysUserService;

    @Operation(summary = "登录")
    @PostMapping(value = "/login")
    @SysLogInterface(title = "登录", businessType = BusinessType.GRANT)
    public Result<LoginResult> login(@RequestBody SysUserLoginParam sysUserLoginParam) {
//        TODO: 验证码校验
        return Result.success(sysUserService.login(sysUserLoginParam.getUserName(),
                sysUserLoginParam.getPassword()));
    }

    @Operation(summary = "刷新token")
    @PostMapping(value = "/refreshToken")
    @SysLogInterface(title = "刷新token", businessType = BusinessType.GRANT)
    public Result<LoginResult> refreshToken(@RequestBody SysUserRefreshTokenParam refreshToken) {
        if (StrUtil.isBlank(refreshToken.getRefreshToken())) {
            return Result.failed("refreshToken必填");
        }
//        TODO： 校验refreshToken的有效期
        return Result.success(sysUserService.refreshToken(refreshToken.getRefreshToken()));
    }


    @Operation(summary = "获取用户信息")
    @GetMapping(value = "/getUserInfo")
    @SaCheckLogin
    public Result<UserInfoVO> getUserInfo() {
        return sysUserService.getUserInfo();
    }

}
