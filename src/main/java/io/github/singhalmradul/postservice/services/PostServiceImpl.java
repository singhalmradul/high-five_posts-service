package io.github.singhalmradul.postservice.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.singhalmradul.postservice.model.IdOnly;
import io.github.singhalmradul.postservice.model.Post;
import io.github.singhalmradul.postservice.model.PostRecord;
import io.github.singhalmradul.postservice.model.User;
import io.github.singhalmradul.postservice.proxies.FollowServiceProxy;
import io.github.singhalmradul.postservice.proxies.LikeServiceProxy;
import io.github.singhalmradul.postservice.proxies.UserServiceProxy;
import io.github.singhalmradul.postservice.repositories.PostRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor_ = @Autowired)
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository repository;
    private final UserServiceProxy userServiceProxy;
    private final LikeServiceProxy likeServiceProxy;
    private final FollowServiceProxy followServiceProxy;

    private PostRecord addData(Post post, UUID userId) {

        User user = userServiceProxy.getUser(post.getUserId());
        int likesCount = likeServiceProxy.getLikesCount(post.getId());
        boolean isLiked = likeServiceProxy.isLikedByUser(post.getId(), userId);

        return new PostRecord(post, user, likesCount, isLiked);
    }

    private List<PostRecord> addData(List<Post> posts, UUID userId) {

        return posts.stream().map(post -> addData(post, userId)).toList();
    }
    public List<PostRecord> getAllPosts(UUID userId) {

        return addData(repository.findAll(), userId);
    }

    @Override
    public boolean existsById(UUID id) {
        return repository.existsById(id);
    }

    @Override
    public List<PostRecord> getByUserId(UUID userId) {

        return addData(repository.findByUserIdOrderByCreatedAt(userId), userId);
    }

    @Override
    public List<PostRecord> getFeedByUserId(UUID userId) {

        List<IdOnly> following = followServiceProxy.getFollowing(userId);
        List<PostRecord> feed = new ArrayList<>();
        following.forEach(user ->
            feed.addAll(
                addData(
                    repository.findByUserIdOrderByCreatedAt(user.id()),
                    userId
                )
            )
        );

        return feed;
    }
}
