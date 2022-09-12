package com.example.fortlomisw.backend.mapping;


import com.example.fortlomisw.backend.domain.model.entity.PublicationComment;
import com.example.fortlomisw.backend.resource.PublicationComment.CreatePublicationComment;
import com.example.fortlomisw.backend.resource.PublicationComment.PublicationCommentResource;
import com.example.fortlomisw.backend.resource.PublicationComment.UpdatePublicationComment;
import com.example.fortlomisw.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.io.Serializable;
import java.util.List;
public class PublicationCommentMapper implements Serializable{



    @Autowired
    EnhancedModelMapper mapper;

    public PublicationCommentResource toResource(PublicationComment model) {
        return mapper.map(model, PublicationCommentResource.class);
    }

    public Page<PublicationCommentResource> modelListToPage(List<PublicationComment> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, PublicationCommentResource.class), pageable, modelList.size());
    }
    public PublicationComment toModel(CreatePublicationComment resource) {
        return mapper.map(resource, PublicationComment.class);
    }

    public PublicationComment toModel(UpdatePublicationComment resource) {
        return mapper.map(resource, PublicationComment.class);
    }




}
