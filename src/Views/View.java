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

public class View extends JFrame{
	private Model model;
	private JTextArea txtOutput;
	private JButton btnOk;
	
	public View(Model myModel) {
		setBounds(100, 100, 480, 414);
		this.setResizable(false);
		JLabel lblHeader = new JLabel("Bank Machine Simulation v1.0 >");
		
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
						.addComponent(lblHeader, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOk)
						.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtOutput, GroupLayout.PREFERRED_SIZE, 458, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 422, GroupLayout.PREFERRED_SIZE)))
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
