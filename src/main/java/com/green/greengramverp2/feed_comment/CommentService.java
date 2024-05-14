package com.green.greengramverp2.feed_comment;

import com.green.greengramverp2.feed_comment.model.ReqAtPostComment;
import com.green.greengramverp2.feed_comment.model.ResAtGetComment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentMapper mapper;

    public int postComment(ReqAtPostComment p){
        return mapper.postComment(p);
    }

    public List<ResAtGetComment> getComment(long feedId){
        List<ResAtGetComment> list=mapper.getComment(feedId);
        list=list.subList(3, list.size());
        return list;
    }
}
