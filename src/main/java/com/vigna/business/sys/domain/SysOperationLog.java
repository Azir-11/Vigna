package com.vigna.business.sys.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class SysOperationLog implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "ID")
    private Long id;

    @Schema(description = "类型（0=其它,1=新增,2=修改,3=删除,4=授权,5=导出,6=导入,7=强退,8=生成代码,9=清空数据）")
    private Integer BusinessType;

    @Schema(description = "方法名称")
    private String method;

    @Schema(description = "请求方式")
    private String requestMethod;

    @Schema(description = "描述")
    private String description;

    @Schema(description = "请求IP")
    private String reqIp;

    @Schema(description = "操作人")
    private String operName;

    @Schema(description = "操作地点")
    private String operLocation;

    @Schema(description = "请求信息")
    private String reqParam;

    @Schema(description = "响应信息")
    private String resp;

    @Schema(description = "错误消息")
    private String errorMsg;

    @Schema(description = "状态")
    private String status;

    /**
     * 开始时间
     */
    @JsonIgnore
    private String beginTime;

    /**
     * 结束时间
     */
    @JsonIgnore
    private String endTime;

}
