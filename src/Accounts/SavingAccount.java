package Accounts;

public class SavingAccount extends Account{
	
	public final static double FEE = 0.50;
	public final static String TYPE = "Savings Account";
//	private String myReport;
	
	public SavingAccount() {
		super();
//		myReport = "";
		// TODO Auto-generated constructor stub
	}
	
	public String viewAccount() {
		myReport = TYPE + '\n';
        myReport += "Account Description: " + description + '\n';
        myReport += "Account Type: " + TYPE + '\n';
        myReport += String.format("Current Balance: $%.02f \n", balance);
	    for (int n=0; n<transactions.size(); n++) {
	    	myReport += transactions.get(n).getTimeStamp() + ": $" + String.format("%.02f", transactions.get(n).getAmount()) + " [" + transactions.get(n).getDescription() + "] " +'\n';	    
	    }
        return myReport;
    }
	
	public void withdraw(String value) {
    	balance = balance - Double.parseDouble(value) - FEE;
    }
	
	public double getFee() {
    	return FEE;
    }
	
	public String getFeeStr() {
    	return Double.toString(FEE);
	}

}
