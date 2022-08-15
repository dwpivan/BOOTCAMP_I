package com.bootcampfinal.java.event.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique=true)
    private String email;

    private String password;

//    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private Set<Person> person;

}
