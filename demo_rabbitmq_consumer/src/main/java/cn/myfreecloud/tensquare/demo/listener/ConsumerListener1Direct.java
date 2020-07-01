package cn.myfreecloud.tensquare.demo.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "itcast")
public class ConsumerListener1Direct {

    @RabbitHandler
    public void getMsg(String msg) {
        System.out.println("itcast 获取到的消息是:" + msg);
    }
}
