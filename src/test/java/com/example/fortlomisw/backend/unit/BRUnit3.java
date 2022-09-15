package com.example.fortlomisw.backend.unit;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.fortlomisw.backend.domain.persistence.ArtistRepository;
import com.example.fortlomisw.backend.domain.persistence.PublicationRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.fortlomisw.backend.domain.model.entity.Artist;
import com.example.fortlomisw.backend.domain.model.entity.Publication;
import com.example.fortlomisw.backend.domain.service.PublicationService;
import com.example.fortlomisw.backend.service.PublicationServiceImpl;

@ExtendWith(SpringExtension.class)
public class BRUnit3 {
    @MockBean
    private PublicationRepository publicationrepository;
    @MockBean
    private ArtistRepository artistrepository;
    @Autowired
    private PublicationService publicationService;



    @TestConfiguration
    static class PublicationServiceImplTestConfiguration {
        @Bean
        public PublicationService publicationService() {
            return new PublicationServiceImpl();
        }
    }

    //@Test // validar que el link de una cancion que comparta un artista sea veridica
    @DisplayName("When Artist.getPublications publications is not equals null")
    public void WhenArtistGetPublicationspublicationsisnotequalsnull() {
        // ----- arrange-----
        // artist
        Long artist_id = 3L;
        Artist testArtist = new Artist();
        testArtist.setId(artist_id);
        // publication set by artist
        Long publication_id = 2L;
        Publication publication = new Publication();
        publication.setId(publication_id);
        publication.setArtist(testArtist);

        // ------act------
        Publication foundPublication = publicationService.getById(publication_id);

        // Assert
        assertThat(foundPublication.getId()).isNotEqualTo(null);

    }
}