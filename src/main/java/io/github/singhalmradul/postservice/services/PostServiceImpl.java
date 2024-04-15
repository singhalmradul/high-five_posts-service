package io.github.singhalmradul.postservice.services;

import static java.util.UUID.randomUUID;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.singhalmradul.postservice.model.IdOnly;
import io.github.singhalmradul.postservice.model.Post;
import io.github.singhalmradul.postservice.model.PostRecord;
import io.github.singhalmradul.postservice.model.User;
import io.github.singhalmradul.postservice.proxies.FollowServiceProxy;
import io.github.singhalmradul.postservice.proxies.LikeServiceProxy;
import io.github.singhalmradul.postservice.proxies.UserServiceProxy;
import io.github.singhalmradul.postservice.repositories.PostRepository;
import io.github.singhalmradul.postservice.utilities.CloudinaryUtilities;
import jakarta.servlet.http.Part;
import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor_ = @Autowired)
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository repository;
    private final UserServiceProxy userServiceProxy;
    private final LikeServiceProxy likeServiceProxy;
    private final FollowServiceProxy followServiceProxy;
    private final CloudinaryUtilities cloudinary;

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
    public List<PostRecord> getPostsByUserId(UUID userId) {

        return addData(repository.findByUserIdOrderByCreatedAt(userId), userId);
    }

    @Override
    public List<PostRecord> getFeedPostsByUserId(UUID userId) {

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

    @Override
    @Transactional
    public Post createPost(UUID userId, String text, Part part) {


        Post post = new Post();
        UUID id = randomUUID();
        String embedUrl = cloudinary.uploadWithId(part, id.toString());

        post.setId(id);
        post.setUserId(userId);
        post.setText(text);
        post.setEmbed(embedUrl);
        post.setCreatedAt(Instant.now());

        return repository.save(post);
    }

    @Override
    @Transactional
    public Post createPost(UUID userId, String text) {

        Post post = new Post();

        post.setUserId(userId);
        post.setId(randomUUID());
        post.setText(text);
        post.setCreatedAt(Instant.now());

        return repository.save(post);
    }

    @Override
    public Post getPost(UUID id) {
        return repository.findById(id).orElseThrow();
    }
}
