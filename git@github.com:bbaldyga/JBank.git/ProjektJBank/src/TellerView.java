import java.awt.*;
import java.awt.event.*;

public class TellerView extends Panel {
	Button accountStatusButton, withdrawButton, depositButton;
	Button addAccountButton, newCustomerButton, futureUseButton;
	TextField custIdTextField, customerNameTextField, amountTextField;
	TextField dateDisplayTextField, messageTextField;
	TextArea customerInformation;
	List accountInformation;
	Label customerIdLabel, accountSelectionLabel;
	Panel topPanel, buttonPanel, messagePanel, customerDisplayPanel;
	Panel displayPanel, accountPanel, listPanel;
	

	public TellerView() {
		buildTellerPanel();
	}

	public void buildTellerPanel() {
		accountStatusButton = new Button("Account Status");
		withdrawButton = new Button("Withdraw");
		depositButton = new Button("Deposit");
		addAccountButton = new Button("Add Account");
		newCustomerButton = new Button("New Customer");
		futureUseButton = new Button(" ");
		customerNameTextField = new TextField("Customer Name will be shown here", 40);
		messageTextField = new TextField("Display message", 20);
		amountTextField = new TextField("Enter amount here:", 20);
		custIdTextField = new TextField(" ");
		dateDisplayTextField = new TextField(" ");

		customerIdLabel = new Label("Customer ID:");
		accountSelectionLabel = new Label("Select an Account");

		customerInformation = new TextArea("Customer Information", 15, 20);

		accountInformation = new List(8);
		/* Creating the top Panel */
		topPanel = new Panel();
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		topPanel.add(customerIdLabel);
		topPanel.add(custIdTextField);
		topPanel.add(customerNameTextField);
		topPanel.add(accountStatusButton);
		/* Building the Button panel */
		buttonPanel = new Panel();
		buttonPanel.setLayout(new GridLayout(2, 6));
		buttonPanel.add(withdrawButton);
		buttonPanel.add(addAccountButton);
		buttonPanel.add(futureUseButton);
		buttonPanel.add(depositButton);
		buttonPanel.add(newCustomerButton);
		buttonPanel.add(dateDisplayTextField);
		/* Building the Panel to hold Customer Information */
		customerDisplayPanel = new Panel();
		customerDisplayPanel.setLayout(new BorderLayout());
		customerDisplayPanel.add(messageTextField, "South");
		messageTextField.setBackground(Color.yellow);
		customerDisplayPanel.add(customerInformation, "Center");

		displayPanel = new Panel();
		displayPanel.setLayout(new GridLayout(1, 2));
		/* Building the listPanel to display Account information */
		listPanel = new Panel();
		listPanel.setLayout(new BorderLayout());
		listPanel.add(accountInformation, "Center");
		listPanel.add(accountSelectionLabel, "North");
		/* Building the accountPanel to accept account details */
		accountPanel = new Panel();
		accountPanel.setLayout(new BorderLayout());
		accountPanel.add(amountTextField, "North");
		accountPanel.add(listPanel, "Center");
		/*
		 * Building the TellerView Panel by add the Panels to the Teller View
		 */
		setLayout(new BorderLayout());
		add(topPanel, "North");
		add(buttonPanel, "South");
		displayPanel.add(accountPanel);
		displayPanel.add(customerDisplayPanel);
		add(displayPanel, "Center");
		setSize(500, 300);

	}

}
