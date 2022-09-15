package com.example.fortlomisw.backend.domain.service;

import com.example.fortlomisw.backend.domain.model.entity.*;
import com.example.fortlomisw.backend.domain.persistence.ArtistRepository;
import com.example.fortlomisw.backend.domain.persistence.PublicationRepository;
import com.example.fortlomisw.backend.domain.persistence.RolRepository;
import com.example.fortlomisw.backend.service.PublicationServiceImpl;
import com.example.fortlomisw.backend.service.RolServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.SimpleDateFormat;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class PublicationServiceTest {

    @MockBean
    private PublicationRepository publicationrepository;
    @MockBean
    private ArtistRepository artistrepository;

    @Autowired
    private PublicationService publicationservice;

    @TestConfiguration
    static class PublicationServiceTestConfiguration {
        @Bean
        public PublicationService publicationService() {
            return new PublicationServiceImpl();
        }
    }

    @Test
    void getAll() {
        Random rand = new Random();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd ");
        Calendar cal = Calendar.getInstance();
        cal.set(2000, 0, 1);
        long start = cal.getTimeInMillis();
        cal.set(2012, 10, 1);
        long end = cal.getTimeInMillis();
        Date d = new Date(start + (long) (rand.nextDouble() * (end - start)));
        long id = 1;

        Publication publication =new Publication();
        publication.setId(id);
        publication.setPublicationname("publication 1");
        publication.setPublicationdescription("publication description 1");
        publication.setLikes((long)10);
        publication.setRegisterdate(d);


        List<Publication> publicationsList= new ArrayList<>();
        publicationsList.add(publication);

        when(publicationrepository.findAll()).thenReturn(publicationsList);
        List<Publication> publications = publicationservice.getAll();
        assertThat(publications).isEqualTo(publicationsList);
    }

    @Test
    void getById() {
        Random rand = new Random();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd ");
        Calendar cal = Calendar.getInstance();
        cal.set(2000, 0, 1);
        long start = cal.getTimeInMillis();
        cal.set(2012, 10, 1);
        long end = cal.getTimeInMillis();
        Date d = new Date(start + (long) (rand.nextDouble() * (end - start)));
        long id = 1;

        Publication publication =new Publication();
        publication.setId(id);
        publication.setPublicationname("publication 1");
        publication.setPublicationdescription("publication description 1");
        publication.setLikes((long)10);
        publication.setRegisterdate(d);

        when(publicationrepository.findById(id)).thenReturn(Optional.of(publication));
        Publication publication1 = publicationservice.getById(id);
        assertThat(publication1).isEqualTo(publication);
    }

    @Test
    void create() {

        Random rand = new Random();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd ");
        Calendar cal = Calendar.getInstance();
        cal.set(2000, 0, 1);
        long start = cal.getTimeInMillis();
        cal.set(2012, 10, 1);
        long end = cal.getTimeInMillis();
        Date d = new Date(start + (long) (rand.nextDouble() * (end - start)));
        long id = 1;

        Artist artist=new Artist();
        artist.setId(id);
        artist.setUsername("sap");
        artist.setRealname("jose");
        artist.setLastname("wrssa");
        artist.setEmail("wes@gmail.com");
        artist.setPassword("nueva");
        artist.setArtistfollowers((long)0);

        Publication publication =new Publication();
        publication.setId(id);
        publication.setPublicationname("publication 1");
        publication.setPublicationdescription("publication description 1");
        publication.setLikes((long)10);
        publication.setRegisterdate(d);

        when(publicationrepository.save(publication)).thenReturn(publication);
        when(artistrepository.save(artist)).thenReturn(artist);
        when(artistrepository.findById(id)).thenReturn(Optional.of(artist));
        Publication result = publicationservice.create(id,publication);
        assertThat(result).isEqualTo(publication);
    }

    @Test
    void update() {
        Random rand = new Random();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd ");
        Calendar cal = Calendar.getInstance();
        cal.set(2000, 0, 1);
        long start = cal.getTimeInMillis();
        cal.set(2012, 10, 1);
        long end = cal.getTimeInMillis();
        Date d = new Date(start + (long) (rand.nextDouble() * (end - start)));
        long id = 1;

        Publication publication =new Publication();
        publication.setId(id);
        publication.setPublicationname("publication 1");
        publication.setPublicationdescription("publication description 1");
        publication.setLikes((long)10);
        publication.setRegisterdate(d);

        Publication publicationnew =new Publication();
        publicationnew.setId(id);
        publicationnew.setPublicationname("publication 2");
        publicationnew.setPublicationdescription("publication description 2");
        publicationnew.setLikes((long)20);
        publicationnew.setRegisterdate(d);

        when(publicationrepository.findById(id)).thenReturn(Optional.of(publication));
        when(publicationrepository.save(publicationnew)).thenReturn(publicationnew);
        when(publicationrepository.findById(id)).thenReturn(Optional.of(publicationnew));
        Publication publication1 = publicationservice.update(id,publicationnew);
        assertThat(publication1).isEqualTo(publicationnew);
    }

    @Test
    void getPublicationByArtistId() {
        Random rand = new Random();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd ");
        Calendar cal = Calendar.getInstance();
        cal.set(2000, 0, 1);
        long start = cal.getTimeInMillis();
        cal.set(2012, 10, 1);
        long end = cal.getTimeInMillis();
        Date d = new Date(start + (long) (rand.nextDouble() * (end - start)));
        long id = 1;

        Artist artist=new Artist();
        artist.setId(id);
        artist.setUsername("sap");
        artist.setRealname("jose");
        artist.setLastname("wrssa");
        artist.setEmail("wes@gmail.com");
        artist.setPassword("nueva");
        artist.setArtistfollowers((long)0);

        Publication publication =new Publication();
        publication.setId(id);
        publication.setPublicationname("publication 1");
        publication.setPublicationdescription("publication description 1");
        publication.setLikes((long)10);
        publication.setRegisterdate(d);

        List<Publication> testlist = new ArrayList<>();
        testlist.add(publication);

        when(artistrepository.findById(id)).thenReturn(Optional.of(artist));
        when(publicationrepository.findByArtistId(id)).thenReturn(testlist);

        List<Publication> publicationslist = publicationservice.getPublicationByArtistId(id);
        assertThat(publicationslist).isEqualTo(testlist);
    }

    @Test
    void delete() {

        Random rand = new Random();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd ");
        Calendar cal = Calendar.getInstance();
        cal.set(2000, 0, 1);
        long start = cal.getTimeInMillis();
        cal.set(2012, 10, 1);
        long end = cal.getTimeInMillis();
        Date d = new Date(start + (long) (rand.nextDouble() * (end - start)));
        long id = 1;

        Publication publication =new Publication();
        publication.setId(id);
        publication.setPublicationname("publication 1");
        publication.setPublicationdescription("publication description 1");
        publication.setLikes((long)10);
        publication.setRegisterdate(d);

        when(publicationrepository.findById(id)).thenReturn(Optional.of(publication));

        ResponseEntity<?> result = publicationservice.delete(id);

        assertThat(result).isEqualTo(ResponseEntity.ok().build());
    }
}