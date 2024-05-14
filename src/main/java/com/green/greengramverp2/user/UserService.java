package com.green.greengramverp2.user;

import com.green.greengramverp2.common.CustomFileUtils;
import com.green.greengramverp2.user.model.ReqAtPostUser;
import com.green.greengramverp2.user.model.ReqAtSignIn;
import com.green.greengramverp2.user.model.ResAtSignIn;
import com.green.greengramverp2.user.model.User;
import lombok.RequiredArgsConstructor;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;
    private final CustomFileUtils utils;

    @Transactional
    int postUser(MultipartFile mf, ReqAtPostUser p){
        //암호화
        String hashPass= BCrypt.hashpw(p.getUpw(),BCrypt.gensalt());
        p.setUpw(hashPass);

        //사진 업로드
        String randomFile=utils.randomFile(mf);
        p.setPic(randomFile);

        int result=mapper.postUser(p);

        String path=String.format("user/%d",p.getUserId());
        utils.makeFolder(path);
        String target=String.format("%s/%s",path,randomFile);
        try{
            utils.transferTo(mf, target);
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return result;
    }
    public ResAtSignIn getUserInfo(ReqAtSignIn p){
        User user=mapper.getUserInfo(p.getUid());
        if(user==null){ throw new RuntimeException("아이디 펑 (∩^o^)⊃━☆");}
        else if(!BCrypt.checkpw(p.getUpw(),user.getUpw())){
            throw new RuntimeException("비밀번호 펑 (∩^o^)⊃━☆");
        }else {
            return ResAtSignIn.builder()
                    .userId(user.getUserId())
                    .pic(user.getPic())
                    .nm(user.getNm())
                    .build();
        }
    }
}
