package co.edu.poli.user.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserDTO {

    @NotEmpty(message = "The name can not be empty")
    private String name;

    @NotEmpty(message = "The lastname can not be empty")
    private String lastName;
}
