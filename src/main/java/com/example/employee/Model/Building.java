package com.example.employee.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    @JsonIgnore
    @OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
    private Set<Employee> employees;

    @JsonIgnore
    @OneToOne(mappedBy = "building", fetch = FetchType.LAZY)
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
