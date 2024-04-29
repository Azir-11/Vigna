/*
 Author                : Azir-11
 GitHub                : https://github.com/Azir-11

 Navicat Premium Data Transfer

 Source Server         : PostGreSQL15.6
 Source Server Type    : PostgreSQL
 Source Server Version : 150006 (150006)
 Source Host           : localhost:5432
 Source Catalog        : Vigna
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 150006 (150006)
 File Encoding         : 65001

 Date: 15/04/2024 00:41:23
*/


-- ----------------------------
-- Sequence structure for t_sys_config_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_sys_config_id_seq";
CREATE SEQUENCE "public"."t_sys_config_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_sys_operation_log_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_sys_operation_log_id_seq";
CREATE SEQUENCE "public"."t_sys_operation_log_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_sys_resource_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_sys_resource_id_seq";
CREATE SEQUENCE "public"."t_sys_resource_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_sys_role_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_sys_role_id_seq";
CREATE SEQUENCE "public"."t_sys_role_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_sys_role_router_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_sys_role_router_id_seq";
CREATE SEQUENCE "public"."t_sys_role_router_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_sys_user_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_sys_user_id_seq";
CREATE SEQUENCE "public"."t_sys_user_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_sys_user_role_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_sys_user_role_id_seq";
CREATE SEQUENCE "public"."t_sys_user_role_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Table structure for t_sys_config
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_sys_config";
CREATE TABLE "public"."t_sys_config" (
  "id" int4 NOT NULL DEFAULT nextval('t_sys_config_id_seq'::regclass),
  "param_type" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "param_key" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "param_value" varchar(255) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "param_name" varchar(2000) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "status" char(1) COLLATE "pg_catalog"."default" DEFAULT '0'::bpchar,
  "remark" varchar(500) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "create_time" timestamp(6) DEFAULT CURRENT_TIMESTAMP,
  "modify_time" timestamp(6) DEFAULT CURRENT_TIMESTAMP,
  "valid" int4 DEFAULT 1
)
;
COMMENT ON COLUMN "public"."t_sys_config"."param_type" IS '系统内置: Y N';
COMMENT ON COLUMN "public"."t_sys_config"."param_key" IS 'key';
COMMENT ON COLUMN "public"."t_sys_config"."param_value" IS 'value';
COMMENT ON COLUMN "public"."t_sys_config"."param_name" IS 'name';
COMMENT ON COLUMN "public"."t_sys_config"."status" IS '状态   0：禁用   1：启用';
COMMENT ON COLUMN "public"."t_sys_config"."remark" IS '备注';
COMMENT ON COLUMN "public"."t_sys_config"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_sys_config"."modify_time" IS '修改时间';
COMMENT ON COLUMN "public"."t_sys_config"."valid" IS '有效状态：0->无效；1->有效';
COMMENT ON TABLE "public"."t_sys_config" IS '系统配置信息表';

-- ----------------------------
-- Records of t_sys_config
-- ----------------------------

