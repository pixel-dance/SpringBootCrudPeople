package com.example.SpringBootCrudPeople.repository;

import com.example.SpringBootCrudPeople.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
