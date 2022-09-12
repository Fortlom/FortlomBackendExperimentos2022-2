package com.example.fortlomisw.backend.mapping;




import com.example.fortlomisw.backend.domain.model.entity.Fanatic;
import com.example.fortlomisw.backend.resource.Fanatic.CreateFanaticResource;
import com.example.fortlomisw.backend.resource.Fanatic.FanaticResource;
import com.example.fortlomisw.backend.resource.Fanatic.UpdateFanaticResource;
import com.example.fortlomisw.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.io.Serializable;
import java.util.List;
public class FanaticMapper implements Serializable{


    @Autowired
    EnhancedModelMapper mapper;

    public FanaticResource toResource(Fanatic model) {
        return mapper.map(model, FanaticResource.class);
    }

    public Page<FanaticResource> modelListToPage(List<Fanatic> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, FanaticResource.class), pageable, modelList.size());
    }
    public Fanatic toModel(CreateFanaticResource resource) {
        return mapper.map(resource, Fanatic.class);
    }

    public Fanatic toModel(UpdateFanaticResource resource) {
        return mapper.map(resource, Fanatic.class);
    }








}
