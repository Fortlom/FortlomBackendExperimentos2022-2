package com.example.fortlomisw.backend.api;





import com.example.fortlomisw.backend.domain.model.entity.Event;
import com.example.fortlomisw.backend.domain.service.EventService;
import com.example.fortlomisw.backend.mapping.EventMapper;
import com.example.fortlomisw.backend.resource.Event.CreateEventResource;
import com.example.fortlomisw.backend.resource.Event.EventResource;
import com.example.fortlomisw.backend.resource.Event.UpdateEventResource;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private EventMapper mapper;

    @Autowired
    private ModelMapper mapping;



    @ApiOperation(value = "Get all Events",notes = "Este consulta consiste en obtener a todos los eventos")
    @GetMapping("/events")
    public Page<EventResource> getAllEvents(Pageable pageable) {
        return mapper.modelListToPage(eventService.getAllEvents(), pageable);
    }

    @ApiOperation(value = "Get an Event by ID",notes = "Este consulta consiste en obtener un evento segun su ID")
    @GetMapping("/event/{eventId}")
    public EventResource getEventById(@PathVariable Long eventId) {
        return mapper.toResource(eventService.getEventById(eventId));
    }


    @ApiOperation(value = "Get all Events by ArtistID",notes = "Este consulta consiste en obtener  eventos segun el ID de un artista")
    @GetMapping("/artist/{artistId}/events")
    public Page<EventResource> getAllEventsByArtistId(@PathVariable Long artistId,Pageable pageable) {
        return mapper.modelListToPage(eventService.getEventsByArtistId(artistId), pageable);
    }

    @ApiOperation(value = "Create  an Event ",notes = "Este consulta consiste en crear a un evento mediante unos datos establecidos y el Id del artista asignado ")
    @PostMapping("/artist/{artistId}/events")
    public EventResource createEvent(@PathVariable Long artistId,@RequestBody CreateEventResource request) {
        Event event = mapping.map(request, Event.class);
        return mapping.map(eventService.createEvent(artistId, event), EventResource.class);
    }

    @ApiOperation(value = "Update  Event likes ",notes = "Este consulta consiste en actualizar  los likes de un evento mediante la nueva cantidad de likes y el ID de el evento ")
    @PutMapping("/event/{eventId}")
    public EventResource updateEvent(@PathVariable Long eventId, @RequestBody UpdateEventResource request) {
        return mapper.toResource(eventService.updateEvent(eventId, mapper.toModel(request)));
    }
    @ApiOperation(value = "Delete  an Event ",notes = "Este consulta consiste en eliminar  un evento mediante su ID")
    @DeleteMapping("/event/{eventId}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long eventId) {
        return eventService.deleteEvent(eventId);
    }

}
