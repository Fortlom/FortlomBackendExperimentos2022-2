package com.example.fortlomisw.backend.domain.persistence;

import com.example.fortlomisw.backend.domain.model.entity.ForumComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForumCommentRepository extends JpaRepository<ForumComment,Long> {
    List<ForumComment> findByForumId(Long forumId);
    List<ForumComment> findByPersonId (Long UserId);
}
