package com.example.fortlomisw.backend.api;

import com.example.fortlomisw.backend.domain.model.entity.Follow;
import com.example.fortlomisw.backend.domain.service.FollowService;
import com.example.fortlomisw.backend.mapping.FollowMapper;
import com.example.fortlomisw.backend.resource.Follow.CreateFollowResource;
import com.example.fortlomisw.backend.resource.Follow.FollowResource;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class FollowController {
    @Autowired
    private FollowService followService;

    @Autowired
    private FollowMapper mapper;

    @Autowired
    private ModelMapper mapping;



    @ApiOperation(value = "Get all Follows",notes = "Este consulta consiste en obtener a todos los seguimientos")
    @GetMapping("/follows")
    public Page<FollowResource> getAllFollows(Pageable pageable) {
        return mapper.modelListToPage(followService.getAll(), pageable);
    }
    @ApiOperation(value = "Get a Follow by ID",notes = "Este consulta consiste en obtener un seguimiento segun su ID")
    @GetMapping("/follows/{followId}")
    public FollowResource getFollowById(@PathVariable("followId") Long followId) {
        return mapper.toResource(followService.getById(followId));
    }

    @ApiOperation(value = "Create  a Follow ",notes = "Este consulta consiste en crear a un follow mediante el ID de un fanatico y el Id de un artista  ")
    @PostMapping("/fanatics/{fanaticId}/artists/{artistId}/follows")
    public FollowResource createFollow(@PathVariable Long fanaticId, @PathVariable Long artistId, @RequestBody CreateFollowResource request) {
        Follow comment = mapping.map(request, Follow.class);
        return mapping.map(followService.create(fanaticId, artistId, comment), FollowResource.class);
    }
    @ApiOperation(value = "Get all Follows by FanaticID",notes = "Este consulta consiste en obtener  seguimientos de un fanatico  segun el ID ")
    @GetMapping("/fanatics/{fanaticId}/follows")
    public Page<FollowResource> getAllFollowsByFanaticId(@PathVariable Long fanaticId,Pageable pageable) {
        return mapper.modelListToPage(followService.followsByFanaticId(fanaticId), pageable);
    }
    @ApiOperation(value = "Get all Follows by ArtistID",notes = "Este consulta consiste en obtener  seguimientos de un artista  segun el ID ")
    @GetMapping("/artists/{artistId}/follows")
    public Page<FollowResource> getAllFollowsByArtistId(@PathVariable Long artistId,Pageable pageable) {
        return mapper.modelListToPage(followService.followsByArtistId(artistId), pageable);
    }
    @ApiOperation(value = "Delete  a Follow ",notes = "Este consulta consiste en eliminar  un seguimiento mediante su ID")
    @DeleteMapping("/follows/{followId}")
    public ResponseEntity<?> deleteFollow(@PathVariable Long followId) {
        return followService.delete(followId);
    }
}
