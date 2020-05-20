package com.lin.entity;

import com.lin.services.CustomAnotationTest;
import com.lin.services.TestChangeMethod;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author LinZebin
 * @date 2020/5/9 6:17 下午
 */
public class Teacher extends User{

	@Autowired
	TestChangeMethod testChangeMethod;

	@Override
	@CustomAnotationTest(id = 01,desc = "teacher")
	public void showMe() {
		testChangeMethod.changeMe();
		System.out.println("I am Teacher");
	}
}
