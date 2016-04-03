package pl.sly.jersey2.spring.example.controller.mapper;

import javax.ws.rs.core.Response;

public enum ApiError {
    NOT_FOUND(Response.Status.NOT_FOUND.getStatusCode(), "Endpoint not found."),
    INTERNAL_SERVER_ERROR(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Internal server error.");

    ApiError(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    private int code;
    private String description;
}
