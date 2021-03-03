package com.example.employee.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

}
