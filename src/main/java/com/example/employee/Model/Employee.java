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

    @ManyToOne
    @JoinColumn(name = "idBuilding")
    private Building building;

    @OneToOne(mappedBy = "employee")
    private Card card;

    @OneToOne(mappedBy = "employee")
    private Guess guess;

    @OneToOne(mappedBy = "employee")
    private ParkingTicket parkingTicket;

    @OneToMany(mappedBy = "employee")
    private List<Post> posts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLunchRegisterEmployee")
    private LunchRegisterEmployee lunchRegisterEmployee;
}
