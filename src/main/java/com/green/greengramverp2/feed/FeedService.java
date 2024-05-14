package com.green.greengramverp2.feed;

import com.green.greengramverp2.common.CustomFileUtils;
import com.green.greengramverp2.feed.model.*;
import com.green.greengramverp2.feed_comment.CommentService;
import com.green.greengramverp2.feed_comment.model.ResAtGetComment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper mapper;
    private final CustomFileUtils utils;

    @Transactional
    ResAtPostFeed postFeed(List<MultipartFile> pics, ReqAtPostFeed p){
        int result=mapper.postFeed(p);//

        ReqAtPostFeedPics dto= ReqAtPostFeedPics.builder().feedId(p.getUserId()).build();

        //사진 처리
        try {
            String path = String.format("feed/%d", p.getFeedId());
            utils.makeFolder(path);
            for(MultipartFile mf:pics) {
                String name = utils.randomFile(mf);
                String target = String.format("%s/%s", path, name);
                utils.transferTo(mf, target);
                dto.getPics().add(name);}
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }int resultpic=mapper.postFeedPics(dto);
    return ResAtPostFeed.builder()
            .userId(dto.getFeedId())
            .pics(dto.getPics())
            .build();
    }

    public List<ResAtGetFeed> getFeed(ReqAtGetFeed p){
        List<ResAtGetFeed> feeds=mapper.getFeed(p);
        CommentService service;

        for(ResAtGetFeed feed:feeds){
            List<String> upPics=mapper.getFeedPics(feed.getFeedId());
            //뭐 할 게 있나.......?
            feed.setPics(upPics);//feed에 pic 넣기
            List<ResAtGetComment> list=mapper.getFeedCommentOnlyThree(feed.getFeedId());
            if(list.size()==4){
                feed.setMoreComment(1);
                list=list.subList(0, (list.size()-feed.getMoreComment()));
            }feed.setComments(list);

        }
        return feeds;
    }

}
