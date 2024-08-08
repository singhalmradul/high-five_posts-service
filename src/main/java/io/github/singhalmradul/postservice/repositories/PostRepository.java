package io.github.singhalmradul.postservice.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.singhalmradul.postservice.model.Post;


public interface PostRepository extends MongoRepository<Post, UUID> {

    List<Post> findByUserIdOrderByCreatedAtDesc(UUID userId);

    List<Post> findByUserIdInOrderByCreatedAtDesc(List<UUID> userIds);

    List<Post> findByUserIdNotInOrderByCreatedAtDesc(List<UUID> userIds);
}
