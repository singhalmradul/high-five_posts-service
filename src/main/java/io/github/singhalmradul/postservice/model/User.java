package io.github.singhalmradul.postservice.model;

import java.util.UUID;

public record User(UUID id,String username,String profilePicture) {}
