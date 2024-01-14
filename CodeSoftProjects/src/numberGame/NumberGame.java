package numberGame;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int lowerLimit=1;
		int upperLimit=100;
		int noOfAttempts=5;
		int score=0;
		
		System.out.println("Welcome to the Number Game");
		
		do {
			int targetNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
			int count = 0;
			boolean guessedCorrectly = false;
			
			System.out.println("Select a number between " +lowerLimit + " and " +upperLimit);
			
			while(count < noOfAttempts) {
				System.out.println("Enter your guess : ");
				int userGuess=scanner.nextInt();
				count++;
				
				if(userGuess == targetNumber) {
					System.out.println("Congratuations You have guess the correct number in : "+count+" attempt" );
					guessedCorrectly = true;
					score += noOfAttempts - count +1;
					break;
				}
				else if(userGuess < targetNumber) {
					System.out.println("Too low try again");
				}
				else {
					System.out.println("Too high try again");
				}
			}
			
			if(!guessedCorrectly) {
				System.out.println("Sorry, You've run out of attempts. The Correct number was : " + targetNumber);
			}
			
			System.out.println("Do you want to play again?(yes/no)");
			String playagain = scanner.next().toLowerCase();
			if(!playagain.equals("yes")) {
				break;
			}
		}while(true);
		
		System.out.println("Thankyou  Your Score is : "+score);
		scanner.close();
	}

}
