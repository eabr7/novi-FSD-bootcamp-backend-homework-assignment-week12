package nl.novi.dtoopdracht.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class GenreRequestDTO {
    @NotBlank(message = "De naam mag niet leeg zijn.")
    @Size(max = 100, min = 2, message = "De naam mag niet minder dan 2 en niet meer dan 100 karakters bevatten.")
    private String name;

    @Size(max = 250, message = "De beschrijving mag niet meer dan 250 karakters bevatten")
    private String description;

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
