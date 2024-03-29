package io.github.singhalmradul.postservice.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.singhalmradul.postservice.model.Post;
import io.github.singhalmradul.postservice.services.PostService;
import reactor.core.publisher.Flux;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping(path = "/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public Flux
    <Post> getAllPosts() {

        return postService.getAllPosts();

    }

}
