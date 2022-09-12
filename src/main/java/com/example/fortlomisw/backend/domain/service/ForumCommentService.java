package com.example.fortlomisw.backend.domain.service;
import com.example.fortlomisw.backend.domain.model.entity.ForumComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;


import java.util.List;
public interface ForumCommentService {
    List<ForumComment> getAll();
    Page<ForumComment> getAll(Pageable pageable);
    ForumComment getById(Long forumcommentId);
    ForumComment create(Long userId, Long forumId, ForumComment forumcomment);
    ForumComment update(Long forumcommentId, ForumComment request);
    List<ForumComment> getForumCommentByForumId(Long forumId);
    ResponseEntity<?> delete(Long forumcommentId);
}
