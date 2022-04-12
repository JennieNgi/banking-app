import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class ViewDeposit extends JFrame{
	private Model model;
	private JTextField txtAmount;
	private JTextField txtDescription;
	private JButton btnOk;
	private JButton btnCancel;
	private TextFieldValidator textFieldValidatorAmount;
	private TextFieldValidator textFieldValidatorDescription;
	private JTextArea txtErrorMessage;
	
	public ViewDeposit(Model myModel) {
		setBounds(100, 100, 480, 414);
		this.setResizable(false);
		JLabel lblHeader = new JLabel("Bank Machine Simulation v1.0 >");
		
		JLabel lblAmount = new JLabel("Enter Amount to deposit: $");
		
		txtAmount = new JTextField();
		txtAmount.setColumns(10);
		
		JLabel lblDescription = new JLabel("Transaction Description:");
		
		txtDescription = new JTextField();
		txtDescription.setColumns(10);
		
		btnOk = new JButton("Ok");
		
		btnCancel = new JButton("Cancel");
		textFieldValidatorAmount = new TextFieldValidator(txtAmount);
		textFieldValidatorAmount.setRegExp("^[0-9]*\\.[0-9][0-9]$");
		
		textFieldValidatorDescription = new TextFieldValidator(txtDescription);
		textFieldValidatorDescription.setRegExp("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$");
		
		txtErrorMessage = new JTextArea();
		txtErrorMessage.setForeground(Color.RED);
		txtErrorMessage.setEditable(false);
		txtErrorMessage.setOpaque(false);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHeader, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDescription, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAmount, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnOk)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnCancel)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtErrorMessage, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(txtAmount)
									.addComponent(txtDescription)))))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblHeader)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAmount)
						.addComponent(txtAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDescription)
						.addComponent(txtDescription, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnOk)
							.addComponent(btnCancel))
						.addComponent(txtErrorMessage, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(197, Short.MAX_VALUE))
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
		textFieldValidatorAmount.checkAmount();
		textFieldValidatorDescription.checkDescription();
		
		if (textFieldValidatorAmount.getValidateStatus() == false && textFieldValidatorDescription.getValidateStatus() == false) {
			txtErrorMessage.setText("*0.00 format for starting balance required \n*Description required");
			
			textFieldValidatorAmount.checkAmount();
			textFieldValidatorDescription.checkDescription();
		}else {
		
			if (textFieldValidatorAmount.getValidateStatus() == true) {
				textFieldValidatorAmount.reset();
				textFieldValidatorDescription.checkDescription();
				if (textFieldValidatorDescription.getValidateStatus() == false) {
					txtErrorMessage.setText("*Description required");
				}
			}else {
				textFieldValidatorAmount.checkAmount();
				txtErrorMessage.setText("*0.00 format for amount required");
			}
			
			if (textFieldValidatorDescription.getValidateStatus() == true) {
				textFieldValidatorDescription.reset();
				textFieldValidatorAmount.checkAmount();
				if (textFieldValidatorAmount.getValidateStatus() == false) {
					txtErrorMessage.setText("*0.00 format for amount required");
				}
			}else {
				textFieldValidatorDescription.checkDescription();
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
	
	public void addDepositListener (ActionListener addDepositActionListener) {
		btnOk.addActionListener(addDepositActionListener);
	}

	public void addCancelListener (ActionListener cancelActionListener) {
		btnCancel.addActionListener(cancelActionListener);
	}
}
