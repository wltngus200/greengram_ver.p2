package com.green.greengramverp2.feed.model;


import com.green.greengramverp2.feed_comment.model.ResAtGetComment;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ResAtGetFeed {
    private long feedId;
    private long userId;
    private String nm;
    private String pic;
    private String contents;
    private String location;
    private String createdAt;

    private List<String> pics;
    private List<ResAtGetComment> comments;
    private int moreComment;
}