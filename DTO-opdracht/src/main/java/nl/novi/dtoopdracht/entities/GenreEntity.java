package nl.novi.dtoopdracht.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "genres")
public class GenreEntity extends BaseEntity {

    // defining columns
    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "description")
    private String description;


    //constructors
    public GenreEntity() {
    }

    public GenreEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}