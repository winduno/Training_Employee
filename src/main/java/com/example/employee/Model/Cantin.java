package com.example.employee.Model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Cantin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String chefs;

    private Double income;

    private Double outcome;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idBuilding")
    private Building building;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCantinDish")
    private CantinDish cantinDish;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLunchRegisterEmployee")
    private LunchRegisterEmployee lunchRegisterEmployee;
}
