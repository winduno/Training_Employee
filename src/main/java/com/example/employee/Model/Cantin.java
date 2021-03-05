package com.example.employee.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Entity
@Getter
@Setter
public class Cantin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String chefs;

    private Double income;

    private Double outcome;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idBuilding")
    private Building building;

    @JsonIgnore
    @OneToMany(mappedBy = "cantin")
    private Set<Menu> menu;

    @JsonIgnore
    @OneToMany(mappedBy = "cantin")
    private Set<LunchRegisterEmployee> lunchRegisterEmployee;

    public Cantin() {
    }

    public Cantin(Long id, String chefs, Double income, Double outcome) {
        this.id = id;
        this.chefs = chefs;
        this.income = income;
        this.outcome = outcome;
    }

    public Cantin(Long id, String chefs, Double income, Double outcome, Building building) {
        this.id = id;
        this.chefs = chefs;
        this.income = income;
        this.outcome = outcome;
        this.building = building;
    }
}
