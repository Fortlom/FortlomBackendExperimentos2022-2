package com.example.fortlomisw.backend.domain.service;

import com.example.fortlomisw.backend.domain.model.entity.*;
import com.example.fortlomisw.backend.domain.persistence.*;
import com.example.fortlomisw.backend.service.RateServiceImpl;
import com.example.fortlomisw.backend.service.RolServiceImpl;
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
class RateServiceTest {

    @MockBean
    private RateRepository raterepository;
    @MockBean
    private FanaticRepository fanaticrepository;
    @MockBean
    private ArtistRepository artistrepository;
    @MockBean
    private FollowRepository followRepository;
    @MockBean
    private ReportRepository reportRepository;

    @Autowired
    private RateService rateservice;

    @TestConfiguration
    static class RateServiceTestConfiguration {
        @Bean
        public RateService rateService() {
            return new RateServiceImpl();
        }
    }

    @Test
    void getAll() {
        long id=1;
        Artist artist=new Artist();
        artist.setId(id);
        artist.setUsername("sap");
        artist.setRealname("jose");
        artist.setLastname("wrssa");
        artist.setEmail("wes@gmail.com");
        artist.setPassword("nueva");
        artist.setArtistfollowers((long)0);

        Fanatic fanatic =new Fanatic();
        fanatic.setId(id);
        fanatic.setUsername("sap");
        fanatic.setRealname("jose");
        fanatic.setLastname("wrssa");
        fanatic.setEmail("wes@gmail.com");
        fanatic.setPassword("nueva");
        fanatic.setFanaticalias("alias 1");

        Rate rate =new Rate();
        rate.setId(id);
        rate.setRates(1);
        rate.setArtist(artist);
        rate.setFanatic(fanatic);

        List<Rate> rateList= new ArrayList<>();
        rateList.add(rate);

        when(raterepository.findAll()).thenReturn(rateList);
        when(fanaticrepository.findById(id)).thenReturn(Optional.of(fanatic));
        when(artistrepository.findById(id)).thenReturn(Optional.of(artist));
        List<Rate> rates = rateservice.getAll();
        assertThat(rates).isEqualTo(rateList);
    }

    @Test
    void getById() {
        long id=1;
        Artist artist=new Artist();
        artist.setId(id);
        artist.setUsername("sap");
        artist.setRealname("jose");
        artist.setLastname("wrssa");
        artist.setEmail("wes@gmail.com");
        artist.setPassword("nueva");
        artist.setArtistfollowers((long)0);

        Fanatic fanatic =new Fanatic();
        fanatic.setId(id);
        fanatic.setUsername("sap");
        fanatic.setRealname("jose");
        fanatic.setLastname("wrssa");
        fanatic.setEmail("wes@gmail.com");
        fanatic.setPassword("nueva");
        fanatic.setFanaticalias("alias 1");

        Rate rate =new Rate();
        rate.setId(id);
        rate.setRates(1);
        rate.setArtist(artist);
        rate.setFanatic(fanatic);

        when(raterepository.findById(id)).thenReturn(Optional.of(rate));
        when(fanaticrepository.findById(id)).thenReturn(Optional.of(fanatic));
        when(artistrepository.findById(id)).thenReturn(Optional.of(artist));
        Rate rate1 = rateservice.getById(id);
        assertThat(rate1).isEqualTo(rate);
    }

    @Test
    void create() {
        long id=1;
        Artist artist=new Artist();
        artist.setId(id);
        artist.setUsername("sap");
        artist.setRealname("jose");
        artist.setLastname("wrssa");
        artist.setEmail("wes@gmail.com");
        artist.setPassword("nueva");
        artist.setArtistfollowers((long)0);

        Fanatic fanatic =new Fanatic();
        fanatic.setId(id);
        fanatic.setUsername("sap");
        fanatic.setRealname("jose");
        fanatic.setLastname("wrssa");
        fanatic.setEmail("wes@gmail.com");
        fanatic.setPassword("nueva");
        fanatic.setFanaticalias("alias 1");

        Rate rate =new Rate();
        rate.setId(id);
        rate.setRates(1);
        rate.setArtist(artist);
        rate.setFanatic(fanatic);

        when(raterepository.save(rate)).thenReturn(rate);
        when(fanaticrepository.findById(id)).thenReturn(Optional.of(fanatic));
        when(artistrepository.findById(id)).thenReturn(Optional.of(artist));
        Rate rate1 = rateservice.create(id,id,rate);
        assertThat(rate1).isEqualTo(rate);
    }

