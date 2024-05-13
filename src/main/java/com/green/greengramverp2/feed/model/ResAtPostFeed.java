package com.green.greengramverp2.feed.model;

import lombok.*;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResAtPostFeed {
    private long userId;
    private List<String> pics;
}
