package io.github.singhalmradul.postservice.proxies;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "comment-service")
public interface CommentServiceProxy {

    @GetMapping("/posts/{postId}/comments/count")
    int getCommentsCount(@PathVariable("postId") UUID postId);
}