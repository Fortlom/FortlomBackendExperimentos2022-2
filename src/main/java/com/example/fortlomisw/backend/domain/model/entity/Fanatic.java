package com.example.fortlomisw.backend.domain.model.entity;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@With
@AllArgsConstructor
@Table(name="fanatics")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Fanatic  extends Person{

    @NotNull
    @NotBlank
    @Size(max = 30)
    @Column(unique = true)
    private String fanaticalias;


    @OneToMany(targetEntity = Rate.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "fanaticid",referencedColumnName = "id")
    private List<Rate> rate;

    @OneToMany(targetEntity = Follow.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "fanaticid",referencedColumnName = "id")
    private List<Follow> follow;


}
