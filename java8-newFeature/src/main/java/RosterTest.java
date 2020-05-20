import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 制作一个社交软件，需要有如下功能
 * 1.管理员制定一些标准，对应一些action
 * 2.管理员选择执行某个action
 * 3.管理员选择submit按钮
 * 4.系统找出所有满足条件的用户
 * 5.系统对所有满足条件的用户触发相应操作
 *
 * @author LinZebin
 * @date 2020/5/11 6:56 下午
 */
public class RosterTest {


	// Approach 7: Use Lambda Expressions Throughout Your Application

	public static void processPersons(
			List<Person> roster,
			Predicate<Person> tester,
			Consumer<Person> block) {
		for (Person p : roster) {
			if (tester.test(p)) {
				block.accept(p);
			}
		}
	}

	// Approach 7, second example

	public static void processPersonsWithFunction(
			List<Person> roster,
			Predicate<Person> tester,
			Function<Person, String> mapper,
			Consumer<String> block) {
		for (Person p : roster) {
			if (tester.test(p)) {
				String data = mapper.apply(p);
				block.accept(data);
			}
		}
	}

	// Approach 8: Use Generics More Extensively

	public static <X, Y> void processElements(
			Iterable<X> source,
			Predicate<X> tester,
			Function<X, Y> mapper,
			Consumer<Y> block) {
		for (X p : source) {
			if (tester.test(p)) {
				Y data = mapper.apply(p);
				block.accept(data);
			}
		}
	}

	public static void main(String... args) {

		List<Person> roster = Person.createRoster();

		// 方法1
		System.out.println("Persons older than 20:");
		FilterMethod.printPersonsOlderThan(roster, 27);
		System.out.println();

		// 方法2
		System.out.println("Persons between the ages of 15 and 30:");
		FilterMethod.printPersonsWithinAgeRange(roster, 15, 30);
		System.out.println();

		// 方法3 匿名类
		System.out.println("定义接口，匿名类实现方式:");
		FilterMethod.printPersons(roster, new CheckPerson() {
			@Override
			public boolean test(Person person) {
				return Sex.MALE.equals(person.getGender());
			}
		});
		System.out.println();

		// 方法4：lamb表达式
		System.out.println("lambda表达式：");
		FilterMethod.lambdaFilter(roster, person -> person.gender.equals(Sex.FEMALE));
		System.out.println();

		// 方法5：lambda表达式，使用Predicate和Consumer
		System.out.println("lambda表达式，使用Predicate和Consumer:");
		FilterMethod.lambdaFilterWithAction(roster,
				person -> person.age >= 15 && person.age < 30,
				Person::printPerson);

		// 方法6：lambda表达式，使用Predicate判断，Function<Person,PersonDao>接收person并返回一个PersonDao对象，
		// Consumer<PersonDao>接收一个PersonDao对象并做相应处理
		System.out.println("lambda表达式，使用Predicate和Function和Consumer");
		FilterMethod.lambdaFilterWithFunction(roster,
				p -> p.getGender().equals(Sex.FEMALE),
				p -> {
					PersonDao personDao = new PersonDao();
					personDao.setName(p.getName());
					personDao.setAge(p.getAge());
					personDao.setSex(p.getGender());
					return personDao;
				},
				personDao -> System.out.println("将personDao插入数据库")
				);
		System.out.println();

		// 方法7：通用方法
		System.out.println("通用方法，接收任意类型的一组数据，完成不用的操作：");
		List<Student> students = Student.createRoster();
		FilterMethod.genericMethod(
				students,
				student -> student.getClazz().equals("一班"),
				student -> {
					PersonDao personDao = new PersonDao();
					personDao.setName(student.getName());
					personDao.setAge(student.getAge());
					personDao.setSex(student.getSex());
					return personDao;
				},
				personDao -> System.out.println("将personDao插入数据库")
		);
		System.out.println();

		// stream
		System.out.println("stream：");
		roster
				.stream()
				.filter(person -> person.getGender().equals(Sex.MALE))
				.map(Person::getName)
				.forEach(System.out::println);
	}
}
