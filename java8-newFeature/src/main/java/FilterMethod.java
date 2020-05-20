import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author LinZebin
 * @date 2020/5/11 8:41 下午
 */
public class FilterMethod {

	/**
	 * 方法1：创建一个选择方法，条件为年龄不小于age
	 * @param roster 用户名单
	 * @param age    年龄要求
	 */
	public static void printPersonsOlderThan(List<Person> roster, int age) {
		for (Person p : roster) {
			if (p.getAge() >= age) {
				p.printPerson();
			}
		}
	}

	/**
	 * 方法2：相较于方法1更通用的方法，条件为，age在[low,high)间
	 * @param roster
	 * @param low
	 * @param high
	 */
	public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
		for (Person p : roster) {
			if (low <= p.getAge() && p.getAge() < high) {
				p.printPerson();
			}
		}
	}

	/**
	 * 上述的方法都很单一，如果筛选条件需要改变，比如要根据性别，地域等筛选，再或者Person类增加了别的属性时，就又需要增加新方法
	 * 这种根据筛选条件，分别构建方法会很脆弱，需要更加通用的方法
	 * 方法3：创建内部类CheckPerson，接口中定义test方法，使用匿名类，然后重写test方法
	 * @param roster
	 * @param tester
	 */
	public static void printPersons(List<Person> roster, CheckPerson tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}



	/**
	 * 方法4：使用Predicate接口，然后通过lambda表达式判断
	 * @param roster
	 * @param tester
	 */
	public static void lambdaFilter(List<Person> roster, Predicate<Person> tester){
		for (Person person : roster) {
			if (tester.test(person)) {
				person.printPerson();
			}
		}
	}

	/**
	 * 方法5：lambda表达式
	 * @param roster
	 * @param tester Predicate用以判断
	 * @param action Consumer，接收一个对象然后对该对象做相应处理，没有返回值
	 */
	public static void lambdaFilterWithAction(List<Person> roster,Predicate<Person> tester,
			Consumer<Person> action){
		for (Person person : roster) {
			if (tester.test(person)){
				action.accept(person);
			}
		}
	}

	/**
	 * 方法6：lambda表达式
	 * @param roster
	 * @param tester
	 * @param action Function，接收一个对象并返回一个对象
	 */
	public static void lambdaFilterWithFunction(List<Person> roster,Predicate<Person> tester,
			Function<Person, PersonDao> action, Consumer<PersonDao> dao){
		for (Person person : roster) {
			if (tester.test(person)){
				PersonDao personD = action.apply(person);
				dao.accept(personD);
			}
		}
	}

	/**
	 * 方法7：通用方法，接收任意格式的一组数据，完成不同的操作
	 * @param source
	 * @param tester
	 * @param action
	 * @param dao
	 * @param <X>
	 * @param <Y>
	 */
	public static <X,Y> void genericMethod(
			Iterable<X> source,
			Predicate<X> tester,
			Function<X,Y> action,
			Consumer<Y> dao){
		for (X x : source) {
			if (tester.test(x)) {
				Y y = action.apply(x);
				dao.accept(y);
			}
		}
	}

}
