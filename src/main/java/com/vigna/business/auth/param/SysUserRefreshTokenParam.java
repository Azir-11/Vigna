package com.vigna.business.auth.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SysUserRefreshTokenParam {
    @Schema(description = "refreshToken")
    private String refreshToken;
}
