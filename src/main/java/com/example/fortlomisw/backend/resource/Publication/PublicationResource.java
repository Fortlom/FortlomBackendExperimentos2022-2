package com.example.fortlomisw.backend.resource.Publication;

import com.example.fortlomisw.backend.resource.Artist.ArtistResource;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class PublicationResource {
    private Long id;
    private String publicationName;
    private String publicationDescription;
    private Long likes;
    private Date date;
    private ArtistResource artist;
}
