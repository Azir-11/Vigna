package com.vigna.business.sys.tables;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 * 角色表 表定义层。
 *
 * @author 20751
 * @since 2024-04-15
 */
public class TSysRoleDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 角色表
     */
    public static final TSysRoleDef T_SYS_ROLE = new TSysRoleDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 类型：1:公共角色；2:特殊角色
     */
    public final QueryColumn TYPE = new QueryColumn(this, "type");

    /**
     * 状态；1:可用，2:禁用
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
     * 角色code
     */
    public final QueryColumn ROLE_CODE = new QueryColumn(this, "role_code");

    
    public final QueryColumn ROLE_DESC = new QueryColumn(this, "role_desc");

    
    public final QueryColumn ROLE_NAME = new QueryColumn(this, "role_name");

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
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, ROLE_NAME, ROLE_CODE, STATUS, ROLE_DESC, TYPE, CREATE_ID, CREATE_BY, UPDATE_ID, UPDATE_BY, CREATE_TIME, UPDATE_TIME, IS_DELETED, DELETE_TIME};

    public TSysRoleDef() {
        super("", "t_sys_role");
    }

}
