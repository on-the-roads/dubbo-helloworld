package com.chenjiawen.Bean.com.chenjiawen.Service;

import java.util.List;

import com.atguigu.gmall.bean.UserAddress;

public interface OrderService {
	
	/**
	 * 初始化订单
	 * @param userId
	 */
	public List<UserAddress> initOrder(String userId);

}
