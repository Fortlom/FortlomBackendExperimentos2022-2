package com.example.fortlomisw.backend.domain.service;

import com.example.fortlomisw.backend.domain.model.entity.Report;
import com.example.fortlomisw.backend.domain.model.entity.Person;
import com.example.fortlomisw.backend.domain.model.enumeration.RolNombre;
import com.example.fortlomisw.backend.domain.persistence.ReportRepository;
import com.example.fortlomisw.backend.domain.persistence.RolRepository;
import com.example.fortlomisw.backend.domain.persistence.UserRepository;
import com.example.fortlomisw.backend.service.ReportServiceImpl;
import com.example.fortlomisw.backend.service.RolServiceImpl;
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
class ReportServiceTest {

    @MockBean
    private ReportRepository reportrepository;

    @MockBean
    private UserRepository personrepository;

    @Autowired
    private ReportService reportservice;

    @TestConfiguration
    static class ReportServiceTestConfiguration {
        @Bean
        public ReportService reportService() { return new ReportServiceImpl(); }
    }

    @Test
    void getAll() {
        long id=1;
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

        Report report =new Report();
        report.setId(id);
        report.setReportDescription("Report description 1");
        report.setUserMain(person);
        report.setUserReported(person2);
        List<Report> reportList= new ArrayList<>();
        reportList.add(report);

        when(reportrepository.findAll()).thenReturn(reportList);
        List<Report> reports = reportservice.getAll();
        assertThat(reports).isEqualTo(reportList);
    }

    @Test
    void getById() {
        long id=1;
        Report report =new Report();
        report.setId(id);
        report.setReportDescription("Report description 1");
        when(reportrepository.findById(id)).thenReturn(Optional.of(report));
        Report report1 = reportservice.getById(id);
        assertThat(report1).isEqualTo(report);
    }

    @Test
    void create() {
        long id=1;
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

        Report report =new Report();
        report.setId(id);
        report.setReportDescription("Report description 1");
        report.setUserMain(person);
        report.setUserReported(person2);

        when(reportrepository.save(report)).thenReturn(report);
        when(personrepository.save(person)).thenReturn(person);
        when(personrepository.save(person2)).thenReturn(person2);
        when(personrepository.findById(person2.getId())).thenReturn(Optional.of(person2));
        when(personrepository.findById(id)).thenReturn(Optional.of(person));
        Report result = reportservice.create(id,id,report);
        assertThat(result).isEqualTo(report);

    }

    @Test
    void update() {
        long id=1;
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

        Report reportupdate =new Report();
        reportupdate.setId(id);
        reportupdate.setReportDescription("Report description 1");
        reportupdate.setUserMain(person);
        reportupdate.setUserReported(person2);

        Report reportold =new Report();
        reportold.setId(id);
        reportold.setReportDescription("Report description 2");
        reportold.setUserMain(person);
        reportold.setUserReported(person2);

        when(reportrepository.findById(id)).thenReturn(Optional.of(reportold));
        when(reportrepository.save(reportupdate)).thenReturn(reportupdate);
        Report report = reportrepository.save(reportupdate);

        assertThat(report).isEqualTo(reportupdate);
    }

    @Test
    void findByUserMainId() {
        long id=1;
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

        Report report =new Report();
        report.setId(id);
        report.setReportDescription("Report description 1");
        report.setUserMain(person);
        report.setUserReported(person2);

        List<Report> testreport = new ArrayList<>();
        testreport.add(report);


        when(personrepository.findById(person.getId())).thenReturn(Optional.of(person));
        when(reportrepository.findByUserMainId(person.getId())).thenReturn(testreport);
        List<Report> reports = reportservice.findByUserMainId(person.getId());
        assertThat(reports).isEqualTo(testreport);
    }

    @Test
    void findByUserReportedId() {
        long id=1;
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

        Report report =new Report();
        report.setId(id);
        report.setReportDescription("Report description 1");
        report.setUserMain(person);
        report.setUserReported(person2);

        List<Report> testreport = new ArrayList<>();
        testreport.add(report);


        when(personrepository.findById(person2.getId())).thenReturn(Optional.of(person2));
        when(reportrepository.findByUserReportedId(person2.getId())).thenReturn(testreport);
        List<Report> reports = reportservice.findByUserReportedId(person2.getId());
        assertThat(reports).isEqualTo(testreport);
    }

    @Test
    void delete() {
        long id = 1;
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

        Report report =new Report();
        report.setId(id);
        report.setReportDescription("Report description 2");
        report.setUserMain(person);
        report.setUserReported(person2);

        when(reportrepository.findById(id)).thenReturn(Optional.of(report));

        ResponseEntity<?> result = reportservice.delete(id);

        assertThat(result).isEqualTo(ResponseEntity.ok().build());
    }
}