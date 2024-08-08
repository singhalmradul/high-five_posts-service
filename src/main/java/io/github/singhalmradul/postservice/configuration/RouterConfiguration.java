package io.github.singhalmradul.postservice.configuration;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA;
import static org.springframework.web.servlet.function.RequestPredicates.accept;
import static org.springframework.web.servlet.function.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import io.github.singhalmradul.postservice.handlers.PostHandler;

@Configuration
public class RouterConfiguration {

    @Bean
    RouterFunction<ServerResponse> likeRouter(PostHandler handler) {

        return (
            route()
            .path("/posts", builder -> builder
                .GET("/{id}", handler::getPost)
                .GET("/{id}/exists", handler::postExists)
                .GET(handler::getAllPosts)
            )
            .path("/users/{userId}/posts", builder -> builder
                .POST(accept(MULTIPART_FORM_DATA), handler::createPost)
                .GET("/feed", handler::getFeedPosts)
                .GET("/explore", handler::getExplorePosts)
                .GET(handler::getPostsByUser)
            )
            .build()
        );
    }
}