-- ----------------------------
-- Table structure for t_sys_operation_log
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_sys_operation_log";
CREATE TABLE "public"."t_sys_operation_log" (
  "id" int4 NOT NULL DEFAULT nextval('t_sys_operation_log_id_seq'::regclass),
  "business_type" int2 NOT NULL,
  "method" varchar(100) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "request_method" varchar(10) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "description" varchar(255) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "req_ip" varchar(50) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "req_param" varchar(2000) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "resp" varchar(1000) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "error_msg" varchar(2000) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "create_id" int8,
  "create_by" varchar(12) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "create_time" timestamp(6),
  "update_id" int8,
  "update_by" varchar(12) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "update_time" timestamp(6),
  "is_deleted" int2,
  "delete_time" timestamp(6),
  "oper_name" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "oper_location" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "status" int2
)
;
COMMENT ON COLUMN "public"."t_sys_operation_log"."business_type" IS '类型（0=其它,1=新增,2=修改,3=删除,4=授权,5=导出,6=导入,7=强退,8=生成代码,9=清空数据）';
COMMENT ON COLUMN "public"."t_sys_operation_log"."method" IS '方法名称';
COMMENT ON COLUMN "public"."t_sys_operation_log"."request_method" IS '请求方式';
COMMENT ON COLUMN "public"."t_sys_operation_log"."description" IS '描述';
COMMENT ON COLUMN "public"."t_sys_operation_log"."req_ip" IS '请求IP';
COMMENT ON COLUMN "public"."t_sys_operation_log"."req_param" IS '请求信息';
COMMENT ON COLUMN "public"."t_sys_operation_log"."resp" IS '响应信息';
COMMENT ON COLUMN "public"."t_sys_operation_log"."error_msg" IS '错误消息';
COMMENT ON COLUMN "public"."t_sys_operation_log"."create_id" IS '创建者ID';
COMMENT ON COLUMN "public"."t_sys_operation_log"."create_by" IS '创建者名称';
COMMENT ON COLUMN "public"."t_sys_operation_log"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_sys_operation_log"."update_id" IS '修改者ID';
COMMENT ON COLUMN "public"."t_sys_operation_log"."update_by" IS '修改者名称';
COMMENT ON COLUMN "public"."t_sys_operation_log"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."t_sys_operation_log"."is_deleted" IS '是否已删除：0->未删除；1->已删除';
COMMENT ON COLUMN "public"."t_sys_operation_log"."delete_time" IS '删除时间';
COMMENT ON COLUMN "public"."t_sys_operation_log"."oper_name" IS '操作人';
COMMENT ON COLUMN "public"."t_sys_operation_log"."oper_location" IS '操作地点';
COMMENT ON COLUMN "public"."t_sys_operation_log"."status" IS '状态 1-可用，2-禁用';
COMMENT ON TABLE "public"."t_sys_operation_log" IS '系统操作日志';

-- ----------------------------
-- Records of t_sys_operation_log
-- ----------------------------

-- ----------------------------
-- Table structure for t_sys_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_sys_role";
CREATE TABLE "public"."t_sys_role" (
  "id" int4 NOT NULL DEFAULT nextval('t_sys_role_id_seq'::regclass),
  "role_name" varchar(16) COLLATE "pg_catalog"."default" NOT NULL,
  "role_code" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "status" varchar(1) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "role_desc" varchar(255) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "type" int2 NOT NULL,
  "create_id" int8 NOT NULL,
  "create_by" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "update_id" int8 NOT NULL,
  "update_by" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6) NOT NULL,
  "update_time" timestamp(6) NOT NULL,
  "is_deleted" int2 NOT NULL DEFAULT '0'::smallint,
  "delete_time" timestamp(6)
)
;
COMMENT ON COLUMN "public"."t_sys_role"."role_code" IS '角色code';
COMMENT ON COLUMN "public"."t_sys_role"."status" IS '状态；1:可用，2:禁用';
COMMENT ON COLUMN "public"."t_sys_role"."type" IS '类型：1:公共角色；2:特殊角色';
COMMENT ON COLUMN "public"."t_sys_role"."create_id" IS '创建者ID';
COMMENT ON COLUMN "public"."t_sys_role"."create_by" IS '创建者名称';
COMMENT ON COLUMN "public"."t_sys_role"."update_id" IS '修改者ID';
COMMENT ON COLUMN "public"."t_sys_role"."update_by" IS '修改者名称';
COMMENT ON COLUMN "public"."t_sys_role"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_sys_role"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."t_sys_role"."is_deleted" IS '是否已删除：0->未删除；1->已删除';
COMMENT ON COLUMN "public"."t_sys_role"."delete_time" IS '删除时间';
COMMENT ON TABLE "public"."t_sys_role" IS '角色表';

