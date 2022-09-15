package com.example.fortlomisw.backend.unit;

import com.example.fortlomisw.backend.domain.model.entity.Forum;
import com.example.fortlomisw.backend.domain.model.entity.Person;
import com.example.fortlomisw.backend.domain.persistence.ForumRepository;
import com.example.fortlomisw.backend.domain.persistence.UserRepository;
import com.example.fortlomisw.backend.domain.service.ForumService;
import com.example.fortlomisw.backend.service.ForumServiceImpl;
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
public class BRUnit4 {


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
    @DisplayName("A forum has hate title")
    public void aForumHasHateTitle() {
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

        assertThat(forumService.isWrongTitle(forum.getForumname())).isFalse();
    }

}
