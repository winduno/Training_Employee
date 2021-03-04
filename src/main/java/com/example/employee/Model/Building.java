package com.example.employee.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "building")
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

    public Building(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Building() {

    }

    public Building(Long id, String name, String address, Set<Employee> employees, Cantin cantin) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.employees = employees;
        this.cantin = cantin;
    }
}
