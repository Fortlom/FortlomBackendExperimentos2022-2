package com.example.fortlomisw.backend.api;


import com.example.fortlomisw.backend.domain.model.entity.Forum;
import com.example.fortlomisw.backend.domain.service.ForumService;
import com.example.fortlomisw.backend.mapping.ForumMapper;
import com.example.fortlomisw.backend.resource.Forum.CreateForumResource;
import com.example.fortlomisw.backend.resource.Forum.ForumResource;
import com.example.fortlomisw.backend.resource.Forum.UpdateForumResource;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1")
public class ForumController {

    @Autowired
    private ForumService forumService;

    @Autowired
    private ForumMapper mapper;

    @Autowired
    private ModelMapper mapping;


    @ApiOperation(value = "Get all Forums",notes = "Este consulta consiste en obtener a todos los foros")
    @GetMapping("/forums")
    public Page<ForumResource> getAllForums(Pageable pageable) {
        return mapper.modelListToPage(forumService.getAllForums(), pageable);
    }

    @ApiOperation(value = "Get a Forum by ID",notes = "Este consulta consiste en obtener un foro segun su ID")
    @GetMapping("/forums/{forumId}")
    public ForumResource getForumById(@PathVariable Long forumId) {
        return mapper.toResource(forumService.getForumById(forumId));
    }
    @ApiOperation(value = "Get all Forums by UserID",notes = "Este consulta consiste en obtener  foro segun el ID del usuario que lo haya creado")
    @GetMapping("/user/{usersId}/forums")
    public Page<ForumResource> getAllForumsByusersId(@PathVariable Long usersId,Pageable pageable) {
        return mapper.modelListToPage(forumService.getForumsByUserId(usersId), pageable);
    }

    @ApiOperation(value = "Create  a Forum ",notes = "Este consulta consiste en crear a un foro mediante unos datos establecidos y el Id del usuario asignado ")
    @PostMapping("/user/{usersId}/forums")
    public ForumResource createForum(@PathVariable Long usersId,@RequestBody CreateForumResource request) {
        Forum forum = mapping.map(request, Forum.class);
        return mapping.map(forumService.createForum(usersId, forum), ForumResource.class);
    }
    @ApiOperation(value = "Delete  a Forum ",notes = "Este consulta consiste en eliminar  un foro mediante su ID")
    @DeleteMapping("/forums/{forumId}")
    public ResponseEntity<?> deleteForum(@PathVariable Long forumId) {
        return forumService.deleteForum(forumId);
    }









}
