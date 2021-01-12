
public abstract class Checking extends Account {
	protected double monthlyFee;
	protected abstract void feeAssessment();
	public void resetMonthlyFee()
	{
		monthlyFee = 0;
	}
	public double getMonthlyFee()
	{
		return monthlyFee;
	}

}
