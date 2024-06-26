# 绿豆

感谢[pea](https://github.com/haitang1894/pea)的开源，不然不会有Vigna的诞生。

## 简介

项目采用SpringBoot3.2 +
JDK21、MyBatis-Flex、Sa-token安全框架等，适配 [soybean-admin](https://gitee.com/honghuangdc/soybean-admin)
开发的简单权限系统。

## TODO

- [ ] 修改数据库ID为漂移雪花
- [ ] 完成用户管理，支持注册
- [ ] 完成角色管理
- [ ] 完成菜单管理
- [ ] 完成日志管理
- [ ] 完成切换账号功能
- [ ] 补充文档
- [ ] 完成登录的验证码功能

## **技术选型：**

| 依赖           | 版本     |
|--------------|--------|
| Spring Boot  | 3.2.4  |
| JDK          | 21     |
| Mybatis-Flex | 1.8.7  |
| hutool       | 5.8.25 |
| knife4j      | 4.5.0  |
| jwt          | 0.9.1  |
| PostGreSQL   | 42.7.2 |
| ...          | ...    |

## 后端部署

> - **GitHub仓库地址:** https://github.com/Azir-11/Vigna

- idea、eclipse需安装lombok插件，不然会提示找不到entity的get set方法
- 创建数据库vigna，数据库编码为UTF-8
- 执行doc/sql/vigna.sql文件，初始化数据
- 修改application-local.yml，更新postgresql数据库连接信息
- Eclipse、IDEA运行PeaApplication.java，则可启动项目
- Swagger文档路径：项目启动之后看看控制台输出就知道了，项目没有给它套好看的外壳，因为我比较推荐直接在ApiFox中导入文档

## 前端部署

> - **GitHub仓库地址:**  https://github.com/soybeanjs/soybean-admin.git

- 前端部署以及更换访问路径请看下面文档


- 前端部署方案：请参考 **[soybean-admin](https://docs.soybeanjs.cn/zh/)** 项目文档

- 你要是愿意等的话，我也会写一下的

- 前端部署完毕，修改配置就可以使用该后端

- 账号：Soybean，密码：123456

- 账号：admin，密码：admin123.

## 注解

- 日志记录注解 @SysLogInterface
- 权限相关请看 [Sa-Token](https://sa-token.dev33.cn/)
