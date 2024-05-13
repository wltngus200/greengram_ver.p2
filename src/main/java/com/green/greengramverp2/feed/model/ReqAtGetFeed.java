package com.green.greengramverp2.feed.model;

import com.green.greengramverp2.common.GlobalNum;
import com.green.greengramverp2.common.Paging;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.BindParam;


@Getter
@Setter
public class ReqAtGetFeed extends Paging {
    private long signedUserId;
    public ReqAtGetFeed(Integer page, Integer length, @BindParam("signed_user_id") long signedUserId) {
        super(page, length==null?GlobalNum.DEFAULT_PAGE:length);
        this.signedUserId=signedUserId;
    }
}
