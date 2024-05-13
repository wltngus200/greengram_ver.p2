package com.green.greengramverp2.feed;

import com.green.greengramverp2.common.ResultDto;
import com.green.greengramverp2.feed.model.ReqAtGetFeed;
import com.green.greengramverp2.feed.model.ReqAtPostFeed;
import com.green.greengramverp2.feed.model.ResAtGetFeed;
import com.green.greengramverp2.feed.model.ResAtPostFeed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feed")
public class FeedController {
    private final FeedService service;

    @PostMapping
    public ResultDto<ResAtPostFeed> postFeed(@RequestPart List<MultipartFile> pics, @RequestPart ReqAtPostFeed p){
        ResAtPostFeed res=service.postFeed(pics, p);
        return ResultDto.<ResAtPostFeed>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("성공적으로 업로드 했습니다.")
                .resultData(res)
                .build();
    }
    @GetMapping
    public ResultDto<List<ResAtGetFeed>> getFeed(@RequestBody ReqAtGetFeed p){
        return ResultDto.<List<ResAtGetFeed>>builder()
                .build();
    }
}
