package nl.novi.dtoopdracht.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PublisherRequestDTO {
    @NotBlank(message = "De naam mag niet leeg zijn.")
    @Size(max = 50, message = "De naam mag niet meer dan 50 karakters bevatten.")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
