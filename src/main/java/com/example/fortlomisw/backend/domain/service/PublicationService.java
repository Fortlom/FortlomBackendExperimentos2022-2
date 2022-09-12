package com.example.fortlomisw.backend.domain.service;
import com.example.fortlomisw.backend.domain.model.entity.Publication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.http.ResponseEntity;
import java.util.List;
public interface PublicationService {

    List<Publication> getAll();
    Page<Publication> getAll(Pageable pageable);
    Publication getById(Long publicationId);
    Publication create(Long artistId, Publication publication);
    Publication update(Long publicationId, Publication request);

    List<Publication> getPublicationByArtistId(Long artistId);
    ResponseEntity<?> delete(Long publicationId);
   void seed();

}
