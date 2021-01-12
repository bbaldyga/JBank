
public class AccountTypeAlreadyExistsException extends Exception {
	 private String accType;
	 AccountTypeAlreadyExistsException(String accType){
		 this.accType = accType;
	 }
	 @Override
		public String getMessage(){
		 String msg = "";
		 switch(this.accType)
		 {
		 case "S":
			 return msg =  "Unable to create a duplicate account of type Savings";
		 case "I":
			 return msg =  "Unable to create a duplicate account of type Investment";
		 case "O":
			 return msg =  "Unable to create a duplicate account of type Overdraft Protection";
		 case "L":
			 return msg =  "Unable to create a duplicate account of type Line of Credit";
		 }
		return msg;
	 }
	}
