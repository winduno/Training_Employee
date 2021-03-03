package com.example.employee.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    @OneToMany(mappedBy = "dish")
    private Set<LunchRegisterEmployee> lunchRegisterEmployee;

    @ManyToMany(mappedBy = "dish")
    private Set<Menu> menus;

}
