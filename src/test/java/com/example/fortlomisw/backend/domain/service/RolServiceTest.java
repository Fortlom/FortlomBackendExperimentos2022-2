package com.example.fortlomisw.backend.domain.service;

import com.example.fortlomisw.backend.domain.model.entity.Multimedia;
import com.example.fortlomisw.backend.domain.model.entity.Person;
import com.example.fortlomisw.backend.domain.model.entity.Rol;
import com.example.fortlomisw.backend.domain.model.enumeration.RolNombre;
import com.example.fortlomisw.backend.domain.persistence.RolRepository;
import com.example.fortlomisw.backend.domain.persistence.UserRepository;
import com.example.fortlomisw.backend.service.PersonServiceImpl;
import com.example.fortlomisw.backend.service.RolServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import com.example.fortlomisw.backend.domain.model.enumeration.RolNombre;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class RolServiceTest {

    @MockBean
    private RolRepository rolrepository;

    @Autowired
    private RolService rolservice;

    @TestConfiguration
    static class RolServiceTestConfiguration {
        @Bean
        public RolService rolService() {
            return new RolServiceImpl();
        }
    }

    @Test
    void findByName() {
        long id=1;
        RolNombre role = RolNombre.valueOf("Role_Fanatic");
        Rol rol =new Rol();
        rol.setId(id);
        rol.setName(role);
        when(rolrepository.findByName(role)).thenReturn(Optional.of(rol));
        Optional<Rol> rol1 = rolservice.findByName(role);
        assertThat(rol1.get()).isEqualTo(rol);
    }

    @Test
    void getAll() {
        long id=1;
        RolNombre role = RolNombre.valueOf("Role_Fanatic");
        Rol rol =new Rol();
        rol.setId(id);
        rol.setName(role);

        List<Rol> rolList= new ArrayList<>();
        rolList.add(rol);

        when(rolrepository.findAll()).thenReturn(rolList);
        List<Rol> roles = rolservice.getAll();
        assertThat(roles).isEqualTo(rolList);
    }
}