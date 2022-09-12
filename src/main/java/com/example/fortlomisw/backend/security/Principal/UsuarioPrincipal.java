package com.example.fortlomisw.backend.security.Principal;


import com.example.fortlomisw.backend.domain.model.entity.Person;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public class UsuarioPrincipal implements UserDetails{

    Person person;

    private String username;

    private String realname;

    private String lastname;


    private String email;

    private String password;


    private Collection<? extends GrantedAuthority>authorities;


    public UsuarioPrincipal(String username, String realname, String lastname, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.realname = realname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static UsuarioPrincipal build(Person persona){
        List<GrantedAuthority>authorities=
                persona.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol
                        .getName().name())).collect(Collectors.toList());

        return new UsuarioPrincipal(persona.getUsername(), persona.getRealname(), persona.getLastname(),persona.getEmail(), persona.getPassword(),authorities );

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }




}
