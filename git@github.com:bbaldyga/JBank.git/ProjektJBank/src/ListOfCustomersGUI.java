import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

public class ListOfCustomersGUI extends JFrame implements ActionListener {
	private JScrollPane scroll;
	private JList<Customer> list;
	private JButton addUser, updateUser, removeUser;
	private Customer customers[];

	ListOfCustomersGUI() {
		customers = Bank.getCustomers();
		buildListOfCustomersGUI();

	}

	public void buildListOfCustomersGUI() {
		setBounds(100, 100, 450, 300);
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		scroll = new JScrollPane();
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scroll);
		list = new JList(customers);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setVisibleRowCount(8);
		list.setFixedCellWidth(20);
		scroll.setViewportView(list);
		addUser = new JButton("Add customer");
		addUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame user = new addCustomerGUI();
				user.setVisible(true);
			}

		});
		panel.add(addUser);

		updateUser = new JButton("Update Customer");
		updateUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedValue()!= null) {
				JFrame user = new UpdateAccountGUI(list.getSelectedValue());
				user.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null, "Please select a customer which you want to update", "WARNING", JOptionPane.WARNING_MESSAGE);
			}

		});
		panel.add(updateUser);

		removeUser = new JButton("Remove Customer");
		removeUser.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedValue()!=null) {
				Bank.removeCustomer(customers[list.getSelectedIndex()].getCustId());
				}
				else
					JOptionPane.showMessageDialog(null, "Please select customer which you want to remove", "WARNING", JOptionPane.WARNING_MESSAGE);
				
			}
			
		});
		panel.add(removeUser);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
