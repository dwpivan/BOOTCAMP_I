package com.bootcampfinal.java.event.service.mapper;

import com.bootcampfinal.java.event.domain.Company;
import com.bootcampfinal.java.event.web.model.CompanyModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    Company companyModelToCompany(CompanyModel model);

    CompanyModel companyToCompanyModel (Company company);

    List<CompanyModel> companysToCompanyModels(List<Company> companys);

    @Mapping(target = "id", ignore = true)
    void update(@MappingTarget Company company, CompanyModel updateEntity);
}
