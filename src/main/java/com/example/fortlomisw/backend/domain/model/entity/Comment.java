package com.example.fortlomisw.backend.domain.model.entity;




import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@NoArgsConstructor
@Getter
@Setter
@Entity
@With
@AllArgsConstructor
@Table(name="comments")
@Inheritance(strategy = InheritanceType.JOINED)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 150)
    private String commentdescription;

    @Temporal(TemporalType.DATE)
    private Date registerdate;



    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(name = "personid")
    private Person person;




}
