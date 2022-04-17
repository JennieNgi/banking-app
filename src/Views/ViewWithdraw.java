package Views;
import ModelController.*;
import Tools.*;
import javax.swing.JFrame;

import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;

public class ViewWithdraw extends JFrame{
	private Model model;
	private JTextField txtAmount;
	private JTextField txtDescription;
	private JButton btnOk;
	private JButton btnCancel;
	private TextFieldValidator textFieldValidatorAmount;
	private TextFieldValidator textFieldValidatorDescription;
	private JTextArea txtErrorMessage;
	
	public ViewWithdraw(Model myModel) {
		
		setBounds(100, 100, 480, 414);
		this.setResizable(false);
		JLabel lblHeader = new JLabel("Bank Machine Simulation v1.0 >");
		lblHeader.setForeground(Color.BLUE);
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lbAmount = new JLabel("Enter Amount to withdraw: $");
		
		txtAmount = new JTextField();
		txtAmount.setColumns(10);
		
		txtDescription = new JTextField();
		txtDescription.setColumns(10);
		
		JLabel lblDescription = new JLabel("Transaction Description:");
		
		btnOk = new JButton("Ok");
		
		btnCancel = new JButton("Cancel");
		
		textFieldValidatorAmount = new TextFieldValidator(txtAmount);
		textFieldValidatorAmount.setRegExp("^[0-9]*\\.[0-9][0-9]$");
		
		textFieldValidatorDescription = new TextFieldValidator(txtDescription);
		textFieldValidatorDescription.setRegExp("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$");
		
		txtErrorMessage = new JTextArea();
		txtErrorMessage.setForeground(Color.RED);
		txtErrorMessage.setLineWrap(true);
		txtErrorMessage.setEditable(false);
		txtErrorMessage.setOpaque(false);
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHeader, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lbAmount, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblDescription, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnOk)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnCancel)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtDescription, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtErrorMessage, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblHeader)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbAmount)
						.addComponent(txtAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescription)
						.addComponent(txtDescription, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnOk)
								.addComponent(btnCancel)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(txtErrorMessage, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(159, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		model = myModel;
	}
	
	public TextFieldValidator getTextValidatorAmount() {
		return textFieldValidatorAmount;
	}
	
	public TextFieldValidator getTextValidatorDescription() {
		return textFieldValidatorDescription;
	}
	
	public void validateMe() {
		textFieldValidatorAmount.checkWithDrawAmount(model.getAccounts().get(model.getCurrentAccount()).getBalance() , model.getAccounts().get(model.getCurrentAccount()).getFee());
//		System.out.println(model.getAccounts().get(model.getCurrentAccount()).getBalance());
//		System.out.println(model.getAccounts().get(model.getCurrentAccount()).getFee());
		textFieldValidatorDescription.check();
		
		if (textFieldValidatorAmount.getValidateStatus() == false && textFieldValidatorDescription.getValidateStatus() == false) {
			txtErrorMessage.setText("Balance: $" + model.getAccounts().get(model.getCurrentAccount()).getBalanceStr() + "\nWithdrawal Fee: $" + model.getAccounts().get(model.getCurrentAccount()).getFeeStr() + "\n*0.00 format for amount >=balance + withdrawal \nfee and >0 required \n*Description required");
			
			textFieldValidatorAmount.checkWithDrawAmount(model.getAccounts().get(model.getCurrentAccount()).getBalance() , model.getAccounts().get(model.getCurrentAccount()).getFee());
			textFieldValidatorDescription.check();
		}else {
		
			if (textFieldValidatorAmount.getValidateStatus() == true) {
				textFieldValidatorAmount.reset();
				textFieldValidatorDescription.check();
				if (textFieldValidatorDescription.getValidateStatus() == false) {
					txtErrorMessage.setText("*Description required");
				}
			}else {
				textFieldValidatorAmount.checkWithDrawAmount(model.getAccounts().get(model.getCurrentAccount()).getBalance() , model.getAccounts().get(model.getCurrentAccount()).getFee());
				txtErrorMessage.setText("Balance: $" + model.getAccounts().get(model.getCurrentAccount()).getBalanceStr() + "\nWithdrawal Fee: $" + model.getAccounts().get(model.getCurrentAccount()).getFeeStr() + "\n*0.00 format for amount >=balance + withdrawal \nfee and >0 required");
			}
			
			if (textFieldValidatorDescription.getValidateStatus() == true) {
				textFieldValidatorDescription.reset();
				textFieldValidatorAmount.checkWithDrawAmount(model.getAccounts().get(model.getCurrentAccount()).getBalance() , model.getAccounts().get(model.getCurrentAccount()).getFee());
				if (textFieldValidatorAmount.getValidateStatus() == false) {
					txtErrorMessage.setText("Balance: $" + model.getAccounts().get(model.getCurrentAccount()).getBalanceStr() + "\nWithdrawal Fee: $" + model.getAccounts().get(model.getCurrentAccount()).getFeeStr() + "\n*0.00 format for amount >=balance + withdrawal \nfee and >0 required");
				}
			}else {
				textFieldValidatorDescription.check();
				txtErrorMessage.setText("*Description required");
			}	
		}
	}
	
	public void resetMe() {
		textFieldValidatorAmount.reset();
		textFieldValidatorDescription.reset();
		txtErrorMessage.setText("");
		txtAmount.setText("");
		txtDescription.setText("");
	}
	
	public String getDescription() {
		String description = txtDescription.getText();	
		return description;
	}
	
	public String getAmount() {
		String despoitAmount = txtAmount.getText();	
		return despoitAmount;
	}
	
	public void withdrawListener (ActionListener withdrawActionListener) {
		btnOk.addActionListener(withdrawActionListener);
	}

	public void addCancelListener (ActionListener cancelActionListener) {
		btnCancel.addActionListener(cancelActionListener);
	}

}
