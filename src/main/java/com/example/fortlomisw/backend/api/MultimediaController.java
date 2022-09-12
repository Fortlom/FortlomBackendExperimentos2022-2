package com.example.fortlomisw.backend.api;
import com.example.fortlomisw.backend.Image.ImageModel;
import com.example.fortlomisw.backend.domain.model.entity.Multimedia;
import com.example.fortlomisw.backend.domain.service.MultimediaService;
import com.example.fortlomisw.backend.mapping.MultimediaMapper;
import com.example.fortlomisw.backend.resource.Multimedia.CreateMultimediaResource;
import com.example.fortlomisw.backend.resource.Multimedia.MultimediaResource;
import com.example.fortlomisw.backend.resource.Multimedia.UpdateMultimediaResource;
import com.example.fortlomisw.shared.exception.Message;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity.BodyBuilder;

@RestController
@RequestMapping("/api/v1")
public class MultimediaController {


    @Autowired
    private MultimediaService multimediaService;

    @Autowired
    private MultimediaMapper mapper;

    @Autowired
    private ModelMapper mapping;

    @ApiOperation(value = "Get all multimedias",notes = "Este consulta consiste en obtener a todas las multimedias")
    @GetMapping("/multimedias")
    public Page<MultimediaResource> getAllMultimedias(Pageable pageable) {
        return mapper.modelListToPage(multimediaService.getAll(), pageable);
    }
    @ApiOperation(value = "Get a multimedia by ID",notes = "Este consulta consiste en obtener una multimedia segun su ID")
    @GetMapping("/multimedias/{multimediaId}")
    public MultimediaResource getCommentById(@PathVariable("multimediaId") Long multimediaId) {
        return mapper.toResource(multimediaService.getById(multimediaId));
    }
    @ApiOperation(value = "Get Details of an image",notes = "Este consulta consiste en obtener los detalles de una imagen segun  su ID")
    @GetMapping("/multimedias/image/info/{multimediaId}")
    public ImageModel getImageDetails (@PathVariable("multimediaId") Long multimediaId) throws IOException, Message {
        return  multimediaService.getImageDetails(multimediaId);
    }

    @ApiOperation(value = "Get an image",notes = "Este consulta consiste en obtener la imagen segun su ID")
    @GetMapping("/multimedias/image/{multimediaId}")
    public ResponseEntity<byte[]> getImage (@PathVariable("multimediaId") Long multimediaId) throws IOException, Message {
        return  multimediaService.getImage(multimediaId);
    }


    @ApiOperation(value = "Create  a multimedia ",notes = "Este consulta consiste en crear a una multimedia mediante una imagen seleccionada y el Id de la publicacion asignado ")
    @PostMapping("/publications/{publicationId}/multimedias")
    public void createComment( @PathVariable Long publicationId,@RequestParam("file") MultipartFile file) throws IOException {
          multimediaService.create(publicationId,file);
    }


    @ApiOperation(value = "Get all multimedias by PublicationID",notes = "Este consulta consiste en obtener  todas las multimedias segun el ID de la publicacion ")
    @GetMapping("/publications/{publicationId}/multimedias")
    public List<ImageModel> getAllmultimediasByPublicationId(@PathVariable Long publicationId, Pageable pageable) {
        return multimediaService.getMultimediaByPublicationId(publicationId);
    }

    @ApiOperation(value = "Download a multimedia ",notes = "Este consulta consiste en descargar un archivo de multimedia ")
    @GetMapping("download/{filenameId}")
    public ResponseEntity<ByteArrayResource> downloadFiles(@PathVariable Long  filenameId ){

        return multimediaService.download(filenameId);
    }


    @ApiOperation(value = "Delete  a multimedia ",notes = "Este consulta consiste en eliminar  una multimedia mediante su ID")
    @DeleteMapping("/multimedias/{multimediaId}")
    public ResponseEntity<?> deleteMultimedia(@PathVariable Long commentId) {
        return multimediaService.delete(commentId);
    }


}
