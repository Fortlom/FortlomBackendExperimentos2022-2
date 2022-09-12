package com.example.fortlomisw.backend.api;


import com.example.fortlomisw.backend.domain.model.entity.Rate;
import com.example.fortlomisw.backend.domain.service.RateService;
import com.example.fortlomisw.backend.mapping.RateMapper;
import com.example.fortlomisw.backend.resource.Rate.CreateRateResource;
import com.example.fortlomisw.backend.resource.Rate.RateResource;
import com.example.fortlomisw.backend.resource.Rate.UpdateRateResource;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class RateController {

    @Autowired
    private RateService rateService;

    @Autowired
    private RateMapper mapper;

    @Autowired
    private ModelMapper mapping;
    @ApiOperation(value="getAllRates",notes = "Esta consulta nos retorna todos las calificaciones existentes")
    @GetMapping("/rates")
    public Page<RateResource> getAllRates(Pageable pageable) {
        return mapper.modelListToPage(rateService.getAll(), pageable);
    }
    @ApiOperation(value="getRateById",notes = "Esta consulta nos ayuda a retorna una calificacion segun su id")
    @GetMapping("/rates/{rateId}")
    public RateResource getRateById(@PathVariable("rateId") Long followId) {
        return mapper.toResource(rateService.getById(followId));
    }
    @ApiOperation(value="createRate",notes = "Esta consulta nos ayuda a crear una calificacion segun el id del fanatico y del artista al que quiere calificar")
    @PostMapping("/fanatics/{fanaticId}/artists/{artistId}/rates")
    public RateResource createRate(@PathVariable Long fanaticId, @PathVariable Long artistId, @RequestBody CreateRateResource request) {
        Rate comment = mapping.map(request, Rate.class);
        return mapping.map(rateService.create(fanaticId, artistId, comment), RateResource.class);
    }
    @ApiOperation(value="getAllRatesByFanaticId",notes = "Esta consulta nos retorna todas las calificaciones segun el id del fanatico que va a calificar")
    @GetMapping("/fanatics/{fanaticId}/rates")
    public Page<RateResource> getAllRatesByFanaticId(@PathVariable Long fanaticId,Pageable pageable) {
        return mapper.modelListToPage(rateService.ratesByFanaticId(fanaticId), pageable);
    }
    @ApiOperation(value="getAllRateByArtistId",notes = "Esta consulta nos retorna todas las calificaciones segun el id del artista que va a ser calificado")
    @GetMapping("/artists/{artistId}/rates")
    public Page<RateResource> getAllRateByArtistId(@PathVariable Long artistId,Pageable pageable) {
        return mapper.modelListToPage(rateService.ratesByArtistId(artistId), pageable);
    }
    @ApiOperation(value="deleteRate",notes = "Esta consulta nos elimina una calificacion segun su id")
    @DeleteMapping("/rates/{rateId}")
    public ResponseEntity<?> deleteRate(@PathVariable Long rateId) {
        return rateService.delete(rateId);
    }

    @ApiOperation(value="updateRate",notes = "Esta consulta nos ayuda a actualizar una calificacion segun su id")
    @PutMapping("/rates/{rateId}")
    public RateResource updateRate(@PathVariable Long rateId, @RequestBody UpdateRateResource request) {
        return mapper.toResource(rateService.update(rateId, mapper.toModel(request)));
    }
}
