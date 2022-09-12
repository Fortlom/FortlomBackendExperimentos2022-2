package com.example.fortlomisw.backend.domain.service;

import com.example.fortlomisw.backend.domain.model.entity.Fanatic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface FanaticService {
    List<Fanatic> getAll();
    Page<Fanatic> getAll(Pageable pageable);
    Fanatic getById(Long artistId);
    Fanatic update(Long artistId, Fanatic request);
    ResponseEntity<?> delete(Long artistId);
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);
    void save(Fanatic artist);
    Fanatic getbyNombreUsuario(String nombreUsuario);
    Optional<Fanatic>getbyNombreUsuarioOrEmail(String nombreOremail);
    Fanatic create(Fanatic artist);
}
