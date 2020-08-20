package org.apache.dubbo.demo;

import org.apache.dubbo.common.extension.SPI;
import org.apache.dubbo.demo.model.User;

import java.util.List;
@SPI("member")
public interface UserService {

    List<User> getUserAddressList();

    UserService getUserServiceByLoader(String spiKey);
}
