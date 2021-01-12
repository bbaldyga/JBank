import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ATMGUI extends JFrame implements ActionListener {
	JButton b1, b2, b3;
	JCheckBox ch1, ch2, ch3, ch4;
	JTextArea ta;
	JLabel customerJLabel, amountJLabel;
	JTextField customerJTextField, amountJTextField;
	JScrollPane scroll;

	private Account locateAccount(String acctType, Customer cust) {
		return cust.getAccount(acctType);
	}

	private void errorMessage(String msg) {
		ta.append(msg);
	}

	public String getSelectedObject() {
		String type = null;
		if (ch1.getSelectedObjects() != null) {
			type = "S";
		}
		if (ch2.getSelectedObjects() != null) {
			type = "L";
		}
		if (ch3.getSelectedObjects() != null) {
			type = "I";
		}
		if (ch4.getSelectedObjects() != null) {
			type = "O";
		}
		return type;
	}

	public String getMessage() {
		return ta.getText();
	}

	public void setMessage(String msg) {
		ta.setText(msg);
	}

	public String getCustid() {
		return customerJTextField.getText();
	}

	public String getAmt() {
		return amountJTextField.getText();
	}

	public ATMGUI() throws ParseException, AccountTypeAlreadyExistsException {
		setMinimumSize(new Dimension(768, 365));
		// setSize(1768, 1365);
		setLayout(null);
		buildATMGUI();
	}

	public void buildATMGUI() {

		customerJLabel = new JLabel("Enter Customer Id");
		customerJLabel.setBounds(16, 39, 117, 16);
		add(customerJLabel);

		ch1 = new JCheckBox("Savings");
		ch1.setBounds(321, 6, 128, 23);
		add(ch1);

		ch2 = new JCheckBox("Line of Credit");
		ch2.setBounds(321, 35, 128, 23);
		add(ch2);

		ch3 = new JCheckBox("Investment");
		ch3.setBounds(321, 70, 128, 23);
		add(ch3);

		ch4 = new JCheckBox("Overdraft");
		ch4.setBounds(321, 105, 128, 23);
		add(ch4);

		amountJLabel = new JLabel("Enter amount here");
		amountJLabel.setBounds(464, 39, 117, 16);
		add(amountJLabel);

		customerJTextField = new JTextField();
		customerJTextField.setBounds(136, 34, 128, 26);
		add(customerJTextField);
		customerJTextField.setColumns(10);

		amountJTextField = new JTextField();
		amountJTextField.setBounds(593, 34, 169, 26);
		add(amountJTextField);
		amountJTextField.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBounds(634, 147, 128, 190);
		add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		b1 = new JButton("Deposit");
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean d = false;
				String Sbalance = amountJTextField.getText();
				String SCustomer = customerJTextField.getText();
				for (int i = 0; i < Sbalance.length(); i++) {
					if (!Character.isDigit(Sbalance.charAt(i)))
						if (Sbalance.charAt(i) != '.')
							d = true;
				}
				for (int j = 0; j < SCustomer.length(); j++) {
					if (!Character.isDigit(SCustomer.charAt(j)))
						if (SCustomer.charAt(j) != '.')
							d = true;
				}
				StringBuffer strb = new StringBuffer();
				if (d == false) {
					if (Bank.getCustomer(Integer.parseInt(customerJTextField.getText())) != null) {
						Customer customer = Bank.getCustomer(Integer.parseInt(customerJTextField.getText()));
						String acctType = getSelectedObject();
						if (acctType != null) {
							Account acct = locateAccount(acctType, customer);
							if (acct != null) {
								double balance = Double.parseDouble(amountJTextField.getText());
								if (acct.deposit(balance)) {
									strb.append(getMessage() + "\n" + " account : " + getCustid() + " amount deposit: $"
											+ getAmt() + " account balance " + acct.getBalance() + " \n");
									setMessage(strb.toString());
								} else {
									errorMessage("\"Unable to complete transaction. Your\n" + "ammount is "
											+ amountJTextField.getText());
								}

							} else
								errorMessage("Customer does not have an " + getSelectedObject() + " Type" + "\n");
						}

					} else
						errorMessage("No Customer with " + customerJTextField.getText() + " ID found" + "\n");

				} else
					errorMessage("Amount/Customer textfield contains illegal characters");
			}

		});
		panel.add(b1);

		b2 = new JButton("Withdraw");
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean d = false;
				String Sbalance = amountJTextField.getText();
				String SCustomer = customerJTextField.getText();
				for (int i = 0; i < Sbalance.length(); i++) {
					if (!Character.isDigit(Sbalance.charAt(i)))
						if (Sbalance.charAt(i) != '.')
							d = true;
				}
				for (int j = 0; j < SCustomer.length(); j++) {
					if (!Character.isDigit(SCustomer.charAt(j)))
						if (SCustomer.charAt(j) != '.')
							d = true;
				}
				StringBuffer strb = new StringBuffer();
				if (d == false) {
					if (Bank.getCustomer(Integer.parseInt(customerJTextField.getText())) != null) {
						Customer customer = Bank.getCustomer(Integer.parseInt(customerJTextField.getText()));
						String acctType = getSelectedObject();
						if (acctType != null) {
							Account acct = locateAccount(acctType, customer);
							if (acct != null) {
								double balance = Double.parseDouble(amountJTextField.getText());
								try {
									acct.withdraw(balance);
									strb.append(
											getMessage() + "\n" + " account : " + getCustid() + " amount withdrawn: $"
													+ getAmt() + " account balance " + acct.getBalance() + " \n");
									setMessage(strb.toString());
								} catch (AmountOverDrawnException ex) {
									strb.append(getMessage() + ex.getMessage() + " \n");
									setMessage(strb.toString());
								}

							} else
								errorMessage("Customer does not have an " + getSelectedObject() + " Type" + "\n");
						}
					} else
						errorMessage("No Customer with " + customerJTextField.getText() + " ID found" + "\n");

				}
				else
					errorMessage("Amount/Customer textfield contains illegal characters");
			}

		});
		panel.add(b2);

		b2 = new JButton("Exit");
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Your are exiting a secure session. Good Bye:", " Exit message",
						JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}

		});
		panel.add(b2);

		ta = new JTextArea();
		ta.setBounds(16, 147, 606, 190);
		scroll = new JScrollPane(ta);
		add(ta);
		add(scroll);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
