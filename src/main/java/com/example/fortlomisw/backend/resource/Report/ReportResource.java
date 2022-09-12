package com.example.fortlomisw.backend.resource.Report;

import com.example.fortlomisw.backend.resource.Person.PersonResource;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReportResource {
    private Long id;

    private String reportDescription;

    private PersonResource userMain;


    private PersonResource userReported;

}
