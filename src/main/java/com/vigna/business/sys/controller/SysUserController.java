package com.vigna.business.sys.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "SysUserController", description = "用户信息控制层")
//@RequestMapping("/sys/user")
@RequestMapping("/systemManage")
public class SysUserController {

//    private final SysUserService sysUserService;
//
//    @Operation(summary = "list 分页列表")
//    @Parameters({
//            @Parameter(name = "current", description = "当前页", required = true, example = "1"),
//            @Parameter(name = "size", description = "每页显示条数", required = true, example = "10"),
//            @Parameter(name = "username", description = "用户名称"),
//    })
//    @GetMapping(value = "/getUserList")
//    public Result<IPage<SysUserVO>> list(@Parameter(hidden = true) @RequestParam Map<String, Object> params) {
//        IPage<SysUserVO> sysUsers = sysUserService.getList(params);
//        return Result.success(sysUsers);
//    }
//
//    @Operation(summary = "创建用户信息")
//    @PostMapping(value = "/createUser")
//    @SysLogInterface(title = "创建用户信息", businessType = BusinessType.INSERT)
//    @PreAuthorize("@pre.hasPermission('system:user:add')")
//    public Result<String> createUser(@RequestBody CreateUserParam createUserParam) {
//        return sysUserService.createUser(createUserParam);
//    }

}
