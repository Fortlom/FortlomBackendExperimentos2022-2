package com.example.fortlomisw.backend.domain.service;

import com.example.fortlomisw.backend.Image.ImageModel;
import com.example.fortlomisw.backend.Image.ImageUtility;
import com.example.fortlomisw.backend.domain.model.entity.Multimedia;
import com.example.fortlomisw.backend.domain.model.entity.Publication;
import com.example.fortlomisw.backend.domain.model.entity.PublicationComment;
import com.example.fortlomisw.backend.domain.persistence.ArtistRepository;
import com.example.fortlomisw.backend.domain.persistence.PublicationCommentRepository;
import com.example.fortlomisw.backend.domain.persistence.PublicationRepository;
import com.example.fortlomisw.backend.service.MultimediaServiceImpl;
import org.junit.jupiter.api.Test;
import com.example.fortlomisw.backend.domain.persistence.MultimediaRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

//import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
class MultimediaServiceTest {

    @MockBean
    private MultimediaRepository multimediarepository;

    @MockBean
    private PublicationCommentRepository commentrepository;

    @MockBean
    private PublicationRepository publicationrepository;

    @Autowired
    private MultimediaService multimediaService;

    @TestConfiguration
    static class CommentServiceTestConfiguration {
        @Bean
        public MultimediaService multimediaService() {
            return new MultimediaServiceImpl();
        }
    }

    @Test
    void getAll() {
        long id=1;
        byte[] bytes = "hello world".getBytes();
        Multimedia multimedia =new Multimedia();
        multimedia.setId(id);
        multimedia.setContent(bytes);
        multimedia.setType("type 1");

        List<Multimedia> multimediaList= new ArrayList<>();
        multimediaList.add(multimedia);

        when(multimediarepository.findAll()).thenReturn(multimediaList);
        List<Multimedia> multimedias = multimediaService.getAll();
        assertThat(multimedias).isEqualTo(multimediaList);
    }

    @Test
    void getById() {
        long id=1;
        byte[] bytes = "hello world".getBytes();
        Multimedia multimedia =new Multimedia();
        multimedia.setId(id);
        multimedia.setContent(bytes);
        multimedia.setType("type 1");

        when(multimediarepository.findById(id)).thenReturn(Optional.of(multimedia));
        Multimedia Multimedia = multimediaService.getById(id);
        assertThat(Multimedia).isEqualTo(multimedia);
    }





    @Test
    void delete() {
        long id = 1;
        PublicationComment comment = new PublicationComment();
        comment.setId(id);
        comment.setCommentdescription("description 1");

        byte[] bytes = "hello world".getBytes();
        Multimedia multimedia =new Multimedia();
        multimedia.setId(id);
        multimedia.setContent(bytes);
        multimedia.setType("type 1");

        when(commentrepository.findById(id)).thenReturn(Optional.of(comment));
        when(multimediarepository.findById(id)).thenReturn(Optional.of(multimedia));
        ResponseEntity<?> result = multimediaService.delete(id);

        assertThat(result).isEqualTo(ResponseEntity.ok().build());
    }
}