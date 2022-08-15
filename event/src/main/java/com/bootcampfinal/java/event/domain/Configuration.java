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
public class Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique=true)
    private String name;

    private String description;

    private Timestamp dateConfiguration;
    private BigDecimal amountmin;
    private BigDecimal amountmax;

    private Boolean status;

}
