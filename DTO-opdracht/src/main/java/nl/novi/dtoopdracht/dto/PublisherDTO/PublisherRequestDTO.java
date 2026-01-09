package nl.novi.dtoopdracht.dto.PublisherDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PublisherRequestDTO {

    // fields
    @NotBlank(message = "De naam mag niet leeg zijn.")
    @Size(max = 50, message = "De naam mag niet meer dan 50 karakters bevatten.")
    private String name;

    // getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
