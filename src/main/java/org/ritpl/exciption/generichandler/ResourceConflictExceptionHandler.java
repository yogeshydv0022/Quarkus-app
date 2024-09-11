package org.ritpl.exciption.generichandler;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.ritpl.exciption.errordto.ErrorResponse;
import org.ritpl.exciption.model.ResourceConflictException;

@Provider
public class ResourceConflictExceptionHandler implements ExceptionMapper<ResourceConflictException> {

    @Override
    public Response toResponse(ResourceConflictException exception) {
        ErrorResponse errorResponse = new ErrorResponse(
                Response.Status.CONFLICT.getStatusCode(),
                exception.getMessage());
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(errorResponse)
                .build();
    }
}
