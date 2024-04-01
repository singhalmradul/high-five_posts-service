package io.github.singhalmradul.postservice.handlers;

import static org.springframework.web.servlet.function.ServerResponse.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import io.github.singhalmradul.postservice.services.PostService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class PostHandler {

    private final PostService postService;

    public ServerResponse getAllPosts(ServerRequest request) {
        return ok()
            .body(postService.getAllPosts());
    }
}
