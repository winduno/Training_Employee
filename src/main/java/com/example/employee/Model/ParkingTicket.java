package com.example.employee.Model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class ParkingTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    private Date dateCreated;

    private String motorPlate;

    private String motorBrand;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmployee")
    private Employee employee;
}
