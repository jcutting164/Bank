import java.util.HashMap;


public class Bank {
	int money;
	double storeRate;
	HashMap<Person, Integer> accounts;
	double takeRate;

	public Bank(int startMoney, double startStoreRate, double startTakeRate, HashMap<Person, Integer> startAccounts){
		money = startMoney;
		storeRate = startStoreRate;
		takeRate = startTakeRate;
		accounts = startAccounts;
	}
	
	public void BankStats(){
		System.out.println("Money: " + money);
		System.out.println("Store Rate: " + storeRate);
		System.out.println("Accounts: " + accounts);
	}
	
	
	
}
