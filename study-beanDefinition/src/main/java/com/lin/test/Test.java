package com.lin.test;

import com.lin.app.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author LinZebin
 * @date 2020/5/1 2:42 下午
 */
public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println(ac.getBeanDefinition("root").getClass());
		System.out.println(ac.getBeanDefinition("child").getClass());
		System.out.println(ac.getBeanDefinition("beanService").getClass());
		System.out.println(ac.getBeanDefinition("appConfig").getClass());




	}
}
