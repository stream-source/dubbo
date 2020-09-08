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

import org.apache.dubbo.demo.OrderService;
import org.apache.dubbo.demo.notify.UserNotifyService;
import org.apache.dubbo.demo.stub.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ConsumerApplication {
    /**
     * In order to make sure multicast registry works, need to specify '-Djava.net.preferIPv4Stack=true' before
     * launch the application
     */
    public static void main(String[] args) throws Exception {
        notifyTest();
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
        orderService.getUserAddressBySpi("general");
        System.out.println("调用完成");
        System.in.read();
    }

    private static void stubTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/stub-consumer.xml");
        UserService stubService = context.getBean(UserService.class);
        String userName = stubService.getUserName("1503891");
        System.out.println(userName);

    }

    private static void notifyTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/notify-consumer.xml");
        UserNotifyService notifyService = context.getBean(UserNotifyService.class);
        String userName = notifyService.getUserName("1503892");
        System.out.println(userName);

    }
}
