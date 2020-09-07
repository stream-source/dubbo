package org.apache.dubbo.demo.stub;

import org.apache.dubbo.common.utils.StringUtils;

/**
 * @author wx
 * @date 2020/9/6 11:09 下午
 * 服务消费者实现接口，并实现本地存根逻辑
 */
public class UserServiceStub implements UserService {
    private static final String USER_ID  = "1503891";

    private final UserService userService;

    /**
     * 通过构造方法将服务接口代理对象（接口实现类对象）传入stub
     * @param userService
     */
    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String getUserName(String userId) {
        System.out.println("开始执行服务消费端本地存根逻辑");
        if (StringUtils.isBlank(userId)) {
            return "userId is null";
        }
        if (!USER_ID.equals(userId)) {
            return "user not exits";
        }
        String userName = userService.getUserName(userId);
        System.out.println("结束执行服务消费端本地存根逻辑");
        return userName;
    }
}
