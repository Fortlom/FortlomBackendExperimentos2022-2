package com.example.fortlomisw.backend.mapping;



import com.example.fortlomisw.backend.domain.model.entity.Follow;
import com.example.fortlomisw.backend.resource.Follow.CreateFollowResource;
import com.example.fortlomisw.backend.resource.Follow.FollowResource;
import com.example.fortlomisw.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.io.Serializable;
import java.util.List;


public class FollowMapper implements Serializable{

    @Autowired
    EnhancedModelMapper mapper;

    public FollowResource toResource(Follow model) {
        return mapper.map(model, FollowResource.class);
    }

    public Page<FollowResource> modelListToPage(List<Follow> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, FollowResource.class), pageable, modelList.size());
    }
    public Follow toModel(CreateFollowResource resource) {
        return mapper.map(resource, Follow.class);
    }

}
