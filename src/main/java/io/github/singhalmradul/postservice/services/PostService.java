package io.github.singhalmradul.postservice.services;

import java.util.List;
import java.util.UUID;

import io.github.singhalmradul.postservice.model.Post;

public interface PostService {

    List<Post> getAllPosts();

    boolean existsById(UUID id);
}
