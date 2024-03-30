package io.github.singhalmradul.postservice.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import io.github.singhalmradul.postservice.model.PostByTime;
import io.github.singhalmradul.postservice.model.PostByTimeKey;

public interface PostByTimeRepository extends ReactiveCrudRepository<PostByTime, PostByTimeKey> {}
