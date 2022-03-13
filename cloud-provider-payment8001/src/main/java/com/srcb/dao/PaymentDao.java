package com.srcb.dao;

import com.srcb.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * The company is 鉴真防务
 * User: 陳佳伟
 * Date: 2022/3/12 下午9:02
 * Description: 多敲多练
 **/

@Mapper
public interface PaymentDao {

    public int add(Payment payment);

    public Payment getPaymentById(@Param("sid") Long sid);
}