    @Test
    void update() {
        long id=1;
        Artist artist=new Artist();
        artist.setId(id);
        artist.setUsername("sap");
        artist.setRealname("jose");
        artist.setLastname("wrssa");
        artist.setEmail("wes@gmail.com");
        artist.setPassword("nueva");
        artist.setArtistfollowers((long)0);

        Fanatic fanatic =new Fanatic();
        fanatic.setId(id);
        fanatic.setUsername("sap");
        fanatic.setRealname("jose");
        fanatic.setLastname("wrssa");
        fanatic.setEmail("wes@gmail.com");
        fanatic.setPassword("nueva");
        fanatic.setFanaticalias("alias 1");

        Rate ratenew =new Rate();
        ratenew.setId(id);
        ratenew.setRates(1);
        ratenew.setArtist(artist);
        ratenew.setFanatic(fanatic);

        Rate rateold =new Rate();
        rateold.setId(id);
        rateold.setRates(10);
        rateold.setArtist(artist);
        rateold.setFanatic(fanatic);

        when(raterepository.save(ratenew)).thenReturn(ratenew);
        when(fanaticrepository.findById(id)).thenReturn(Optional.of(fanatic));
        when(artistrepository.findById(id)).thenReturn(Optional.of(artist));
        when(raterepository.findById(id)).thenReturn(Optional.of(rateold));
        when(raterepository.findById(id)).thenReturn(Optional.of(ratenew));
        Rate rate1 = rateservice.update(id,ratenew);
        assertThat(rate1).isEqualTo(ratenew);
    }

    @Test
    void ratesByFanaticId() {
        long id=1;
        Artist artist=new Artist();
        artist.setId(id);
        artist.setUsername("sap");
        artist.setRealname("jose");
        artist.setLastname("wrssa");
        artist.setEmail("wes@gmail.com");
        artist.setPassword("nueva");
        artist.setArtistfollowers((long)0);

        Fanatic fanatic =new Fanatic();
        fanatic.setId(id);
        fanatic.setUsername("sap");
        fanatic.setRealname("jose");
        fanatic.setLastname("wrssa");
        fanatic.setEmail("wes@gmail.com");
        fanatic.setPassword("nueva");
        fanatic.setFanaticalias("alias 1");

        Rate rate =new Rate();
        rate.setId(id);
        rate.setRates(1);
        rate.setArtist(artist);
        rate.setFanatic(fanatic);

        List<Rate> rateList= new ArrayList<>();
        rateList.add(rate);


        when(fanaticrepository.findById(id)).thenReturn(Optional.of(fanatic));
        when(artistrepository.findById(id)).thenReturn(Optional.of(artist));
        when(raterepository.findByFanaticId(fanatic.getId())).thenReturn(rateList);
        List<Rate> rates = rateservice.ratesByFanaticId(fanatic.getId());
        assertThat(rates).isEqualTo(rateList);
    }

    @Test
    void ratesByArtistId() {
        long id=1;
        Artist artist=new Artist();
        artist.setId(id);
        artist.setUsername("sap");
        artist.setRealname("jose");
        artist.setLastname("wrssa");
        artist.setEmail("wes@gmail.com");
        artist.setPassword("nueva");
        artist.setArtistfollowers((long)0);

        Fanatic fanatic =new Fanatic();
        fanatic.setId(id);
        fanatic.setUsername("sap");
        fanatic.setRealname("jose");
        fanatic.setLastname("wrssa");
        fanatic.setEmail("wes@gmail.com");
        fanatic.setPassword("nueva");
        fanatic.setFanaticalias("alias 1");

        Rate rate =new Rate();
        rate.setId(id);
        rate.setRates(1);
        rate.setArtist(artist);
        rate.setFanatic(fanatic);

        List<Rate> rateList= new ArrayList<>();
        rateList.add(rate);


        when(fanaticrepository.findById(id)).thenReturn(Optional.of(fanatic));
        when(artistrepository.findById(id)).thenReturn(Optional.of(artist));
        when(raterepository.findByArtistId(id)).thenReturn(rateList);
        List<Rate> rates = rateservice.ratesByArtistId(artist.getId());
        assertThat(rates).isEqualTo(rateList);
    }

    @Test
    void delete() {
        long id = 1;
        Artist artist=new Artist();
        artist.setId(id);
        artist.setUsername("sap");
        artist.setRealname("jose");
        artist.setLastname("wrssa");
        artist.setEmail("wes@gmail.com");
        artist.setPassword("nueva");
        artist.setArtistfollowers((long)0);

        Fanatic fanatic =new Fanatic();
        fanatic.setId(id);
        fanatic.setUsername("sap");
        fanatic.setRealname("jose");
        fanatic.setLastname("wrssa");
        fanatic.setEmail("wes@gmail.com");
        fanatic.setPassword("nueva");
        fanatic.setFanaticalias("alias 1");

        Rate rate =new Rate();
        rate.setId(id);
        rate.setRates(1);
        rate.setArtist(artist);
        rate.setFanatic(fanatic);

        when(raterepository.findById(id)).thenReturn(Optional.of(rate));

        ResponseEntity<?> result = rateservice.delete(id);

        assertThat(result).isEqualTo(ResponseEntity.ok().build());
    }
}