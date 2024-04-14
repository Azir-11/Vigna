package com.vigna.business.sys.tables;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 * 系统操作日志 表定义层。
 *
 * @author 20751
 * @since 2024-04-15
 */
public class TSysOperationLogDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 系统操作日志
     */
    public static final TSysOperationLogDef T_SYS_OPERATION_LOG = new TSysOperationLogDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 响应信息
     */
    public final QueryColumn RESP = new QueryColumn(this, "resp");

    /**
     * 请求IP
     */
    public final QueryColumn REQ_IP = new QueryColumn(this, "req_ip");

    /**
     * 方法名称
     */
    public final QueryColumn METHOD = new QueryColumn(this, "method");

    /**
     * 状态 1-可用，2-禁用
     */
    public final QueryColumn STATUS = new QueryColumn(this, "status");

    /**
     * 创建者名称
     */
    public final QueryColumn CREATE_BY = new QueryColumn(this, "create_by");

    /**
     * 创建者ID
     */
    public final QueryColumn CREATE_ID = new QueryColumn(this, "create_id");

    /**
     * 错误消息
     */
    public final QueryColumn ERROR_MSG = new QueryColumn(this, "error_msg");

    /**
     * 操作人
     */
    public final QueryColumn OPER_NAME = new QueryColumn(this, "oper_name");

    /**
     * 请求信息
     */
    public final QueryColumn REQ_PARAM = new QueryColumn(this, "req_param");

    /**
     * 修改者名称
     */
    public final QueryColumn UPDATE_BY = new QueryColumn(this, "update_by");

    /**
     * 修改者ID
     */
    public final QueryColumn UPDATE_ID = new QueryColumn(this, "update_id");

    /**
     * 是否已删除：0->未删除；1->已删除
     */
    public final QueryColumn IS_DELETED = new QueryColumn(this, "is_deleted");

    /**
     * 创建时间
     */
    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    /**
     * 删除时间
     */
    public final QueryColumn DELETE_TIME = new QueryColumn(this, "delete_time");

    /**
     * 更新时间
     */
    public final QueryColumn UPDATE_TIME = new QueryColumn(this, "update_time");

    /**
     * 描述
     */
    public final QueryColumn DESCRIPTION = new QueryColumn(this, "description");

    /**
     * 类型（0=其它,1=新增,2=修改,3=删除,4=授权,5=导出,6=导入,7=强退,8=生成代码,9=清空数据）
     */
    public final QueryColumn BUSINESS_TYPE = new QueryColumn(this, "business_type");

    /**
     * 操作地点
     */
    public final QueryColumn OPER_LOCATION = new QueryColumn(this, "oper_location");

    /**
     * 请求方式
     */
    public final QueryColumn REQUEST_METHOD = new QueryColumn(this, "request_method");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, BUSINESS_TYPE, METHOD, REQUEST_METHOD, DESCRIPTION, REQ_IP, REQ_PARAM, RESP, ERROR_MSG, CREATE_ID, CREATE_BY, CREATE_TIME, UPDATE_ID, UPDATE_BY, UPDATE_TIME, IS_DELETED, DELETE_TIME, OPER_NAME, OPER_LOCATION, STATUS};

    public TSysOperationLogDef() {
        super("", "t_sys_operation_log");
    }

}
