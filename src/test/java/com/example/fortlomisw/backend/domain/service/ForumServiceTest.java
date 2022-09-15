package com.example.fortlomisw.backend.domain.service;

import com.example.fortlomisw.backend.domain.model.entity.Forum;
import com.example.fortlomisw.backend.domain.model.entity.ForumComment;
import com.example.fortlomisw.backend.domain.model.entity.Person;
import com.example.fortlomisw.backend.domain.persistence.ForumRepository;
import com.example.fortlomisw.backend.domain.persistence.UserRepository;
import com.example.fortlomisw.backend.service.ForumCommentServiceImpl;
import com.example.fortlomisw.backend.service.ForumServiceImpl;
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
class ForumServiceTest {
    @MockBean
    private UserRepository userRepository;

    @MockBean
    private ForumRepository forumRepository;

    @Autowired
    private ForumService forumService;

    @TestConfiguration
    static class ForumServiceTestConfiguration {
        @Bean
        public ForumService forumService() {
            return new ForumServiceImpl();
        }
    }



    @Test
    void getAllForums() {
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

        List<Forum> forumList= new ArrayList<>();
        forumList.add(forum);

        when(forumRepository.findAll()).thenReturn(forumList);
        List<Forum>forums=forumService.getAllForums();
        assertThat(forums).isEqualTo(forumList);

    }

    @Test
    void getForumById() {
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

        when(forumRepository.findById(id)).thenReturn(Optional.of(forum));
        Forum found=forumService.getForumById(id);
        assertThat(found.getId()).isEqualTo(id);
    }

    @Test
    void createForum() {
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

        when(userRepository.findById(id)).thenReturn(Optional.of(person));
        when(forumRepository.save(forum)).thenReturn(forum);
        Forum save=forumService.createForum(id,forum);

        assertThat(save).isEqualTo(forum);
    }

    @Test
    void getForumsByUserId() {
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
        List<Forum> forumList= new ArrayList<>();
        forumList.add(forum);
        when(userRepository.findById(id)).thenReturn(Optional.of(person));
        when(forumRepository.findByPersonId(id)).thenReturn(forumList);
        List<Forum>forums=forumService.getForumsByUserId(id);
        assertThat(forums).isEqualTo(forumList);
    }

    @Test
    void deleteForum() {
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

        when(forumRepository.findById(id)).thenReturn(Optional.of(forum));

        // ACt
        ResponseEntity<?> result = forumService.deleteForum(id);

        // Assert
        assertThat(result).isEqualTo(ResponseEntity.ok().build());
    }
}