package com.example.fortlomisw.backend.security.Dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailValues {

    private String mailFrom;
    private String mailTo;
    private String subject;
    private String userName;
    private String tokenPassword;


    public EmailValues(){}

    public EmailValues(String mailFrom, String mailTo, String subject, String userName, String tokenPassword) {
        this.mailFrom = mailFrom;
        this.mailTo = mailTo;
        this.subject = subject;
        this.userName = userName;
        this.tokenPassword = tokenPassword;
    }



}
