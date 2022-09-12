package com.example.fortlomisw.backend.domain.model.entity;




import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@NoArgsConstructor
@Getter
@Setter
@Entity
@With
@AllArgsConstructor
@Table(name="multimedias")
public class Multimedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Lob
    private byte[] content;

    private String type;


    @ManyToOne(targetEntity = Publication.class)
    @JoinColumn(name = "publicationid")
    private Publication publication;





}
