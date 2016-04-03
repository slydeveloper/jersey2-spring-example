package pl.sly.jersey2.spring.example.controller.mapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public abstract class AbstractResponseProvider {
    public Response buildResponse(ApiError apiError) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(apiError.getCode(), apiError.getDescription());

        return Response.status(apiError.getCode()).type(MediaType.APPLICATION_JSON).entity(apiErrorResponse).build();
    }
}