-- ----------------------------
-- Records of t_sys_role
-- ----------------------------
INSERT INTO "public"."t_sys_role" VALUES (1, '超级管理员', 'SUPBER_ADMIN', '1', '权限超级大，拥有所有权限', 2, 1, 'admin', 1, 'admin', '2024-03-09 10:21:23', '2024-03-09 10:21:25', 0, NULL);
INSERT INTO "public"."t_sys_role" VALUES (2, '普通管理员', 'ADMIN', '1', '只拥有部分管理权限', 2, 1, 'admin', 1, 'admin', '2024-03-09 10:21:23', '2024-03-09 10:21:25', 0, NULL);

-- ----------------------------
-- Table structure for t_sys_role_router
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_sys_role_router";
CREATE TABLE "public"."t_sys_role_router" (
  "id" int4 NOT NULL DEFAULT nextval('t_sys_role_router_id_seq'::regclass),
  "role_id" int8 NOT NULL,
  "router_id" int8 NOT NULL,
  "create_id" int8,
  "create_by" varchar(45) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "update_id" int8,
  "update_by" varchar(16) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "is_deleted" int2 NOT NULL DEFAULT '0'::smallint,
  "delete_time" timestamp(6)
)
;
COMMENT ON TABLE "public"."t_sys_role_router" IS '角色路由关联表';

-- ----------------------------
-- Records of t_sys_role_router
-- ----------------------------
INSERT INTO "public"."t_sys_role_router" VALUES (1, 1, 1, 1, 'admin', 1, 'admin', '2024-03-11 10:24:29', NULL, 0, NULL);
INSERT INTO "public"."t_sys_role_router" VALUES (2, 1, 2, 1, 'admin', 1, 'admin', '2024-03-11 10:24:29', NULL, 0, NULL);
INSERT INTO "public"."t_sys_role_router" VALUES (3, 1, 3, 1, 'admin', 1, 'admin', '2024-03-11 10:24:29', NULL, 0, NULL);
INSERT INTO "public"."t_sys_role_router" VALUES (4, 1, 4, 1, 'admin', 1, 'admin', '2024-03-11 10:24:29', NULL, 0, NULL);
INSERT INTO "public"."t_sys_role_router" VALUES (5, 1, 5, 1, 'admin', 1, 'admin', '2024-03-11 10:24:29', NULL, 0, NULL);
INSERT INTO "public"."t_sys_role_router" VALUES (6, 1, 6, 1, 'admin', 1, 'admin', '2024-03-11 10:24:29', NULL, 0, NULL);
INSERT INTO "public"."t_sys_role_router" VALUES (7, 1, 7, 1, 'admin', 1, 'admin', '2024-03-11 10:24:29', NULL, 0, NULL);
INSERT INTO "public"."t_sys_role_router" VALUES (8, 1, 8, 1, 'admin', 1, 'admin', '2024-03-11 10:24:29', NULL, 0, NULL);
INSERT INTO "public"."t_sys_role_router" VALUES (9, 1, 9, 1, 'admin', 1, 'admin', '2024-03-11 10:24:29', NULL, 0, NULL);
INSERT INTO "public"."t_sys_role_router" VALUES (10, 1, 10, 1, 'admin', 1, 'admin', '2024-03-11 10:24:29', NULL, 0, NULL);
INSERT INTO "public"."t_sys_role_router" VALUES (11, 1, 11, 1, 'admin', 1, 'admin', '2024-03-11 10:24:29', NULL, 0, NULL);
INSERT INTO "public"."t_sys_role_router" VALUES (12, 1, 12, 1, 'admin', 1, 'admin', '2024-03-11 10:24:29', NULL, 0, NULL);
INSERT INTO "public"."t_sys_role_router" VALUES (14, 1, 14, 1, 'admin', 1, 'admin', '2024-03-11 10:24:29', NULL, 0, NULL);
INSERT INTO "public"."t_sys_role_router" VALUES (15, 1, 15, 1, 'admin', 1, 'admin', '2024-03-11 10:24:29', NULL, 0, NULL);
INSERT INTO "public"."t_sys_role_router" VALUES (16, 1, 16, 1, 'admin', 1, 'admin', '2024-03-11 10:24:29', NULL, 0, NULL);
INSERT INTO "public"."t_sys_role_router" VALUES (17, 1, 17, 1, 'admin', 1, 'admin', '2024-03-11 10:24:29', NULL, 0, NULL);
INSERT INTO "public"."t_sys_role_router" VALUES (18, 1, 18, 1, 'admin', 1, 'admin', '2024-03-11 10:24:29', NULL, 0, NULL);
INSERT INTO "public"."t_sys_role_router" VALUES (19, 1, 19, 1, 'admin', 1, 'admin', '2024-03-11 10:24:29', NULL, 0, NULL);
INSERT INTO "public"."t_sys_role_router" VALUES (20, 1, 20, 1, 'admin', 1, 'admin', '2024-03-11 10:24:29', NULL, 0, NULL);
INSERT INTO "public"."t_sys_role_router" VALUES (21, 1, 21, 1, 'admin', 1, 'admin', '2024-03-11 10:24:29', NULL, 0, NULL);
INSERT INTO "public"."t_sys_role_router" VALUES (22, 1, 22, 1, 'admin', 1, 'admin', '2024-03-11 10:24:29', NULL, 0, NULL);
INSERT INTO "public"."t_sys_role_router" VALUES (23, 1, 27, 1, 'admin', 1, 'admin', '2024-04-01 10:24:29', NULL, 0, NULL);

