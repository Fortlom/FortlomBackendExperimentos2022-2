package com.example.fortlomisw.backend.service;

import com.example.fortlomisw.backend.domain.model.entity.Rol;
import com.example.fortlomisw.backend.domain.model.enumeration.RolNombre;
import com.example.fortlomisw.backend.domain.persistence.RolRepository;
import com.example.fortlomisw.backend.domain.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    RolRepository rolRepository;

    private static String[] DEFAULT_ROLES = {"Role_Fanatic","Role_Artist"};

    public RolServiceImpl(){

    }

    @Override
    public Optional<Rol> findByName(RolNombre name) {
        return rolRepository.findByName(name);
    }

    @Override
    public void seed() {
        Arrays.stream(DEFAULT_ROLES).forEach(name -> {
            RolNombre roleName = RolNombre.valueOf(name);
            if(!rolRepository.existsByName(roleName)) {
                rolRepository.save((new Rol()).withName(roleName));
            }
        } );
    }

    @Override
    public List<Rol> getAll() {
        return rolRepository.findAll();
    }
}
