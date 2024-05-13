package com.green.greengramverp2.user.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class ResAtSignIn {
    private long userId;
    private String pic;
    private String nm;
}
