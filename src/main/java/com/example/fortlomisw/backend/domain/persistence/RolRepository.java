package com.example.fortlomisw.backend.domain.persistence;
import com.example.fortlomisw.backend.domain.model.entity.Rol;
import com.example.fortlomisw.backend.domain.model.enumeration.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RolRepository extends JpaRepository<Rol,Long>{
    Optional<Rol> findByName(RolNombre name);
    boolean existsByName(RolNombre name);
}
