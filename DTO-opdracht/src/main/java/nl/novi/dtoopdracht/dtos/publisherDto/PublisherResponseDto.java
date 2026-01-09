package nl.novi.dtoopdracht.dtos.publisherDto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PublisherResponseDto {

    // fields
    @JsonProperty("publisher_id")
    private Long id;

    @JsonProperty("publisher_name")
    private String name;

    @JsonProperty("publisher_address")
    private String address;

    @JsonProperty("publisher_contact_details")
    private String contactDetails;

    // getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }
}
