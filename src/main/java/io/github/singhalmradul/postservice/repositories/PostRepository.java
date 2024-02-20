package io.github.singhalmradul.postservice.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.singhalmradul.postservice.model.Post;

public interface PostRepository extends JpaRepository<Post, UUID> {

}