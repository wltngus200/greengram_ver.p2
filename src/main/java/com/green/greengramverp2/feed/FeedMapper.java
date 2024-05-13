package com.green.greengramverp2.feed;

import com.green.greengramverp2.feed.model.PostFeedDto;
import com.green.greengramverp2.feed.model.ReqAtGetFeed;
import com.green.greengramverp2.feed.model.ReqAtPostFeed;
import com.green.greengramverp2.feed.model.ResAtGetFeed;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface FeedMapper {
    int postFeed(ReqAtPostFeed p);
    int postFeedPics(PostFeedDto p); //DTO는 DB에 쿼리문을 INSERT

    ResAtGetFeed getFeed(ReqAtGetFeed p);
}
