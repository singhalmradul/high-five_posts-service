package io.github.singhalmradul.postservice.services;

import java.util.List;
import java.util.UUID;

import io.github.singhalmradul.postservice.model.PostRecord;

public interface PostService {

    List<PostRecord> getAllPosts(UUID userId);

    boolean existsById(UUID id);

    List<PostRecord> getByUserId(UUID userId);

    List<PostRecord> getFeed(UUID userId);
}
