package io.github.singhalmradul.postservice.services;

import org.springframework.stereotype.Service;

import io.github.singhalmradul.postservice.model.Post;
import io.github.singhalmradul.postservice.proxies.UserServiceProxy;
import io.github.singhalmradul.postservice.repositories.PostRepository;
import reactor.core.publisher.Flux;

@Service
public class PostServiceImpl implements PostService{

    private PostRepository postsRepository;
    private UserServiceProxy userServiceProxy;

    public PostServiceImpl(PostRepository postsRepository, UserServiceProxy userServiceProxy) {
        this.postsRepository = postsRepository;
        this.userServiceProxy = userServiceProxy;
    }


    private Post addUser(Post post) {
        // User user = userServiceProxy.getUser(post.getUserId());
        // post.setUser(user);
        return post;
    }
    public Flux<Post> getAllPosts() {

        var posts = postsRepository.findAll();
        return posts.map(this::addUser);

    }

}
