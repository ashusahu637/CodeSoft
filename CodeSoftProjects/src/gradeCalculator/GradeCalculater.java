package gradeCalculator;

import java.util.Scanner;

public class GradeCalculater {

	public static void main(String[] args) {
		Scanner scanner =  new Scanner(System.in);
		
		System.out.println("Enter marks obtained in each subject :");
		int numSubjects=5;
		int[] marks = new int[numSubjects];
		
		for(int i=0; i < numSubjects; i++) {
			System.out.println("Subject" + (i+1) + ": ");
			marks[i] = scanner.nextInt();
		}
		
		int totalMarks = calculateTotalMarks(marks);
		
		double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);
		
		char grade = calculatGrade(averagePercentage);
		
		displayResult(totalMarks, averagePercentage, grade);
		
		scanner.close();

	}

	private static double calculateAveragePercentage(int totalMarks, int numSubjects) {
		
		 return (double)totalMarks/numSubjects;
		
	}

	private static void displayResult(int totalMarks, double averagePercentage, char grade) {
		
		System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
		
	}

	private static char calculatGrade(double averagePercentage) {
		if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
	}

	private static int calculateTotalMarks(int[] marks) {
		int totalMarks = 0;
		for(int mark : marks) {
			totalMarks += mark;
		}
		
		return totalMarks;
	}

}
