package ru.rass.api.payload.request;

import lombok.Getter;

import java.util.Set;

import javax.validation.constraints.*;

@Getter
public class SignupRequest {
    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    private String firstName, lastName, middleName;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

}
