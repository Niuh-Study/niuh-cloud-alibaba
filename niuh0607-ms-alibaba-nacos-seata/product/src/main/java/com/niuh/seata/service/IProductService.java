package com.niuh.seata.service;



public interface IProductService {

    boolean reduceCount(Integer amount, Integer productId) throws Exception;
}
