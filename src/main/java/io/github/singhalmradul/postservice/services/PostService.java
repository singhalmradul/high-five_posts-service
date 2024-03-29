package io.github.singhalmradul.postservice.services;

import io.github.singhalmradul.postservice.model.Post;
import reactor.core.publisher.Flux;

public interface PostService {

    Flux<Post> getAllPosts();

}