-- ----------------------------
-- Table structure for t_sys_router
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_sys_router";
CREATE TABLE "public"."t_sys_router" (
  "id" int4 NOT NULL DEFAULT nextval('t_sys_resource_id_seq'::regclass),
  "parent_id" int4 NOT NULL,
  "ui_path" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "menu_type" varchar(1) COLLATE "pg_catalog"."default" NOT NULL,
  "status" varchar(1) COLLATE "pg_catalog"."default" NOT NULL,
  "menu_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "route_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "route_path" varchar(255) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "component" varchar(40) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "meta" varchar(455) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "create_id" int8 NOT NULL,
  "create_by" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "update_id" int8 NOT NULL,
  "update_by" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6) NOT NULL,
  "update_time" timestamp(6) NOT NULL,
  "is_deleted" int2 NOT NULL DEFAULT '0'::smallint,
  "delete_time" timestamp(6)
)
;
COMMENT ON COLUMN "public"."t_sys_router"."parent_id" IS '父节点id';
COMMENT ON COLUMN "public"."t_sys_router"."ui_path" IS '唯一标识路径';
COMMENT ON COLUMN "public"."t_sys_router"."menu_type" IS '1：菜单路由；2：资源（按钮）3: 基础资源';
COMMENT ON COLUMN "public"."t_sys_router"."status" IS '状态；1:可用，2:禁用';
COMMENT ON COLUMN "public"."t_sys_router"."menu_name" IS '名称';
COMMENT ON COLUMN "public"."t_sys_router"."route_name" IS '路由名称';
COMMENT ON COLUMN "public"."t_sys_router"."route_path" IS '菜单路由为path，其他为唯一标识';
COMMENT ON COLUMN "public"."t_sys_router"."component" IS '组件';
COMMENT ON COLUMN "public"."t_sys_router"."meta" IS '元数据';
COMMENT ON COLUMN "public"."t_sys_router"."create_id" IS '创建者ID';
COMMENT ON COLUMN "public"."t_sys_router"."create_by" IS '创建者名称';
COMMENT ON COLUMN "public"."t_sys_router"."update_id" IS '修改者ID';
COMMENT ON COLUMN "public"."t_sys_router"."update_by" IS '修改者名称';
COMMENT ON COLUMN "public"."t_sys_router"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_sys_router"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."t_sys_router"."is_deleted" IS '是否已删除：0->未删除；1->已删除';
COMMENT ON COLUMN "public"."t_sys_router"."delete_time" IS '删除时间';
COMMENT ON TABLE "public"."t_sys_router" IS '资源表';

