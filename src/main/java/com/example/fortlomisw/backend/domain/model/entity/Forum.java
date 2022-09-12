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
@Table(name="forums")
public class Forum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 20)
    @Column(unique = true)
    private String forumname;



    @NotNull
    @NotBlank
    @Size(max = 200)
    private String forumdescription;


    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(name = "personid")
    private Person person;

    @OneToMany(targetEntity = ForumComment.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "forumid",referencedColumnName = "id")
    private List<ForumComment> forumComments;






}
