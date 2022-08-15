package com.bootcampfinal.java.event.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyModel {
    @JsonProperty("companyId")
    private Long id;

    private String name;

    private String ruc;

    private String description;
}
