package com.example.SpringBootCrudPeople.controllers;

import com.example.SpringBootCrudPeople.models.Person;
import com.example.SpringBootCrudPeople.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping()
    @PreAuthorize("hasAuthority('people:read')")
    public String findAll(Model model){
        List<Person> people = peopleService.findAll();
        model.addAttribute("people", people);
        return "person-list";
    }

    @GetMapping("/person-create")
    @PreAuthorize("hasAuthority('people:write')")
    public String createPersonForm(Person person){
        return "person-create";
    }

    @PostMapping("/person-create")
    @PreAuthorize("hasAuthority('people:write')")
    public String createPerson(Person person){
        peopleService.savePerson(person);
        return "redirect:/people";
    }

    @GetMapping("person-delete/{id}")
    @PreAuthorize("hasAuthority('people:write')")
    public String deletePerson(@PathVariable("id") Long id){
        peopleService.deleteById(id);
        return "redirect:/people";
    }

    @GetMapping("person-update/{id}")
    @PreAuthorize("hasAuthority('people:write')")
    public String updatePersonForm(@PathVariable("id") Long id, Model model){
        Person person = peopleService.findById(id);
        model.addAttribute("person", person);
        return "/person-update";
    }

    @PostMapping("/person-update")
    @PreAuthorize("hasAuthority('people:write')")
    public String updatePerson(Person person){
        peopleService.savePerson(person);
        return "redirect:/people";
    }
}
