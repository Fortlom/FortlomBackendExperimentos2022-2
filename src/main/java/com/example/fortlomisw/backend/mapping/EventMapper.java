package com.example.fortlomisw.backend.mapping;


import com.example.fortlomisw.backend.domain.model.entity.Event;
import com.example.fortlomisw.backend.resource.Event.CreateEventResource;
import com.example.fortlomisw.backend.resource.Event.EventResource;
import com.example.fortlomisw.backend.resource.Event.UpdateEventResource;
import com.example.fortlomisw.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.io.Serializable;
import java.util.List;

public class EventMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public EventResource toResource(Event model) {
        return mapper.map(model, EventResource.class);
    }

    public Page<EventResource> modelListToPage(List<Event> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, EventResource.class), pageable, modelList.size());
    }

    public Event toModel(CreateEventResource resource) {
        return mapper.map(resource, Event.class);
    }

    public Event toModel(UpdateEventResource resource) {
        return mapper.map(resource, Event.class);
    }







}
