package com.fifteen.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class GeetestForm {

    /**
     * 极验的数据包
     */
    private String geetest_challenge ;
    private String geetest_seccode ;
    private String geetest_validate ;
    private String uuid ;

    public void check(){

    }
}
