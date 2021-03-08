package com.example.employee.Repository;

import com.example.employee.Model.Building;
import com.example.employee.Model.DTO.BuildingObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface BuildingRepository extends JpaRepository<Building, Long> {

    @Query("SELECT new com.example.employee.Model.Building(b.id, b.name, b.address) FROM Building b")
    List<Building> getAll();

    @Query(value = "SELECT * FROM Building b", nativeQuery = true)
    List<BuildingObj> getAllCustom();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO building (address, name) values (:address, :name)", nativeQuery = true)
    void save(@Param("address") String address, @Param("name") String name);

    @Query("SELECT new com.example.employee.Model.Building(b.id, b.name, b.address) FROM Building b where b.id = :id")
    Optional<Building> findById(@Param("id") Long id);

    @Query(value = "SELECT * FROM Building b where b.id = :id", nativeQuery = true)
    Optional<BuildingObj> findBuildingById(@Param("id") Long id);

    @Modifying
    @Query(value = "DELETE FROM building where id = :id", nativeQuery = true)
    void delete(@Param("id") Long id);
}
