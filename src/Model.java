import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Model {
	ArrayList<Account> accounts;
	SavingAccount newSavingAccount;
	AirmilesAccount newAirmilesAccount;
	Transaction newTransaction;
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
		newTransaction = new Transaction();
		newTransaction.setDescription(description);
		newTransaction.setAmount(amount);
		accounts.get(currentAccount).getTransactions().add(newTransaction);
		accounts.get(currentAccount).deposit(amount);
	}
	
	public String getReport() {
		return accounts.get(currentAccount).viewAccount();
	}
	
	public void withdraw(String description, String amount) {
		newTransaction = new Transaction();
		newTransaction.setDescription(description);
		newTransaction.setAmount("-" + Double.toString(Double.parseDouble(amount) + accounts.get(currentAccount).getFee()));
		accounts.get(currentAccount).getTransactions().add(newTransaction);
		accounts.get(currentAccount).withdraw(amount);
	}
	
	public String getListItems() {
		return accounts.get(currentAccount).getDescription();
	}
	
	public void deleteAccount() {
		accounts.remove(currentAccount);
		currentAccount = accounts.size()-1;
	}
	
	public void selectAccount(int value) {
		currentAccount = value;
	}
	
}
