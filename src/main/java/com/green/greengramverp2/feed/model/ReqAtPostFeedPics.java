package com.green.greengramverp2.feed.model;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class ReqAtPostFeedPics {
    private long feedId;
    @Builder.Default
    private List<String> pics=new ArrayList();
}
