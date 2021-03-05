package com.example.employee.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCantin", referencedColumnName = "id")
    private Cantin cantin;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "menu_dish", joinColumns = @JoinColumn(name = "idMenu"),
            inverseJoinColumns = @JoinColumn(name = "idDish"))
    private List<Dish> dish;

    public Menu(Long id, Date date, Cantin cantin, List<Dish> dish) {
        this.id = id;
        this.date = date;
        this.cantin = cantin;
        this.dish = dish;
    }

    public Menu() {

    }

    public Menu(Long id, Date date, List<Dish> dish) {
        this.id = id;
        this.date = date;
        this.dish = dish;
    }

    public Menu(Long id, Date date) {
        this.id = id;
        this.date = date;
    }

    public Menu(Long id, Date date, Cantin cantin) {
        this.id = id;
        this.date = date;
        this.cantin = cantin;
    }
}
