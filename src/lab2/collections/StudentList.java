package lab2.collections;

import lab2.core.Student;

public class StudentList {
	private int current;
	private Student[] students;
	
	public StudentList(int size) {
		students = new Student[size];
		current = 0;
	}
	
	public void addStudent(Student student) {
		if (current < students.length) {
			students[current++] = student;
		}
	}
	public StudentIterator getEnumeration() {
		return new StudentIteratorImpl();
	}
	
	public class StudentIteratorImpl implements StudentIterator{
		
		private int index;
		
		public StudentIteratorImpl() {
			index = 0;
		}
		
		@Override
		public boolean hasMoreElements() {
			return index < students.length;
		}

		@Override
		public Student nextElement() {
			return students[index++];
		}

	}

}
