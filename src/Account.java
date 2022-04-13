import java.util.ArrayList;

/*
 * Student Super class -----------------------------this class live to be inherited by sub-classes
 * Intro to Object Oriented Programming
 * Sean Morrow
*/


// make it an abstract class because 1)gives you the abstract method   2)you can't construct any Student object, only the sub class objects, the Student class is only for purpose of inheriting
public abstract class Account implements java.io.Serializable{

    protected String description;
    protected double balance;
    protected ArrayList<Transaction> transactions;
    protected String myReport;

    // --------------------------------------- constructor methods
    public Account() {
    	description = "";
        balance = 0;
        transactions = new ArrayList<Transaction>();
        myReport = "";
    }

    // --------------------------------------- get/set methods
    public double getBalance() {
    	return balance;
	}
    
    public String getBalanceStr() {
    	return Double.toString(balance);
	}
    
    public void setBalance(double newBalance) {
    	balance = newBalance;
	}
    
    public String getDescription() {
    	return description;
    }
    
    public void setDescription(String newDescription) {
    	description = newDescription;
	}
    
    public ArrayList<Transaction> getTransactions() {
		return transactions;
	}
    
    public void deposit(String value) {
    	balance = balance + Double.parseDouble(value);
    }
   
    
    
    // --------------------------------------- abstract method
    public abstract void withdraw(String value);
    
    //for Model withdraw method
    public abstract double getFee();
    // for ViewWithdraw error message
    public abstract String getFeeStr();
    
    public abstract String viewAccount();
    
}