package io.github.singhalmradul.postservice.model;

import java.time.Instant;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Table("post_by_user")
@Data
public class PostByUser {

    @JsonIgnore
    @PrimaryKey
    private PostByUserKey key;

    private String text;

    private String image;

    private int likes;

    private int comments;

    @Column("created_at")
    private Instant createdAt;

    public UUID getPostId() {
        return key.getPostId();
    }

    public UUID getUserId() {
        return key.getUserid();
    }

}
