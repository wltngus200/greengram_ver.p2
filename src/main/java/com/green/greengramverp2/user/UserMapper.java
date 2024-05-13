package com.green.greengramverp2.user;

import com.green.greengramverp2.user.model.ReqAtPostUser;
import com.green.greengramverp2.user.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int postUser(ReqAtPostUser p);


    User getUserInfo(String uid);
}
