package Views;
import ModelController.*;
import Tools.*;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;

public class ViewCreate extends JFrame{
	
	private JTextField txtDescription;
	private JTextField txtBalance;
	private JButton btnOk;
	private JButton btnCancel;
	private JList<String> listAccountType;
	private TextFieldValidator textFieldValidatorAmount;
	private TextFieldValidator textFieldValidatorDescription;
	private JTextArea txtErrorMessage;
	private Model model;
	
	public ViewCreate(Model myModel) {
		setBounds(100, 100, 480, 414);
		this.setResizable(false);
		JLabel lblHeader = new JLabel("Bank Machine Simulation v1.0 >");
		lblHeader.setForeground(Color.BLUE);
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		
		listAccountType = new JList<String> ();
		listAccountType.setModel(new AbstractListModel() {
			String[] values = new String[] {"Air Miles Account", "Savings Account"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listAccountType.setSelectedIndex(0);
		
		
		JLabel lblSelect = new JLabel("Select Account Type:");
		
		JLabel lblDescription = new JLabel("Account Description:");
		
		txtDescription = new JTextField();
		txtDescription.setColumns(10);
		
		txtBalance = new JTextField();
		txtBalance.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("Starting Balance: $");
		
		btnOk = new JButton("Ok");
		
		btnCancel = new JButton("Cancel");
		
		txtErrorMessage = new JTextArea("");
		txtErrorMessage.setForeground(Color.RED);
		txtErrorMessage.setEditable(false);
		txtErrorMessage.setOpaque(false);
		
		textFieldValidatorAmount = new TextFieldValidator(txtBalance);
		textFieldValidatorAmount.setRegExp("^[0-9]*\\.[0-9][0-9]$");
		
		textFieldValidatorDescription = new TextFieldValidator(txtDescription);
		textFieldValidatorDescription.setRegExp("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$");
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHeader, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblDescription, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblSelect, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtDescription, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(listAccountType, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtBalance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnOk)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnCancel))
								.addComponent(txtErrorMessage, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(72, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblHeader)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSelect)
						.addComponent(listAccountType))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescription)
						.addComponent(txtDescription, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtBalance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOk)
						.addComponent(btnCancel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtErrorMessage, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(167, Short.MAX_VALUE))
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
		textFieldValidatorAmount.check();
		textFieldValidatorDescription.check();
		
		if (textFieldValidatorAmount.getValidateStatus() == false && textFieldValidatorDescription.getValidateStatus() == false) {
			txtErrorMessage.setText("*Description required \n*0.00 format for amount required");
			textFieldValidatorAmount.check();
			textFieldValidatorDescription.check();
		}else {
		
			if (textFieldValidatorAmount.getValidateStatus() == true) {
				textFieldValidatorAmount.reset();
				textFieldValidatorDescription.check();
				if (textFieldValidatorDescription.getValidateStatus() == false) {
					txtErrorMessage.setText("*Description required");
				}
			}else {
				textFieldValidatorAmount.check();
				txtErrorMessage.setText("*0.00 format for amount required");
			}
			
			if (textFieldValidatorDescription.getValidateStatus() == true) {
				textFieldValidatorDescription.reset();
				textFieldValidatorAmount.check();
				if (textFieldValidatorAmount.getValidateStatus() == false) {
					txtErrorMessage.setText("*0.00 format for amount required");
				}
			}else {
				textFieldValidatorDescription.check();
				txtErrorMessage.setText("*Description required");
			}	
		}
	}
	
	public JList<String> getList() {
		return listAccountType;
	}
	
	public void resetMe() {
		textFieldValidatorAmount.reset();
		textFieldValidatorDescription.reset();
		txtErrorMessage.setText("");
		txtBalance.setText("");
		txtDescription.setText("");
		listAccountType.setSelectedIndex(0);
	}
	
	public String getDescription() {
		String description = txtDescription.getText();	
		return description;
	}
	
	public String getInitialBalance() {
		String initialBalance = txtBalance.getText();	
		return initialBalance;
	}
	
	public String getAccountType() {
		String selectedAccountType = listAccountType.getSelectedValue();	
		return selectedAccountType;
	}
	
	public int getAccountTypeIndex() {
		int selectedAccountTypeIndex = listAccountType.getSelectedIndex();	
		return selectedAccountTypeIndex;
	}
	
	
	public void addAccountListener (ActionListener addAccountActionListener) {
		btnOk.addActionListener(addAccountActionListener);
	}

	public void addCancelListener (ActionListener cancelActionListener) {
		btnCancel.addActionListener(cancelActionListener);
	}
	
}
