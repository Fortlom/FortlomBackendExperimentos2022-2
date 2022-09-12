package com.example.fortlomisw.backend.domain.service;
import com.example.fortlomisw.backend.domain.model.entity.PublicationComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import java.util.List;


public interface PublicationCommentService {


    List<PublicationComment> getAll();
    Page<PublicationComment> getAll(Pageable pageable);
    PublicationComment getById(Long commentId);
    PublicationComment create(Long userId, Long publicationId, PublicationComment comment);
    PublicationComment update(Long commentId, PublicationComment request);
    List<PublicationComment> getCommentByPublicationId(Long publicationId);
    ResponseEntity<?> delete(Long commentId);




}
