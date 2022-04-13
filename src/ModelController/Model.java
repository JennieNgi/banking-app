package ModelController;
import Accounts.*;
import Tools.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model {
	ArrayList<Account> accounts;
	int currentAccount;
	
	public Model() {
		accounts = new ArrayList<Account>();
		currentAccount = accounts.size()-1;
	}
	
	// ---------------------------------------------------- public methods
	
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	
	public int getCurrentAccount(){
		return currentAccount;
	}
	
	public void setCurrentAccount(int value){
		currentAccount = value;
	}
	
	
	public void addAccount(String description, String initialBalance, int selectedAccountTypeIndex) {
		if (selectedAccountTypeIndex == 0) {
			AirmilesAccount newAirmilesAccount = new AirmilesAccount();
			newAirmilesAccount.setDescription(description);
			accounts.add(newAirmilesAccount);
			newAirmilesAccount.initialDepositAirmiles();
			newAirmilesAccount.deposit(initialBalance);
			
			// set the active account to the last added account
			currentAccount = accounts.size()-1;
			
			
		}else {
			SavingAccount newSavingAccount = new SavingAccount();
			newSavingAccount.setDescription(description);
			accounts.add(newSavingAccount);
			newSavingAccount.deposit(initialBalance);
			
			// set the active account to the last added account
			currentAccount = accounts.size()-1;
		}
		
	}
	
	public void addDeposit(String description, String amount) {
		Transaction newTransaction = new Transaction();
		newTransaction.setDescription(description);
		newTransaction.setAmount(amount);
		accounts.get(currentAccount).getTransactions().add(newTransaction);
		accounts.get(currentAccount).deposit(amount);
	}
	
	public String getReport() {
		return accounts.get(currentAccount).viewAccount();
	}
	
	public void withdraw(String description, String amount) {
		Transaction newTransaction = new Transaction();
		newTransaction.setDescription(description);
		newTransaction.setAmount("-" + Double.toString(Double.parseDouble(amount) + accounts.get(currentAccount).getFee()));
		accounts.get(currentAccount).getTransactions().add(newTransaction);
		accounts.get(currentAccount).withdraw(amount);
	}
	
	public String getListItems() {
//		System.out.println(currentAccount);
		return accounts.get(currentAccount).getDescription();
	}
	
	public void deleteAccount() {
		accounts.remove(currentAccount);
		currentAccount = accounts.size()-1;
	}
	
	public void selectAccount(int value) {
		currentAccount = value;
	}
	
	public void writeObject() {
		List<Object> objectlist = new ArrayList<>();
		FileManager.getInstance().setFilename("account.dat");
		// loop thru the accounts and add each account to the List<Object> objectlist
		for (Account a : accounts) {
			objectlist.add(a);
		}
		System.out.println(objectlist);
		// save the entire List<Object> objectlist to the file
		FileManager.getInstance().save(objectlist);		
		
	}
	
	public void readObject() {
		// load the account object[] using singleton FileManager Class
		FileManager.getInstance().setFilename("account.dat");
		// converting the List<Object> into List<ArrayList>
		List<Account> accountList = (List<Account>) FileManager.getInstance().load();
		System.out.println(accountList);
		// converting the List <Account> into ArrayList
		accounts.addAll(accountList);
		// set the default selected account to the first one
		currentAccount = 0;
	}
	
}
