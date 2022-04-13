
public class AirmilesAccount extends Account{
	
	public final static double FEE = 0.75;
	public final static String TYPE = "Air Miles Account";
	
	private int airmiles;
	private int extraAirmiles;
//	private String myReport;
		
	public AirmilesAccount() {
		super();
		// TODO Auto-generated constructor stub
		airmiles = 0;
		extraAirmiles = 0;
//		myReport = "";
	}
	
	public void initialDepositAirmiles() {	
		airmiles = airmiles + 10;
    }
	
	// ----------------------------------------------------------------------- overriding method
	public void deposit(String value) {
//		System.out.println(times);
		// calling the super method in the super class first and based on it ADDING something to it
		super.deposit(value);
		
		double valueDouble = Double.parseDouble(value);
		
		while (valueDouble >= 30 ) 
		{
			valueDouble = valueDouble - 30;
//			System.out.println(valueDouble);
		    extraAirmiles++;
//		    System.out.println(times);
		}

		airmiles = airmiles + extraAirmiles;
		// reset times to 0 so it won't accumulate next time
		extraAirmiles = 0;
    }
	
	// ----------------------------------------------------------------------- abstract method
	public String viewAccount() {
		myReport = TYPE + '\n';
        myReport += "Account description: " + description + '\n';
        myReport += "Account Type: " + TYPE + '\n';
        myReport += "Current balance: " + balance + '\n';
        myReport += "Air Miles: " + airmiles + '\n';
        
	    for (int n=0; n<transactions.size(); n++) {
	    	myReport += transactions.get(n).getTimeStamp() + ": $" + transactions.get(n).getAmount() + " [" + transactions.get(n).getDescription() + "] " +'\n';     	
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
