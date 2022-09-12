package com.example.fortlomisw.backend.domain.service;
import com.example.fortlomisw.backend.domain.model.entity.Follow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface FollowService {

    List<Follow> getAll();
    Page<Follow> getAll(Pageable pageable);
    Follow getById(Long followId);
    Follow create(Long fanaticId, Long ArtistId, Follow follow);
    List<Follow> followsByFanaticId(Long FanaticId);
    List<Follow> followsByArtistId(Long ArtistId);
    ResponseEntity<?> delete(Long followId);


}
