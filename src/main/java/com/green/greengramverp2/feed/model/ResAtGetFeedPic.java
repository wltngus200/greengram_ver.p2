package com.green.greengramverp2.feed.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResAtGetFeedPic {
    private List<String> pics;
    private long feedId;
}
