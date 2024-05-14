package com.green.greengramverp2.user;

import com.green.greengramverp2.common.ResultDto;
import com.green.greengramverp2.user.model.ReqAtPostUser;
import com.green.greengramverp2.user.model.ReqAtSignIn;
import com.green.greengramverp2.user.model.ResAtSignIn;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api/user")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService service;

    @PostMapping("sign-up")
    @Operation(summary = "USER SIGN-IN", description = "프로필 사진은 필수가 아님")
    public ResultDto<Integer> postUser(@RequestPart(required = false) MultipartFile pic, @RequestPart ReqAtPostUser p){
        int result=service.postUser(pic, p);
        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("( ﾉ ﾟｰﾟ)ﾉ 얼쑤")
                .resultData(result)
                .build();

        //return ResultDto.resultDto(HttpStatus.OK,HttpStatus.OK.toString(),result);

    }
    @PostMapping("sign-in")
    public ResultDto<ResAtSignIn> getUserInfo(@RequestBody ReqAtSignIn p){
        ResAtSignIn result=service.getUserInfo(p);
        return ResultDto.<ResAtSignIn>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("로그인 펑 (∩^o^)⊃━☆")
                .resultData(result)
                .build();
    }

}
