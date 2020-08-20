package org.apache.dubbo.demo.provider.impl;

import org.apache.dubbo.demo.UserService;
import org.apache.dubbo.demo.model.User;
import org.apache.dubbo.demo.provider.AbstractUserService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
@Service
public class MemberServiceImpl extends AbstractUserService implements UserService, Serializable {
    @Override
    public List<User> getUserAddressList() {
        List<User> userList = new LinkedList<>();
        for (int i = 0; i < 2; i++) {
            User user = new User();
            user.setUserLevel("member");
            user.setUserAddress("杭州拱墅 " + i);
            userList.add(user);
        }
        return userList;

    }
}
