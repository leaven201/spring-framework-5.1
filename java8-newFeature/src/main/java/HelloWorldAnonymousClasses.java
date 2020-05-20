/**
 * 匿名类的作用
 * @author LinZebin
 * @date 2020/5/11 5:53 下午
 */
public class HelloWorldAnonymousClasses {

	interface HelloWorld {
		public void greet();
		public void greetSomeone(String someone);
	}

	public void sayHello() {

		class EnglishGreeting implements HelloWorld {
			String name = "world";
			@Override
			public void greet() {
				greetSomeone("world");
			}
			@Override
			public void greetSomeone(String someone) {
				name = someone;
				System.out.println("Hello " + name);
			}
		}

		HelloWorld englishGreeting = new EnglishGreeting();

		HelloWorld chineseGreeting = new HelloWorld() {
			String name = "世界";
			@Override
			public void greet() {
				greetSomeone("世界");
			}
			@Override
			public void greetSomeone(String someone) {
				name = someone;
				System.out.println("你好 " + name);
			}
		};

		HelloWorld spanishGreeting = new HelloWorld() {
			String name = "mundo";
			@Override
			public void greet() {
				greetSomeone("mundo");
			}
			@Override
			public void greetSomeone(String someone) {
				name = someone;
				System.out.println("Hola, " + name);
			}
		};
		englishGreeting.greet();
		chineseGreeting.greetSomeone("世界");
		spanishGreeting.greet();
	}

	public static void main(String... args) {
		HelloWorldAnonymousClasses myApp =
				new HelloWorldAnonymousClasses();
		myApp.sayHello();
	}
}
