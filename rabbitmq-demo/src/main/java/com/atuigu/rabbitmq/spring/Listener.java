package com.atuigu.rabbitmq.spring;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    @RabbitListener(bindings = @QueueBinding(
            // 绑定的队列
            value = @Queue(value = "spring.test.queue", durable = "true"),

            // 绑定的交换机
            exchange = @Exchange(
                    // 交换机的名字
                    value = "spring.test.exchange",
                    // 忽略声明异常
                    ignoreDeclarationExceptions = "true",
                    // 消息模式 主题模式
                    type = ExchangeTypes.TOPIC
            ),
            // key至少两个单词
            key = {"#.#"})
    )
    public void listen(String msg){
        System.out.println("接收到消息：" + msg);
    }
}
