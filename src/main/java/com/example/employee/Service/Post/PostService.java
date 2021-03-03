package com.example.employee.Service.Post;

import com.example.employee.Model.Post;
import com.example.employee.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService implements IPostService{

    @Autowired
    private PostRepository postRepository;

    @Override
    public Iterable<Post> getAll() {
        return this.postRepository.findAll();
    }

    @Override
    public Post save(Post post) {
        return this.postRepository.save(post);
    }

    @Override
    public Optional<Post> findById(Long id) {
        return this.postRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        this.postRepository.deleteById(id);
    }
}
