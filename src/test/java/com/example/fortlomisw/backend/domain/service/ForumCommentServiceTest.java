package com.example.fortlomisw.backend.domain.service;

import com.example.fortlomisw.backend.domain.model.entity.*;
import com.example.fortlomisw.backend.domain.persistence.ForumCommentRepository;
import com.example.fortlomisw.backend.domain.persistence.ForumRepository;
import com.example.fortlomisw.backend.domain.persistence.UserRepository;
import com.example.fortlomisw.backend.service.FanaticServiceImpl;
import com.example.fortlomisw.backend.service.ForumCommentServiceImpl;
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
class ForumCommentServiceTest {


    @MockBean
    private UserRepository userRepository;

    @MockBean
    private ForumRepository forumRepository;


    @MockBean
    private ForumCommentRepository forumCommentRepository;

    @Autowired
    private ForumCommentService forumCommentService;


    @TestConfiguration
    static class ForumCommentServiceTestConfiguration {
        @Bean
        public ForumCommentService forumCommentService() {
            return new ForumCommentServiceImpl();
        }
    }


    @Test
    void getAll() {
        long id=1;
        Person person=new Person();
        person.setId(id);
        person.setUsername("sap");
        person.setRealname("jose");
        person.setLastname("wrssa");
        person.setEmail("wes@gmail.com");
        person.setPassword("nueva");
        Forum forum=new Forum();
        forum.setId(id);
        forum.setForumname("nuevo foro");
        forum.setForumdescription("descripcion");
        forum.setPerson(person);
        ForumComment forumComment=new ForumComment();
        forumComment.setId(id);
        forumComment.setCommentdescription("descrupcion");
        forumComment.setPerson(person);
        forumComment.setForum(forum);

        List<ForumComment> forumCommentList= new ArrayList<>();
        forumCommentList.add(forumComment);

        when(forumCommentRepository.findAll()).thenReturn(forumCommentList);
        List<ForumComment>forumComments=forumCommentService.getAll();
        assertThat(forumComments).isEqualTo(forumCommentList);


    }

    @Test
    void getById() {
        long id=1;
        Person person=new Person();
        person.setId(id);
        person.setUsername("sap");
        person.setRealname("jose");
        person.setLastname("wrssa");
        person.setEmail("wes@gmail.com");
        person.setPassword("nueva");
        Forum forum=new Forum();
        forum.setId(id);
        forum.setForumname("nuevo foro");
        forum.setForumdescription("descripcion");
        forum.setPerson(person);
        ForumComment forumComment=new ForumComment();
        forumComment.setId(id);
        forumComment.setCommentdescription("descrupcion");
        forumComment.setPerson(person);
        forumComment.setForum(forum);


        when(forumCommentRepository.findById(id)).thenReturn(Optional.of(forumComment));
        ForumComment found=forumCommentService.getById(id);
        assertThat(found.getId()).isEqualTo(id);
    }

    @Test
    void create() {
        long id=1;
        Person person=new Person();
        person.setId(id);
        person.setUsername("sap");
        person.setRealname("jose");
        person.setLastname("wrssa");
        person.setEmail("wes@gmail.com");
        person.setPassword("nueva");
        Forum forum=new Forum();
        forum.setId(id);
        forum.setForumname("nuevo foro");
        forum.setForumdescription("descripcion");
        forum.setPerson(person);
        ForumComment forumComment=new ForumComment();
        forumComment.setId(id);
        forumComment.setCommentdescription("descrupcion");
        forumComment.setPerson(person);
        forumComment.setForum(forum);


        when(userRepository.findById(id)).thenReturn(Optional.of(person));
        when(forumRepository.findById(id)).thenReturn(Optional.of(forum));
        when(forumCommentRepository.save(forumComment)).thenReturn(forumComment);
        ForumComment save=forumCommentService.create(id,id,forumComment);

        assertThat(save).isEqualTo(forumComment);
    }

    @Test
    void getForumCommentByForumId() {
        long id=1;
        Person person=new Person();
        person.setId(id);
        person.setUsername("sap");
        person.setRealname("jose");
        person.setLastname("wrssa");
        person.setEmail("wes@gmail.com");
        person.setPassword("nueva");
        Forum forum=new Forum();
        forum.setId(id);
        forum.setForumname("nuevo foro");
        forum.setForumdescription("descripcion");
        forum.setPerson(person);
        ForumComment forumComment=new ForumComment();
        forumComment.setId(id);
        forumComment.setCommentdescription("descrupcion");
        forumComment.setPerson(person);
        forumComment.setForum(forum);


        List<ForumComment> forumCommentList= new ArrayList<>();
        forumCommentList.add(forumComment);
        when(forumRepository.findById(id)).thenReturn(Optional.of(forum));
        when(forumCommentRepository.findByForumId(id)).thenReturn(forumCommentList);
        List<ForumComment>forumComments=forumCommentService.getForumCommentByForumId(id);
        assertThat(forumComments).isEqualTo(forumCommentList);


    }

    @Test
    void delete() {
        long id=1;
        Person person=new Person();
        person.setId(id);
        person.setUsername("sap");
        person.setRealname("jose");
        person.setLastname("wrssa");
        person.setEmail("wes@gmail.com");
        person.setPassword("nueva");
        Forum forum=new Forum();
        forum.setId(id);
        forum.setForumname("nuevo foro");
        forum.setForumdescription("descripcion");
        forum.setPerson(person);
        ForumComment forumComment=new ForumComment();
        forumComment.setId(id);
        forumComment.setCommentdescription("descrupcion");
        forumComment.setPerson(person);
        forumComment.setForum(forum);

        when(forumCommentRepository.findById(id)).thenReturn(Optional.of(forumComment));

        // ACt
        ResponseEntity<?> result = forumCommentService.delete(id);

        // Assert
        assertThat(result).isEqualTo(ResponseEntity.ok().build());
    }
}