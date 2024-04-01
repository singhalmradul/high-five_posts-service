package io.github.singhalmradul.postservice.repositories;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.singhalmradul.postservice.model.Post;

public interface PostRepository extends MongoRepository<Post, UUID> {}
