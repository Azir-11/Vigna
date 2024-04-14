package com.vigna.business.sys.tables;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 * 用户角色关联表 表定义层。
 *
 * @author 20751
 * @since 2024-04-15
 */
public class TSysUserRoleDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 用户角色关联表
     */
    public static final TSysUserRoleDef T_SYS_USER_ROLE = new TSysUserRoleDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 角色id
     */
    public final QueryColumn ROLE_ID = new QueryColumn(this, "role_id");

    /**
     * 用户id
     */
    public final QueryColumn USER_ID = new QueryColumn(this, "user_id");

    
    public final QueryColumn UPDATE_BY = new QueryColumn(this, "update_by");

    
    public final QueryColumn UPDATE_ID = new QueryColumn(this, "update_id");

    
    public final QueryColumn CREATOR_BY = new QueryColumn(this, "creator_by");

    
    public final QueryColumn CREATOR_ID = new QueryColumn(this, "creator_id");

    
    public final QueryColumn IS_DELETED = new QueryColumn(this, "is_deleted");

    
    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    
    public final QueryColumn DELETE_TIME = new QueryColumn(this, "delete_time");

    
    public final QueryColumn UPDATE_TIME = new QueryColumn(this, "update_time");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, USER_ID, ROLE_ID, CREATOR_ID, CREATOR_BY, UPDATE_ID, UPDATE_BY, CREATE_TIME, UPDATE_TIME, IS_DELETED, DELETE_TIME};

    public TSysUserRoleDef() {
        super("", "t_sys_user_role");
    }

}
