package pl.sly.jersey2.spring.example.controller.mapper;

public class ApiErrorResponse {
    private int code;
    private String description;

    public ApiErrorResponse(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
