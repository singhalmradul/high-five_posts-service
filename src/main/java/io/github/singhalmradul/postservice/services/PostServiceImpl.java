package io.github.singhalmradul.postservice.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import io.github.singhalmradul.postservice.model.Post;
import io.github.singhalmradul.postservice.model.PostByTime;
import io.github.singhalmradul.postservice.model.PostByUser;
import io.github.singhalmradul.postservice.model.User;
import io.github.singhalmradul.postservice.proxies.UserServiceProxy;
import io.github.singhalmradul.postservice.repositories.PostByTimeRepository;
import io.github.singhalmradul.postservice.repositories.PostByUserRepository;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService{

    private PostByUserRepository postByUserRepository;
    private PostByTimeRepository postByTimeRepository;
    private UserServiceProxy userServiceProxy;

    private Post createPost(PostByUser post) {
        // User user = userServiceProxy.getUser(post.getUserId());
        // post.setUser(user);
        return new Post(post, new User(UUID.randomUUID(), "test", "test"));
    }

    private Post createPost(PostByTime post) {
        // User user = userServiceProxy.getUser(post.getUserId());
        // post.setUser(user);
        return new Post(post, new User(UUID.randomUUID(), "test", "test"));
    }
    public Flux<Post> getAllPosts() {

        var posts = postByTimeRepository.findAll();
        return posts.map(this::createPost);

    }

}
