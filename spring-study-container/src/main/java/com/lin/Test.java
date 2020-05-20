package com.lin;

import com.lin.entity.Student;
import com.lin.services.GetBeanTest;
import com.lin.services.TestChangeMethod;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LinZebin
 * @date 2020/5/8 9:49 下午
 */
public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beanFactoryTest.xml");
		TestChangeMethod testChangeMethod = (TestChangeMethod) ac.getBean("testChangeMethod");
		testChangeMethod.changeMe();

		GetBeanTest getBeanTest = (GetBeanTest) ac.getBean("getBeanTest");
		getBeanTest.getBean().showMe();

		Student student = (Student) ac.getBean("student");
		System.out.println(student);


	}

}
