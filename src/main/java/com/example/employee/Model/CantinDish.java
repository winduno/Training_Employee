package com.example.employee.Model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Data
public class CantinDish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    @OneToMany(mappedBy = "cantinDish")
    private Set<Cantin> cantin;

    @OneToMany(mappedBy = "cantinDish")
    private Set<Dish> dish;
}
