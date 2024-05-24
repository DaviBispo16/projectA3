package exceptions;

public class IncorrectEmploymentContract extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public IncorrectEmploymentContract(String msg) {
		super(msg);
	}
}
