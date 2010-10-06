package lab2.core;

public class Person {
	protected String name;
	protected int age;
	
	public Person(String name, int age) {
		this.name = new String(name);
		this.age = new Integer(age);
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

}
