package io.github.singhalmradul.postservice.services;

import java.util.List;
import java.util.UUID;

import io.github.singhalmradul.postservice.model.Post;
import io.github.singhalmradul.postservice.model.PostRecord;
import jakarta.servlet.http.Part;

public interface PostService {

    List<PostRecord> getAllPosts(UUID userId);

    boolean existsById(UUID id);

    List<PostRecord> getPostsByUserId(UUID userId);

    List<PostRecord> getFeedPostsByUserId(UUID userId);

    Post createPost(UUID userId, String text, Part part);

    Post createPost(UUID userId, String text);

    Post getPost(UUID id);
}
