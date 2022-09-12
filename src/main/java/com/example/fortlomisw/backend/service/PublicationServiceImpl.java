package com.example.fortlomisw.backend.service;

import com.example.fortlomisw.backend.domain.model.entity.Publication;
import com.example.fortlomisw.backend.domain.persistence.ArtistRepository;
import com.example.fortlomisw.backend.domain.persistence.PublicationRepository;
import com.example.fortlomisw.backend.domain.service.PublicationService;
import com.example.fortlomisw.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.validation.Validator;
import java.util.Date;
import java.util.List;


@Service
public class PublicationServiceImpl implements PublicationService {



    private static final String ENTITY = "Publication";
    private static final String ENTITY2 = "Artist";

    @Autowired
    private  PublicationRepository publicationRepository;
    @Autowired
    private  ArtistRepository artistRepository;


    public PublicationServiceImpl() {

    }


    @Override
    public List<Publication> getAll() {
        return publicationRepository.findAll();
    }

    @Override
    public Page<Publication> getAll(Pageable pageable) {
        return publicationRepository.findAll(pageable);
    }

    @Override
    public Publication getById(Long publicationId) {
        return publicationRepository.findById(publicationId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, publicationId));
    }

    @Override
    public Publication create(Long artistId, Publication request) {
        Date date = new Date();
        return artistRepository.findById(artistId)
                .map(artists -> {
                    request.setArtist(artists);
                    request.setRegisterdate(date);
                    return publicationRepository.save(request);
                })
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY2, artistId));
    }

    @Override
    public Publication update(Long publicationId, Publication request) {

        return publicationRepository.findById(publicationId).map(post->{

            post.setLikes(request.getLikes());
            publicationRepository.save(post);
            return post;

        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, publicationId));




    }

    @Override
    public List<Publication> getPublicationByArtistId(Long artistId) {
        return publicationRepository.findByArtistId(artistId);
    }

    @Override
    public ResponseEntity<?> delete(Long publicationId) {
        return publicationRepository.findById(publicationId).map(post -> {
            publicationRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, publicationId));
    }

    @Override
    public void seed() {
        Publication request=new Publication();
        request.setPublicationname("publictestanalisis");
        request.setPublicationdescription("for tests");
        request.setLikes((long)0);
        if(!publicationRepository.existsByPublicationname(request.getPublicationname())){

            create((long)2,request);
        }

    }
}
