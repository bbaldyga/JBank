
public class AccountTypeNotFoundException extends Exception{
	private String accType;
	AccountTypeNotFoundException(String accType){
		this.accType = accType;
	}
	@Override
	public String getMessage(){
		String msg = "";
	 switch(this.accType)
	 {
	 case "S":
		 msg = "Unable to find an account of type Savings";
	 case "I":
		 msg =  "Unable to find an account of type Investment";
	 case "O":
		 msg =  "Unable to find an account of type Overdraft Protection";
	 case "L":
		 msg =  "Unable to find an account of type Line of Credit";
	 }
	return msg;
 }

}
