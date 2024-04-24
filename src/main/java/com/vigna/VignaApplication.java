package com.vigna;

import com.mybatisflex.core.audit.AuditManager;
import com.mybatisflex.core.audit.ConsoleMessageCollector;
import com.mybatisflex.core.audit.MessageCollector;
import com.vigna.common.utils.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@EnableCaching
@SpringBootApplication
public class VignaApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(VignaApplication.class);
    }

    public static void main(String[] args) {
        // 开启Mybatis-flex审计功能
        MessageCollector collector = new ConsoleMessageCollector();
        AuditManager.setMessageCollector(collector);
        AuditManager.setAuditEnable(true);
        
        ConfigurableApplicationContext context = SpringApplication.run(VignaApplication.class, args);
        String hostIp = IpUtil.getHostIp();
        String port = context.getEnvironment().getProperty("server.port");
        String swaggerPath = context.getEnvironment().getProperty("springdoc.swagger-ui.path");
        log.info("Swagger访问地址：http://{}:{}{}", hostIp, port, swaggerPath);
    }

}
