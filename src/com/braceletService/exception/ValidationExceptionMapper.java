package com.braceletService.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.braceletService.model.ErrorMessage;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ValidationException>{

	@Override
	public Response toResponse(ValidationException ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 406);
		return Response.status(Status.NOT_ACCEPTABLE)
				.entity(errorMessage)
				.build();
	}
	
}
