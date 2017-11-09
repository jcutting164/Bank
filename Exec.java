import java.util.ArrayList;
import java.util.HashMap;


public class Exec {
	public static void main(String [ ] args){
		HashMap<Person, Integer> accounts = new HashMap<Person, Integer>();
		ArrayList<Integer> loanAmounts = new ArrayList<Integer>();
		Bank first = new Bank(1000000, 1.0, 4.0, accounts);
		first.BankStats();
		
		Person Josh = new Person("Josh", 1000, 700, loanAmounts);
		Josh.createAccount(Josh, first);
		Josh.storeMoney(Josh, first);
		Josh.takeMoney(Josh, first);
		Josh.Loan(Josh, first);
		
		//start of process of creation of bank and person objects
		ArrayList<Bank> banks = new ArrayList<Bank>();
		for(int i=1; i<11; i++){
			Bank temp = new Bank(1000000, 1.0, 4.0, accounts);
			banks.add(temp);
		}
		for(int j=1; j<10; j++){
			for(int i=1; i<1000; i++){
				Person temp = new Person("Josh", 1000, 700, loanAmounts);
				temp.createAccount(temp, banks.get(j));
			}
		}

		
	/*	for(int i=1; i<2; i++){
			System.out.println("Year: "+i);
			
			for(int j=1; j<366; j++){
				System.out.println("Day: "+j); 
			}
		}*/
		
	}
}
