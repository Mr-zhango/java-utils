package cn.myfreecloud.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @author: zhangyang
 * @date: 2019/5/12 12:19
 * @description:
 */
@RestController
@RequestMapping("/mq")
public class ActiveMQController {



    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Environment env;


    /**
     * 发消息
     * @param name
     * @return
     */
    @RequestMapping("/send")
    public String send(String name){

        jmsTemplate.send(env.getProperty("message"), new MessageCreator() {

            @Override
            public Message createMessage(Session session) throws JMSException {
                // TODO Auto-generated method stub
                MapMessage map = session.createMapMessage();
                //手机号
                map.setString("phone", "11111111");
                //验证码
                map.setString("code", "123346");

                return map;
            }
        });
        return "success";
    }
}
