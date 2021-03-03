package com.example.employee.Repository;

import com.example.employee.Model.Building;
import com.example.employee.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
