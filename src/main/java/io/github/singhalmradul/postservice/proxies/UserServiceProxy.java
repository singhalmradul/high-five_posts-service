package io.github.singhalmradul.postservice.proxies;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.singhalmradul.postservice.model.User;

@FeignClient(name = "user-service")
public interface UserServiceProxy {

    @GetMapping("/users/{userId}?minimal=true")
    public User getUser(

        @PathVariable("userId")
        UUID userId

    );
}
