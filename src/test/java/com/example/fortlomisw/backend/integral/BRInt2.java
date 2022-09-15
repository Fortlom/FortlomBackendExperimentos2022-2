package com.example.fortlomisw.backend.integral;

import com.example.fortlomisw.backend.domain.model.entity.*;
import com.example.fortlomisw.backend.domain.persistence.*;
import com.example.fortlomisw.backend.domain.service.RateService;
import com.example.fortlomisw.backend.domain.service.ReportService;
import com.example.fortlomisw.backend.service.RateServiceImpl;
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
public class BRInt2 {
    @MockBean
    private RateRepository raterepository;
    @MockBean
    private FanaticRepository fanaticrepository;
    @MockBean
    private ArtistRepository artistrepository;
    @MockBean
    private FollowRepository followRepository;
    @MockBean
    private ReportRepository reportRepository;
    @Autowired
    private RateService rateservice;
    @MockBean
    private UserRepository personrepository;
    @TestConfiguration
    static class RateServiceTestConfiguration {
        @Bean
        public RateService rateService() {
            return new RateServiceImpl();
        }
    }
    @Test
    @DisplayName("User is considered Hater and want to give low rate")
    void UserIsHaterAndGiveLowRate() {
        long id=1;
        Artist artist=new Artist();
        artist.setId(id);
        artist.setUsername("sap");
        artist.setRealname("jose");
        artist.setLastname("wrssa");
        artist.setEmail("wes@gmail.com");
        artist.setPassword("nueva");
        artist.setArtistfollowers((long)0);

        Fanatic fanatic =new Fanatic();
        fanatic.setId(id);
        fanatic.setUsername("sap");
        fanatic.setRealname("jose");
        fanatic.setLastname("wrssa");
        fanatic.setEmail("wes@gmail.com");
        fanatic.setPassword("nueva");
        fanatic.setFanaticalias("alias 1");

        byte[] bytes = "hello world".getBytes();
        Person person =new Person();
        person.setId(id);
        person.setUsername("Person 1");
        person.setRealname("Real name 1");
        person.setLastname("Lastname 1");
        person.setEmail("email 1");
        person.setPassword("12345");
        person.setContent(bytes);
        person.setImageprofiletype("Type 1");
        person.setTokenpassword("token 1");

        Person person2 =new Person();
        person.setId((long)2);
        person.setUsername("Person 2");
        person.setRealname("Real name 2");
        person.setLastname("Lastname 2");
        person.setEmail("email 2");
        person.setPassword("123456");
        person.setContent(bytes);
        person.setImageprofiletype("Type 2");
        person.setTokenpassword("token 2");

        Rate rate =new Rate();
        rate.setId(id);
        rate.setRates(1);
        rate.setArtist(artist);
        rate.setFanatic(fanatic);

        Report report =new Report();
        report.setId(id);
        report.setReportDescription("Report description 1");
        report.setUserMain(person);
        report.setUserReported(person2);

        Report report2 =new Report();
        report2.setId(id);
        report2.setReportDescription("Report description 1");
        report2.setUserMain(person);
        report2.setUserReported(person2);

        Report report3 =new Report();
        report3.setId(id);
        report3.setReportDescription("Report description 1");
        report3.setUserMain(person);
        report3.setUserReported(person2);

        when(reportRepository.save(report)).thenReturn(report);
        when(personrepository.save(person)).thenReturn(person);
        when(personrepository.save(person2)).thenReturn(person2);
        when(raterepository.findById(id)).thenReturn(Optional.of(rate));
        when(fanaticrepository.findById(id)).thenReturn(Optional.of(fanatic));
        when(artistrepository.findById(id)).thenReturn(Optional.of(artist));
        Rate rate1 = rateservice.getById(id);
        assertThat(rate1).isEqualTo(rate);
    }
}
