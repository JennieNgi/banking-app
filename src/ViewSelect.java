import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;

public class ViewSelect extends JFrame{
	private static JList<String> list;
	private static DefaultListModel<String> listModel;
	private Model model;
	private JButton btnOk;
	private JButton btnCancel;
	private JLabel lblErrorMessage;
	private JScrollPane scrollPane;
	
	public ViewSelect(Model myModel) {
		setBounds(100, 100, 480, 414);
		this.setResizable(false);
		model = myModel;
		
		JLabel lblNewLabel = new JLabel("Bank Machine Simulation v1.0 >");
		
		JLabel lblSelect = new JLabel("Select Account:");
		listModel = new DefaultListModel<String>();
		
		btnOk = new JButton("Ok");
		
		btnCancel = new JButton("Cancel");
		
		lblErrorMessage = new JLabel("");
		lblErrorMessage.setForeground(Color.RED);
		
		scrollPane = new JScrollPane();
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSelect, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
							.addGap(55)
							.addComponent(lblErrorMessage, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnOk)
							.addGap(18)
							.addComponent(btnCancel)))
					.addContainerGap(250, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblSelect)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(150)
							.addComponent(lblErrorMessage))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnOk)
								.addComponent(btnCancel))))
					.addContainerGap(181, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		list = new JList<String>();
		scrollPane.setViewportView(list);
		list.setModel(listModel);
		list.setSelectedIndex(0);
		
	}
	
	public DefaultListModel<String> getlistModel() {
		return listModel;
	}
	
	public JList<String> getList() {
		return list;
	}
	
	public int getAccountTypeIndex() {
		int selectedAccountTypeIndex = list.getSelectedIndex();	
		return selectedAccountTypeIndex;
	}
	
	public static void updateSelectionList(String description) {
		listModel.addElement(description);
	}
	
	public void selectAccountListener (ActionListener selectAccountActionListener) {
		btnOk.addActionListener(selectAccountActionListener);
	}

	public void addCancelListener (ActionListener cancelActionListener) {
		btnCancel.addActionListener(cancelActionListener);
	}
}
