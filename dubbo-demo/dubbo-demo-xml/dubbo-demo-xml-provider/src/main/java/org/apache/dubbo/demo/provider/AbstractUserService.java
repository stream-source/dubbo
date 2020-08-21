package org.apache.dubbo.demo.provider;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.demo.UserService;
import org.apache.dubbo.demo.model.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class AbstractUserService implements UserService {

    @Override
    public List<User> getUserServiceByLoader(String spiKey) {
       ExtensionLoader<UserService> extensionLoader = ExtensionLoader.getExtensionLoader(UserService.class);
        UserService userService = extensionLoader.getExtension(spiKey);
        return userService.getUserAddressList();
    }

}