-- ----------------------------
-- Records of t_sys_router
-- ----------------------------
INSERT INTO "public"."t_sys_router" VALUES (1, 0, 'home/', '2', '1', '首页', 'home', '/home', 'layout.base$view.home', '{"iconType": "1","icon": "mdi:monitor-dashboard", "order": 0, "title": "home", "i18nKey": "route.home"}', 1, 1, 'admin', 1, 'admin', '2024-03-09 08:49:27', '2024-03-09 08:49:30', 0, '2024-03-09 08:49:34');
INSERT INTO "public"."t_sys_router" VALUES (2, 0, '/exception', '1', '1', '异常页面', 'exception', '/exception', 'layout.base', '{"iconType": "1","icon": "ant-design:exception-outlined", "order": 7, "title": "exception", "i18nKey": "route.exception"}', 7, 1, 'admin', 1, 'admin', '2024-03-09 08:49:27', '2024-03-09 08:49:30', 0, '2024-03-09 08:49:34');
INSERT INTO "public"."t_sys_router" VALUES (3, 2, '/exception/403', '2', '1', '403', 'exception_403', '/exception/403', 'view.403', '{"iconType": "1","icon": "ic:baseline-block", "title": "exception_403", "i18nKey": "route.exception_403"}', 1, 1, 'admin', 1, 'admin', '2024-03-09 08:49:27', '2024-03-09 08:49:30', 0, '2024-03-09 08:49:34');
INSERT INTO "public"."t_sys_router" VALUES (4, 2, '/exception/404', '2', '1', '404', 'exception_404', '/exception/404', 'view.404', '{"iconType": "1","icon": "ic:baseline-web-asset-off", "title": "exception_404", "i18nKey": "route.exception_404"}', 2, 1, 'admin', 1, 'admin', '2024-03-09 08:49:27', '2024-03-09 08:49:30', 0, '2024-03-09 08:49:34');
INSERT INTO "public"."t_sys_router" VALUES (5, 2, '/exception/500', '2', '1', '500', 'exception_500', '/exception/500', 'view.500', '{"iconType": "1","icon": "ic:baseline-wifi-off", "title": "exception_500", "i18nKey": "route.exception_500"}', 3, 1, 'admin', 1, 'admin', '2024-03-09 08:49:27', '2024-03-09 08:49:30', 0, '2024-03-09 08:49:34');
INSERT INTO "public"."t_sys_router" VALUES (6, 0, '/about', '2', '1', '关于', 'about', '/about', 'layout.base$view.about', '{"iconType": "1","icon": "fluent:book-information-24-regular", "order": 10, "title": "about", "i18nKey": "route.about"}', 10, 1, 'admin', 1, 'admin', '2024-03-09 08:49:27', '2024-04-03 05:38:24', 0, '2024-03-09 08:49:34');
INSERT INTO "public"."t_sys_router" VALUES (7, 0, '/function', '1', '1', '系统功能', 'function', '/function', 'layout.base', '{"iconType": "1","icon": "icon-park-outline:all-application", "order": 6, "title": "function", "i18nKey": "route.function"}', 6, 1, 'admin', 1, 'admin', '2024-03-09 08:49:27', '2024-03-09 08:49:30', 0, '2024-03-09 08:49:34');
INSERT INTO "public"."t_sys_router" VALUES (8, 7, '/function/multi-tab', '2', '1', '多标签页', 'function_multi-tab', '/function/multi-tab', 'view.function_multi-tab', '{"iconType": "1","icon": "ic:round-tab", "title": "function_multi-tab", "i18nKey": "route.function_multi-tab", "multiTab": true, "hideInMenu": true, "activeMenu": "function_tab"}', 1, 1, 'admin', 1, 'admin', '2024-03-09 08:49:27', '2024-03-09 08:49:30', 0, '2024-03-09 08:49:34');
INSERT INTO "public"."t_sys_router" VALUES (9, 0, '/multi-menu', '1', '1', '多级菜单', 'multi-menu', '/multi-menu', 'layout.base', '{"iconType": "1","icon": "mdi:menu", "order": 4, "title": "multi-menu", "i18nKey": "route.multi-menu"}', 4, 1, 'admin', 1, 'admin', '2024-03-09 08:49:27', '2024-03-09 08:49:30', 0, '2024-03-09 08:49:34');
INSERT INTO "public"."t_sys_router" VALUES (10, 9, '/multi-menu/first', '1', '1', '菜单一', 'multi-menu_first', '/multi-menu/first', NULL, '{"iconType": "1","icon": "mdi:menu", "order": 1, "title": "multi-menu_first", "i18nKey": "route.multi-menu_first"}', 1, 1, 'admin', 1, 'admin', '2024-03-09 08:49:27', '2024-03-09 08:49:30', 0, '2024-03-09 08:49:34');
INSERT INTO "public"."t_sys_router" VALUES (11, 10, '/multi-menu/first/child', '2', '1', '菜单一子菜单', 'multi-menu_first_child', '/multi-menu/first/child', 'view.multi-menu_first_child', '{"iconType": "1","icon": "mdi:menu", "order": 1, "title": "multi-menu_first_child", "i18nKey": "route.multi-menu_first_child"}', 1, 1, 'admin', 1, 'admin', '2024-03-09 08:49:27', '2024-03-09 08:49:30', 0, '2024-03-09 08:49:34');

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_sys_user";
CREATE TABLE "public"."t_sys_user" (
  "id" int4 NOT NULL DEFAULT nextval('t_sys_user_id_seq'::regclass),
  "nick_name" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "user_name" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "password" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "status" varchar(1) COLLATE "pg_catalog"."default" NOT NULL,
  "otp_secret" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "user_gender" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "user_phone" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "user_email" varchar(30) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "last_login_time" timestamp(6),
  "last_login_ip" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "create_id" int8,
  "create_by" varchar(12) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "create_time" timestamp(6),
  "update_id" int8,
  "update_by" varchar(12) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "update_time" timestamp(6),
  "is_deleted" int2,
  "delete_time" timestamp(6)
)
;
COMMENT ON COLUMN "public"."t_sys_user"."nick_name" IS '账户昵称';
COMMENT ON COLUMN "public"."t_sys_user"."user_name" IS '用户名';
COMMENT ON COLUMN "public"."t_sys_user"."password" IS '密码';
COMMENT ON COLUMN "public"."t_sys_user"."status" IS '状态；1:可用，2:禁用';
COMMENT ON COLUMN "public"."t_sys_user"."user_gender" IS '性别';
COMMENT ON COLUMN "public"."t_sys_user"."user_phone" IS '电话';
COMMENT ON COLUMN "public"."t_sys_user"."user_email" IS '电子邮箱';
COMMENT ON TABLE "public"."t_sys_user" IS '用户表';

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
INSERT INTO "public"."t_sys_user" VALUES (1, '管理员', 'admin', '$2a$10$RdBAjlvTjY3E1awve4O7y.vROotZwnJw6e.rj0IZJQ9Dk1eRiCwyS', '1', '', '1', '13189770694', 'abc@qq.com', '2024-03-10 11:42:46', '192.168.31.51', 1, 'admin', '2020-01-01 19:00:00', 1, 'admin', '2024-03-10 11:42:46', 0, NULL);
INSERT INTO "public"."t_sys_user" VALUES (8, 'Soybean', 'Soybean', '$2a$10$CoWcan6u6BDnQ8w8m4tzPuc7hq.WyS4X.iiwSfujROWeGS28WeRxK', '1', NULL, '1', '13892700749', '123@qq.com', '2024-04-09 22:49:09', '192.168.2.128', 1, 'admin', '2024-03-09 21:56:34', NULL, NULL, '2024-04-09 22:49:09', 0, NULL);

