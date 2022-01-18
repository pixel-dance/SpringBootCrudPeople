package com.example.SpringBootCrudPeople.service;

import com.example.SpringBootCrudPeople.models.Person;
import com.example.SpringBootCrudPeople.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {
    private  final PersonRepository personRepository;

    @Autowired
    public PeopleService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person findById(Long id){
        return personRepository.findById(id).orElse(null);
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public Person savePerson(Person person){
        return personRepository.save(person);
    }

    public void deleteById(Long id){
        personRepository.deleteById(id);
    }
}
