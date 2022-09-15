package com.example.fortlomisw.backend.domain.service;

import com.example.fortlomisw.backend.domain.model.entity.Artist;
import com.example.fortlomisw.backend.domain.model.entity.Event;
import com.example.fortlomisw.backend.domain.model.entity.Fanatic;
import com.example.fortlomisw.backend.domain.model.entity.Follow;
import com.example.fortlomisw.backend.domain.persistence.ArtistRepository;
import com.example.fortlomisw.backend.domain.persistence.FanaticRepository;
import com.example.fortlomisw.backend.domain.persistence.FollowRepository;
import com.example.fortlomisw.backend.service.FanaticServiceImpl;
import com.example.fortlomisw.backend.service.FollowServiceImpl;
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
class FollowServiceTest {



    @MockBean
    private FollowRepository followRepository;
    @MockBean
    private ArtistRepository artistRepository;
    @MockBean
    private FanaticRepository fanaticRepository;
    @Autowired
    private FollowService followService;

    @TestConfiguration
    static class FollowServiceTestConfiguration {
        @Bean
        public FollowService followService() {
            return new FollowServiceImpl();
        }
    }
    @Test
    void getAll() {
        long id=1;
        Fanatic fanatic=new Fanatic();
        fanatic.setId(id);
        fanatic.setUsername("sapERSS");
        fanatic.setRealname("jose");
        fanatic.setLastname("wrssa");
        fanatic.setEmail("wes@gmail.com");
        fanatic.setPassword("nueva");
        fanatic.setFanaticalias("caminatumbas");


        Artist artist=new Artist();
        artist.setId(id);
        artist.setUsername("sap");
        artist.setRealname("jose");
        artist.setLastname("wrssa");
        artist.setEmail("weserr@gmail.com");
        artist.setPassword("nueva");
        artist.setArtistfollowers((long)0);

        Follow follow=new Follow();
        follow.setId(id);
        follow.setArtist(artist);
        follow.setFanatic(fanatic);
        List<Follow>followslist= new ArrayList<>();
        followslist.add(follow);
        when(followRepository.findAll()).thenReturn(followslist);
        List<Follow>follows=followService.getAll();
        assertThat(follows).isEqualTo(followslist);


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


        Artist artist=new Artist();
        artist.setId(id);
        artist.setUsername("sap");
        artist.setRealname("jose");
        artist.setLastname("wrssa");
        artist.setEmail("weserr@gmail.com");
        artist.setPassword("nueva");
        artist.setArtistfollowers((long)0);

        Follow follow=new Follow();
        follow.setId(id);
        follow.setArtist(artist);
        follow.setFanatic(fanatic);


        when(followRepository.findById(id)).thenReturn(Optional.of(follow));
        Follow found=followService.getById(id);
        assertThat(found.getId()).isEqualTo(id);

    }

    @Test
    void create() {
        long id=1;
        Fanatic fanatic=new Fanatic();
        fanatic.setId(id);
        fanatic.setUsername("sapERSS");
        fanatic.setRealname("jose");
        fanatic.setLastname("wrssa");
        fanatic.setEmail("wes@gmail.com");
        fanatic.setPassword("nueva");
        fanatic.setFanaticalias("caminatumbas");


        Artist artist=new Artist();
        artist.setId(id);
        artist.setUsername("sap");
        artist.setRealname("jose");
        artist.setLastname("wrssa");
        artist.setEmail("weserr@gmail.com");
        artist.setPassword("nueva");
        artist.setArtistfollowers((long)0);

        Follow follow=new Follow();
        follow.setId(id);
        follow.setArtist(artist);
        follow.setFanatic(fanatic);

        when(fanaticRepository.findById(id)).thenReturn(Optional.of(fanatic));
        when(artistRepository.findById(id)).thenReturn(Optional.of(artist));
        when(followRepository.save(follow)).thenReturn(follow);
        Follow save=followService.create(id,id,follow);

        assertThat(save).isEqualTo(follow);

    }

    @Test
    void followsByFanaticId() {
        long id=1;
        Fanatic fanatic=new Fanatic();
        fanatic.setId(id);
        fanatic.setUsername("sapERSS");
        fanatic.setRealname("jose");
        fanatic.setLastname("wrssa");
        fanatic.setEmail("wes@gmail.com");
        fanatic.setPassword("nueva");
        fanatic.setFanaticalias("caminatumbas");


        Artist artist=new Artist();
        artist.setId(id);
        artist.setUsername("sap");
        artist.setRealname("jose");
        artist.setLastname("wrssa");
        artist.setEmail("weserr@gmail.com");
        artist.setPassword("nueva");
        artist.setArtistfollowers((long)0);

        Follow follow=new Follow();
        follow.setId(id);
        follow.setArtist(artist);
        follow.setFanatic(fanatic);
        List<Follow>followslist= new ArrayList<>();
        followslist.add(follow);

        when(fanaticRepository.findById(id)).thenReturn(Optional.of(fanatic));
        when(followRepository.findByFanaticId(id)).thenReturn(followslist);
        List<Follow>follows=followService.followsByFanaticId(id);
        assertThat(follows).isEqualTo(followslist);
    }

    @Test
    void followsByArtistId() {
        long id=1;
        Fanatic fanatic=new Fanatic();
        fanatic.setId(id);
        fanatic.setUsername("sapERSS");
        fanatic.setRealname("jose");
        fanatic.setLastname("wrssa");
        fanatic.setEmail("wes@gmail.com");
        fanatic.setPassword("nueva");
        fanatic.setFanaticalias("caminatumbas");


        Artist artist=new Artist();
        artist.setId(id);
        artist.setUsername("sap");
        artist.setRealname("jose");
        artist.setLastname("wrssa");
        artist.setEmail("weserr@gmail.com");
        artist.setPassword("nueva");
        artist.setArtistfollowers((long)0);

        Follow follow=new Follow();
        follow.setId(id);
        follow.setArtist(artist);
        follow.setFanatic(fanatic);
        List<Follow>followslist= new ArrayList<>();
        followslist.add(follow);

        when(artistRepository.findById(id)).thenReturn(Optional.of(artist));
        when(followRepository.findByArtistId(id)).thenReturn(followslist);
        List<Follow>follows=followService.followsByArtistId(id);
        assertThat(follows).isEqualTo(followslist);
    }

    @Test
    void delete() {
        long id=1;
        Fanatic fanatic=new Fanatic();
        fanatic.setId(id);
        fanatic.setUsername("sapERSS");
        fanatic.setRealname("jose");
        fanatic.setLastname("wrssa");
        fanatic.setEmail("wes@gmail.com");
        fanatic.setPassword("nueva");
        fanatic.setFanaticalias("caminatumbas");


        Artist artist=new Artist();
        artist.setId(id);
        artist.setUsername("sap");
        artist.setRealname("jose");
        artist.setLastname("wrssa");
        artist.setEmail("weserr@gmail.com");
        artist.setPassword("nueva");
        artist.setArtistfollowers((long)0);

        Follow follow=new Follow();
        follow.setId(id);
        follow.setArtist(artist);
        follow.setFanatic(fanatic);

        when(followRepository.findById(id)).thenReturn(Optional.of(follow));

        // ACt
        ResponseEntity<?> result = followService.delete(id);

        // Assert
        assertThat(result).isEqualTo(ResponseEntity.ok().build());


    }
}