package com.example.employee.Model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Date dateOfbirth;

    private String department;

    @OneToOne
    @JoinColumn(name = "idBuilding")
    private Building building;
}
