package com.mrwang.order.pojo;

import java.io.Serializable;
import java.util.List;

import com.mrwang.pojo.TbOrder;
import com.mrwang.pojo.TbOrderItem;
import com.mrwang.pojo.TbOrderShipping;

public class OrderInfo extends TbOrder implements Serializable {
	private List<TbOrderItem> orderItems;
	private TbOrderShipping orderShipping;

	public List<TbOrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<TbOrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public TbOrderShipping getOrderShipping() {
		return orderShipping;
	}

	public void setOrderShipping(TbOrderShipping orderShipping) {
		this.orderShipping = orderShipping;
	}

}
