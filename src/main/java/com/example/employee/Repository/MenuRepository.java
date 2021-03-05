package com.example.employee.Repository;

import com.example.employee.Model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Query(value = "SELECT m.id, date, id_cantin, md.id_dish FROM menu m join menu_dish md on m.id = md.id_menu", nativeQuery = true)
    List<Menu> getAll();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO menu_dish (id_menu, id_dish) VALUES (:id_menu, :id_dish)", nativeQuery = true)
    void insertDishIntoMenu(@Param("id_menu") Long id_menu, @Param("id_dish") Long id_dish);

    @Transactional
    @Modifying
    @Query(value = "update Menu m set m.date = :date where m.id = :id", nativeQuery = true)
    void editDateOfMenu(@Param("id") Long id, @Param("date") Date date);

}
