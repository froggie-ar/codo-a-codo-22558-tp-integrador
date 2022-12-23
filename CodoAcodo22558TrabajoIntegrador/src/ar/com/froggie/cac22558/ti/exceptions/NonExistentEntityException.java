package ar.com.froggie.cac22558.ti.exceptions;

public class NonExistentEntityException extends Exception {
	
	private static final long serialVersionUID = -1843721785856684196L;
	
	public NonExistentEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    public NonExistentEntityException(String message) {
        super(message);
    }
    
}
