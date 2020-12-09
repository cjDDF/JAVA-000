package com.ddf.sub.service;


import io.shardingsphere.transaction.annotation.ShardingTransactionType;
import io.shardingsphere.transaction.api.TransactionType;
import org.springframework.transaction.annotation.Transactional;

/**
 * 订单
 *
 * @author ddf
 * @email tataluoke@gmail.com
 * @date 2020-05-27 10:49:05
 */
public interface OrderService {


    @Transactional
    @ShardingTransactionType(TransactionType.XA)
    void insertWithTxXA();
}

