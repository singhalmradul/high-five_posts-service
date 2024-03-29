package io.github.singhalmradul.postservice.model;

import java.util.UUID;

public record User(UUID id,String displayName,String profilePicture) {}
