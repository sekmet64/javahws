package lab2.core;

public class Student extends Person {
	
	private String faculty;
	
	public Student(String name, int age, String faculty) {
		super(name, age);
		this.faculty = new String(faculty);
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	
	public String toString() {
		return name + " " + age + " " + faculty; 
	}
}
