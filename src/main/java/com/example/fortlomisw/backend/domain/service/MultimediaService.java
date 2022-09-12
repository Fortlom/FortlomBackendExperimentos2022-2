package com.example.fortlomisw.backend.domain.service;
import com.example.fortlomisw.backend.Image.ImageModel;
import com.example.fortlomisw.backend.domain.model.entity.Multimedia;
import com.example.fortlomisw.shared.exception.Message;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
public interface MultimediaService {
    List<Multimedia> getAll();
    Page<Multimedia> getAll(Pageable pageable);
    Multimedia getById(Long multimediaId);
    ImageModel getImageDetails(Long MultimediaID) throws Message;
    ResponseEntity<byte[]> getImage(Long MultimediaID) throws Message;
    ResponseEntity<Object> create(Long multimediaId, MultipartFile file) throws IOException;
    ResponseEntity<ByteArrayResource>download(Long filenameId);
    Multimedia update(Long multimediaId, Multimedia request);
    List<ImageModel> getMultimediaByPublicationId(Long multimediaId);
    ResponseEntity<?> delete(Long commentId);
}
