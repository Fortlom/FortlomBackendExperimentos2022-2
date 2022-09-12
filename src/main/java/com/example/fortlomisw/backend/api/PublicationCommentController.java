package com.example.fortlomisw.backend.api;


import com.example.fortlomisw.backend.domain.model.entity.PublicationComment;
import com.example.fortlomisw.backend.domain.service.PublicationCommentService;
import com.example.fortlomisw.backend.mapping.PublicationCommentMapper;
import com.example.fortlomisw.backend.resource.PublicationComment.CreatePublicationComment;
import com.example.fortlomisw.backend.resource.PublicationComment.PublicationCommentResource;
import com.example.fortlomisw.backend.resource.PublicationComment.UpdatePublicationComment;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class PublicationCommentController {


    @Autowired
    private PublicationCommentService commentService;

    @Autowired
    private PublicationCommentMapper mapper;

    @Autowired
    private ModelMapper mapping;
    @ApiOperation(value="getAllComments",notes = "Esta consulta nos retorna todos los comentarios existentes de las publicaciones")
    @GetMapping("/comments")
    public Page<PublicationCommentResource> getAllComments(Pageable pageable) {
        return mapper.modelListToPage(commentService.getAll(), pageable);
    }
    @ApiOperation(value="getCommentById",notes = "Esta consulta nos ayuda a retorna un comentario de una publicacion segun su id")
    @GetMapping("/comments/{commentId}")
    public PublicationCommentResource getCommentById(@PathVariable("commentId") Long commentId) {
        return mapper.toResource(commentService.getById(commentId));
    }
    @ApiOperation(value="createComment",notes = "Esta consulta nos ayuda a crear un comentario segun el id del usuario que va a comentar y de la publicacion al que se va a comentar")
    @PostMapping("/users/{userId}/publications/{publicationId}/comments")
    public PublicationCommentResource createComment(@PathVariable Long userId, @PathVariable Long publicationId, @RequestBody CreatePublicationComment request) {
        PublicationComment comment = mapping.map(request, PublicationComment.class);
        return mapping.map(commentService.create(userId, publicationId, comment), PublicationCommentResource.class);
    }
    @ApiOperation(value="getAllCommentsByPublicationId",notes = "Esta consulta nos ayuda a retorna todos los comentarios segun el id de una publicacion")
    @GetMapping("/publications/{publicationId}/comments")
    public Page<PublicationCommentResource> getAllCommentsByPublicationId(@PathVariable Long publicationId,Pageable pageable) {
        return mapper.modelListToPage(commentService.getCommentByPublicationId(publicationId), pageable);
    }
    @ApiOperation(value="updateComment",notes = "Esta consulta nos ayuda a actualizar un comentario de una publicacion segun su id")
    @PutMapping("/comments/{commentId}")
    public PublicationCommentResource updateComment(@PathVariable Long commentId, @RequestBody UpdatePublicationComment request) {
        return mapper.toResource(commentService.update(commentId, mapper.toModel(request)));
    }
    @ApiOperation(value="deleteComment",notes = "Esta consulta nos ayuda a eliminar un comentario de una publicacion segun su id")
    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable Long commentId) {
        return commentService.delete(commentId);
    }

}
