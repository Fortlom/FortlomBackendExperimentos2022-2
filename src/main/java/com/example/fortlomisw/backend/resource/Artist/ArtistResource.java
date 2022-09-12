package com.example.fortlomisw.backend.resource.Artist;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ArtistResource {

    private Long id;

    private String username;

    private String realname;

    private String lastname;

    private String email;

    private String password;

    private byte[] content;

    private Long artistfollowers;

    private String instagramLink;

    private String facebookLink;

    private String twitterLink;
}
