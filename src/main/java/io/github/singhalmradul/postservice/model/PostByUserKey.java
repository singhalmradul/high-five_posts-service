package io.github.singhalmradul.postservice.model;

import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.CLUSTERED;
import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.PARTITIONED;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import lombok.Data;

@PrimaryKeyClass
@Data
public class PostByUserKey {


    @PrimaryKeyColumn(
        name = "user_id",
        type = PARTITIONED
    )
    private UUID userid;

    @PrimaryKeyColumn(
        name = "post_id",
        type = CLUSTERED
    )
    private UUID postId;
}
