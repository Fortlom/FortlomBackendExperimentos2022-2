package com.example.fortlomisw.backend.domain.persistence;


import com.example.fortlomisw.backend.domain.model.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
    List<Event> findByArtistId(Long artistId);
    Boolean existsByEventname(String username);
}
