package com.green.greengramverp2.feed;

import com.green.greengramverp2.common.CustomFileUtils;
import com.green.greengramverp2.feed.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper mapper;
    private final CustomFileUtils utils;

    @Transactional
    ResAtPostFeed postFeed(List<MultipartFile> pics, ReqAtPostFeed p){
        int result=mapper.postFeed(p);

        PostFeedDto dto=PostFeedDto.builder().userId(p.getUserId()).build();

        //사진 처리
        try {
            String path = String.format("feed/%d", p.getUserId());
            utils.makeFolder(path);
            for(MultipartFile mf:pics) {
                String name = utils.randomFile(mf);
                dto.getPics().add(name);
                String target = String.format("%s/%s", path, name);
                utils.transferTo(mf, target);}
            }catch(Exception e){
                e.printStackTrace();
                throw new RuntimeException();
            }int resultpic=mapper.postFeedPics(dto);
    return ResAtPostFeed.builder()
            .userId(dto.getUserId())
            .pics(dto.getPics())
            .build();
    }

    public List<ResAtGetFeed> getFeed(ReqAtGetFeed p){
        mapper.getFeed(p);
        return null;
    }

}
