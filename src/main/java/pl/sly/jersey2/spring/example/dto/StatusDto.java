package pl.sly.jersey2.spring.example.dto;

/**
 * Status DTO with time value.
 */
public class StatusDto {
    private Long status;

    /**
     * Get time value.
     * @return A time value.
     */
    public Long getStatus() {
        return status;
    }

    /**
     * Set time value.
     * @param status A time value.
     */
    public void setStatus(Long status) {
        this.status = status;
    }
}
