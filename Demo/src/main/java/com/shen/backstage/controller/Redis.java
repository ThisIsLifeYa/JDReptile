package com.shen.backstage.controller;

import com.shen.backstage.config.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
@RequestMapping("/redis")
public class Redis {
    @Autowired
    RedisUtil redisUtil;

    @RequestMapping("/setKeyValue")
    @ResponseBody
    public String testRedis(String key , String value){
        redisUtil.set(key,value);
        System.out.println(redisUtil.get(key));
        return  redisUtil.get(key).toString();
    }
    @RequestMapping("/getValue")
    @ResponseBody
    public String getValue(String key){
       return redisUtil.get(key).toString();
    }
}
