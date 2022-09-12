package com.example.fortlomisw.backend.mapping;
import com.example.fortlomisw.backend.domain.model.entity.ForumComment;
import com.example.fortlomisw.backend.resource.ForumComment.CreateForumCommentResource;
import com.example.fortlomisw.backend.resource.ForumComment.ForumCommentResource;
import com.example.fortlomisw.backend.resource.ForumComment.UpdateForumCommentResource;
import com.example.fortlomisw.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.io.Serializable;
import java.util.List;
public class ForumCommentMapper implements Serializable{

    @Autowired
    EnhancedModelMapper mapper;

    public ForumCommentResource toResource(ForumComment model) {
        return mapper.map(model, ForumCommentResource.class);
    }

    public Page<ForumCommentResource> modelListToPage(List<ForumComment> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ForumCommentResource.class), pageable, modelList.size());
    }
    public ForumComment toModel(CreateForumCommentResource resource) {
        return mapper.map(resource, ForumComment.class);
    }

    public ForumComment toModel(UpdateForumCommentResource resource) {
        return mapper.map(resource, ForumComment.class);
    }


}
