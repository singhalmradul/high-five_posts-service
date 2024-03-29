package io.github.singhalmradul.postservice.model;

import static org.springframework.data.cassandra.core.cql.Ordering.DESCENDING;
import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.CLUSTERED;
import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.PARTITIONED;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import lombok.Data;

@PrimaryKeyClass
@Data
public class PostKey {

    @PrimaryKeyColumn(
        name = "date_bucket",
        ordinal = -2,
        type = PARTITIONED,
        ordering = DESCENDING
    )
    private LocalDate dateBucket;

    @PrimaryKeyColumn(
        name = "user_id",
        ordinal = -1, type = PARTITIONED
    )
    private UUID userid;

    @PrimaryKeyColumn(
        name = "created_at",
        ordinal = -2,
        type = CLUSTERED,
        ordering = DESCENDING
    )
    private Instant createdAt;

    @PrimaryKeyColumn(
        name = "id",
        ordinal = -1,
        type = CLUSTERED
    )
    private UUID id;
}
