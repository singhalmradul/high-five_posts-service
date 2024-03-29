package io.github.singhalmradul.postservice.model;

import java.time.Instant;
import java.util.UUID;

import org.springframework.data.annotation.Transient;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Table
@Data
public class Post {

    @JsonIgnore
    @PrimaryKey
    PostKey key;

    String text;

    String image;

    int likes;

    int comments;

    @Transient
    private User user;

    public UUID getId() {
        return key.getId();
    }

    public UUID getUserId() {
        return key.getUserid();
    }

    public Instant getCreatedAt() {
        return key.getCreatedAt();
    }
}
