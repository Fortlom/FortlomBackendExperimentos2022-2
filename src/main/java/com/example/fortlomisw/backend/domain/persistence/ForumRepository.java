package com.example.fortlomisw.backend.domain.persistence;


import com.example.fortlomisw.backend.domain.model.entity.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForumRepository extends JpaRepository<Forum,Long> {
    List<Forum> findByPersonId(Long userId);
    Boolean existsByForumname(String username);
}
