package com.heapdev.messenger.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.heapdev.messenger.model.ErrorMessage;

//DISABLED IT BY REMOVING TAG "@Provider"
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 500, "http://www.heapdev.com/error/500/description");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
						.entity(errorMessage)
						.type(MediaType.APPLICATION_JSON)
						.build();
	}
}