package org.apache.dubbo.demo.consumer.notify;

import org.springframework.stereotype.Service;

/**
 * @author wx
 * @date 2020/9/8 1:59 下午
 */
@Service
public class ConsumerNotifyServiceImpl implements ConsumerNotifyService{
    @Override
    public void onInvoke(String name) {
        System.out.println("[事件通知]执行onInvoke方法，参数：" + name);
    }

    @Override
    public void onReturnWithoutParam(String result) {
        System.out.println("[事件通知]执行onReturnWithoutParam方法，返回结果：" + result);
    }

    @Override
    public void onReturn(String result, String name) {
        System.out.println("[事件通知]执行onReturn方法，参数：" + name + ", 返回结果：" + result);
    }

    @Override
    public void onThrow(Throwable ex, String name) {
        System.out.println("[事件通知]执行onThrow方法，参数：" + name + ", 异常信息：" + ex.getMessage());
    }
}
