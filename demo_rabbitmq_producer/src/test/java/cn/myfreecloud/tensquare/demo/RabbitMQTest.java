package cn.myfreecloud.tensquare.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitMqApp.class)
public class RabbitMQTest {

    // 声明使用RabbitMQ的模板
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 直接模式
     */
    @Test
    public void test1(){
        rabbitTemplate.convertAndSend("itcast","rabbitMQ直接模式");
        System.out.println("消息发送成功");
    }

    /**
     * 分列模式
     */
    @Test
    public void test2(){
        rabbitTemplate.convertAndSend("chuanzhi","","rabbitMQ分列模式");
        System.out.println("rabbitMQ 分列模式消息发送成功");
    }

    /**
     * 主题模式
     */
    @Test
    public void test3() throws InterruptedException {
       while (true){
           rabbitTemplate.convertAndSend("chuanzhitopic","item","rabbitMQ主题模式->item");
           rabbitTemplate.convertAndSend("chuanzhitopic","order","rabbitMQ主题模式->order");
           System.out.println("rabbitMQ 主题模式消息发送成功");

           Thread.sleep(1000);
       }
    }
}
