package com.green.greengramverp2.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqAtPostUser {
    @JsonIgnore
    private long userId;

    private String uid;
    private String upw;
    private String nm;

    @JsonIgnore
    private String pic;

}
