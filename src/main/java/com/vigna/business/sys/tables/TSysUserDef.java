package com.vigna.business.sys.tables;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 * 用户表 表定义层。
 *
 * @author 20751
 * @since 2024-04-15
 */
public class TSysUserDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 用户表
     */
    public static final TSysUserDef T_SYS_USER = new TSysUserDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 状态；1:可用，2:禁用
     */
    public final QueryColumn STATUS = new QueryColumn(this, "status");

    
    public final QueryColumn CREATE_BY = new QueryColumn(this, "create_by");

    
    public final QueryColumn CREATE_ID = new QueryColumn(this, "create_id");

    /**
     * 账户昵称
     */
    public final QueryColumn NICK_NAME = new QueryColumn(this, "nick_name");

    /**
     * 密码
     */
    public final QueryColumn PASSWORD = new QueryColumn(this, "password");

    
    public final QueryColumn UPDATE_BY = new QueryColumn(this, "update_by");

    
    public final QueryColumn UPDATE_ID = new QueryColumn(this, "update_id");

    /**
     * 用户名
     */
    public final QueryColumn USER_NAME = new QueryColumn(this, "user_name");

    
    public final QueryColumn IS_DELETED = new QueryColumn(this, "is_deleted");

    
    public final QueryColumn OTP_SECRET = new QueryColumn(this, "otp_secret");

    /**
     * 电子邮箱
     */
    public final QueryColumn USER_EMAIL = new QueryColumn(this, "user_email");

    /**
     * 电话
     */
    public final QueryColumn USER_PHONE = new QueryColumn(this, "user_phone");

    
    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    
    public final QueryColumn DELETE_TIME = new QueryColumn(this, "delete_time");

    
    public final QueryColumn UPDATE_TIME = new QueryColumn(this, "update_time");

    /**
     * 性别
     */
    public final QueryColumn USER_GENDER = new QueryColumn(this, "user_gender");

    
    public final QueryColumn LAST_LOGIN_IP = new QueryColumn(this, "last_login_ip");

    
    public final QueryColumn LAST_LOGIN_TIME = new QueryColumn(this, "last_login_time");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, NICK_NAME, USER_NAME, PASSWORD, STATUS, OTP_SECRET, USER_GENDER, USER_PHONE, USER_EMAIL, LAST_LOGIN_TIME, LAST_LOGIN_IP, CREATE_ID, CREATE_BY, CREATE_TIME, UPDATE_ID, UPDATE_BY, UPDATE_TIME, IS_DELETED, DELETE_TIME};

    public TSysUserDef() {
        super("", "t_sys_user");
    }

}
