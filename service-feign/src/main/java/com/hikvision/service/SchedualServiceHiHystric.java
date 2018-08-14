package com.hikvision.service;

import org.springframework.stereotype.Component;

/**
 * Created by xiongyou on 2018/7/11.
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name){
        return "sorry, "+name;
    }
}
