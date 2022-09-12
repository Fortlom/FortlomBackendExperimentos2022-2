package com.example.fortlomisw.backend.security.Dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class NewArtist {

    @NotBlank
    private String username;
    @NotBlank
    private String realname;
    @NotBlank
    private String lastname;
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    private Set<String> roles=new HashSet<>();
}
