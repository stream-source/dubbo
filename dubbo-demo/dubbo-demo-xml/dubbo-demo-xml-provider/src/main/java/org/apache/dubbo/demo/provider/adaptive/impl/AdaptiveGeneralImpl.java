package org.apache.dubbo.demo.provider.adaptive.impl;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.demo.AdaptiveService;
import org.springframework.stereotype.Service;

@Service
public class AdaptiveGeneralImpl implements AdaptiveService {

    @Override
    public void echo(String message, URL url) {
        System.out.println("general:" + message);
    }
}
