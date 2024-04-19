package io.github.singhalmradul.postservice.model;

import java.time.Instant;
import java.util.UUID;

public record PostRecord(
    String text,
    String embed,
    int likes,
    int comments,
    UUID id,
    User user,
    Instant createdAt,
    boolean isLiked
) {

    public PostRecord(Post post, User user, int likes, int comments, boolean isLiked) {
        this(
            post.getText(),
            post.getEmbed(),
            likes,
            comments,
            post.getId(),
            user,
            post.getCreatedAt(),
            isLiked
        );
    }
}
