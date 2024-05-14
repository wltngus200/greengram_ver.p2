package com.green.greengramverp2.feed_comment.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResAtGetComment {
    private long userId;
    private long feedId;
    private String comment;
    private String createdAt;
    private String nm;
    private String pic;
}
