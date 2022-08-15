package com.bootcampfinal.java.event.repository;

import com.bootcampfinal.java.event.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
