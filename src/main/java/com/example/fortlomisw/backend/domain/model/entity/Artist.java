package com.example.fortlomisw.backend.domain.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@With
@AllArgsConstructor
@Table(name="artists")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Artist extends Person{

    @NotNull
    private Long artistfollowers;

    private String instagramLink;

    private String facebookLink;

    private String twitterLink;

    @OneToMany(targetEntity = Rate.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "artistid",referencedColumnName = "id")
    private List<Rate> rate;

    @OneToMany(targetEntity = Event.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "artistid",referencedColumnName = "id")
    private List<Event> events;

    @OneToMany(targetEntity = Publication.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "artistid",referencedColumnName = "id")
    private List<Publication> publications;

    @OneToMany(targetEntity = Follow.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "artistid",referencedColumnName = "id")
    private List<Follow> follow;



}
