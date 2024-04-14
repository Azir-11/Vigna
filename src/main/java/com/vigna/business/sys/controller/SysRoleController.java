package com.vigna.business.sys.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "SysRoleController", description = "用户角色控制层")
//@RequestMapping("/sys/role")
@RequestMapping("/systemManage")
public class SysRoleController {

//    private final SysRoleService sysRoleService;
//
//    @Operation(summary = "list 分页列表")
//    @Parameters({
//            @Parameter(name = "current", description = "当前页", required = true, example = "1"),
//            @Parameter(name = "size", description = "每页显示条数", required = true, example = "10"),
//            @Parameter(name = "username", description = "用户名称"),
//    })
//    @GetMapping(value = "/getRoleList")
//    public Result<IPage<SysRole>> list(@Parameter(hidden = true) @RequestParam Map<String, Object> params) {
//        IPage<SysRole> sysUsers = sysRoleService.getPage(params);
//        return Result.success(sysUsers);
//    }
//
//    @Operation(summary = "查询角色信息")
//    @GetMapping(value = "/getAllRoles")
//    public Result<List<SysRoleVO>> getAllRoles(@RequestHeader("Authorization") String authorizationHeader) {
//        return sysRoleService.getAllRoles(authorizationHeader);
//    }

}
