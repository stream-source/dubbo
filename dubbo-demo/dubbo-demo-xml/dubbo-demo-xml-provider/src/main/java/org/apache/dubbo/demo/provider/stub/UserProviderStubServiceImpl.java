package org.apache.dubbo.demo.provider.stub;

import org.apache.dubbo.demo.stub.UserService;
import org.springframework.stereotype.Service;

/**
 * @author wx
 * @date 2020/9/6 11:09 下午
 * 服务消费者实现接口，并实现本地存根逻辑
 */
@Service
public class UserProviderStubServiceImpl implements UserService {
    private static final String USER_ID  = "1503891";

    @Override
    public String getUserName(String userId) {
        return USER_ID.equals(userId) ? "溪～源" : "";
    }
}
