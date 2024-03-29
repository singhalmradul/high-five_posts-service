package io.github.singhalmradul.postservice.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import io.github.singhalmradul.postservice.model.Post;
import io.github.singhalmradul.postservice.model.PostKey;

public interface PostRepository extends ReactiveCrudRepository<Post, PostKey> {}