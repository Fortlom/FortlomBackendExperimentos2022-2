package com.example.fortlomisw.backend.domain.service;

import com.example.fortlomisw.backend.domain.model.entity.Artist;
import com.example.fortlomisw.backend.domain.model.entity.Fanatic;
import com.example.fortlomisw.backend.domain.persistence.FanaticRepository;
import com.example.fortlomisw.backend.service.EventServiceImpl;
import com.example.fortlomisw.backend.service.FanaticServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class FanaticServiceTest {



    @MockBean
    private FanaticRepository fanaticRepository;
    @Autowired
    private FanaticService fanaticService;

    @TestConfiguration
    static class FanaticServiceTestConfiguration {
        @Bean
        public FanaticService fanaticService() {
            return new FanaticServiceImpl();
        }
    }


    @Test
    void getAll() {
        long id=1;
        Fanatic fanatic=new Fanatic();
        fanatic.setId(id);
        fanatic.setUsername("sapTR");
        fanatic.setRealname("jose");
        fanatic.setLastname("wrssa");
        fanatic.setEmail("wes@gmail.com");
        fanatic.setPassword("nueva");
        fanatic.setFanaticalias("caminatumbas");
        List<Fanatic> fanaticList= new ArrayList<>();
        fanaticList.add(fanatic);

        when(fanaticRepository.findAll()).thenReturn(fanaticList);
        List<Fanatic>fanatics=fanaticService.getAll();
        assertThat(fanatics).isEqualTo(fanaticList);
    }

    @Test
    void getById() {
        long id=1;
        Fanatic fanatic=new Fanatic();
        fanatic.setId(id);
        fanatic.setUsername("sapERSS");
        fanatic.setRealname("jose");
        fanatic.setLastname("wrssa");
        fanatic.setEmail("wes@gmail.com");
        fanatic.setPassword("nueva");
        fanatic.setFanaticalias("caminatumbas");
        when(fanaticRepository.findById(id)).thenReturn(Optional.of(fanatic));
        Fanatic found=fanaticService.getById(id);
        assertThat(found.getId()).isEqualTo(id);
    }

    @Test
    void update() {
        long id=1;
        Fanatic fanatic=new Fanatic();
        fanatic.setId(id);
        fanatic.setUsername("sap");
        fanatic.setRealname("jose");
        fanatic.setLastname("wrssa");
        fanatic.setEmail("wes@gmail.com");
        fanatic.setPassword("nueva");
        fanatic.setFanaticalias("caminatumbas");



        Fanatic updatefanatic=new Fanatic();
        updatefanatic.setId(id);
        updatefanatic.setUsername("sapes");
        updatefanatic.setRealname("joses");
        updatefanatic.setLastname("wrssa");
        updatefanatic.setEmail("wes@gmail.com");
        updatefanatic.setPassword("nueva");
        updatefanatic.setFanaticalias("caminatumbassss");

        when(fanaticRepository.findById(id)).thenReturn(Optional.of(fanatic));
        when(fanaticRepository.save(updatefanatic)).thenReturn(updatefanatic);
        Fanatic found=fanaticRepository.save(updatefanatic);
        assertThat(found).isEqualTo(updatefanatic);
    }

    @Test
    void delete() {

        long id=1;
        Fanatic fanatic=new Fanatic();
        fanatic.setId(id);
        fanatic.setUsername("sap");
        fanatic.setRealname("jose");
        fanatic.setLastname("wrssa");
        fanatic.setEmail("wes@gmail.com");
        fanatic.setPassword("nueva");
        fanatic.setFanaticalias("caminatumbas");

        when(fanaticRepository.findById(id)).thenReturn(Optional.of(fanatic));

        // ACt
        ResponseEntity<?> result = fanaticService.delete(id);

        // Assert
        assertThat(result).isEqualTo(ResponseEntity.ok().build());

    }

    @Test
    void existsByNombreUsuario() {
        long id=1;
        Fanatic fanatic=new Fanatic();
        fanatic.setId(id);
        fanatic.setUsername("sap");
        fanatic.setRealname("jose");
        fanatic.setLastname("wrssa");
        fanatic.setEmail("wes@gmail.com");
        fanatic.setPassword("nueva");
        fanatic.setFanaticalias("caminatumbas");
        when(fanaticRepository.existsByUsername("sap")).thenReturn(true);
        Boolean found=fanaticService.existsByNombreUsuario("sap");
        assertThat(found).isEqualTo(true);
    }

    @Test
    void existsByEmail() {
        long id=1;
        Fanatic fanatic=new Fanatic();
        fanatic.setId(id);
        fanatic.setUsername("sap");
        fanatic.setRealname("jose");
        fanatic.setLastname("wrssa");
        fanatic.setEmail("wes@gmail.com");
        fanatic.setPassword("nueva");
        fanatic.setFanaticalias("caminatumbas");
        when(fanaticRepository.existsByUsername("wes@gmail.com")).thenReturn(true);
        Boolean found=fanaticService.existsByNombreUsuario("wes@gmail.com");
        assertThat(found).isEqualTo(true);
    }

    @Test
    void getbyNombreUsuario() {
        long id=1;
        Fanatic fanatic=new Fanatic();
        fanatic.setId(id);
        fanatic.setUsername("sap");
        fanatic.setRealname("jose");
        fanatic.setLastname("wrssa");
        fanatic.setEmail("wes@gmail.com");
        fanatic.setPassword("nueva");
        fanatic.setFanaticalias("caminatumbas");
        when(fanaticRepository.findByUsername("sap")).thenReturn(Optional.of(fanatic));
        Fanatic found=fanaticService.getbyNombreUsuario("sap");
        assertThat(found.getUsername()).isEqualTo("sap");
    }

    @Test
    void create() {
        long id=1;
        Fanatic fanatic=new Fanatic();
        fanatic.setId(id);
        fanatic.setUsername("sap");
        fanatic.setRealname("jose");
        fanatic.setLastname("wrssa");
        fanatic.setEmail("wes@gmail.com");
        fanatic.setPassword("nueva");
        fanatic.setFanaticalias("caminatumbas");
        when(fanaticRepository.save(fanatic)).thenReturn(fanatic);
        Fanatic save=fanaticService.create(fanatic);

        assertThat(save).isEqualTo(fanatic);

    }
}