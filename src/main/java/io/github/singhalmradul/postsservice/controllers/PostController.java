package io.github.singhalmradul.postsservice.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.singhalmradul.postsservice.model.Post;
import io.github.singhalmradul.postsservice.services.PostService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping(path = "/posts")
public class PostController {

    private PostService postService;

    /**
     * @param postService
     */
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts() {

        return postService.getAllPosts();

    }

}
