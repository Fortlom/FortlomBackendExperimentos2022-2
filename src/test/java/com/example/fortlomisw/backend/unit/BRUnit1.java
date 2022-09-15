package com.example.fortlomisw.backend.unit;

import com.example.fortlomisw.backend.domain.model.entity.Forum;
import com.example.fortlomisw.backend.domain.model.entity.ForumComment;
import com.example.fortlomisw.backend.domain.model.entity.Person;
import com.example.fortlomisw.backend.domain.persistence.ForumCommentRepository;
import com.example.fortlomisw.backend.domain.persistence.ForumRepository;
import com.example.fortlomisw.backend.domain.persistence.UserRepository;
import com.example.fortlomisw.backend.domain.service.ForumCommentService;
import com.example.fortlomisw.backend.service.ForumCommentServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class BRUnit1 {
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
    @DisplayName("A comment has hate words")
    public void aCommentHasHateContent() {
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
        forumComment.setCommentdescription("Un comentario");
        forumComment.setPerson(person);
        forumComment.setForum(forum);


      //  when(userRepository.findById(id)).thenReturn(Optional.of(person));
     //   when(forumRepository.findById(id)).thenReturn(Optional.of(forum));
      //  when(forumCommentRepository.save(forumComment)).thenReturn(forumComment);

        assertThat(forumCommentService.IsHateComment(forumComment.getCommentdescription())).isFalse();
    }

}
