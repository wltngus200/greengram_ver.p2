package com.green.greengramverp2.common;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
public class ResultDto<T> {
    private HttpStatus statusCode;
    private String resultMsg;
    private T resultData;

    public static <T> ResultDto<T> resultDto(HttpStatus code, String msg, T data) {
        return ResultDto.<T>builder().statusCode(code).resultMsg(msg)
                .resultData(data).build();
    }
}
