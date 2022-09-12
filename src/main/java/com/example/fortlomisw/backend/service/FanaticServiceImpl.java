package com.example.fortlomisw.backend.service;

import com.example.fortlomisw.backend.domain.model.entity.Fanatic;
import com.example.fortlomisw.backend.domain.persistence.FanaticRepository;
import com.example.fortlomisw.backend.domain.service.FanaticService;
import com.example.fortlomisw.shared.exception.ResourceNotFoundException;
import com.example.fortlomisw.shared.exception.ResourcePerzonalized;
import com.example.fortlomisw.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class FanaticServiceImpl implements FanaticService {



    private static final String ENTITY = "Artist";

    @Autowired
    private  FanaticRepository fanaticRepository;



    public FanaticServiceImpl() {

    }


    @Override
    public List<Fanatic> getAll() {
        return fanaticRepository.findAll();
    }

    @Override
    public Page<Fanatic> getAll(Pageable pageable) {
        return fanaticRepository.findAll(pageable);
    }

    @Override
    public Fanatic getById(Long fanaticId) {
        return fanaticRepository.findById(fanaticId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, fanaticId));
    }

    @Override
    public Fanatic update(Long artistId, Fanatic request) {



        return fanaticRepository.findById(artistId).map(dueño ->
                fanaticRepository.save(
                        dueño.withFanaticalias(request.getFanaticalias())

                )
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, artistId));
    }

    @Override
    public ResponseEntity<?> delete(Long artistId) {
        return fanaticRepository.findById(artistId).map(post -> {
            fanaticRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, artistId));
    }

    @Override
    public boolean existsByNombreUsuario(String nombreUsuario) {
        return fanaticRepository.existsByUsername(nombreUsuario);
    }

    @Override
    public boolean existsByEmail(String email) {
        return fanaticRepository.existsByEmail(email);
    }

    @Override
    public void save(Fanatic artist) {
           fanaticRepository.save(artist);
    }

    @Override
    public Fanatic getbyNombreUsuario(String nombreUsuario) {
        return fanaticRepository.findByUsername(nombreUsuario)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, (long)1));
    }

    @Override
    public Optional<Fanatic> getbyNombreUsuarioOrEmail(String nombreOremail) {
        return fanaticRepository.findByUsernameOrEmail(nombreOremail,nombreOremail);
    }

    @Override
    public Fanatic create(Fanatic artist) {

        if(fanaticRepository.existsByUsername(artist.getUsername()))
            throw  new ResourcePerzonalized("ya exsite este nombre de usuario");
        if (fanaticRepository.existsByEmail(artist.getEmail()))
            throw  new ResourcePerzonalized("ya exsite este correo electronico");

        return fanaticRepository.save(artist);
    }
}
