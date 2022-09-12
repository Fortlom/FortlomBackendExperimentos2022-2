package com.example.fortlomisw.backend.domain.model.entity;


import lombok.*;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persons")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 30)
    @Column(unique = true)
    private String username;


    @NotNull
    @NotBlank
    @Size(max = 30)
    private String realname;

    @NotNull
    @NotBlank
    @Size(max = 30)
    private String lastname;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    @NotBlank
    private String password;

    @Lob
    private byte[] content;

    private String imageprofiletype;

    private String tokenpassword;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Rol> roles=new HashSet<>();


    @OneToMany(targetEntity = Forum.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "personid",referencedColumnName = "id")
    private List<Forum> forums;

    @OneToMany(targetEntity = Comment.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "personid",referencedColumnName = "id")
    private List<Comment> comments;


    @OneToMany(targetEntity = Report.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "userMainid",referencedColumnName = "id")
    private List<Report> reportmains;

    @OneToMany(targetEntity = Report.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "userReportedid",referencedColumnName = "id")
    private List<Report> reporttouser;




}
