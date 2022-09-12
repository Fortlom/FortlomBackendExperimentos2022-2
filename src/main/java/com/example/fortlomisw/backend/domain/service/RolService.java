package com.example.fortlomisw.backend.domain.service;

import com.example.fortlomisw.backend.domain.model.entity.Rol;
import com.example.fortlomisw.backend.domain.model.enumeration.RolNombre;

import java.util.List;
import java.util.Optional;

public interface RolService {
    Optional<Rol> findByName(RolNombre name);

    void seed();

    List<Rol> getAll();
}
