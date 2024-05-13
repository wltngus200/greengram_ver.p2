package com.green.greengramverp2.feed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.green.greengramverp2.common.Paging;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResAtGetFeed {
    private long feedId;
    private long userId;
    private String nm;
    private String pic;
    private String contents;
    private String location;
    private String createdAt;
}