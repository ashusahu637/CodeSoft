package atmInterfaceTask3;

import java.util.Scanner;

class BankAccounnt{
	private double balance;

	public BankAccounnt(double balance) {
		super();
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void deposit(double amount) {
		balance += amount;
		}
	
	public boolean withdraw(double amount) {
		if(amount <= balance) {
			balance -= amount;
			return true;
		}
		else 
			return false;
	}
}

public class AtmInterface {
	
	private BankAccounnt userAccount;
	
	
	public AtmInterface(BankAccounnt userAccount) {
		super();
		this.userAccount = userAccount;
	}

	public void withdraw(double amount)throws Exception {
		if(userAccount.withdraw(amount)) {
			System.out.println("Wihdrawal successful. Remaining balance: " + userAccount.getBalance());
		
		}else {
			throw new Exception("Insuficient funds. withdrawal failed.");
		}
	}
	
	public void deposit(double amount) {
		userAccount.deposit(amount);
		System.out.println("Deposite successful. New balance: "+userAccount.getBalance());
	}
	
	public void checkBalance() {
		System.out.println("Current balance: "+userAccount.getBalance());
	}
	
	
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	BankAccounnt userAccounnt = new BankAccounnt(3000);
		AtmInterface atm = new AtmInterface(userAccounnt);
	
		do {
			System.out.println("Welcome to SBI: ");
			System.out.println("1. Withdrwal");
			System.out.println("2. Deposit");
			System.out.println("3. Check Balance");
			System.out.println("4. Exit");
			
			int choice = scanner.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Enter withdrawal amount");
				double withdrawAmount = scanner.nextDouble();
				if(withdrawAmount > 0) {
					try {
						atm.withdraw(withdrawAmount);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				}else {
					System.out.println("Invalid amount. Please a valid Amount.");
				}
				break;
				
			case 2:
				System.out.println("Enter deposit amount: ");
				double depositAmount = scanner.nextDouble();
				if(depositAmount > 0) {
					atm.deposit(depositAmount);
				}else {
					System.out.println("Invalid amount. Please a valid Amount");
				}
				break;
				
			case 3:
				atm.checkBalance();
				break;
				
			case 4:
			System.out.println("Thank you for Banking with us.");
			    System.exit(4);
			
			default:
				System.out.println("Invalid choice. Please choose a valid option.");
				break;
			}
			
			System.out.println("Do you want to continue?(yes/no)");
			String con = scanner.next().toLowerCase();
			if(!con.equals("yes")) {
			System.out.println("Thank you for Banking with us.");
				break;
			}
		}while(true);
	}

}
