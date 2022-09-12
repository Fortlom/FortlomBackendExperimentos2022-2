package com.example.fortlomisw.backend.security.Dto;



import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class ChangePassword {


    @NotBlank
    private String password;
    @NotBlank
    private String confirmPassword;
    @NotBlank
    private String tokenPassword;


    public ChangePassword(){}

    public ChangePassword(String password, String confirmPassword, String tokenPassword) {
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.tokenPassword = tokenPassword;
    }





}
