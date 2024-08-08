package io.github.singhalmradul.postservice.model;

import java.time.Instant;
import java.util.UUID;

public record PostRecord(
    String text,
    String embed,
    int likesCount,
    int commentsCount,
    UUID id,
    User user,
    Instant createdAt,
    boolean isLiked
) {

    public PostRecord(Post post, User user, int likesCount, int commentsCount, boolean isLiked) {
        this(
            post.getText(),
            post.getEmbed(),
            likesCount,
            commentsCount,
            post.getId(),
            user,
            post.getCreatedAt(),
            isLiked
        );
    }
}
