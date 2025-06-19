package com.pickgo.domain.post.post.dto;

import java.time.LocalDate;

import com.pickgo.domain.post.post.entity.Post;

public record PostSimpleResponse(
    Long id,
    String title,
    Long views,
    LocalDate startDate,
    LocalDate endDate,
    String poster,
    String venue
) {
    public static PostSimpleResponse from(Post post) {
        return new PostSimpleResponse(
            post.getId(),
            post.getTitle(),
            post.getViews(),
            post.getPerformance().getStartDate(),
            post.getPerformance().getEndDate(),
            post.getPerformance().getPoster(),
            post.getPerformance().getVenue().getName()
        );
    }
}
