package com.example.demo.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ${DESCRIPTION}
 *
 * @author huangcanjia
 * @create 2018-03-29 17:52
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi{

    @Override
    public String sayHiFromClientOne(@RequestParam(value = "name") String name) {
        return "has error,sorry "+name;
    }
}
