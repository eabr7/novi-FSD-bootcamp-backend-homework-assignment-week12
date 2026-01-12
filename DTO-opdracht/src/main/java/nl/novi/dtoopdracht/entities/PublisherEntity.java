package nl.novi.dtoopdracht.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "publishers")
public class PublisherEntity extends BaseEntity {

    // defining columns
    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_details")
    private String contactDetails;

    //constructors
    public PublisherEntity() {

    }

    public PublisherEntity(String name, String address, String contactDetails) {
        this.name = name;
        this.address = address;
        this.contactDetails = contactDetails;
    }

    // getters & setters
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