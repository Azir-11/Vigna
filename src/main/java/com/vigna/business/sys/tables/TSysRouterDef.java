package com.vigna.business.sys.tables;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 * 资源表 表定义层。
 *
 * @author 20751
 * @since 2024-04-15
 */
public class TSysRouterDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 资源表
     */
    public static final TSysRouterDef T_SYS_ROUTER = new TSysRouterDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 元数据
     */
    public final QueryColumn META = new QueryColumn(this, "meta");

    /**
     * 状态；1:可用，2:禁用
     */
    public final QueryColumn STATUS = new QueryColumn(this, "status");

    /**
     * 唯一标识路径
     */
    public final QueryColumn UI_PATH = new QueryColumn(this, "ui_path");

    /**
     * 创建者名称
     */
    public final QueryColumn CREATE_BY = new QueryColumn(this, "create_by");

    /**
     * 创建者ID
     */
    public final QueryColumn CREATE_ID = new QueryColumn(this, "create_id");

    /**
     * 名称
     */
    public final QueryColumn MENU_NAME = new QueryColumn(this, "menu_name");

    /**
     * 1：菜单路由；2：资源（按钮）3: 基础资源
     */
    public final QueryColumn MENU_TYPE = new QueryColumn(this, "menu_type");

    /**
     * 父节点id
     */
    public final QueryColumn PARENT_ID = new QueryColumn(this, "parent_id");

    /**
     * 修改者名称
     */
    public final QueryColumn UPDATE_BY = new QueryColumn(this, "update_by");

    /**
     * 修改者ID
     */
    public final QueryColumn UPDATE_ID = new QueryColumn(this, "update_id");

    /**
     * 组件
     */
    public final QueryColumn COMPONENT = new QueryColumn(this, "component");

    /**
     * 是否已删除：0->未删除；1->已删除
     */
    public final QueryColumn IS_DELETED = new QueryColumn(this, "is_deleted");

    /**
     * 路由名称
     */
    public final QueryColumn ROUTE_NAME = new QueryColumn(this, "route_name");

    /**
     * 菜单路由为path，其他为唯一标识
     */
    public final QueryColumn ROUTE_PATH = new QueryColumn(this, "route_path");

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
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, PARENT_ID, UI_PATH, MENU_TYPE, STATUS, MENU_NAME, ROUTE_NAME, ROUTE_PATH, COMPONENT, META, CREATE_ID, CREATE_BY, UPDATE_ID, UPDATE_BY, CREATE_TIME, UPDATE_TIME, IS_DELETED, DELETE_TIME};

    public TSysRouterDef() {
        super("", "t_sys_router");
    }

}
