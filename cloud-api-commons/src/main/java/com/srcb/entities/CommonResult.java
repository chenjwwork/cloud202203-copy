package com.srcb.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The company is 鉴真防务
 * User: 陳佳伟
 * Date: 2022/3/12 下午9:00
 * Description: 多敲多练
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String message;
    private  T data;


    public  CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
