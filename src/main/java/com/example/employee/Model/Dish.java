package com.example.employee.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCantinDish")
    private CantinDish cantinDish;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLunchRegisterEmployee")
    private LunchRegisterEmployee lunchRegisterEmployee;
}
