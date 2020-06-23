package cn.myfreecloud.tensquare.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitMQConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMQConsumerApp.class, args);
    }
}
