package com.green.greengramverp2.feed.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class PostFeedDto {
    private long userId;
    private List<String> pics=new ArrayList();
}
