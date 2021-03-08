package com.example.employee.Repository;

import com.example.employee.Model.Cantin;
import com.example.employee.Model.DTO.CantinObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CantinRepository extends JpaRepository<Cantin, Long> {

    @Query("SELECT new com.example.employee.Model.Cantin(c.id, c.chefs, c.income, c.outcome, c.building) FROM Cantin c")
    List<Cantin> getAll();

    @Query(value = "SELECT c.id, chefs, income, outcome, id_building, b.name, b.address FROM Cantin c INNER JOIN Building b ON c.id_building = b.id", nativeQuery = true)
    List<CantinObj> getAllCantinCustom();

    @Transactional
    @Modifying
    @Query( value = "INSERT INTO cantin (chefs, income, outcome, id_building) values (:chefs, :income, :outcome, :id_building)",nativeQuery = true)
    void save(@Param("chefs") String chefs, @Param("income") Double income, @Param("outcome") Double outcome, @Param("id_building") Long idbuilding);
}

