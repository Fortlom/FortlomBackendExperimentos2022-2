package com.example.fortlomisw.backend.api;




import com.example.fortlomisw.backend.domain.model.entity.ForumComment;
import com.example.fortlomisw.backend.domain.service.ForumCommentService;
import com.example.fortlomisw.backend.mapping.ForumCommentMapper;
import com.example.fortlomisw.backend.resource.ForumComment.CreateForumCommentResource;
import com.example.fortlomisw.backend.resource.ForumComment.ForumCommentResource;
import com.example.fortlomisw.backend.resource.ForumComment.UpdateForumCommentResource;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class ForumCommentController {



    @Autowired
    private ForumCommentService forumcommentService;

    @Autowired
    private ForumCommentMapper mapper;

    @Autowired
    private ModelMapper mapping;


    @ApiOperation(value = "Get all ForumComments",notes = "Este consulta consiste en obtener a todos los comentarios de todos los foros")
    @GetMapping("/forumcomments")
    public Page<ForumCommentResource> getAllForumComments(Pageable pageable) {
        return mapper.modelListToPage(forumcommentService.getAll(), pageable);
    }


    @ApiOperation(value = "Get a ForumComment by ID",notes = "Este consulta consiste en obtener un comentario de foro segun su su ID")
    @GetMapping("/forumcomments/{forumcommentId}")
    public ForumCommentResource getForumCommentById(@PathVariable("forumcommentId") Long forumcommentId) {
        return mapper.toResource(forumcommentService.getById(forumcommentId));
    }

    @ApiOperation(value = "Create  a ForumComment ",notes = "Este consulta consiste en crear a un commentario de foro mediante unos datos establecidos , el Id del usuario y el Id del foro al que se le quiere hacer el comentario ")
    @PostMapping("/users/{userId}/forums/{forumId}/forumcomments")
    public ForumCommentResource createForumComment(@PathVariable Long userId, @PathVariable Long forumId, @RequestBody CreateForumCommentResource request) {
        ForumComment forumcomment = mapping.map(request, ForumComment.class);
        return mapping.map(forumcommentService.create(userId, forumId, forumcomment), ForumCommentResource.class);
    }
    @ApiOperation(value = "Get all ForumComments by ForumID",notes = "Este consulta consiste en obtener  los comentarios de un foro  segun el ID de este")
    @GetMapping("/forums/{forumId}/forumcomments")
    public Page<ForumCommentResource> getAllForumCommentsByForumId(@PathVariable Long forumId,Pageable pageable) {
        return mapper.modelListToPage(forumcommentService.getForumCommentByForumId(forumId), pageable);
    }


    @ApiOperation(value = "Delete  a  ForumComment",notes = "Este consulta consiste en eliminar  un comentario de Foro mediante su ID")
    @DeleteMapping("/forumcomments/{forumcommentId}")
    public ResponseEntity<?> deleteForumComment(@PathVariable Long forumcommentId) {
        return forumcommentService.delete(forumcommentId);
    }












}
