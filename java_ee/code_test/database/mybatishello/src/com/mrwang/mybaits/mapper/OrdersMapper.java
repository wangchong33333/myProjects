package com.mrwang.mybaits.mapper;

import java.util.List;

import com.mrwang.mybaits.po.OrdersExt;
import com.mrwang.mybaits.po.User;
import com.mrwang.mybaits.po.UserQueryVO;

public interface OrdersMapper {

	public List<OrdersExt> findOrdersAndUser();

	public List<OrdersExt> findOrdersAndUserRstMap();

	public List<OrdersExt> findOrdersAndDetailRstMap();
	
	public List<User> findUserAndItemsRstMap();
	
	public List<OrdersExt> findOrderAndUserLazyLoading();
}