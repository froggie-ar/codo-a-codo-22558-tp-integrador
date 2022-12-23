package ar.com.froggie.cac22558.ti.exceptions;

import javax.servlet.ServletException;

public class TheIdProvidedCannotBeNull extends ServletException {

	private static final long serialVersionUID = 2197783422787562692L;

	public TheIdProvidedCannotBeNull (String message, Throwable cause) {
        super(message, cause);
    }
	
    public TheIdProvidedCannotBeNull (String message) {
        super(message);
    }
    
}
