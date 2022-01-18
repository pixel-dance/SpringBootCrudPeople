package com.example.SpringBootCrudPeople.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PERSON")
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "Name", length = 50, nullable = false)
    private String name;

    @Column(name = "Age", nullable = false)
    private int age;

    @Column(name = "Email")
    private String email;
}
