package com.example.fortlomisw.backend.domain.service;

import com.example.fortlomisw.backend.domain.model.entity.Person;
import com.example.fortlomisw.backend.domain.model.entity.Publication;
import com.example.fortlomisw.backend.domain.model.entity.PublicationComment;
import com.example.fortlomisw.backend.domain.persistence.*;
import com.example.fortlomisw.backend.service.PublicationCommentServiceImpl;
import com.example.fortlomisw.backend.service.RolServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.internal.matchers.Null;
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
class PublicationCommentServiceTest {

    @MockBean
    private PublicationCommentRepository pcommentrepository;
    @MockBean
    private PublicationRepository publicationrepository;
    @MockBean
    private UserRepository artistrepository;
    @MockBean
    private FollowRepository followRepository;
    @Autowired
    private PublicationCommentService pcommentservice;

    @TestConfiguration
    static class PublicationCommentServiceTestConfiguration {
        @Bean
        public PublicationCommentService publicationCommentService() {
            return new PublicationCommentServiceImpl();
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

        PublicationComment pcomment =new PublicationComment();
        pcomment.setId(id);
        pcomment.setCommentdescription("publication comment description 1");
        pcomment.setRegisterdate(d);


        List<PublicationComment> pcommentList= new ArrayList<>();
        pcommentList.add(pcomment);

        when(pcommentrepository.findAll()).thenReturn(pcommentList);
        List<PublicationComment> pcomments = pcommentservice.getAll();
        assertThat(pcomments).isEqualTo(pcommentList);
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

        PublicationComment pcomment =new PublicationComment();
        pcomment.setId(id);
        pcomment.setCommentdescription("publication comment description 1");
        pcomment.setRegisterdate(d);

        when(pcommentrepository.findById(id)).thenReturn(Optional.of(pcomment));
        PublicationComment pcomment1 = pcommentservice.getById(id);
        assertThat(pcomment1).isEqualTo(pcomment);
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

        byte[] bytes = "hello world".getBytes();
        Person person = new Person();
        person.setId(id);
        person.setUsername("Person 1");
        person.setRealname("Real name 1");
        person.setLastname("Lastname 1");
        person.setEmail("email 1");
        person.setPassword("12345");
        person.setContent(bytes);
        person.setImageprofiletype("Type 1");
        person.setTokenpassword("token 1");

        Publication publication =new Publication();
        publication.setId(id);
        publication.setPublicationname("publication 1");
        publication.setPublicationdescription("publication description 1");
        publication.setLikes((long)10);
        publication.setRegisterdate(d);

        PublicationComment pcomment =new PublicationComment();
        pcomment.setId(id);
        pcomment.setCommentdescription("publication comment description 1");
        pcomment.setRegisterdate(d);

        when(pcommentrepository.save(pcomment)).thenReturn(pcomment);
        when(publicationrepository.findById(id)).thenReturn(Optional.of(publication));
        when(artistrepository.findById(id)).thenReturn(Optional.of(person));
        PublicationComment pcomment1 = pcommentservice.create(id,id,pcomment);
        assertThat(pcomment1).isEqualTo(pcomment);
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

        PublicationComment pcomment =new PublicationComment();
        pcomment.setId(id);
        pcomment.setCommentdescription("publication comment description 1");
        pcomment.setRegisterdate(d);

        PublicationComment pcommentnew =new PublicationComment();
        pcommentnew.setId(id);
        pcommentnew.setCommentdescription("publication comment description 2");
        pcommentnew.setRegisterdate(d);

        when(pcommentrepository.findById(id)).thenReturn(Optional.of(pcomment));
        when(pcommentrepository.save(pcommentnew)).thenReturn(pcommentnew);
        PublicationComment pcomment1 = pcommentrepository.save(pcommentnew);
        assertThat(pcomment1).isEqualTo(pcommentnew);
    }

    @Test
    void getCommentByPublicationId() {
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

        PublicationComment pcomment =new PublicationComment();
        pcomment.setId(id);
        pcomment.setCommentdescription("publication comment description 1");
        pcomment.setRegisterdate(d);

        List<PublicationComment> pcommentlist = new ArrayList<>();
        pcommentlist.add(pcomment);


        when(publicationrepository.findById(id)).thenReturn(Optional.of(publication));
        when(pcommentrepository.findByPublicationId(id)).thenReturn(pcommentlist);
        List<PublicationComment> pcomments = pcommentservice.getCommentByPublicationId(id);
        assertThat(pcomments).isEqualTo(pcommentlist);
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

        PublicationComment pcomment =new PublicationComment();
        pcomment.setId(id);
        pcomment.setCommentdescription("publication comment description 1");
        pcomment.setRegisterdate(d);

        when(pcommentrepository.findById(id)).thenReturn(Optional.of(pcomment));

        ResponseEntity<?> result = pcommentservice.delete(id);

        assertThat(result).isEqualTo(ResponseEntity.ok().build());
    }
}