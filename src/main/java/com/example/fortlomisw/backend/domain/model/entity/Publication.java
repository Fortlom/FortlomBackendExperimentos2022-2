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
@Table(name="publication")
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    @NotBlank
    @Size(max = 30)
    @Column(unique=true)
    private String publicationname;

    @NotNull
    @NotBlank
    @Size(max = 200)
    private String publicationdescription;


    @NotNull
    private Long likes;

    @Temporal(TemporalType.DATE)
    private Date registerdate;


    @ManyToOne(targetEntity = Artist.class)
    @JoinColumn(name = "artistid")
    private Artist artist;



    @OneToMany(targetEntity = Multimedia.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "publicationid",referencedColumnName = "id")
    private List<Multimedia> multimedia;


    @OneToMany(targetEntity = PublicationComment.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "publicationid",referencedColumnName = "id")
    private List<PublicationComment> publicationComments;





}
