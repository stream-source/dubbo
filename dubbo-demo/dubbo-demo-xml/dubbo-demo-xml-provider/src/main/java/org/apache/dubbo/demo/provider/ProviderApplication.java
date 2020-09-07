/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.demo.provider;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.demo.AdaptiveService;
import org.apache.dubbo.demo.UserService;
import org.apache.dubbo.demo.model.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

public class ProviderApplication {
    public static void main(String[] args) throws Exception {
        stubTest();
    }

    private static void providerMainTest() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-provider.xml");
        context.start();
        System.in.read();
    }

    /**
     * SPI接口调用方式
     */
    private static void providerSpiTest() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-provider.xml");
        context.start();
        String spiKey = "true";
        ExtensionLoader<UserService> extensionLoader = ExtensionLoader.getExtensionLoader(UserService.class);
        UserService extension = extensionLoader.getExtension(spiKey);
        System.out.println(extension.getUserAddressList().get(0).getUserAddress());
        System.in.read();
    }

    /**
     * adaptive机制 TODO
     * @throws IOException
     */
    private static void providerAdaptiveTest() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-provider.xml");
        context.start();
        ExtensionLoader<AdaptiveService> extensionLoader = ExtensionLoader.getExtensionLoader(AdaptiveService.class);
        AdaptiveService adaptiveExtension = extensionLoader.getAdaptiveExtension();
        URL url = URL.valueOf("http://localhost/testAdaptive");
        adaptiveExtension.echo("adaptive", url);
        System.in.read();
    }

    /**
     * 服务端Stub测试
     * @throws IOException
     */
    private static void stubTest() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/stub-provider.xml");
        context.start();
        System.in.read();
    }
}
