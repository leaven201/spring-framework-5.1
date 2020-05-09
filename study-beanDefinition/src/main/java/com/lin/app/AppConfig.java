package com.lin.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author LinZebin
 * @date 2020/5/1 2:41 下午
 */
@Configuration
@ImportResource("classpath:applicationContext.xml")
@ComponentScan("com.lin")
public class AppConfig {

}
