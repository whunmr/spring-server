package com.example.mock;


import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ZoneAwareLoadBalancer;

/**
 * Created by azhu on 06/06/2017.
 */
public class TestLoadBalancer<T extends Server> extends ZoneAwareLoadBalancer<T> {

    @Override
    public Server chooseServer(Object key) {
        throw new RuntimeException("I already break in!!!!");
//        if (String.valueOf(key).equals("EC2")) {
//            return  new Server("localhost", 9002);
//        }
//        return super.chooseServer(key);
    }
}
