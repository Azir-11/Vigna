package com.vigna.business.sys.tables;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 * 系统配置信息表 表定义层。
 *
 * @author 20751
 * @since 2024-04-15
 */
public class TSysConfigDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 系统配置信息表
     */
    public static final TSysConfigDef T_SYS_CONFIG = new TSysConfigDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 有效状态：0->无效；1->有效
     */
    public final QueryColumn VALID = new QueryColumn(this, "valid");

    /**
     * 备注
     */
    public final QueryColumn REMARK = new QueryColumn(this, "remark");

    /**
     * 状态   0：禁用   1：启用
     */
    public final QueryColumn STATUS = new QueryColumn(this, "status");

    /**
     * key
     */
    public final QueryColumn PARAM_KEY = new QueryColumn(this, "param_key");

    /**
     * name
     */
    public final QueryColumn PARAM_NAME = new QueryColumn(this, "param_name");

    /**
     * 系统内置: Y N
     */
    public final QueryColumn PARAM_TYPE = new QueryColumn(this, "param_type");

    /**
     * 创建时间
     */
    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    /**
     * 修改时间
     */
    public final QueryColumn MODIFY_TIME = new QueryColumn(this, "modify_time");

    /**
     * value
     */
    public final QueryColumn PARAM_VALUE = new QueryColumn(this, "param_value");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, PARAM_TYPE, PARAM_KEY, PARAM_VALUE, PARAM_NAME, STATUS, REMARK, CREATE_TIME, MODIFY_TIME, VALID};

    public TSysConfigDef() {
        super("", "t_sys_config");
    }

}
