package io.github.singhalmradul.postsservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.singhalmradul.postsservice.model.Post;
import io.github.singhalmradul.postsservice.repositories.PostsRepository;

@Service
public class PostService {

    private PostsRepository postsRepository;

    /**
     * @param postsRepository
     */
    public PostService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    public List<Post> getAllPosts() {

        return postsRepository.findAll();
    }

}
