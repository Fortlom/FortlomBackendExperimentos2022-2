package com.example.fortlomisw.backend.unit;

import com.example.fortlomisw.backend.domain.model.entity.Artist;
import com.example.fortlomisw.backend.domain.model.entity.Event;
import com.example.fortlomisw.backend.domain.model.entity.Publication;
import com.example.fortlomisw.backend.domain.persistence.ArtistRepository;
import com.example.fortlomisw.backend.domain.persistence.EventRepository;
import com.example.fortlomisw.backend.domain.persistence.PublicationRepository;
import com.example.fortlomisw.backend.domain.service.EventService;
import com.example.fortlomisw.backend.domain.service.PublicationService;
import com.example.fortlomisw.backend.service.EventServiceImpl;
import com.example.fortlomisw.backend.service.PublicationServiceImpl;
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
public class BRUnit2 {

    @MockBean
    private ArtistRepository artistRepository;

    @MockBean
    private EventRepository eventRepository;

    @Autowired
    private EventService eventService;



    @TestConfiguration
    static class EventServiceTestConfiguration {
        @Bean
        public EventService eventService() {
            return new EventServiceImpl();
        }
    }


    @Test
    @DisplayName("Publication date is outdated")
   public void isOutdatedPublication() {
        long id=1;
        Artist artist=new Artist();
        artist.setId(id);
        artist.setUsername("sap");
        artist.setRealname("jose");
        artist.setLastname("wrssa");
        artist.setEmail("wes@gmail.com");
        artist.setPassword("nueva");
        artist.setArtistfollowers((long)0);
        Event event=new Event();
        event.setId(id);
        event.setEventname("sap");
        event.setEventeescription("jose");
        event.setEventlikes((long)0);
        event.setArtist(artist);
        Random rand = new Random();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd ");
        Calendar cal = Calendar.getInstance();
        cal.set(2000, 0, 1);
        long start = cal.getTimeInMillis();
        cal.set(2012, 10, 1);
        long end = cal.getTimeInMillis();
        Date d = new Date(start + (long) (rand.nextDouble() * (end - start)));
        event.setRegisterdate(d);
        //when(eventService.createEvent(id,event));
        assertThat(eventService.isOutdated(event.getRegisterdate())).isTrue();
    }

}
