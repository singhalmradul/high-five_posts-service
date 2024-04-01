package io.github.singhalmradul.postservice.repositories;

import org.springframework.data.repository.CrudRepository;

import io.github.singhalmradul.postservice.model.PostByUser;
import io.github.singhalmradul.postservice.model.PostByUserKey;

public interface PostByUserRepository extends CrudRepository<PostByUser, PostByUserKey> {}