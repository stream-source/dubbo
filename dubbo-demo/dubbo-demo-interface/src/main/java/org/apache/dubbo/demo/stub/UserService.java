package org.apache.dubbo.demo.stub;

/**
 * @author wx
 * @date 2020/9/6 11:39 下午
 * 测试本地存根服务接口
 */
public interface UserService {
    /**
     * 根据用户名，返回用户名字
     * @param userId 用户ID
     * @return 用户名
     */
    String getUserName(String userId);
}
