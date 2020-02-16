package dev.esz.users.api.users.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequestModel {
    @NotNull(message = "First name cannot be null!")
    @Size(min = 2, message = "First name should be longer than 2 characters!")
    private String firstName;

    @NotNull(message = "Last name cannot be null!")
    @Size(min = 2, message = "Last name should be longer than 2 characters!")
    private String lastName;

    @NotNull(message = "Password cannot be null!")
    @Size(min = 8, max = 256, message = "Password should be between 8 and 256 characters!")
    private String password;

    @NotNull(message = "Email cannot be null!")
    @Email(message = "Should be correct email format!")
    private String email;
}
