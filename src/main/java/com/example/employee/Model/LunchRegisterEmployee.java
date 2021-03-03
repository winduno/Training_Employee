package com.example.employee.Model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Data
public class LunchRegisterEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    @OneToMany(mappedBy = "lunchRegisterEmployee")
    private Set<Employee> employee;

    @OneToMany(mappedBy = "lunchRegisterEmployee")
    private Set<Cantin> cantin;

    @OneToMany(mappedBy = "lunchRegisterEmployee")
    private Set<Dish> dish;
}
