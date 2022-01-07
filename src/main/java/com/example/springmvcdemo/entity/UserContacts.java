package com.example.springmvcdemo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserContacts {

    @Id
    @SequenceGenerator(name = "userContactsSequence", sequenceName = "userContactsSequence" ,allocationSize = 1)
    @GeneratedValue(generator = "userContactsSequence", strategy = GenerationType.SEQUENCE)
    private int id;
    private int userId;
    private int personId;

}
