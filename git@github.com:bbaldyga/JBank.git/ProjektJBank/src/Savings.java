
public class Savings extends Account {
	protected double InterestEarned;

	public Savings(Customer cust, double amount) {
		super();
		balance = amount;
		acctId = Integer.toString(cust.getCustId());
		acctType = "S";
	}

	@Override
	public void withdraw(double amount) throws AmountOverDrawnException {
		if (balance - amount >= 10) {
			balance -= amount;
		} else
			throw new AmountOverDrawnException (this);
	}

	public void addDailyInterest(int days) {
	
		double f = Math.pow( (1 + (.03/365)),(365 * days));
		f = f*balance;
		InterestEarned = f - balance;
		balance = f;
	}

	public double getDailyInterest() {
		return InterestEarned;
	}
}
