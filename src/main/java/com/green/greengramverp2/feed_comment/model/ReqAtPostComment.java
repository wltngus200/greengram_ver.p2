package com.green.greengramverp2.feed_comment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ReqAtPostComment {
    @JsonIgnore
    private long commentId;

    private long userId;
    private long feedId;
    private String comment;
}
