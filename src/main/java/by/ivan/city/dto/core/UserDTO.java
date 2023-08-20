package by.ivan.city.dto.core;

import by.ivan.city.models.enums.Status;
import by.ivan.city.models.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String lastName;
    private String firstName;
    private String username;
    private String password;
    private String mail;
    private Role userRole;
    private Status userStatus;
}

