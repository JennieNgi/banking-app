import java.time.LocalDateTime;   
import java.time.format.DateTimeFormatter;  

public class Transaction {
	protected String description;
    protected double amount;
    protected LocalDateTime timeStamp;
    protected DateTimeFormatter dtf;

    // --------------------------------------- constructor methods
    public Transaction() {
    	description = "";
    	amount = 0;
    	timeStamp = LocalDateTime.now(); 
    	dtf = DateTimeFormatter.ofPattern("E MMM dd HH:mm:ss 'ADT' yyyy");  
    }
    
    public String getTimeStamp() {
    	return dtf.format(timeStamp);
	}
    
    public String getAmountStr() {
    	return Double.toString(amount);
	}
    
    public double getAmount() {
    	return amount;
	}
    
    public void setAmount(String newAmount) {
    	amount = Double.parseDouble(newAmount);
	}
    
    public String getDescription() {
    	return description;
    }
    
    public void setDescription(String newDescription) {
    	description = newDescription;
	}
    
    
    
}
