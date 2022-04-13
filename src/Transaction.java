import java.time.LocalDateTime;   
import java.time.format.DateTimeFormatter;  

public class Transaction implements java.io.Serializable{
	
	private String description;
	private double amount;
	private LocalDateTime timeStamp;

    // --------------------------------------- constructor methods
    public Transaction() {
    	description = "";
    	amount = 0;
    	timeStamp = LocalDateTime.now(); 
    }
    
    public String getTimeStamp() {
    	DateTimeFormatter dtf;
    	dtf = DateTimeFormatter.ofPattern("E MMM dd HH:mm:ss 'ADT' yyyy");  
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
