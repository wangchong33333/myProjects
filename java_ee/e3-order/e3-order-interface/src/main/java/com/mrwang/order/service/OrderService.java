package com.mrwang.order.service;

import com.mrwang.common.utils.E3Result;
import com.mrwang.order.pojo.OrderInfo;

public interface OrderService {
	E3Result createOrder(OrderInfo orderInfo);
}
