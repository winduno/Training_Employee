package com.example.employee.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @JsonIgnore
    @OneToMany(mappedBy = "dish", fetch = FetchType.LAZY)
    private Set<LunchRegisterEmployee> lunchRegisterEmployee;

    @JsonIgnore
    @ManyToMany(mappedBy = "dish")
    private Set<Menu> menus;

}
