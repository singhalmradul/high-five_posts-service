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
    public <T extends PostModel> Post(T post, User user, int likesCount) {
        this(
            post.getPostId(),
            user,
            post.getText(),
            post.getImage(),
            likesCount,
            post.getComments(),
            post.getCreatedAt()
        );
    }
}
