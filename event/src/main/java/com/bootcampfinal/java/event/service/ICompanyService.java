package com.bootcampfinal.java.event.service;

import com.bootcampfinal.java.event.web.model.CompanyModel;

import java.util.List;

public interface ICompanyService {

    List<CompanyModel> findAll() throws Exception;

    CompanyModel findById(Long id) throws Exception;

    CompanyModel create(CompanyModel companyModel) throws Exception;

    void update(Long id, CompanyModel companyModel) throws Exception;

    void deleteById(Long id) throws Exception;
}
