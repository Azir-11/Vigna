package com.vigna.business.sys.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;


@Data
@EqualsAndHashCode(callSuper = false)
public class SysRoleRouter implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "角色资源关联ID")
    private Long id;

    @Schema(description = "角色ID")
    private Long roleId;

    @Schema(description = "资源ID")
    private Long resourceId;
}