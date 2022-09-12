package com.example.fortlomisw.backend.api;



import com.example.fortlomisw.backend.domain.service.FanaticService;
import com.example.fortlomisw.backend.mapping.FanaticMapper;
import com.example.fortlomisw.backend.resource.Fanatic.CreateFanaticResource;
import com.example.fortlomisw.backend.resource.Fanatic.FanaticResource;
import com.example.fortlomisw.backend.resource.Fanatic.UpdateFanaticResource;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fanatics")
public class FanaticController {


    @Autowired
    private FanaticService fanaticService;

    @Autowired
    private FanaticMapper mapper;


    @ApiOperation(value = "Get all Fanatics",notes = "Este consulta consiste en obtener a todos los fanaticos")
    @GetMapping
    public Page<FanaticResource> getAllFanatics(Pageable pageable) {
        return mapper.modelListToPage(fanaticService.getAll(), pageable);
    }

    @ApiOperation(value = "Get a fanatic by ID",notes = "Este consulta consiste en obtener un fanatico segun su ID")
    @GetMapping("{fanaticId}")
    public FanaticResource getUserById(@PathVariable("fanaticId") Long fanaticId) {
        return mapper.toResource(fanaticService.getById(fanaticId));
    }

    @ApiOperation(value = "Get a fanatic  by name",notes = "Este consulta consiste en obtener un fanatico segun su nombre de usuario")
    @GetMapping("/name/{fanaticname}")
    public FanaticResource getUserByfanaticname(@PathVariable("fanaticname") String fanaticname) {
        return mapper.toResource(fanaticService.getbyNombreUsuario(fanaticname));
    }

    @ApiOperation(value = "Create  a Fanatic ",notes = "Este consulta consiste en crear a un fanatico mediante unos datos establecidos ")
    @PostMapping
    public FanaticResource createUser(@RequestBody CreateFanaticResource request) {

        return mapper.toResource(fanaticService.create(mapper.toModel(request)));
    }

    @ApiOperation(value = "Update  a fanatic ",notes = "Este consulta consiste en actualizar  la informacion principal de un fanatico ")
    @PutMapping("{fanaticId}")
    public FanaticResource updateUser(@PathVariable Long fanaticId, @RequestBody UpdateFanaticResource request) {
        return mapper.toResource(fanaticService.update(fanaticId, mapper.toModel(request)));
    }

    @ApiOperation(value = "Delete  a Fanatic ",notes = "Este consulta consiste en eliminar  la cuenta de un fanatico  mediante su ID")
    @DeleteMapping("{fanaticId}")
    public ResponseEntity<?> deletePost(@PathVariable Long fanaticId) {
        return fanaticService.delete(fanaticId);
    }












}
