package io.github.singhalmradul.postservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.singhalmradul.postservice.model.Post;
import io.github.singhalmradul.postservice.model.User;
import io.github.singhalmradul.postservice.proxies.UserServiceProxy;
import io.github.singhalmradul.postservice.repositories.PostRepository;

@Service
public class PostServiceImpl implements PostService{

    private PostRepository postsRepository;
    private UserServiceProxy userServiceProxy;

    public PostServiceImpl(PostRepository postsRepository, UserServiceProxy userServiceProxy) {
        this.postsRepository = postsRepository;
        this.userServiceProxy = userServiceProxy;
    }


    private void addUser(Post post) {
        User user = userServiceProxy.getUser(post.getUserId());
        post.setUser(user);
    }
    public List<Post> getAllPosts() {

        List<Post> posts = postsRepository.findAll();
        posts.forEach(this::addUser);
        return posts;

    }

}
