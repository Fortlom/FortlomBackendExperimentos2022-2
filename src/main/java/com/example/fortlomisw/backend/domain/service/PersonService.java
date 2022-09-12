package com.example.fortlomisw.backend.domain.service;

import com.example.fortlomisw.backend.Image.ImageModel;
import com.example.fortlomisw.backend.domain.model.entity.Person;
import com.example.fortlomisw.shared.exception.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

public interface PersonService {

    Optional<Person> getbyNombreUsuarioOrEmail(String nombreOremail);

    void save(Person usuario);

    Optional<Person> getByTokenPassword(String tokenPassword);

    Person getById(Long artistId);

   ResponseEntity<Object> updatephoto(Long artistId, MultipartFile file) throws IOException;

   ResponseEntity<byte[]> getprofileimage(Long userID) throws Message;

    ImageModel getImageDetails(Long MultimediaID) throws Message;

    Person updateprofile(Long userId, Person request);

    Person updatepassword(Long userId, Person request);
}
