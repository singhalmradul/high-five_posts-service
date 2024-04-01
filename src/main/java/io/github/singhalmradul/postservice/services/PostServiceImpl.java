package io.github.singhalmradul.postservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import io.github.singhalmradul.postservice.model.Post;
import io.github.singhalmradul.postservice.model.PostModel;
import io.github.singhalmradul.postservice.model.User;
import io.github.singhalmradul.postservice.proxies.LikeServiceProxy;
import io.github.singhalmradul.postservice.proxies.UserServiceProxy;
import io.github.singhalmradul.postservice.repositories.PostByTimeRepository;
import io.github.singhalmradul.postservice.repositories.PostByUserRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService{

    private PostByUserRepository postByUserRepository;
    private PostByTimeRepository postByTimeRepository;
    private UserServiceProxy userServiceProxy;
    private LikeServiceProxy likeServiceProxy;

    private <T extends PostModel> Post createPost(T post) {

        User user = userServiceProxy.getUser(post.getUserId());
        int likesCount = likeServiceProxy.getLikesCount(post.getPostId());

        return new Post(post, user, likesCount);
    }

    public List<Post> getAllPosts() {

        List<Post> posts = new ArrayList<>();
        postByTimeRepository.findAll().forEach(post -> posts.add(this.createPost(post)));
        return posts;
    }

}
