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
@Table(name="rates")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    private Integer rates;


    @ManyToOne(targetEntity = Artist.class)
    @JoinColumn(name = "artistid")
    private Artist artist;


    @ManyToOne(targetEntity = Fanatic.class)
    @JoinColumn(name = "fanaticid")
    private Fanatic fanatic;





}
