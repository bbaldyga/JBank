
public class OverDraftProtect extends Checking {
	private Savings savingsAccount;

	public OverDraftProtect(Customer cust, double amount, Savings sav) {
		super();
		balance = amount;
		savingsAccount = sav;
		acctId = Integer.toString(cust.getCustId());
		acctType = "O";
	}

	@Override
	protected void feeAssessment() {
		monthlyFee += 3.00;
		balance -= 3.00;

	}

	@Override
	public void withdraw(double amount) throws AmountOverDrawnException {
		if (amount > balance + savingsAccount.getBalance() - 10) {
			throw new AmountOverDrawnException (this);
		} else if (amount > balance) {

			savingsAccount.withdraw(amount - balance);
			balance = 0;
			feeAssessment();
		} else {
			balance = balance - amount;
		}
	}

}
