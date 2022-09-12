package com.example.fortlomisw.backend.domain.model.entity;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 30)
    @Column(unique = true)
    private String eventname;

    @NotNull
    @NotBlank
    @Size(max = 200)
    private String eventeescription;

    @NotNull
    private Long eventlikes;


    @Temporal(TemporalType.DATE)
    private Date registerdate;


    @ManyToOne(targetEntity = Artist.class)
    @JoinColumn(name = "artistid")
    private Artist artist;



}
