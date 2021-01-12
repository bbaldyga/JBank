
public class AmountOverDrawnException extends Exception {
	private Account acct;
	AmountOverDrawnException(Account acct)
	{
		this.acct = acct;		
	}
	@Override
	public String getMessage(){
		String msg = "";
		if(acct instanceof Savings)
			msg = "Insufficient funds in Savings";
		if(acct instanceof OverDraftProtect)
			msg = "Insufficient funds  in Overdraft protection";
		if(acct instanceof Investment)
			msg = " Insufficient funds in Investment";
		if(acct instanceof LineOfCredit)
			msg = "Insufficient funds  in Line of credit";
		return msg;
	}
}
