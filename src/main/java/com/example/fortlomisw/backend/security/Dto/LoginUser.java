package com.example.fortlomisw.backend.security.Dto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginUser {


    @NotBlank
    private String nombreUsuario;

    @NotBlank
    private String password;
}
