package com.argus.web.config;

import com.argus.web.aspect.LogAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author xingding
 * @date 17/7/15.
 */
@Configuration
@EnableAspectJAutoProxy //开启AOP
@ComponentScan(basePackages = "com.argus.web")
public class SpringConfig {
}
