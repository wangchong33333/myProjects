package com.mrwang.order.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mrwang.common.jedis.JedisClient;
import com.mrwang.common.utils.E3Result;
import com.mrwang.mapper.TbOrderItemMapper;
import com.mrwang.mapper.TbOrderMapper;
import com.mrwang.mapper.TbOrderShippingMapper;
import com.mrwang.order.pojo.OrderInfo;
import com.mrwang.order.service.OrderService;
import com.mrwang.pojo.TbOrderItem;
import com.mrwang.pojo.TbOrderItemExample;
import com.mrwang.pojo.TbOrderShipping;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private TbOrderMapper orderMapper;
	@Autowired
	private TbOrderItemMapper orderItemMapper;
	@Autowired
	private TbOrderShippingMapper orderShippingMapper;
	@Autowired
	JedisClient jedisClient;
	@Value("${ORDER_ID_GEN_KEY}")
	private String ORDER_ID_GEN_KEY;
	@Value("${ORDER_ID_START}")
	private String ORDER_ID_START;
	@Value("${ORDER_DETAIL_ID_GEN_KEY}")
	private String ORDER_DETAIL_ID_GEN_KEY;

	@Override
	public E3Result createOrder(OrderInfo orderInfo) {
		if (!jedisClient.exists(ORDER_ID_GEN_KEY)) {
			jedisClient.set(ORDER_ID_GEN_KEY, ORDER_ID_START);
		}
		String orderId = jedisClient.incr(ORDER_ID_GEN_KEY).toString();
		orderInfo.setOrderId(orderId);
		// 1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭'
		orderInfo.setStatus(1);
		orderInfo.setCreateTime(new Date());
		orderInfo.setUpdateTime(new Date());
		orderMapper.insert(orderInfo);
		List<TbOrderItem> orderItems = orderInfo.getOrderItems();
		for (TbOrderItem tbOrderItem : orderItems) {
			String odId = jedisClient.incr(ORDER_DETAIL_ID_GEN_KEY).toString();
			tbOrderItem.setId(odId);
			tbOrderItem.setOrderId(orderId);
			orderItemMapper.insert(tbOrderItem);
		}

		TbOrderShipping orderShipping = orderInfo.getOrderShipping();
		orderShipping.setOrderId(orderId);
		orderShipping.setCreated(new Date());
		orderShipping.setUpdated(new Date());
		orderShippingMapper.insert(orderShipping);
		return E3Result.ok(orderId);
	}

}
