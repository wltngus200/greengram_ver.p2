package com.green.greengramverp2.feed;

import com.green.greengramverp2.feed.model.*;
import com.green.greengramverp2.feed_comment.model.ResAtGetComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface FeedMapper {
    int postFeed(ReqAtPostFeed p);
    int postFeedPics(ReqAtPostFeedPics p); //DTO는 DB에 쿼리문을 INSERT

    List<ResAtGetFeed> getFeed(ReqAtGetFeed p);
    List<String> getFeedPics(long feedId);

    List<ResAtGetComment> getFeedCommentOnlyThree(long feedId);
}
