package com.ecan.exception;

public class AuthorityException extends RuntimeException {
	
	private static final long serialVersionUID = -8065906692358500801L;
    
    public AuthorityException() {
    	super("HTTP请求超出设定的限制");
    }
    
    public AuthorityException(String message) {
        super(message);
    }
    
}
