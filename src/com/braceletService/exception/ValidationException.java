package com.braceletService.exception;

import javax.xml.bind.JAXBException;

public class ValidationException extends RuntimeException{

	private static final long serialVersionUID = 8557617263258019661L;

	public ValidationException(JAXBException e){
		super(e);
	}

}
