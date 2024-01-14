package studentManagementSystem;

import java.util.Scanner;

public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StudentManagementSystem sms = new StudentManagementSystem();
		Student student = new Student();
		Scanner scanner = new Scanner(System.in);
		
		do {
		System.out.println("Welcome to Student Management System");
		System.out.println("1. List of All Students.");
		System.out.println("2. Search Student. ");
		System.out.println("3. Add New Student. ");
		System.out.println("4. Upadte Student Details");
		System.out.println("5. Remove Student");
		System.out.println("6. Exit");
		
		int choice=scanner.nextInt();
		switch(choice) {
		case 1:
			sms.showAll();
			break;
		case 2:
			sms.showOne();
			break;
		case 3:
			sms.addStudent(student);
			break;
		case 4:
			sms.updateStudent(student);
			break;
		case 5:
			sms.removeStudent(student);
			break;
		case 6:
			System.out.println("Thank-you for using this Application");
			System.exit(6);
		default :
			System.out.println("Enter valid input");
			break;
		}
		
		System.out.println("Do you want to continue?(yes/no)");
		String con = scanner.next().toLowerCase();
		if(!con.equals("yes")) {
			System.out.println("Thank-you for using this Application");
			break;	
		}
	}while(true);
		scanner.close();
  }
}
