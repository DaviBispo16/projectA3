package exceptions;

public class IncorrectMinimumWage extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public IncorrectMinimumWage(String msg) {
		super(msg);
	}
}
