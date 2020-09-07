package org.apache.dubbo.demo.consumer.impl;

import org.apache.dubbo.demo.OrderService;
import org.apache.dubbo.demo.UserService;
import org.apache.dubbo.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 使用注解注入类，由于不是springBoot项目，则需要xml配置文件处理包扫描路径
 */
//@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserService userService;

    @Override
    public void getUserAddressList() {
        List<User> userAddressList = userService.getUserAddressList();
        for (User user : userAddressList) {
            System.out.println(user.getUserAddress());
        }
    }

    @Override
    public void getUserAddressBySpi(String spiKey) {
        List<User> userAddressList = userService.getUserServiceByLoader(spiKey);
        for (User user : userAddressList) {
            System.out.println("level:" + user.getUserLevel() + " address:" + user.getUserAddress());
        }
    }
}
