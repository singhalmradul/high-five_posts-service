package io.github.singhalmradul.postservice.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import io.github.singhalmradul.postservice.model.Post;
import io.github.singhalmradul.postservice.model.User;
import io.github.singhalmradul.postservice.proxies.LikeServiceProxy;
import io.github.singhalmradul.postservice.proxies.UserServiceProxy;
import io.github.singhalmradul.postservice.repositories.PostRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService{

    private PostRepository repository;
    private UserServiceProxy userServiceProxy;
    private LikeServiceProxy likeServiceProxy;

    private Post addData(Post post) {

        User user = userServiceProxy.getUser(post.getUserId());
        int likesCount = likeServiceProxy.getLikesCount(post.getId());

        post.setUser(user);
        post.setLikes(likesCount);
        return post;
    }

    public List<Post> getAllPosts() {

        return repository.findAll().stream().map(this::addData).toList();
    }

    @Override
    public boolean existsById(UUID id) {
        return repository.existsById(id);
    }

}
