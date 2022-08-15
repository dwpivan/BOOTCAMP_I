package com.bootcampfinal.java.event.repository;

import com.bootcampfinal.java.event.domain.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedureRepository extends JpaRepository<Procedure, Long> {
}
