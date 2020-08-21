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
package org.apache.dubbo.demo.consumer;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.demo.DemoService;

import org.apache.dubbo.demo.OrderService;
import org.apache.dubbo.demo.UserService;
import org.apache.dubbo.rpc.Protocol;
import org.apache.dubbo.rpc.ProtocolServer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ConsumerApplication {
    /**
     * In order to make sure multicast registry works, need to specify '-Djava.net.preferIPv4Stack=true' before
     * launch the application
     */
    public static void main(String[] args) throws Exception {
       consumerMainTest();

    }

    private static void consumerMainTest() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-consumer.xml");
        OrderService orderService = context.getBean(OrderService.class);
        orderService.getUserAddressList();
        System.out.println("调用完成");
        System.in.read();
    }

    /**
     * spi方式远程调用，暂时未实现
     * @throws IOException
     */
    private static void consumerSpiTest() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-consumer.xml");
        OrderService orderService = context.getBean(OrderService.class);
        orderService.getUserAddressList();
        orderService.getUserAddressBySpi("member");
        System.out.println("调用完成");
        System.in.read();
    }
}
