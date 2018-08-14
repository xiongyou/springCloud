package com.hikvision.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by xiongyou on 2018/7/10.
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")  //对方法创建熔断器的功能，并指定fallbackMethod熔断的方法，直接返回一个字符串
    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }

    /*
    *熔断的方法，直接返回一个字符串
    * */
    public String hiError(String name){
        return "hi, "+name+", sorry,error!";
    }
}
