package com.review.model;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Table
@Data
public class Review {
    public Review(UUID reviewId,long driverId, String content, Date postDate, Date lastModifiedDate, long nb_likes) {
        this.reviewId = reviewId;
        this.driverId=driverId;
        this.content = content;
        this.postDate = postDate;
        this.lastModifiedDate = lastModifiedDate;
        this.nb_likes = nb_likes;
    }

    @PrimaryKey
    private UUID reviewId;
    private long driverId;
    private String content;
    private Date postDate;
    private Date lastModifiedDate;
    private long nb_likes;

}
