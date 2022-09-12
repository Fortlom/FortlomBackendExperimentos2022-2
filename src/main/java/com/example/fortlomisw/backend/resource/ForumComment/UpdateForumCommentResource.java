package com.example.fortlomisw.backend.resource.ForumComment;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class UpdateForumCommentResource {
    private String commentdescription;

    private Date registerdate;
}
