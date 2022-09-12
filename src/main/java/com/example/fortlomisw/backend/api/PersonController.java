package com.example.fortlomisw.backend.api;


import com.example.fortlomisw.backend.Image.ImageModel;
import com.example.fortlomisw.backend.domain.service.PersonService;
import com.example.fortlomisw.backend.mapping.MultimediaMapper;
import com.example.fortlomisw.backend.mapping.PersonMapper;
import com.example.fortlomisw.backend.resource.Multimedia.MultimediaResource;
import com.example.fortlomisw.backend.resource.Person.PersonResource;
import com.example.fortlomisw.backend.resource.Person.UpdatePersonResource;
import com.example.fortlomisw.shared.exception.Message;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

    @Autowired
    PersonService personService;


    @Autowired
    private PersonMapper mapper;
    @ApiOperation(value="getUserById",notes = "Esta consulta nos retorna un usuario segun su id")
    @GetMapping("/users/{userID}")
    public PersonResource getUserById(@PathVariable("userID") Long userID) {
        return mapper.toResource(personService.getById(userID));
    }
    @ApiOperation(value="updatePhoto",notes = "Esta consulta nos actualiza la foto del usuario segun el id de este")
    @PutMapping("/users/{userID}/updatephoto")
    public void updatePhoto( @PathVariable Long userID,@RequestParam("file") MultipartFile file) throws IOException {
        personService.updatephoto(userID,file);
    }
    @ApiOperation(value="updateprofile",notes = "Esta consulta nos actualiza la informacion del perfil del usuario segun el id de este")
    @PutMapping("/users/changeprofile/{userId}")
    public PersonResource updateprofile(@PathVariable Long userId, @RequestBody UpdatePersonResource request) {
        return mapper.toResource(personService.updateprofile(userId, mapper.toModel(request)));
    }
    @ApiOperation(value="updatepassword",notes = "Esta consulta nos actualiza la contraseña del usuario segun el id de este")
    @PutMapping("/users/changepassword/{userId}")
    public PersonResource updatepassword(@PathVariable Long userId, @RequestBody UpdatePersonResource request) {
        return mapper.toResource(personService.updatepassword(userId, mapper.toModel(request)));
    }

    @ApiOperation(value="getImage",notes = "Esta consulta nos retorna la imagen del usuario segun el id de este")
    @GetMapping("/users/onlyimage/{userID}")
    public ResponseEntity<byte[]> getImage (@PathVariable("userID") Long userID) throws Message {
        return  personService.getprofileimage(userID);
    }
    @ApiOperation(value="getImagecontent",notes = "Esta consulta nos retorna los detalles de la imagen del usuario segun el id de este")
    @GetMapping("/users/image/{userID}")
    public ImageModel getImagecontent (@PathVariable("userID") Long userID) throws IOException, Message {
        return  personService.getImageDetails(userID);
    }



}
