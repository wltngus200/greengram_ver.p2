package com.green.greengramverp2.feed;

import com.green.greengramverp2.common.ResultDto;
import com.green.greengramverp2.feed.model.ReqAtGetFeed;
import com.green.greengramverp2.feed.model.ReqAtPostFeed;
import com.green.greengramverp2.feed.model.ResAtGetFeed;
import com.green.greengramverp2.feed.model.ResAtPostFeed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Slf4j
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
                .resultMsg("성 *(੭*ˊᵕˋ)੭*ଘ 공")
                .resultData(res)
                .build();
    }
    @GetMapping
    public ResultDto<List<ResAtGetFeed>> getFeed(@ModelAttribute @ParameterObject ReqAtGetFeed p){
        List<ResAtGetFeed> list= service.getFeed(p);
        return ResultDto.<List<ResAtGetFeed>>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("。(๑•̀ㅂ•́)و✧ 와자뵹")
                .resultData(list)
                .build();
    }
}
