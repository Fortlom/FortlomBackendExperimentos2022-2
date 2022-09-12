package com.example.fortlomisw.backend.domain.service;

import com.example.fortlomisw.backend.domain.model.entity.Artist;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ArtistService {
    List<Artist> getAll();
    Page<Artist> getAll(Pageable pageable);
    Artist getById(Long artistId);
    Artist update(Long artistId, Artist request);
    ResponseEntity<?> delete(Long artistId);
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);
    void save(Artist artist);
    Artist getbyNombreUsuario(String nombreUsuario);
    Artist setInstagramAccount(Long artistId,Artist request);
    Artist setFacebookAccount(Long artistId,Artist request);
    Artist setTwitterAccount(Long artistId,Artist request);
    Optional<Artist>getbyNombreUsuarioOrEmail(String nombreOremail);
    Artist create(Artist artist);



}
