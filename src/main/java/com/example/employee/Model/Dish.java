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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMenu")
    private Menu menu;

    @OneToMany(mappedBy = "dish")
    private Set<LunchRegisterEmployee> lunchRegisterEmployee;
}
