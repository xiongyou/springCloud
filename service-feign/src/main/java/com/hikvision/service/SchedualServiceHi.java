package com.hikvision.service;


import com.hikvision.service.SchedualServiceHiHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xiongyou on 2018/7/11.
 */
@FeignClient(value = "service-hi",fallback = SchedualServiceHiHystric.class)  //断路器指定fallback的类。
public interface SchedualServiceHi {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
