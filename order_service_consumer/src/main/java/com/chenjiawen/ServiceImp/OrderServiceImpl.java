package com.chenjiawen.ServiceImp;

import com.chenjiawen.Bean.UserAddress;
import com.chenjiawen.Service.OrderService;
import com.chenjiawen.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: jiawen.chen
 * @Date: 2019/7/17 18:08
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    UserService userService;

    @Override
    public void initOrder(String userId) {


        System.out.println("用户ID： "+userId);
        //1查询用户的收货地址，这里就需要去调用接口查询用户的信息
        List<UserAddress> addressList = userService.getUserAddressList(userId);
        for (UserAddress address : addressList) {
            System.out.println(address);
        }
    }
}
