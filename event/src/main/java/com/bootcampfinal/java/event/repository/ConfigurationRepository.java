package com.bootcampfinal.java.event.repository;

import com.bootcampfinal.java.event.domain.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {
}
