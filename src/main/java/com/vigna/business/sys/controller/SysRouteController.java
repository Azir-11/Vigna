package com.vigna.business.sys.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.vigna.business.sys.service.SysRouterService;
import com.vigna.business.sys.vo.SysRoutesVO;
import com.vigna.common.api.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "SysRouteController", description = "路由信息控制层")
@RequestMapping("/route")
public class SysRouteController {

    private final SysRouterService sysRouterService;

    @Operation(summary = "查询用户路由信息")
    @GetMapping(value = "/getUserRoutes")
    @SaCheckLogin
    public Result<Map<String, Object>> getUserRoutes() {
        return sysRouterService.getUserRoutes();
    }

    @Operation(summary = "查询基础路由信息")
    @GetMapping(value = "/getConstantRoutes")
    public Result<List<SysRoutesVO>> getConstantRoutes() {
        return sysRouterService.getConstantRoutes();
    }

}
