package com.example.fortlomisw.backend.api;



import com.example.fortlomisw.backend.domain.model.entity.Publication;
import com.example.fortlomisw.backend.domain.service.PublicationService;
import com.example.fortlomisw.backend.mapping.PublicationMapper;
import com.example.fortlomisw.backend.resource.Publication.CreatePublicationResource;
import com.example.fortlomisw.backend.resource.Publication.PublicationResource;
import com.example.fortlomisw.backend.resource.Publication.UpdatePublicationResource;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class PublicationController {

    @Autowired
    private PublicationService publicationService;

    @Autowired
    private PublicationMapper mapper;

    @Autowired
    private ModelMapper mapping;
    @ApiOperation(value="getAllPublications",notes = "Esta consulta nos retorna todos las publicaciones existentes")
    @GetMapping("/publications")
    public Page<PublicationResource> getAllPublications(Pageable pageable) {
        return mapper.modelListToPage(publicationService.getAll(), pageable);
    }
    @ApiOperation(value="getPublicationById",notes = "Esta consulta nos ayuda a retorna una publicacion segun su id")
    @GetMapping("/publications/{publicationId}")
    public PublicationResource getPublicationById(@PathVariable("publicationId") Long publicationId) {
        return mapper.toResource(publicationService.getById(publicationId));
    }
    @ApiOperation(value="createPublication",notes = "Esta consulta nos ayuda a crear una publicacion segun el id del artista que va a publicar su contenido")
    @PostMapping("/artists/{artistId}/publications")
    public PublicationResource createPublication(@PathVariable Long artistId,@RequestBody CreatePublicationResource request) {
        Publication publication = mapping.map(request, Publication.class);
        return mapping.map(publicationService.create(artistId, publication), PublicationResource.class);
    }
    @ApiOperation(value="updatePublication",notes = "Esta consulta nos ayuda a actualizar una publicacion segun su id")
    @PutMapping("/publications/{publicationId}")
    public PublicationResource updatePublication(@PathVariable Long publicationId, @RequestBody UpdatePublicationResource request) {
        return mapper.toResource(publicationService.update(publicationId, mapper.toModel(request)));
    }
    @ApiOperation(value="deletePublication",notes = "Esta consulta nos elimina una publicacion segun su id")
    @DeleteMapping("/publications/{publicationId}")
    public ResponseEntity<?> deletePublication(@PathVariable Long publicationId) {
        return publicationService.delete(publicationId);
    }
    @ApiOperation(value="getAllPublicationByArtistId",notes = "Esta consulta nos retorna todas las publicaciones segun el id del artista que realizo una publicacion de su contenido")
    @GetMapping("/artists/{artistId}/publications")
    public Page<PublicationResource> getAllPublicationByArtistId(@PathVariable Long artistId,Pageable pageable) {
        return mapper.modelListToPage(publicationService.getPublicationByArtistId(artistId), pageable);
    }
}
