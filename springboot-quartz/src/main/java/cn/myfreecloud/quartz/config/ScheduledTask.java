package cn.myfreecloud.quartz.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Slf4j
@Configuration
@Component
@EnableScheduling
public class ScheduledTask {

    public void sayHello() {
        log.info("Hello world, i'm the king of the world!!!");
    }
}