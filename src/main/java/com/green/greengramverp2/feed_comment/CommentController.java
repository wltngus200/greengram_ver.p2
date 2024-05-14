package com.green.greengramverp2.feed_comment;

import com.green.greengramverp2.common.ResultDto;
import com.green.greengramverp2.feed_comment.model.ReqAtPostComment;
import com.green.greengramverp2.feed_comment.model.ResAtGetComment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/feed/comment")//?? 매핑이 필요한가???? 피드에 소속된 경우
@RequiredArgsConstructor
public class CommentController {
    private final CommentService service;

    @PostMapping
    public ResultDto<Integer> postComment(@RequestBody ReqAtPostComment p){
        int result=service.postComment(p);
        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("ヽ(✿ﾟ▽ﾟ)ノ 뾰로롱")
                .resultData(result)
                .build();
    }

    @GetMapping
    public ResultDto<List<ResAtGetComment>> getComment(long feedId){
        List<ResAtGetComment> list=service.getComment(feedId);
        return ResultDto.<List<ResAtGetComment>>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("좋아 o(*°▽°*)o 좋아")
                .resultData(list)
                .build();
    }
}
