package com.example.fortlomisw.backend.api;


import com.example.fortlomisw.backend.domain.model.entity.Artist;
import com.example.fortlomisw.backend.domain.service.ArtistService;
import com.example.fortlomisw.backend.mapping.ArtistMapper;
import com.example.fortlomisw.backend.resource.Artist.ArtistResource;


import com.example.fortlomisw.backend.resource.Artist.CreateArtistResource;
import com.example.fortlomisw.backend.resource.Artist.UpdateArtistResource;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @Autowired
    private ArtistMapper mapper;



    @ApiOperation(value = "Get all artists",notes = "Este consulta consiste en obtener a todos los artistas")
    @GetMapping
    public Page<ArtistResource> getAllFanatics(Pageable pageable) {
        return mapper.modelListToPage(artistService.getAll(), pageable);
    }
    @ApiOperation(value = "Get an artist by ID",notes = "Este consulta consiste en obtener un artista segun su ID")
    @GetMapping("{artistId}")
    public ArtistResource getUserById(@PathVariable("artistId") Long artistId) {
        return mapper.toResource(artistService.getById(artistId));
    }

    @ApiOperation(value = "Get an artist by name",notes = "Este consulta consiste en obtener un artista segun su nombre de usuario")
    @GetMapping("/name/{artistname}")
    public ArtistResource getUserByartistname(@PathVariable("artistname") String artistname) {
        return mapper.toResource(artistService.getbyNombreUsuario(artistname));
    }

    @ApiOperation(value = "Create  an artist ",notes = "Este consulta consiste en crear a un artista mediante unos datos establecidos ")
    @PostMapping
    public ArtistResource createUser(@RequestBody CreateArtistResource request) {

        return mapper.toResource(artistService.create(mapper.toModel(request)));
    }

    @ApiOperation(value = "Update  an artist ",notes = "Este consulta consiste en actualizar  la informacion principal de un artista ")
    @PutMapping("{artistId}")
    public ArtistResource updateUser(@PathVariable Long artistId, @RequestBody UpdateArtistResource request) {
        return mapper.toResource(artistService.update(artistId, mapper.toModel(request)));
    }


    @ApiOperation(value = "Update Instagram Account ",notes = "Este consulta consiste en actualizar o colocar por primera vez  la cuenta de Instagram  de un artista ")
    @PutMapping("/artist/{artistId}/InstagramAccount")
    public ArtistResource updateInstagramAccount(@PathVariable Long artistId, @RequestBody UpdateArtistResource request){
        return mapper.toResource(artistService.setInstagramAccount(artistId,mapper.toModel(request)));

    }
    @ApiOperation(value = "Update Twitter Account ",notes = "Este consulta consiste en actualizar o colocar por primera vez  la cuenta de Twitter  de un artista ")

    @PutMapping("/artist/{artistId}/TwitterAccount")
    public ArtistResource updateTwitterAccount(@PathVariable Long artistId, @RequestBody UpdateArtistResource request){
        return mapper.toResource(artistService.setTwitterAccount(artistId,mapper.toModel(request)));
    }

    @ApiOperation(value = "Update Facebook Account ",notes = "Este consulta consiste en actualizar o colocar por primera vez  la cuenta de Facebook  de un artista ")

    @PutMapping("/artist/{artistId}/FacebookAccount")
    public ArtistResource updateFacebookAccount(@PathVariable Long artistId, @RequestBody UpdateArtistResource request){
        return mapper.toResource(artistService.setFacebookAccount(artistId,mapper.toModel(request)));
    }
    @ApiOperation(value = "Delete  an artist ",notes = "Este consulta consiste en eliminar  la cuenta de un artista mediante su ID")
    @DeleteMapping("{artistId}")
    public ResponseEntity<?> deletePost(@PathVariable Long artistId) {
        return artistService.delete(artistId);
    }







}
