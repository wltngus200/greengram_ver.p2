package com.green.greengramverp2.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Getter
@Setter
public class Paging {
    @JsonIgnore
    private int startIdx;

    private int length;
    private int page;

    @ConstructorProperties({"page", "size"})
    public Paging(Integer page, Integer length){
        this.page = (page==null?1:page);
        this.length = (length==null?15:length);
        this.startIdx = (this.page-1)*this.length;
    }

    //1페이지 1~15
    //2페이지 16~30
    //3페이지 31~45
}
