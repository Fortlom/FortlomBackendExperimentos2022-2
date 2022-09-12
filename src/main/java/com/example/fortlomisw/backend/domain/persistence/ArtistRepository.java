package com.example.fortlomisw.backend.domain.persistence;


import com.example.fortlomisw.backend.domain.model.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist,Long> {

    Optional<Artist> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String Usermail);

    Optional<Artist> findByUsernameOrEmail(String username,String email);



}
