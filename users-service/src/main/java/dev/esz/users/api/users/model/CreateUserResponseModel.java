package dev.esz.users.api.users.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResponseModel {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
}
