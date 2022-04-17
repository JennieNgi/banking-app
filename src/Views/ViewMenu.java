package Views;
import ModelController.*;
import Tools.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class ViewMenu extends JFrame{
	private Model model;
	private JButton btnSelect;
	private JButton btnDeposit;
	private JButton btnWithdraw;
	private JButton btnCreate;
	private JButton btnDelete;
	private JButton btnView;
	private JButton btnQuit;
	
	public ViewMenu(Model myModel) {
		setBounds(100, 100, 480, 414);
		this.setResizable(false);
		
		JLabel lblHeader = new JLabel("Bank Machine Simulation v1.0 >");
		lblHeader.setForeground(Color.BLUE);
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btnSelect = new JButton("select");
		
		btnDeposit = new JButton("deposit");
		
		btnWithdraw = new JButton("withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnCreate = new JButton("create");
		
		btnDelete = new JButton("delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnView = new JButton("View");
		
		btnQuit = new JButton("quit");
		
		JLabel lblSelect = new JLabel("Select Account");
		
		JLabel lblDeposit = new JLabel("Deposit sum to account");
		
		JLabel lblWithdraw = new JLabel("Withdraw sum from account");
		
		JLabel lblCreate = new JLabel("Create account");
		
		JLabel lblDelete = new JLabel("Delete account");
		
		JLabel lblView = new JLabel("View account transactions");
		
		JLabel lblNewLabel = new JLabel("Save and Quit");
		
//		btnSelect.setEnabled(false);

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHeader, GroupLayout.PREFERRED_SIZE, 436, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnQuit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnView, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnDelete, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnCreate, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnDeposit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnSelect, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnWithdraw, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCreate, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblDeposit, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
									.addComponent(lblSelect, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblWithdraw, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblDelete, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblView, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblHeader)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSelect)
						.addComponent(lblSelect))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDeposit)
						.addComponent(lblDeposit))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnWithdraw)
						.addComponent(lblWithdraw))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCreate)
						.addComponent(lblCreate))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDelete)
						.addComponent(lblDelete))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnView)
						.addComponent(lblView))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnQuit)
						.addComponent(lblNewLabel))
					.addContainerGap(145, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		model = myModel;
		
		enableButton();
		
	}
	
	public void enableButton() {
		if (model.getAccounts().size() == 0) {
			btnSelect.setEnabled(false);
			btnDeposit.setEnabled(false);		
			btnWithdraw.setEnabled(false);		
			btnDelete.setEnabled(false);			
			btnView.setEnabled(false);

		}else {
			btnSelect.setEnabled(true);
			btnDeposit.setEnabled(true);		
			btnWithdraw.setEnabled(true);		
			btnDelete.setEnabled(true);			
			btnView.setEnabled(true);
		}
	}
	
	public void addViewCreateListener (ActionListener viewCreateActionListener) {
		btnCreate.addActionListener(viewCreateActionListener);
	}
	
	public void addViewDeleteListener (ActionListener viewDeleteActionListener) {
		btnDelete.addActionListener(viewDeleteActionListener);
	}
	
	public void addViewDepositListener (ActionListener viewDepositActionListener) {
		btnDeposit.addActionListener(viewDepositActionListener);
	}
	
	public void addViewSelectListener (ActionListener viewSelectActionListener) {
		btnSelect.addActionListener(viewSelectActionListener);
	}
	
	public void addViewWithdrawListener (ActionListener viewWithdrawActionListener) {
		btnWithdraw.addActionListener(viewWithdrawActionListener);
	}
	
	public void addViewListener (ActionListener viewActionListener) {
		btnView.addActionListener(viewActionListener);
	}
	
	public void addQuitListener (ActionListener quitActionListener) {
		btnQuit.addActionListener(quitActionListener);
	}
	
	
	

}
