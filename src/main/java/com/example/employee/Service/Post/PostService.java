package com.example.employee.Service.Post;

import com.example.employee.Model.Post;
import com.example.employee.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAll() {
        return this.postRepository.findAll();
    }

    public void save(Post post) {
        this.postRepository.save(post);
    }

    public Optional<Post> findById(Long id) {
        return this.postRepository.findById(id);
    }

    public void delete(Long id) {
        this.postRepository.deleteById(id);
    }
}
