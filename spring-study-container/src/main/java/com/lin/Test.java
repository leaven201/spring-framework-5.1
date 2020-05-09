package com.lin;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author LinZebin
 * @date 2020/5/8 9:49 下午
 */
public class Test {

	public static void main(String[] args) {
//		ApplicationContext ac = new ClassPathXmlApplicationContext("beanFactoryTest.xml");
//		System.out.println(ac.getBean("serviceImpl"));
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
		System.out.println(bf.getBean("serviceImpl"));

	}

}
