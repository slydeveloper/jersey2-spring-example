package pl.sly.jersey2.spring.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import pl.sly.jersey2.spring.example.dto.StatusDto;
import pl.sly.jersey2.spring.example.service.StatusService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Component annotation allows use the Spring's DI with Jersey
 */
@Component
@Path("/status")
public class StatusController {
    @Autowired
    StatusService statusService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStatus() {
        StatusDto statusDto = new StatusDto();
        statusDto.setStatus(statusService.getTime());

        return Response.status(HttpStatus.OK.value()).entity(statusDto).build();
    }
}
