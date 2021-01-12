import java.util.*;

public class Customer {
	private final int custId;
	private Account[] accounts = new Account[4];
	private String firstName;
	private String lastName;
	private int numOfAccounts;
	private String cityName;
	private final Date DOB;
	private String emailAddress;
	private String postalCode;
	private String phoneNumber;
	private String streetAddress;

	public Customer(String lastName, String firstName, Date DOB) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.DOB = DOB;
		custId = Bank.getNextId();
	}

	public Customer(String lastName, String firstName) {
		this(lastName, firstName, null);
	}

	public String getAddress() {
		return postalCode + cityName + streetAddress;
	}

	public Account getAccount(String type) {
		Account acct = null;
		for (int i = 0; i < accounts.length; i++) {
			Account a = accounts[i];

			switch (type) {
			case "S":
				if (accounts[i] instanceof Savings) {
					acct = accounts[i];

				}
				break;
			case "L":

				if (accounts[i] instanceof LineOfCredit) {
					acct = accounts[i];

				}
				break;

			case "O":

				if (accounts[i] instanceof OverDraftProtect) {
					acct = accounts[i];

				}
				break;

			case "I":

				if (accounts[i] instanceof Investment) {
					acct = accounts[i];

				}
				break;

			}

		}
		return acct;
	}

	public int getCustId() {
		return custId;
	}

	public String getEmail() {
		return emailAddress;
	}

	public String getName() {
		return firstName + "," + lastName;
	}

	public int getNumOfAccounts() {
		return numOfAccounts;
	}

	public String getPhone() {
		return phoneNumber;
	}

	public Date getDOB() {
		return DOB;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getCityName() {
		return cityName;
	}

	public String getstreetAddress() {
		return streetAddress;
	}

	public String getCustomerFirstName() {
		return firstName;
	}

	public String getCustomerLastName() {
		return lastName;
	}

	/*
	 * public void setDOB(Date DOB) { this.DOB = DOB; }
	 */
	public void setAddress(String postalCode, String cityName, String streetAddress) {
		this.postalCode = postalCode;
		this.cityName = cityName;
		this.streetAddress = streetAddress;
		;
	}

	public void setEmail(String email) {
		this.emailAddress = email;
	}

	public void setName(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void setPhone(String phone) {
		this.phoneNumber = phone;
	}

	public boolean addAccount(Account acct) throws AccountTypeAlreadyExistsException {
		boolean accountAdded = true;
		if (numOfAccounts > 4) {
			accountAdded = false;
		} else {
			int notUsed = -1;
			for (int i = 0; i < accounts.length; i++) {
				if (accounts[i] == null && notUsed == -1) {
					notUsed = i;
				} else {
					if (accounts[i] != null) {
						if (accounts[i].getAcctType() == acct.getAcctType()) {
							throw new AccountTypeAlreadyExistsException(acct.acctType);
						}
					}
				}
			}
			if (notUsed != -1 && accountAdded) {
				accounts[notUsed] = acct;
				accountAdded = true;
				++numOfAccounts;
			}
		}
		return accountAdded;
	}

	public boolean removeAccount(String type) {
		boolean removed = false;
		Account acct = null;
		for (int i = 0; i < accounts.length; i++) {
			Account a = accounts[i];

			switch (type) {
			case "S":
				if (accounts[i] instanceof Savings) {
					accounts[i] = null;
					removed = true;

				}
				break;
			case "L":

				if (accounts[i] instanceof LineOfCredit) {
					accounts[i] = null;
					removed = true;

				}
				break;

			case "O":

				if (accounts[i] instanceof OverDraftProtect) {
					accounts[i] = null;
					removed = true;

				}
				break;

			case "I":

				if (accounts[i] instanceof Investment) {
					accounts[i] = null;
					removed = true;

				}
				break;

			}

		}
		return removed;
	}

	/*
	 * public void setCustId(int id) { custId = id; }
	 */
	@Override
	public String toString() {
		return Integer.toString(custId) + " " + lastName + " " + firstName;
	}

}
