package lab2;

import lab2.collections.StudentIterator;
import lab2.collections.StudentList;
import lab2.core.Student;

public class TestStudentList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StudentList students = new StudentList(5);
		students.addStudent(new Student("Antal", 18, "CS"));
		students.addStudent(new Student("Bela", 19, "M"));
		students.addStudent(new Student("Csenge", 20, "CS"));
		students.addStudent(new Student("Dezso", 21, "M"));
		students.addStudent(new Student("Endre", 22, "CS"));
		
		StudentIterator e = students.getEnumeration();

		while (e.hasMoreElements())
			System.out.println(e.nextElement());
	}

}
