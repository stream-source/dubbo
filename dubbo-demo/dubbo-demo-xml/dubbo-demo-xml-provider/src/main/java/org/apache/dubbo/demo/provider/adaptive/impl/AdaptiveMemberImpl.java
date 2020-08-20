package org.apache.dubbo.demo.provider.adaptive.impl;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.demo.AdaptiveService;
import org.springframework.stereotype.Service;

@Service
@Adaptive
public class AdaptiveMemberImpl implements AdaptiveService {
    @Override
    public void echo(String message, URL url) {
        System.out.println("member:" + message);
    }
}
