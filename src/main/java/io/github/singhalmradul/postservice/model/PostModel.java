package io.github.singhalmradul.postservice.model;

import java.time.Instant;
import java.util.UUID;

public interface PostModel {

        UUID getPostId();

        String getText();

        String getImage();

        int getComments();

        Instant getCreatedAt();

        UUID getUserId();
}
