package io.github.singhalmradul.postservice.handlers;

import static org.springframework.web.servlet.function.ServerResponse.created;
import static org.springframework.web.servlet.function.ServerResponse.ok;

import java.io.IOException;
import java.net.URI;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebInputException;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import io.github.singhalmradul.postservice.model.Post;
import io.github.singhalmradul.postservice.services.PostService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Part;
import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor_ = @Autowired)
@Component
public class PostHandlerImpl implements PostHandler {

    private static final String USER_ID = "userId";
    private final PostService service;


    @Override
    public ServerResponse getAllPosts(ServerRequest request) {
        UUID userId = UUID.fromString(request.pathVariable(USER_ID));
        return ok().body(service.getAllPosts(userId));
    }

    @Override
    public ServerResponse postExists(ServerRequest request) {
        UUID id = UUID.fromString(request.pathVariable("id"));
        return ok().body(service.existsById(id));
    }

    @Override
    public ServerResponse getPostsByUser(ServerRequest request) {
        UUID userId = UUID.fromString(request.pathVariable(USER_ID));
        UUID loggedInUserId = UUID.fromString(request.param(USER_ID).orElse(null));
        return ok().body(service.getPostsByUserId(userId, loggedInUserId));
    }

    @Override
    public ServerResponse getFeedPosts(ServerRequest request) {
        UUID userId = UUID.fromString(request.pathVariable(USER_ID));
        return ok().body(service.getFeedPostsByUserId(userId));
    }

    @Override
    public ServerResponse createPost(ServerRequest request) {

        try {
            UUID userId = UUID.fromString(request.pathVariable(USER_ID));
            String text = request.param("text").orElse(null);
            Part file = request.multipartData().getFirst("embed");
            Post post = service.createPost(userId, text, file);

            return created(URI.create("/posts/" + post.getId())).body(post);

        } catch (
            ServletException
            | IOException
            | IllegalArgumentException
            | NullPointerException e
        ) {
            e.printStackTrace();
            throw new ServerWebInputException(e.getMessage());
        }
    }

    @Override
    public ServerResponse getPost(ServerRequest request) {

        UUID id = UUID.fromString(request.pathVariable("id"));
        Post post = service.getPost(id);

        return ok().body(post);
    }

    @Override
    public ServerResponse getExplorePosts(ServerRequest request) {

        UUID id = UUID.fromString(request.pathVariable(USER_ID));
        return ok().body(service.getExplorePosts(id));
    }
}
