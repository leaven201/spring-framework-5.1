import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户类，用来表示该应用中的用户
 * @author LinZebin
 * @date 2020/5/11 6:53 下午
 */
public class Person {

	String name;
	int age;
	LocalDate birthday;
	Sex gender;
	String emailAddress;

	public Person(String name, int age, LocalDate birthday, Sex gender, String emailAddress) {
		this.name = name;
		this.age = age;
		this.birthday = birthday;
		this.gender = gender;
		this.emailAddress = emailAddress;
	}

	public static List<Person> createRoster(){
		List<Person> roster = new ArrayList<>();
		roster.add(new Person("Lin",27,LocalDate.of(1993,9,14),Sex.MALE,"lin@163.com"));
		roster.add(new Person("Nan",26,LocalDate.of(1994,9,17),Sex.FEMALE,"nin@163.com"));
		roster.add(new Person("Kobe",42,LocalDate.of(1978,8,23),Sex.MALE,"kebo@qq.com"));
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

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public Sex getGender() {
		return gender;
	}

	public void setGender(Sex gender) {
		this.gender = gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void printPerson() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				'}';
	}
}
