package com.green.greengramverp2.feed_comment;

import com.green.greengramverp2.feed_comment.model.ReqAtPostComment;
import com.green.greengramverp2.feed_comment.model.ResAtGetComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    int postComment(ReqAtPostComment p);
    List<ResAtGetComment> getComment(long feedId);
}
