package io.github.singhalmradul.postservice.model;

import java.time.Instant;
import java.util.UUID;

public record Post(
    UUID id,
    User user,
    String text,
    String image,
    int likes,
    int comments,
    Instant createdAt
) {
    public Post(PostByUser post, User user) {
        this(
            post.getPostId(),
            user,
            post.getText(),
            post.getImage(),
            post.getLikes(),
            post.getComments(),
            post.getCreatedAt()
        );
    }

    public Post(PostByTime post, User user) {
        this(
            post.getPostId(),
            user,
            post.getText(),
            post.getImage(),
            post.getLikes(),
            post.getComments(),
            post.getCreatedAt()
        );
    }
}
