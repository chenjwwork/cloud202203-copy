package com.srcb.service.impl;

import com.srcb.dao.PaymentDao;
import com.srcb.entities.Payment;
import com.srcb.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * The company is 鉴真防务
 * User: 陳佳伟
 * Date: 2022/3/12 下午9:54
 * Description: 多敲多练
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    @Override
    public int add(Payment payment) {
        return paymentDao.add(payment);
    }

    @Override
    public Payment getPaymentById(Long sid) {
        return paymentDao.getPaymentById(sid);
    }
}
