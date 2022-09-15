package com.example.fortlomisw.backend.domain.service;

import com.example.fortlomisw.backend.domain.model.entity.Artist;
import com.example.fortlomisw.backend.domain.model.entity.Event;
import com.example.fortlomisw.backend.domain.persistence.ArtistRepository;
import com.example.fortlomisw.backend.domain.persistence.EventRepository;
import com.example.fortlomisw.backend.service.ArtistServiceImpl;
import com.example.fortlomisw.backend.service.EventServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
class EventServiceTest {


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
    void getAllEvents() {





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
        event.setEventname("jose");
        event.setEventlikes((long)0);
        event.setArtist(artist);
        List<Event> eventList= new ArrayList<>();
        eventList.add(event);

        when(eventRepository.findAll()).thenReturn(eventList);
        List<Event>events=eventService.getAllEvents();
        assertThat(events).isEqualTo(eventList);
    }

    @Test
    void getEventById() {
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
        when(eventRepository.findById(id)).thenReturn(Optional.of(event));
        Event found=eventService.getEventById(id);
        assertThat(found.getId()).isEqualTo(id);
    }

    @Test
    void createEvent() {
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
        when(artistRepository.findById(id)).thenReturn(Optional.of(artist));
        when(eventRepository.save(event)).thenReturn(event);
        Event save=eventService.createEvent(id,event);

      assertThat(save).isEqualTo(event);
       // assertThat(eventService.isOutdated(event.getRegisterdate())).isTrue();
    }

    @Test
    void updateEvent() {

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
        Event updateevent=new Event();
        updateevent.setId(id);
        updateevent.setEventeescription("description");
        updateevent.setEventname("jose");
        updateevent.setEventlikes((long)0);
        updateevent.setArtist(artist);

        when(eventRepository.findById(id)).thenReturn(Optional.of(event));
        when(eventRepository.save(updateevent)).thenReturn(updateevent);
        Event found=eventRepository.save(updateevent);
        assertThat(found).isEqualTo(updateevent);


    }

    @Test
    void getEventsByArtistId() {
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
        event.setEventname("jose");
        event.setEventlikes((long)0);
        event.setArtist(artist);
        List<Event> eventList= new ArrayList<>();
        eventList.add(event);
        when(artistRepository.findById(id)).thenReturn(Optional.of(artist));
        when(eventRepository.findByArtistId(id)).thenReturn(eventList);
        List<Event>events=eventService.getEventsByArtistId(id);
        assertThat(events).isEqualTo(eventList);
    }

    @Test
    void deleteEvent() {
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
        when(eventRepository.findById(id)).thenReturn(Optional.of(event));

        // ACt
        ResponseEntity<?> result = eventService.deleteEvent(id);

        // Assert
        assertThat(result).isEqualTo(ResponseEntity.ok().build());
    }
}