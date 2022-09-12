package com.example.fortlomisw.backend.domain.model.entity;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import lombok.*;
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "follows")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Artist.class)
    @JoinColumn(name = "artistid")
    private Artist artist;


    @ManyToOne(targetEntity = Fanatic.class)
    @JoinColumn(name = "fanaticid")
    private Fanatic fanatic;
}
