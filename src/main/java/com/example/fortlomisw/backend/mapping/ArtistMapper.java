package com.example.fortlomisw.backend.mapping;

import java.io.Serializable;
import java.util.List;

import com.example.fortlomisw.backend.domain.model.entity.Artist;
import com.example.fortlomisw.backend.resource.Artist.ArtistResource;
import com.example.fortlomisw.backend.resource.Artist.CreateArtistResource;
import com.example.fortlomisw.backend.resource.Artist.UpdateArtistResource;
import com.example.fortlomisw.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;




public class ArtistMapper implements Serializable {




    @Autowired
    EnhancedModelMapper mapper;


    public ArtistResource toResource(Artist model) {
        return mapper.map(model, ArtistResource.class);
    }

    public Page<ArtistResource> modelListToPage(List<Artist> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ArtistResource.class), pageable, modelList.size());
    }
    public Artist toModel(CreateArtistResource resource) {
        return mapper.map(resource, Artist.class);
    }

    public Artist toModel(UpdateArtistResource resource) {
        return mapper.map(resource, Artist.class);
    }













}
