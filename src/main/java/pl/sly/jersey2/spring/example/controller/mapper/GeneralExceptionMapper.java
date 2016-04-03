package pl.sly.jersey2.spring.example.controller.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GeneralExceptionMapper extends AbstractResponseProvider implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception e) {
        return buildResponse(ApiError.INTERNAL_SERVER_ERROR);
    }
}
