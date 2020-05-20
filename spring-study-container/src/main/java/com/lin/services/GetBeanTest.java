package com.lin.services;

import com.lin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;

/**
 * @author LinZebin
 * @date 2020/5/9 6:20 下午
 */
public abstract class GetBeanTest {

	@Autowired
	private TestChangeMethod testChangeMethod;

	public void showMe(){
		testChangeMethod.changeMe();
		this.getBean().showMe();
	}
	@Lookup("teacher")
	public abstract User getBean();

}
