package com.example.fortlomisw.backend.service;

import com.example.fortlomisw.backend.domain.model.entity.Artist;
import com.example.fortlomisw.backend.domain.model.entity.Person;
import com.example.fortlomisw.backend.domain.model.entity.PublicationComment;
import com.example.fortlomisw.backend.domain.persistence.ArtistRepository;
import com.example.fortlomisw.backend.domain.persistence.PublicationCommentRepository;
import com.example.fortlomisw.backend.domain.persistence.PublicationRepository;
import com.example.fortlomisw.backend.domain.persistence.UserRepository;
import com.example.fortlomisw.backend.domain.service.PublicationCommentService;
import com.example.fortlomisw.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import javax.validation.Validator;
@Service
public class PublicationCommentServiceImpl implements PublicationCommentService {


    private static final String ENTITY = "Comment";
    @Autowired
    private  PublicationCommentRepository publicationCommentRepository;
    @Autowired
    private  UserRepository artistRepository;
    @Autowired
    private  PublicationRepository publicationRepository;

    public PublicationCommentServiceImpl() {

    }


    @Override
    public List<PublicationComment> getAll() {
        return publicationCommentRepository.findAll();
    }

    @Override
    public Page<PublicationComment> getAll(Pageable pageable) {
        return publicationCommentRepository.findAll(pageable);
    }

    @Override
    public PublicationComment getById(Long commentId) {
        return publicationCommentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentId));
    }

    @Override
    public PublicationComment create(Long userId, Long publicationId, PublicationComment request) {
        Person user = artistRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", userId));
        Date date = new Date();
        return publicationRepository.findById(publicationId)
                .map(publications -> {
                    request.setPublication(publications);
                    request.setPerson(user);
                    request.setRegisterdate(date);
                    return publicationCommentRepository.save(request);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Publication", publicationId));
    }

    @Override
    public PublicationComment update(Long commentId, PublicationComment request) {





        return null;
    }

    @Override
    public List<PublicationComment> getCommentByPublicationId(Long publicationId) {
        return publicationCommentRepository.findByPublicationId(publicationId);
    }

    @Override
    public ResponseEntity<?> delete(Long commentId) {
        return publicationCommentRepository.findById(commentId).map(post -> {
            publicationCommentRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentId));
    }
}
