package com.example.employee.Model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
public class LunchRegisterEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    @OneToOne
    @JoinColumn(name = "idEmployee")
    private Employee employee;

    @OneToOne
    @JoinColumn(name = "idCantin")
    private Cantin cantin;

    @OneToOne
    @JoinColumn(name = "idDish")
    private Dish dish;
}
