package com.bootcampfinal.java.event.service;

import com.bootcampfinal.java.event.domain.Company;
import com.bootcampfinal.java.event.repository.CompanyRepository;
import com.bootcampfinal.java.event.service.mapper.CompanyMapper;
import com.bootcampfinal.java.event.web.model.CompanyModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService implements ICompanyService {


    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;


    @Override
    public List<CompanyModel> findAll()  throws Exception {
        List<Company> companys = companyRepository.findAll();
        return companyMapper.companysToCompanyModels(companys);
    }


    @Override
    public CompanyModel findById(Long id) throws Exception {
        Optional<Company> company = companyRepository.findById(id);
        if(company.isPresent()) return companyMapper.companyToCompanyModel(company.get());
        else throw new Exception("No se encontraron datos");
    }

    @Override
    public CompanyModel create(CompanyModel companyModel)  throws Exception{
        var company = companyRepository.save(companyMapper.companyModelToCompany(companyModel));
        return companyMapper.companyToCompanyModel(company);
    }

    @Override
    public void update(Long id, CompanyModel companyModel)  throws Exception {
        Optional<Company> companyOptional = companyRepository.findById(id);

        if(companyOptional.isPresent()) {
            Company companyToUpdate = companyOptional.get();
            companyMapper.update(companyToUpdate, companyModel);
            companyRepository.save(companyToUpdate);
        }
        else throw new Exception("No se encontraron datos");
    }

    @Override
    public void deleteById(Long id)  throws Exception {
        companyRepository.deleteById(id);
    }
}
