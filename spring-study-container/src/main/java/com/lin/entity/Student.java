package com.lin.entity;

/**
 * @author LinZebin
 * @date 2020/5/9 6:23 下午
 */
public class Student extends User{

	private int id;

	private String name;

	private String clazz;

	public Student(int id) {
		this.id = id;
	}

	public Student(int id, String name, String clazz) {
		this.id = id;
		this.name = name;
		this.clazz = clazz;
	}

	@Override
	public void showMe() {
		System.out.println("I am student");
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", name='" + name + '\'' +
				", clazz='" + clazz + '\'' +
				'}';
	}
}
