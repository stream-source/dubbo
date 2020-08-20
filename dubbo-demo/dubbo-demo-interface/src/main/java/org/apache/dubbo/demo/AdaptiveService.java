package org.apache.dubbo.demo;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

@SPI("general")
public interface AdaptiveService {
    @Adaptive
    void echo(String message, URL url);
}
