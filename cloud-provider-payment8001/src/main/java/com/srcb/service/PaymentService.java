package com.srcb.service;

import com.srcb.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * The company is 鉴真防务
 * User: 陳佳伟
 * Date: 2022/3/12 下午9:53
 * Description: 多敲多练
 **/
public interface PaymentService {

    public int add(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
