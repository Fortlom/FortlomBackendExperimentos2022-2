package com.example.fortlomisw.backend.service;

import com.example.fortlomisw.backend.Image.ImageModel;
import com.example.fortlomisw.backend.Image.ImageUtility;
import com.example.fortlomisw.backend.domain.model.entity.Multimedia;
import com.example.fortlomisw.backend.domain.model.entity.Publication;
import com.example.fortlomisw.backend.domain.persistence.MultimediaRepository;
import com.example.fortlomisw.backend.domain.persistence.PublicationRepository;
import com.example.fortlomisw.backend.domain.service.MultimediaService;
import com.example.fortlomisw.backend.security.service.EmailService;
import com.example.fortlomisw.shared.exception.Message;
import com.example.fortlomisw.shared.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class MultimediaServiceImpl implements MultimediaService {



    private static final Logger logger = LoggerFactory.getLogger(MultimediaServiceImpl.class);


    private static final String ENTITY = "Multimedia";
    @Autowired
    private MultimediaRepository multimediaRepository;
    @Autowired
    private PublicationRepository publicationRepository;


    public MultimediaServiceImpl() {

    }




    @Override
    public List<Multimedia> getAll() {
        return multimediaRepository.findAll();
    }

    @Override
    public Page<Multimedia> getAll(Pageable pageable) {
        return multimediaRepository.findAll(pageable);
    }

    @Override
    public Multimedia getById(Long multimediaId) {
        return multimediaRepository.findById(multimediaId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, multimediaId));
    }

    @Override
    public ImageModel getImageDetails(Long MultimediaID) throws Message {
        Optional<Multimedia>dbImage=multimediaRepository.findById(MultimediaID);
        if(dbImage.isPresent()){
            ImageModel imageModel= new ImageModel(dbImage.get().getId(),dbImage.get().getType(),ImageUtility.decompressImage(dbImage.get().getContent()));
            return imageModel;

        }
        throw new Message("Error");
    }

    @Override
    public ResponseEntity<byte[]> getImage(Long MultimediaID) throws Message {
        Optional<Multimedia>dbImage=multimediaRepository.findById(MultimediaID);
        if(dbImage.isPresent()){

            return ResponseEntity
                    .ok()
                    .contentType(MediaType.valueOf(dbImage.get().getType()))
                    .body(ImageUtility.decompressImage(dbImage.get().getContent()));
        }
        throw new Message("Error");


    }

    @Override
    public ResponseEntity<Object> create(Long publicationId, MultipartFile file)  {


        Optional<Publication>value=publicationRepository.findById(publicationId);
        if (value.isPresent()){
            Multimedia request = new Multimedia();
            request.setType(file.getContentType());

            try {
                request.setContent(ImageUtility.compressImage(file.getBytes()));
            } catch (IOException e) {
                logger.info("context", e);
            }
            request.setPublication(value.get());
            multimediaRepository.save(request);
            return ResponseEntity.ok().build();
        }




        return null;
    }

    @Override
    public ResponseEntity<ByteArrayResource> download(Long filenameId) {
        Multimedia multimedia=getById(filenameId);
        multimedia.setContent(ImageUtility.decompressImage(multimedia.getContent()));
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(multimedia.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+multimedia.getId()+"\"")
                .body(new ByteArrayResource(multimedia.getContent()));
    }


    @Override
    public Multimedia update(Long multimediaId, Multimedia request) {
        return null;
    }

    @Override
    public List<ImageModel> getMultimediaByPublicationId(Long multimediaId) {
        List<Multimedia> multimedias=multimediaRepository.findByPublicationId(multimediaId);
        List<ImageModel>imageModels = new ArrayList<>() ;
        for (int i=0;i<multimedias.size();i++){
            Multimedia multimedia=multimedias.get(i);
            ImageModel imageModel= new ImageModel(multimedia.getId(),multimedia.getType(),ImageUtility.decompressImage(multimedia.getContent()));
            imageModels.add(imageModel);
        }
        return imageModels;
    }

    @Override
    public ResponseEntity<?> delete(Long multimediaId) {
        return multimediaRepository.findById(multimediaId).map(post -> {
            multimediaRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, multimediaId));
    }
}
