package com.example.fortlomisw.backend.api;

import com.example.fortlomisw.backend.domain.model.entity.Artist;
import com.example.fortlomisw.backend.domain.persistence.ArtistRepository;
import com.example.fortlomisw.backend.domain.service.ArtistService;
import com.example.fortlomisw.backend.mapping.ArtistMapper;
import com.example.fortlomisw.backend.service.ArtistServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
        import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;



import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
class ArtistControllerTest {



    @MockBean
    private ArtistRepository artistRepository;


    @Autowired
    private ArtistService artistService;



    @TestConfiguration
    static class ArtistServiceTestConfiguration {
        @Bean
        public ArtistService artistService() {
            return new ArtistServiceImpl();
        }
    }


    @Test
    void getAllFanatics() {
        long id=1;
        Artist artist=new Artist();
        artist.setId(id);
        artist.setUsername("sap");
        artist.setRealname("jose");
        artist.setLastname("wrssa");
        artist.setEmail("wes@gmail.com");
        artist.setPassword("nueva");
        artist.setArtistfollowers((long)0);
        List<Artist> artistList= new ArrayList<>();
        artistList.add(artist);

        when(artistRepository.findAll()).thenReturn(artistList);
        List<Artist>artists=artistService.getAll();
        assertThat(artists).isEqualTo(artistList);
    }

    @Test
    void getUserById()  {
        long id=1;
        Artist artist=new Artist();
        artist.setId(id);
        artist.setUsername("sap");
        artist.setRealname("jose");
        artist.setLastname("wrssa");
        artist.setEmail("wes@gmail.com");
        artist.setPassword("nueva");
        artist.setArtistfollowers((long)0);
        when(artistRepository.findById(id)).thenReturn(Optional.of(artist));
        Artist found=artistService.getById(id);
        assertThat(found.getId()).isEqualTo(id);

    }


    @Test
    void getUserByartistname() {
        long id=1;
        Artist artist=new Artist();
        artist.setId(id);
        artist.setUsername("sap");
        artist.setRealname("jose");
        artist.setLastname("wrssa");
        artist.setEmail("wes@gmail.com");
        artist.setPassword("nueva");
        artist.setArtistfollowers((long)0);
        when(artistRepository.findByUsername("sap")).thenReturn(Optional.of(artist));
        Artist found=artistService.getbyNombreUsuario("sap");
        assertThat(found.getUsername()).isEqualTo(found.getUsername());
    }

    @Test
    void createUser() {
        long id=1;
        Artist artist=new Artist();
        artist.setId(id);
        artist.setUsername("sap");
        artist.setRealname("jose");
        artist.setLastname("wrssa");
        artist.setEmail("wes@gmail.com");
        artist.setPassword("nueva");
        artist.setArtistfollowers((long)0);

        when(artistRepository.save(artist)).thenReturn(artist);
        Artist save=artistService.create(artist);

        assertThat(save).isEqualTo(artist);

    }

    @Test
    void updateUser() {
        long id=1;
        Artist updateartist=new Artist();
        updateartist.setId(id);
        updateartist.setUsername("sapes");
        updateartist.setRealname("joses");
        updateartist.setLastname("wrssa");
        updateartist.setEmail("wes@gmail.com");
        updateartist.setPassword("nueva");
        updateartist.setArtistfollowers((long)0);
        Artist artist=new Artist();
        artist.setId(1L);
        artist.setUsername("sap");
        artist.setRealname("jose");
        artist.setLastname("wrssa");
        artist.setEmail("wes@gmail.com");
        artist.setPassword("nueva");
        artist.setArtistfollowers((long)0);
        when(artistRepository.findById(id)).thenReturn(Optional.of(artist));
        when(artistRepository.save(updateartist)).thenReturn(updateartist);
        Artist found=artistRepository.save(updateartist);
        assertThat(found).isEqualTo(updateartist);
    }

    @Test
    void updateInstagramAccount() {
        long id=1;
        Artist updateartist=new Artist();
        updateartist.setId(id);
        updateartist.setUsername("sapes");
        updateartist.setRealname("joses");
        updateartist.setLastname("wrssa");
        updateartist.setEmail("wes@gmail.com");
        updateartist.setPassword("nueva");
        updateartist.setArtistfollowers((long)0);
        Artist artist=new Artist();
        artist.setId(1L);
        artist.setUsername("sapes");
        artist.setRealname("joses");
        artist.setLastname("wrssa");
        artist.setEmail("wes@gmail.com");
        artist.setPassword("nueva");
        artist.setInstagramLink("IntagramLink");
        artist.setArtistfollowers((long)0);
        when(artistRepository.findById(id)).thenReturn(Optional.of(artist));
        when(artistRepository.save(updateartist)).thenReturn(updateartist);
        Artist found=artistRepository.save(updateartist);
        assertThat(found).isEqualTo(updateartist);
    }

    @Test
    void updateTwitterAccount() {
        long id=1;
        Artist updateartist=new Artist();
        updateartist.setId(id);
        updateartist.setUsername("sapes");
        updateartist.setRealname("joses");
        updateartist.setLastname("wrssa");
        updateartist.setEmail("wes@gmail.com");
        updateartist.setPassword("nueva");
        updateartist.setArtistfollowers((long)0);
        Artist artist=new Artist();
        artist.setId(1L);
        artist.setUsername("sapes");
        artist.setRealname("joses");
        artist.setLastname("wrssa");
        artist.setEmail("wes@gmail.com");
        artist.setPassword("nueva");
        artist.setTwitterLink("TwitterLink");
        artist.setArtistfollowers((long)0);
        when(artistRepository.findById(id)).thenReturn(Optional.of(artist));
        when(artistRepository.save(updateartist)).thenReturn(updateartist);
        Artist found=artistRepository.save(updateartist);
        assertThat(found).isEqualTo(updateartist);
    }

    @Test
    void updateFacebookAccount() {
        long id=1;
        Artist updateartist=new Artist();
        updateartist.setId(id);
        updateartist.setUsername("sapes");
        updateartist.setRealname("joses");
        updateartist.setLastname("wrssa");
        updateartist.setEmail("wes@gmail.com");
        updateartist.setPassword("nueva");
        updateartist.setArtistfollowers((long)0);
        Artist artist=new Artist();
        artist.setId(1L);
        artist.setUsername("sapes");
        artist.setRealname("joses");
        artist.setLastname("wrssa");
        artist.setEmail("wes@gmail.com");
        artist.setPassword("nueva");
        artist.setFacebookLink("FacebookLink");
        artist.setArtistfollowers((long)0);
        when(artistRepository.findById(id)).thenReturn(Optional.of(artist));
        when(artistRepository.save(updateartist)).thenReturn(updateartist);
        Artist found=artistRepository.save(updateartist);
        assertThat(found).isEqualTo(updateartist);
    }

    @Test
    void deletePost() {
        long id=1;
        Artist artist=new Artist();
        artist.setId(id);
        artist.setUsername("sap");
        artist.setRealname("jose");
        artist.setLastname("wrssa");
        artist.setEmail("wes@gmail.com");
        artist.setPassword("nueva");
        artist.setArtistfollowers((long)0);
        when(artistRepository.findById(id)).thenReturn(Optional.of(artist));

        // ACt
        ResponseEntity<?> result = artistService.delete(id);

        // Assert
        assertThat(result).isEqualTo(ResponseEntity.ok().build());

    }
}