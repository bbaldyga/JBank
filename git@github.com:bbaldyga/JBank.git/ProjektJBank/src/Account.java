
public abstract class Account {
	protected double balance;
	protected String acctId;
	protected String acctType;
	public String getAcctType() {
		return acctType;
	}

	public double getBalance() {
		return balance;
	}

	public String getId() {
		return acctId;
	}

	public void setBalance(double amount) {
		balance = amount;
	}

	public boolean deposit(double balance2) {
		if (balance2 > 0) {
			balance += balance2;
			return true;
		} else
			return false;
	}

	public abstract void withdraw(double amount) throws AmountOverDrawnException ;

	public String toString() {
		return acctId;
	}

}
