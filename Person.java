import java.util.ArrayList;

import java.util.Random;

public class Person {
	int balance;
	int creditScore;
	String name;
	ArrayList<Integer> loanAmounts;

	public Person(String holderName, int startBalance, int startCreditScore, ArrayList<Integer> loans){
		name = holderName;
		balance = startBalance;
		creditScore = startCreditScore;
		loanAmounts = loans;
	}
	//creates account for Person object
	public void createAccount(Person currentPerson, Bank currentBank){
		currentBank.accounts.put(currentPerson, 0); 
		
	}
	// putting money into account
	public void storeMoney(Person accountHolder, Bank currentBank){
		System.out.println("Account Holder: " + accountHolder.name);
		System.out.println("Current Balance: " + accountHolder.balance);
		System.out.println("Credit Score: " + accountHolder.creditScore);
		// make random percent of balance the requested stored amount later, for now 10%
		
		int toBeStored = (int) (accountHolder.balance * .1);
		System.out.println("Amount to be stored: " + toBeStored);
		
		
		// put toBeStored into bank
		// adds money to total bank money for bank to use
		currentBank.money = currentBank.money + toBeStored;
		// adds money to account for individual transactions
		System.out.println("accounts: "+ currentBank.accounts);
		Integer account_money = currentBank.accounts.get(accountHolder);
		System.out.println("Old account balance: "+ account_money);
		account_money = account_money + toBeStored;
		//replaces old account value to new value
		currentBank.accounts.put(accountHolder, account_money);
		System.out.println("New account balance: "+currentBank.accounts.get(accountHolder));
		// subtract money from person object
		System.out.println("Money on "+accountHolder.name+" before transaction: " +accountHolder.balance);
		accountHolder.balance = accountHolder.balance - toBeStored;
		System.out.println("Money on "+accountHolder.name+" after transaction: " +accountHolder.balance);
	}
	// take money out of account (Note: NOT A LOAN)
	public void takeMoney(Person accountHolder, Bank currentBank){
		System.out.println("Account Holder: " + accountHolder.name);
		System.out.println("Current Balance: " + accountHolder.balance);
		System.out.println("Credit Score: " + accountHolder.creditScore);
		
		// make random percent of balance the requested stored amount later, for now 10%
		// Note: if no money in account, transaction will be cancelled.
		// Note: Make same sys for person if person has 0 money later.
		
		int toBeTaken = (int) (currentBank.accounts.get(accountHolder) * .1);
		// take out of bank total cash
		currentBank.money = currentBank.money - toBeTaken;
		
		// subtracts money from account
		Integer account_money = currentBank.accounts.get(accountHolder);
		System.out.println("Old account balance: "+ account_money);
		account_money = account_money - toBeTaken;
		System.out.println("Old account balance: "+ account_money);
		
		// Adds money to person
		
		System.out.println("Money on "+accountHolder.name+" before transaction: " +accountHolder.balance);
		accountHolder.balance = accountHolder.balance + toBeTaken;
		System.out.println("Money on "+accountHolder.name+" after transaction: " +accountHolder.balance);
		
	}
	
	
	// Loan system: 4% / year base rate. See reference for calculation based on credit score
	// below 620 is declined
	
	public double getRate(Person accountHolder, Bank currentBank){
		double interestRate = 0;
		double baseRate = currentBank.takeRate;
		double creditScore = accountHolder.creditScore;
		if(creditScore >=760 && creditScore <= 850){
			interestRate = baseRate;
		}else if(creditScore >= 700 && creditScore <= 759){
			interestRate = baseRate + .2;
		}else if(creditScore >= 680 && creditScore <= 699){
			interestRate = baseRate + .4; 
		}else if(creditScore >= 660 && creditScore <= 679){
			interestRate = baseRate + .6; 
		}else if(creditScore >= 640 && creditScore <= 659){
			interestRate = baseRate + 1.3; 
		}else if(creditScore <= 639){
			System.out.println("Loan denied. ");
			interestRate = 0.0;
		}
		return interestRate;
	}
	
	public void Loan(Person accountHolder, Bank currentBank){
		//gets the amount the Person will request
		Random r = new Random();
		int max = 100000;
		int min = 10000;
		int requestedAmount = r.nextInt((max - min) + 1) + min;
		double interestRate = accountHolder.getRate(accountHolder, currentBank);
		if(interestRate == 0){
			return;
		}
		System.out.println("Money in bank before loan: "+currentBank.money+" ");
		currentBank.money = currentBank.money - requestedAmount;
		System.out.println("Money in bank after loan: "+currentBank.money+" ");
		System.out.println("Account Holder balance before loan: "+accountHolder.balance);
		accountHolder.balance = accountHolder.balance + requestedAmount;
		System.out.println("Account Holder balance after loan: "+accountHolder.balance);
		ArrayList<Integer> temp = accountHolder.loanAmounts;
		temp.add(requestedAmount);
		System.out.println("List of current loans of: "+accountHolder.name+" "+temp);

		accountHolder.loanAmounts = temp;

	}
	
	
}
