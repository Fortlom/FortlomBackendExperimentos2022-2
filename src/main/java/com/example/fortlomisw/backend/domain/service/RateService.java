package com.example.fortlomisw.backend.domain.service;

import com.example.fortlomisw.backend.domain.model.entity.Rate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;


import java.util.List;
public interface RateService {
    List<Rate> getAll();
    Page<Rate> getAll(Pageable pageable);
    Rate getById(Long rateId);
    Rate create(Long fanaticId, Long ArtistId, Rate rate);
    Rate update(Long rateId, Rate request);
    List<Rate> ratesByFanaticId(Long FanaticId);
    List<Rate> ratesByArtistId(Long ArtistId);
    ResponseEntity<?> delete(Long rateId);
}
