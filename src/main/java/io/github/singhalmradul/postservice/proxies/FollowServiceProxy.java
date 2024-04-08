package io.github.singhalmradul.postservice.proxies;

import java.util.List;
import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.singhalmradul.postservice.model.IdOnly;

@FeignClient(name = "follow-service")
public interface FollowServiceProxy {

    @GetMapping("/users/{userId}/followers")
    List<IdOnly> getFollowers(@PathVariable("userId") UUID userId);

    @GetMapping("/users/{userId}/following")
    List<IdOnly> getFollowing(@PathVariable("userId") UUID userId);
}
