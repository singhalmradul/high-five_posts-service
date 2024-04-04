package io.github.singhalmradul.postservice.handlers;

import static org.springframework.web.servlet.function.ServerResponse.ok;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import io.github.singhalmradul.postservice.services.PostService;
import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor_ = @Autowired)
@Component
public class PostHandlerImpl implements PostHandler {

    private final PostService postService;

    @Override
    public ServerResponse getAllPosts(ServerRequest request) {
        UUID userId = UUID.fromString(request.pathVariable("userId"));
        return ok().body(postService.getAllPosts(userId));
    }

    @Override
    public ServerResponse postExists(ServerRequest request) {
        UUID id = UUID.fromString(request.pathVariable("id"));
        return ok().body(postService.existsById(id));
    }

    @Override
    public ServerResponse getPostsByUser(ServerRequest request) {
        UUID userId = UUID.fromString(request.pathVariable("userId"));
        return ok().body(postService.getByUserId(userId));
    }
}
