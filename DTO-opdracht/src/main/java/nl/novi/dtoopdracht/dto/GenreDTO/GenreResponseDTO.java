package nl.novi.dtoopdracht.dto.GenreDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GenreResponseDTO {

    // fields
    @JsonProperty("genre_id")
    private Long id;

    @JsonProperty("genre_name")
    private String name;

    @JsonProperty("genre_description")
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
