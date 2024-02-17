package io.github.singhalmradul.postsservice.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.singhalmradul.postsservice.model.Post;

public interface PostsRepository extends JpaRepository<Post, UUID> {

}