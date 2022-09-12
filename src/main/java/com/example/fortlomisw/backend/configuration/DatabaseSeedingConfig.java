package com.example.fortlomisw.backend.configuration;


import com.example.fortlomisw.backend.domain.service.EventService;
import com.example.fortlomisw.backend.domain.service.ForumService;
import com.example.fortlomisw.backend.domain.service.PublicationService;
import com.example.fortlomisw.backend.domain.service.RolService;
import com.example.fortlomisw.backend.security.service.AuthService;
import com.example.fortlomisw.shared.exception.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class DatabaseSeedingConfig {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseSeedingConfig.class);

    @Autowired
    RolService rolService;

    @Autowired
    AuthService authService;

    @Autowired
    ForumService forumService;

    @Autowired
    PublicationService publicationService;

    @Autowired
    EventService eventService;

    @EventListener
    public void onApplicationReady(ApplicationReadyEvent event) throws Message {
        String name = event.getApplicationContext().getId();
        logger.info("Starting Database Seeding Process for {} at {}", name, new Timestamp(System.currentTimeMillis()));
        rolService.seed();
        authService.seed();
        forumService.seed();
        publicationService.seed();
        eventService.seed();
        logger.info("Finished Database Seeding Process for {} at {}", name, new Timestamp(System.currentTimeMillis()));



    }

}
