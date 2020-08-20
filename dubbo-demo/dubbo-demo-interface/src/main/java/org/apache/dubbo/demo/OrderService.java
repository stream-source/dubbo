package org.apache.dubbo.demo;

public interface OrderService {
    void getUserAddressList();

    void getUserAddressBySpi(String spiKey);
}
