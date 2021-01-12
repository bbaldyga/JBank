
public class EmailDontCountainAtSignException extends Exception{
	private String email;
	EmailDontCountainAtSignException(String email){
		this.email = email;
	}
	@Override
	public String getMessage() {
		return "Email does not contain @ sign";
	}
}
