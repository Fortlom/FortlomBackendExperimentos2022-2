package com.example.fortlomisw.backend.integral;

import com.example.fortlomisw.backend.domain.model.entity.Person;
import com.example.fortlomisw.backend.domain.model.entity.Publication;
import com.example.fortlomisw.backend.domain.model.entity.PublicationComment;
import com.example.fortlomisw.backend.domain.persistence.FollowRepository;
import com.example.fortlomisw.backend.domain.persistence.PublicationCommentRepository;
import com.example.fortlomisw.backend.domain.persistence.PublicationRepository;
import com.example.fortlomisw.backend.domain.persistence.UserRepository;
import com.example.fortlomisw.backend.domain.service.PublicationCommentService;
import com.example.fortlomisw.backend.service.PublicationCommentServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class BRInt1 {
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
    @DisplayName("The coment have hate words and dont follow")
    void IsItHateAndDontFollow() {
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
        pcomment.setCommentdescription("publication  description 1");
        pcomment.setRegisterdate(d);

        when(pcommentrepository.save(pcomment)).thenReturn(pcomment);
        when(publicationrepository.findById(id)).thenReturn(Optional.of(publication));
        when(artistrepository.findById(id)).thenReturn(Optional.of(person));
        PublicationComment pcomment1 = pcommentservice.create(id,id,pcomment);

        assertThat(pcomment1).isEqualTo(pcomment);
    }

}
