package com.example.employee.Repository;

import com.example.employee.Model.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface BuildingRepository extends JpaRepository<Building, Long> {

    @Query(value = "SELECT building.id, building.address, building.name FROM building", nativeQuery = true)
    List<Building> getAll();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO building (address, name) values (:address, :name)", nativeQuery = true)
    void save(@Param("address") String address, @Param("name") String name);

    @Query(value = "SELECT FROM building where id = :id", nativeQuery = true)
    Optional<Building> findById(@Param("id") Long id);

    @Modifying
    @Query(value = "DELETE FROM building where id = :id", nativeQuery = true)
    void delete(@Param("id") Long id);
}
