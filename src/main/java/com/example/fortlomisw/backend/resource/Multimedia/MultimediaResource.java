package com.example.fortlomisw.backend.resource.Multimedia;

import com.example.fortlomisw.backend.resource.Publication.PublicationResource;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MultimediaResource {

    private Long id;
    private byte[] content;
    private PublicationResource publication;
}
