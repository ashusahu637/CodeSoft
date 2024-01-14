package studentManagementSystemTask5;

import java.util.Collection;
import java.util.Scanner;

public class StudentManagementSystem {

	Scanner scanner = new Scanner(System.in);

	public void addStudent(Student student) {
		StudentInterface<Student,Integer> di = new StudentDatabaseDao();
		System.out.println("Enter Student ID: ");
		int studentId = scanner.nextInt();
		System.out.println("Enter Student Name: ");
		String studentName = scanner.next();
		System.out.println("Enter Roll No.: ");
		int rollNo = scanner.nextInt();
		System.out.println("Enter Grade: ");
		String grade = scanner.next();
		Student stu = new Student(studentId,studentName,rollNo,grade);
		di.createNew(stu);
	}
	
	public void removeStudent(Student student) {
		StudentInterface<Student, Integer> di = 
				new StudentDatabaseDao();
		System.out.println("Enter Student ID: ");
		int id = scanner.nextInt();
		      di.deleteById(id);
	}
	
	public void updateStudent(Student student) {
		
		StudentInterface<Student, Integer> di = 
				new StudentDatabaseDao();
		
		System.out.println("Enter Student ID: ");
		int id = scanner.nextInt();
		Student rst = di.getOneById(id);
		
		System.out.println("Enter Student Name: ");
		String name = scanner.next();
		System.out.println("Enter Roll No.: ");
		int rollno = scanner.nextInt();
		System.out.println("Enter Grade: ");
		String grade = scanner.next();
		
		rst.setStudentName(name);
		rst.setGrade(grade);
		rst.setRollNo(rollno);
		di.update(rst);
	}
	
	public void showOne() {
		StudentInterface<Student, Integer> di = 
				new StudentDatabaseDao();
		System.out.println("Enter Student ID: ");
		int id = scanner.nextInt();
		Student rst = di.getOneById(id);
		if(rst != null)
			System.out.println(rst);
		else
			System.out.println("Student with this id not found");
	}
	
	
	public void showAll() {
		StudentInterface<Student, Integer> di = 
				new StudentDatabaseDao();
		Collection<Student> allStudents = di.getAll();
		for(Student rs : allStudents)
			System.out.println(rs);
	}
	
}
