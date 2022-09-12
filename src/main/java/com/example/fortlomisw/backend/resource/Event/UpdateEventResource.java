package com.example.fortlomisw.backend.resource.Event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateEventResource {
    private String eventname;
    private String eventeescription;
    private Long eventlikes;
}
