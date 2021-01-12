
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public final class Investment extends Savings {

	@SuppressWarnings("unused")
	private Date startDate;
	private Date endDate;
	private double interestRate;

	public Investment(Customer cust, double ammount, int months) {
		super(cust, ammount);
		acctType = "I";
		int terms;
		if (months < 6)
			terms = 6;
		else
			terms = months;
		Calendar s = new GregorianCalendar();
		startDate = s.getTime();
		s.add(Calendar.MONTH, terms);
		endDate = s.getTime();
		if (months <= 6)
			interestRate = 0.05;
		else if (months > 6 & months <= 12)
			interestRate = 0.06;

		else
			interestRate = 0.07;

	}

	@Override
	public void addDailyInterest(int days) {
		double f = Math.pow(((1 + (interestRate / 365))), (365 * days));
		f = f*balance;
		InterestEarned = f - balance;
		balance = f;
	}

	@Override
	public void withdraw(double ammount) throws AmountOverDrawnException {
		if (balance - ammount >= 10) {
			if (Calendar.getInstance().before(endDate)) {
				balance -= ammount;
			} else {
				if (ammount < (balance - (0.20 * balance))) {
					balance = balance - (0.2 * balance) - ammount;
				} else
					throw new AmountOverDrawnException (this);
			}
		} else
			throw new AmountOverDrawnException (this);
	}

}
