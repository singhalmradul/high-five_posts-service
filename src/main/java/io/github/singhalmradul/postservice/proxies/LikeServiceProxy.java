package io.github.singhalmradul.postservice.proxies;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "like-service")
public interface LikeServiceProxy {

    @GetMapping("/posts/{postId}/likes/count")
    int getLikesCount(@PathVariable("postId") UUID postId);

    @GetMapping("/posts/{postId}/likes/{userId}")
    boolean isLikedByUser(@PathVariable("postId") UUID postId, @PathVariable("userId") UUID userId);
}