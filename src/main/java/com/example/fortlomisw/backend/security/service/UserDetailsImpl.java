package com.example.fortlomisw.backend.security.service;
import com.example.fortlomisw.backend.domain.model.entity.Person;
import com.example.fortlomisw.backend.domain.service.PersonService;
import com.example.fortlomisw.backend.security.Principal.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsImpl implements UserDetailsService{

    @Autowired
    PersonService personaService;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person>value=personaService.getbyNombreUsuarioOrEmail(username);
        if (value.isPresent()){
            return UsuarioPrincipal.build(value.get());
        }
       throw new UsernameNotFoundException("Error");
    }
}
