package io.github.singhalmradul.postservice.handlers;

import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

public interface PostHandler {

    ServerResponse getAllPosts(ServerRequest request);

    ServerResponse postExists(ServerRequest request);

    ServerResponse getPostsByUser(ServerRequest request);

    ServerResponse getFeed(ServerRequest request);

    ServerResponse createPost(ServerRequest request);

    ServerResponse getPost(ServerRequest request);
}