package com.example.springmvcdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "person")
public class Person {

    @Id
    @SequenceGenerator(name = "student1_person", sequenceName = "student1_person", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student1_person")
    private int id;
    private int userId;
    private String firstName;
    private String lastName;
    private String street1;
    private String street2;
    private String birthday;

}
