package com.green.greengramverp2.feed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
public class ReqAtPostFeed{
    @JsonIgnore
    private long userId;

    private String contents;
    private String location;
    private List<MultipartFile> pics;
}