-- ----------------------------
-- Table structure for t_sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_sys_user_role";
CREATE TABLE "public"."t_sys_user_role" (
  "id" int4 NOT NULL DEFAULT nextval('t_sys_user_role_id_seq'::regclass),
  "user_id" int8 NOT NULL,
  "role_id" int8 NOT NULL,
  "creator_id" int8,
  "creator_by" varchar(45) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "update_id" int8,
  "update_by" varchar(45) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "create_time" timestamp(6) NOT NULL,
  "update_time" timestamp(6),
  "is_deleted" int2 NOT NULL DEFAULT '0'::smallint,
  "delete_time" timestamp(6)
)
;
COMMENT ON COLUMN "public"."t_sys_user_role"."user_id" IS '用户id';
COMMENT ON COLUMN "public"."t_sys_user_role"."role_id" IS '角色id';
COMMENT ON TABLE "public"."t_sys_user_role" IS '用户角色关联表';

-- ----------------------------
-- Records of t_sys_user_role
-- ----------------------------
INSERT INTO "public"."t_sys_user_role" VALUES (1, 1, 1, 1, 'admin', 1, 'admin', '2024-03-09 10:37:52', '2024-03-09 10:38:04', 0, NULL);
INSERT INTO "public"."t_sys_user_role" VALUES (2, 8, 1, 1, 'admin', 1, 'admin', '2024-03-10 13:10:39', '2024-03-10 13:10:41', 0, NULL);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."t_sys_config_id_seq"
OWNED BY "public"."t_sys_config"."id";
SELECT setval('"public"."t_sys_config_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."t_sys_operation_log_id_seq"
OWNED BY "public"."t_sys_operation_log"."id";
SELECT setval('"public"."t_sys_operation_log_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."t_sys_resource_id_seq"
OWNED BY "public"."t_sys_router"."id";
SELECT setval('"public"."t_sys_resource_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."t_sys_role_id_seq"
OWNED BY "public"."t_sys_role"."id";
SELECT setval('"public"."t_sys_role_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."t_sys_role_router_id_seq"
OWNED BY "public"."t_sys_role_router"."id";
SELECT setval('"public"."t_sys_role_router_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."t_sys_user_id_seq"
OWNED BY "public"."t_sys_user"."id";
SELECT setval('"public"."t_sys_user_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."t_sys_user_role_id_seq"
OWNED BY "public"."t_sys_user_role"."id";
SELECT setval('"public"."t_sys_user_role_id_seq"', 1, false);

-- ----------------------------
-- Uniques structure for table t_sys_config
-- ----------------------------
ALTER TABLE "public"."t_sys_config" ADD CONSTRAINT "t_sys_config_param_key_key" UNIQUE ("param_key");

-- ----------------------------
-- Primary Key structure for table t_sys_config
-- ----------------------------
ALTER TABLE "public"."t_sys_config" ADD CONSTRAINT "t_sys_config_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_sys_operation_log
-- ----------------------------
ALTER TABLE "public"."t_sys_operation_log" ADD CONSTRAINT "t_sys_operation_log_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_sys_role
-- ----------------------------
ALTER TABLE "public"."t_sys_role" ADD CONSTRAINT "t_sys_role_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_sys_role_router
-- ----------------------------
ALTER TABLE "public"."t_sys_role_router" ADD CONSTRAINT "t_sys_role_router_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table t_sys_router
-- ----------------------------
CREATE UNIQUE INDEX "t_sys_resource_ui_path_idx" ON "public"."t_sys_router" USING btree (
  "ui_path" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table t_sys_router
-- ----------------------------
ALTER TABLE "public"."t_sys_router" ADD CONSTRAINT "t_sys_resource_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_sys_user
-- ----------------------------
ALTER TABLE "public"."t_sys_user" ADD CONSTRAINT "t_sys_user_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_sys_user_role
-- ----------------------------
ALTER TABLE "public"."t_sys_user_role" ADD CONSTRAINT "t_sys_user_role_pkey" PRIMARY KEY ("id");
