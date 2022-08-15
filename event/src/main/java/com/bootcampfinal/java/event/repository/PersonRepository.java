package com.bootcampfinal.java.event.repository;

import com.bootcampfinal.java.event.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
