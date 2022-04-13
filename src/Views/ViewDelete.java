package Views;
import ModelController.*;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ViewDelete extends JFrame{
	private Model model;
	private static JLabel lblAccount;
	private JButton btnDelete;
	private JButton btnCancel;
	
	public ViewDelete(Model myModel) {
		
		setBounds(100, 100, 480, 414);
		this.setResizable(false);
		JLabel lblHeader = new JLabel("Bank Machine Simulation v1.0 >");
		
		JLabel lblDelete = new JLabel("Delete Current Account?");
		
		lblAccount = new JLabel("");
		lblAccount.setForeground(Color.ORANGE);
		
		btnDelete = new JButton("Delete");
		
		btnCancel = new JButton("Cancel");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHeader, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDelete, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAccount, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnDelete)
									.addGap(6)
									.addComponent(btnCancel)))))
					.addContainerGap(152, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblHeader)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAccount)
						.addComponent(lblDelete))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDelete)
						.addComponent(btnCancel))
					.addContainerGap(304, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		model = myModel;
	}
	

	
	public static void setCurrentAccount(String currentAccount) {
		lblAccount.setText(currentAccount);
	}
	
	public void deleteAccountListener (ActionListener deleteAccountActionListener) {
		btnDelete.addActionListener(deleteAccountActionListener);
	}

	public void addCancelListener (ActionListener cancelActionListener) {
		btnCancel.addActionListener(cancelActionListener);
	}

}
