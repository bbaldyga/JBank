import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class addCustomerGUI extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField cityName;
	private JTextField emailAddress;
	private JTextField postalCode;
	private JTextField streetAddress;
	private JTextField phoneNumber;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField balance;
	private JButton check;
	private JTextField DOB;

	public addCustomerGUI() {
		buildWindow();
	}

	public void buildWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setBounds(67, 21, 74, 16);
		contentPane.add(lblNewLabel_1);

		firstName = new JTextField();
		firstName.setBounds(161, 16, 284, 26);
		contentPane.add(firstName);
		firstName.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setBounds(67, 49, 80, 16);
		contentPane.add(lblNewLabel_2);

		lastName = new JTextField();
		lastName.setBounds(161, 49, 284, 26);
		contentPane.add(lastName);
		lastName.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("City name");
		lblNewLabel_3.setBounds(67, 82, 64, 16);
		contentPane.add(lblNewLabel_3);

		cityName = new JTextField();
		cityName.setBounds(161, 82, 284, 26);
		contentPane.add(cityName);
		cityName.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Email address");
		lblNewLabel_4.setBounds(67, 125, 89, 16);
		contentPane.add(lblNewLabel_4);

		emailAddress = new JTextField();
		emailAddress.setBounds(161, 120, 284, 26);
		contentPane.add(emailAddress);
		emailAddress.setColumns(10);

		JLabel lblNewLabel = new JLabel("Postal code");
		lblNewLabel.setBounds(67, 163, 89, 16);
		contentPane.add(lblNewLabel);

		postalCode = new JTextField();
		postalCode.setBounds(161, 158, 284, 26);
		contentPane.add(postalCode);
		postalCode.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Street adress");
		lblNewLabel_5.setBounds(67, 191, 89, 16);
		contentPane.add(lblNewLabel_5);

		streetAddress = new JTextField();
		streetAddress.setBounds(161, 186, 284, 26);
		contentPane.add(streetAddress);
		streetAddress.setColumns(10);

		phoneNumber = new JTextField();
		phoneNumber.setBounds(161, 224, 284, 26);
		contentPane.add(phoneNumber);
		phoneNumber.setColumns(10);

		lblNewLabel_6 = new JLabel("Phone number");
		lblNewLabel_6.setBounds(67, 229, 101, 16);
		contentPane.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("Balance");
		lblNewLabel_7.setBounds(67, 257, 58, 16);
		contentPane.add(lblNewLabel_7);

		balance = new JTextField();
		balance.setBounds(160, 252, 285, 26);
		contentPane.add(balance);
		balance.setColumns(10);

		check = new JButton("Check");
		check.setBounds(191, 325, 101, 29);
		check.addActionListener(this);
		contentPane.add(check);

		JLabel lblNewLabel_7_1 = new JLabel("Date of birth");
		lblNewLabel_7_1.setBounds(67, 285, 89, 16);
		contentPane.add(lblNewLabel_7_1);

		DOB = new JTextField();
		DOB.setColumns(10);
		DOB.setBounds(161, 280, 285, 26);
		contentPane.add(DOB);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SimpleDateFormat dateToAdd = new SimpleDateFormat("dd.MM.yyyy");
		String lastName = this.lastName.getText();
		String firstName = this.firstName.getText();
		String postalCode = this.postalCode.getText();
		String cityName = this.cityName.getText();
		String streetAddress = this.streetAddress.getText();
		String email = this.emailAddress.getText();
		String phoneNumber = this.phoneNumber.getText();
		String balance = this.balance.getText();
		Date DOB;
		try {
			DOB = dateToAdd.parse(this.DOB.getText());
			checkEmail(email);
			checkBalance(balance);
			Customer c = new Customer(lastName, firstName, DOB);
			c.setAddress(postalCode, cityName, streetAddress);
			c.setEmail(email);
			c.setPhone(phoneNumber);
			Savings s = new Savings(c, Double.parseDouble(balance));
			c.addAccount(s);
			Bank.addCustomer(c);
			dispose();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage(), "WARNING", JOptionPane.WARNING_MESSAGE);
		} catch (EmailDontCountainAtSignException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage(), "WARNING", JOptionPane.WARNING_MESSAGE);
		} catch (IncorrectBalanceException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage(), "WARNING", JOptionPane.WARNING_MESSAGE);
		} catch (AccountTypeAlreadyExistsException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage(), "WARNING", JOptionPane.WARNING_MESSAGE);
		}
	}

	private void checkEmail(String email) throws EmailDontCountainAtSignException {
		boolean check = false;
		if (email.contains("@"))
			check = true;
		if (check == false)
			throw new EmailDontCountainAtSignException(email);
	}

	private void checkBalance(String balance) throws IncorrectBalanceException
	{
		boolean check = true;
		for(int i = 0;i<balance.length();i++) {
		if(!Character.isDigit(balance.charAt(i)))
		{
			if(balance.charAt(i)!='.')
				check = false;
		}
		}
		if(check ==true) {
			double bal = Double.parseDouble(balance);
			if(bal<10)
			{
				check = false;
			}
		}
		if(check == false)
		{
			throw new IncorrectBalanceException(balance);
		}
	}
}
