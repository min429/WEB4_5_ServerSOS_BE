package com.pickgo.domain.post.review.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pickgo.domain.member.member.entity.Member;
import com.pickgo.domain.post.review.entity.Review;
import com.pickgo.domain.post.review.entity.ReviewLike;

@Repository
public interface ReviewLikeRepository extends JpaRepository<ReviewLike, Long> {

    Optional<ReviewLike> findByMemberAndReview(Member member, Review review);

    boolean existsByMemberAndReview(Member member, Review review);

    void deleteByMemberAndReview(Member member, Review review);

    int countReviewLikeByReview_Id(Long reviewId);
}
