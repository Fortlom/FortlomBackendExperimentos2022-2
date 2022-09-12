package com.example.fortlomisw.backend.service;

import com.example.fortlomisw.backend.Image.ImageModel;
import com.example.fortlomisw.backend.Image.ImageUtility;
import com.example.fortlomisw.backend.domain.model.entity.Person;
import com.example.fortlomisw.backend.domain.persistence.UserRepository;
import com.example.fortlomisw.backend.domain.service.PersonService;
import com.example.fortlomisw.shared.exception.Message;
import com.example.fortlomisw.shared.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);
    public PersonServiceImpl() {

    }


    @Override
    public Optional<Person> getbyNombreUsuarioOrEmail(String nombreOremail) {
        return userRepository.findByUsernameOrEmail(nombreOremail,nombreOremail);
    }

    @Override
    public void save(Person usuario) {
        userRepository.save(usuario);
    }

    @Override
    public Optional<Person> getByTokenPassword(String tokenPassword) {
        return userRepository.findByTokenpassword(tokenPassword);
    }

    @Override
    public Person getById(Long artistId) {
        return userRepository.findById(artistId)
                .orElseThrow(() -> new ResourceNotFoundException("User", artistId));
    }

    @Override
    public ResponseEntity<Object> updatephoto(Long artistId, MultipartFile file) {



        Optional<Person>value=userRepository.findById(artistId);
        if (value.isPresent()){

            try {
                value.get().setContent(ImageUtility.compressImage(file.getBytes()));
                value.get().setImageprofiletype(file.getContentType());
                userRepository.save(value.get());
                return ResponseEntity.ok().build();
            } catch (IOException e) {
                logger.info("context", e);
                return null;
            }

        }

        return null;
    }

    @Override
    public ResponseEntity<byte[]> getprofileimage(Long userID) throws Message {

        Optional<Person>db=userRepository.findById(userID);
        if(db.isPresent()) {
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.valueOf(db.get().getImageprofiletype()))
                    .body(ImageUtility.decompressImage(db.get().getContent()));
        }
        throw new Message("Error");
    }

    @Override
    public ImageModel getImageDetails(Long MultimediaID) throws Message {
        Optional<Person>db=userRepository.findById(MultimediaID);
        if(db.isPresent()){
            ImageModel imageModel= new ImageModel(db.get().getId(),db.get().getImageprofiletype(),ImageUtility.decompressImage(db.get().getContent()));
            return imageModel;
        }

        throw new Message("Error");

    }

    @Override
    public Person updateprofile(Long userId, Person request) {


        return userRepository.findById(userId).map(user ->{
            user.setRealname(request.getRealname());
            user.setLastname(request.getLastname());
            user.setEmail(request.getEmail());
            userRepository.save(user);
            return user;


        }).orElseThrow(() -> new ResourceNotFoundException("Person", userId));
    }

    @Override
    public Person updatepassword(Long userId, Person request) {
       PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();

        return userRepository.findById(userId).map(user ->{
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            userRepository.save(user);
            return user;


        }).orElseThrow(() -> new ResourceNotFoundException("Person", userId));
    }
}
