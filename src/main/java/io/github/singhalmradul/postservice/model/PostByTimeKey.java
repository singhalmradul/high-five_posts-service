package io.github.singhalmradul.postservice.model;

import static org.springframework.data.cassandra.core.cql.Ordering.DESCENDING;
import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.CLUSTERED;
import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.PARTITIONED;

import java.time.Instant;
import java.time.LocalDate;

import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import lombok.Data;

@PrimaryKeyClass
@Data
public class PostByTimeKey {

    @PrimaryKeyColumn(
        name = "date_bucket",
        type = PARTITIONED,
        ordering = DESCENDING
    )
    private LocalDate dateBucket;

    @PrimaryKeyColumn(
        name = "created_at",
        type = CLUSTERED,
        ordering = DESCENDING
    )
    private Instant createdAt;
}
