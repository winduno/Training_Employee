package com.example.employee.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Cantin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String chefs;

    private Double income;

    private Double outcome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idBuilding")
    private Building building;

    @ManyToOne
    @JoinColumn(name = "idCantinDish")
    private CantinDish cantinDish;
}
