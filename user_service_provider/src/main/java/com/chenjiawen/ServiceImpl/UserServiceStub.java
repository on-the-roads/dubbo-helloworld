package com.chenjiawen.Service.ServiceImpl;

import java.util.List;

import com.chenjiawen.Bean.UserAddress;
import com.chenjiawen.Service.UserService;


public class UserServiceStub implements UserService {
	
	private final UserService userService;
	

	/**
	 * 传入的是userService远程的代理对象
	 * @param userService
	 */
	public UserServiceStub(UserService userService) {
		super();
		this.userService = userService;
	}


	@Override
	public List<UserAddress> getUserAddressList(String userId) {
		// TODO Auto-generated method stub
		System.out.println("UserServiceStub.....");
		if(userId==null&&userId.length()!=0) {
			return userService.getUserAddressList(userId);
		}
		return null;
	}

}