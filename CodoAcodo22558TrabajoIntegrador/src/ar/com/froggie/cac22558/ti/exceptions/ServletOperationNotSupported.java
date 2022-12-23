package ar.com.froggie.cac22558.ti.exceptions;

import javax.servlet.ServletException;

public class ServletOperationNotSupported extends ServletException {
	
	private static final long serialVersionUID = 6825561959228093219L;

	public ServletOperationNotSupported (String message, Throwable cause) {
        super(message, cause);
    }
	
    public ServletOperationNotSupported (String message) {
        super(message);
    }
    
}
