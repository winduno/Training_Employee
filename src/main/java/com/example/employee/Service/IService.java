package com.example.employee.Service;

import java.util.List;
import java.util.Optional;

public interface IService<T> {
    List<T> getAll();

    void save(T t);

    Optional<T> findById(Long id);

    void delete(Long id);
}
