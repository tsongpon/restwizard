package transport;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */
public class EmployeeTransport {
    private Long id;
    private String name;
    private String jobTitle;

    public EmployeeTransport(Long id, String name, String jobTitle) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
