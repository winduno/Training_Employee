package com.example.employee.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    @OneToMany(mappedBy = "building")
    private Set<Employee> employees;

    @OneToOne(mappedBy = "building")
    private Cantin cantin;
}
