
public class test {
	public static void main(String[] args) {
		ABStack<String> person = new ABStack<>();
		
		person.push("Test");
		person.push("this");
		ABStack<String> person1 = new ABStack<>();
		person1.push("Test1");
		person1.push("this1");
		ABStack<String> c = new ABStack<>(person1);

		ABStack<String> t = new ABStack<>();
		t.copy(person);
		t.push("shoot");
		System.out.println(person);
		System.out.println(t);
		System.out.println(person1);
		System.out.println(c);

	}
}
