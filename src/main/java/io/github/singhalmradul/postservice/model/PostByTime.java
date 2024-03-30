package io.github.singhalmradul.postservice.model;

import java.time.Instant;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Table("post_by_time")
@Data
public class PostByTime {

    @JsonIgnore
    @PrimaryKey
    PostByTimeKey key;

    String text;

    String image;

    int likes;

    int comments;

    @Column("post_id")
    UUID postId;

    @Column("user_id")
    UUID userId;

    public Instant getCreatedAt() {
        return key.getCreatedAt();
    }
}
