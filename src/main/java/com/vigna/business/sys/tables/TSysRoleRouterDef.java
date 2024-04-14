package com.vigna.business.sys.tables;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 * 角色路由关联表 表定义层。
 *
 * @author 20751
 * @since 2024-04-15
 */
public class TSysRoleRouterDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 角色路由关联表
     */
    public static final TSysRoleRouterDef T_SYS_ROLE_ROUTER = new TSysRoleRouterDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn ROLE_ID = new QueryColumn(this, "role_id");

    
    public final QueryColumn CREATE_BY = new QueryColumn(this, "create_by");

    
    public final QueryColumn CREATE_ID = new QueryColumn(this, "create_id");

    
    public final QueryColumn ROUTER_ID = new QueryColumn(this, "router_id");

    
    public final QueryColumn UPDATE_BY = new QueryColumn(this, "update_by");

    
    public final QueryColumn UPDATE_ID = new QueryColumn(this, "update_id");

    
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
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, ROLE_ID, ROUTER_ID, CREATE_ID, CREATE_BY, UPDATE_ID, UPDATE_BY, CREATE_TIME, UPDATE_TIME, IS_DELETED, DELETE_TIME};

    public TSysRoleRouterDef() {
        super("", "t_sys_role_router");
    }

}
