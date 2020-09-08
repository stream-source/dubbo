package org.apache.dubbo.demo.provider.notify;

import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.demo.notify.UserNotifyService;
import org.apache.dubbo.rpc.RpcException;
import org.springframework.stereotype.Service;

/**
 * @author wx
 * @date 2020/9/8 1:46 下午
 */
@Service
public class UserNotifyServiceImpl implements UserNotifyService {

    private static final String USER_ID  = "1503892";
    @Override
    public String getUserName(String userId) {
        if (StringUtils.isBlank(userId)) {
            throw new RpcException("userId is null");
        }
        return USER_ID.equals(userId) ? "溪～源" : "";
    }
}
