package com.example.fortlomisw.backend.resource.Rate;


import com.example.fortlomisw.backend.resource.Artist.ArtistResource;
import com.example.fortlomisw.backend.resource.Fanatic.FanaticResource;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RateResource {
    private Long id;
    private Long rates;
    private ArtistResource artist;
    private FanaticResource fanatic;
}
