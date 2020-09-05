package com.leyou.client;

import com.leyou.entity.User;
import org.springframework.stereotype.Component;


@Component
public class UserClientFallBack implements UserClient {
    @Override
    public User queryById(Long id) {
        User user = new User();
        user.setId(10000L);
        user.setUsername("服务已经熔断");
        return user;
    }
}
