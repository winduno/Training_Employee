package com.example.employee.Model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Data
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCantin")
    private Cantin cantin;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "menu_dish", joinColumns = @JoinColumn(name = "idMenu"),
            inverseJoinColumns = @JoinColumn(name = "idDish"))
    private Set<Dish> dish;
}
