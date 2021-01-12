import java.util.*;

public class LineOfCredit extends Checking {

	private double creditBalance;
	private double creditLimit;

	public LineOfCredit(Customer cust, double balance, double creditLimit) {
		super();
		acctId = Integer.toString(cust.getCustId());
		creditBalance = balance;
		this.creditLimit = creditLimit;
		acctType = "L";
	}

	public double getCreditBalance() {
		return creditBalance;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditBalance(double amount) {
		creditBalance = amount;
	}

	public void setCreditLimit(double amount) {
		creditLimit = amount;
	}

	@Override
	protected void feeAssessment() {
		int days = new GregorianCalendar().get(Calendar.DAY_OF_MONTH);
		double deficit = creditLimit - creditBalance;
		double amt = Math.pow(1 + (0.21 / 365), 356 * days);
		amt = amt * deficit;
		monthlyFee = amt - deficit;

	}

	@Override
	public void withdraw(double amount) throws AmountOverDrawnException {
		if (amount > balance + creditBalance) {
			throw new AmountOverDrawnException (this);
		} else if (amount > balance) {
			creditBalance -= (amount - balance);
			balance = 0;
		} else {
			balance = balance - amount;
		}
	}

}
