package com.cjw.gmall.Controller;

import com.chenjiawen.Bean.UserAddress;
import com.chenjiawen.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: jiawen.chen
 * @Date: 2019/7/19 9:04
 */
@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping("/initOrder")
    @ResponseBody
    public List<UserAddress>  initOrder(@RequestParam("uid") String  userId){
        return  orderService.initOrder(userId);
    }
}
