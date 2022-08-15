package com.bootcampfinal.java.event.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Procedure {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique=true)
    private String name;

    private String description;

    private Timestamp dateProcedure;

    private String status;
    private BigDecimal amount;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;
}
