package com.vigna.business.sys.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class SysRole implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "角色ID")
    private Long id;

    @Schema(description = "角色名称", minLength = 1, maxLength = 16)
    private String roleName;

    @Schema(description = "角色编码", minLength = 1, maxLength = 64)
    private String roleCode;

    @Schema(description = "状态：1-可用，2-禁用", example = "1")
    private String status;

    @Schema(description = "备注信息")
    private String roleDesc;

    @Schema(description = "角色类型：1-公共角色，2-特殊角色", example = "1")
    private Integer type;
}