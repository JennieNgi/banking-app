package Views;
import ModelController.*;
import javax.swing.JFrame;

import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;

public class View extends JFrame{
	private Model model;
	private JTextArea txtOutput;
	private JButton btnOk;
	
	public View(Model myModel) {
		setBounds(100, 100, 480, 414);
		this.setResizable(false);
		JLabel lblHeader = new JLabel("Bank Machine Simulation v1.0 >");
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHeader.setForeground(Color.BLUE);
		
		JLabel lblTitle = new JLabel("Transactions of currently selected account:");
		
		btnOk = new JButton("Ok");
		
		JScrollPane scrollPane = new JScrollPane();
		
		txtOutput = new JTextArea();
		txtOutput.setLineWrap(true);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnOk)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtOutput, GroupLayout.PREFERRED_SIZE, 458, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 422, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(lblHeader, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblTitle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblHeader)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblTitle)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtOutput, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(btnOk)
					.addContainerGap(90, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		model = myModel;
	}
	
	public void setReport(String report) {
		txtOutput.setText(report);
	}
	
	public void addCancelListener (ActionListener cancelActionListener) {
		btnOk.addActionListener(cancelActionListener);
	}
}
