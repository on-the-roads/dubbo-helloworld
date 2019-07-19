package com.cjw.gmall.ServiceImpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.chenjiawen.Bean.UserAddress;
import com.chenjiawen.Service.OrderService;
import com.chenjiawen.Service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: jiawen.chen
 * @Date: 2019/7/17 18:08
 */

@Service
public class OrderServiceImpl implements OrderService {

//    @Autowired
    @Reference
    UserService userService;


    @Override
    public List<UserAddress>  initOrder(String userId) {
        System.out.println("用户ID： "+userId);
        //1查询用户的收货地址，这里就需要去调用接口查询用户的信息
        List<UserAddress> addressList = userService.getUserAddressList(userId);
        return addressList;
    }
}
