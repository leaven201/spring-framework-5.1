import java.util.ArrayList;
import java.util.List;

/**
 * @author LinZebin
 * @date 2020/5/11 10:14 下午
 */
public class Student {

	public String name;
	public int age;
	public Sex sex;
	public String clazz;

	public Student(String name, int age, Sex sex, String clazz) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.clazz = clazz;
	}

	public static List<Student> createRoster(){
		List<Student> roster = new ArrayList<>();
		roster.add(new Student("Lin",27,Sex.MALE,"一班"));
		roster.add(new Student("Nan",26,Sex.FEMALE,"一班"));
		roster.add(new Student("Kobe",42,Sex.MALE,"二班"));
		return roster;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
}
