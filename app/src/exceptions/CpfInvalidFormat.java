package exceptions;

public class CpfInvalidFormat extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public CpfInvalidFormat(String msg) {
		super(msg);
	}
	
}
