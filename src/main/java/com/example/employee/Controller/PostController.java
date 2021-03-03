package com.example.employee.Controller;

import com.example.employee.Model.Post;
import com.example.employee.Service.Post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private IPostService postService;

    @GetMapping
    public ResponseEntity<Iterable<Post>> getAllPost(){
        return new ResponseEntity<>(this.postService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable(name = "id") Long id){
        Optional<Post> optionalPost = this.postService.findById(id);
        return optionalPost.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Post> addPost(@RequestBody Post post){
        return new ResponseEntity<>(this.postService.save(post), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Post> deletePostById(@PathVariable(name = "id") Long id){
        Optional<Post> optionalPost = this.postService.findById(id);
        if (optionalPost.isPresent()){
            this.postService.delete(id);
            return new ResponseEntity<>( HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
