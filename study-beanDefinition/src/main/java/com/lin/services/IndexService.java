package com.lin.services;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author LinZebin
 * @date 2020/5/1 2:51 下午
 */
@Component
//@Scope("prototype")
public class IndexService implements InitializingBean {

	public void init(){
		System.out.println("IndexService Init-Method");
	}

	@PostConstruct
	public void annoInit(){
		System.out.println("IndexServie Annotation Init Method");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("IndexService InitializingBean Init Method");
	}
}
