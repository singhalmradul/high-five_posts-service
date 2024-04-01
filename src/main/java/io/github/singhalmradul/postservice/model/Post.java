package io.github.singhalmradul.postservice.model;

import java.time.Instant;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Data
@Document(collection = "posts")
public class Post {

    private String text;

    private String image;

    private int likes;

    private int comments;

    @Id
    private UUID id;

    @JsonIgnore
    private UUID userId;

    private Instant createdAt;

    @Transient
    private User user;
}
