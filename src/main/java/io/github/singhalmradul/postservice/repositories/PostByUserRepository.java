package io.github.singhalmradul.postservice.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import io.github.singhalmradul.postservice.model.PostByUser;
import io.github.singhalmradul.postservice.model.PostByUserKey;

public interface PostByUserRepository extends ReactiveCrudRepository<PostByUser, PostByUserKey> {}