package com.pickgo.domain.post.post.entity;

import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PostSortType {
    ID_DESC("최신순", Sort.by(Sort.Direction.DESC, "id")),
    VIEW_DESC("조회순", Sort.by(Sort.Direction.DESC, "views")),
    OPENING_SOON("오픈 임박순", Sort.by(Sort.Direction.ASC, "performance.startDate"));

    private final String value;
    private final Sort sort;
}
