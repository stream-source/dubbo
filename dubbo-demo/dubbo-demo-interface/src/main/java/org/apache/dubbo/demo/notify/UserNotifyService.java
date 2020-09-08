package org.apache.dubbo.demo.notify;

/**
 * @author wx
 * @date 2020/9/8 1:44 下午
 * 测试事件通知
 */
public interface UserNotifyService {
    /**
     * 获取用户名字
     * @param userId
     * @return
     */
    String getUserName(String userId);
}
