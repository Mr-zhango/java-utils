package cn.myfreecloud.core.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author: zhangyang
 * @date: 2019/5/12 12:23
 * @description:
 */
@Component
public class Consumer {


    /**
     * 监听消息
     * @param map
     */
    @JmsListener(destination = "message")
    public void reciverMessage(Map<String,String> map){

        System.out.println("手机号:" + map.get("phone"));
        System.out.println("验证码:" + map.get("code"));

        //发短信


    }

}
