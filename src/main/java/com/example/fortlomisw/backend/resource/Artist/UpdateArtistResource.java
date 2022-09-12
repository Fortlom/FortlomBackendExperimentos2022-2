package com.example.fortlomisw.backend.resource.Artist;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateArtistResource {

    private Long artistfollowers;
    private String instagramLink;

    private String facebookLink;

    private String twitterLink;
}
