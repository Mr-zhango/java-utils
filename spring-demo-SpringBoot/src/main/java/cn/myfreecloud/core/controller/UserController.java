package cn.myfreecloud.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 环境  Spring容器  参数:  读取properties文件并解决硬编码问题,注入这一个就可以读取所有的配置文件
     */
	@Autowired
	private Environment env;

    /**
     * 测试用的
     * @param name
     * @return
     */
	@RequestMapping("/getName")
	public String getName(String name){
		return name +":" + env.getProperty("url");
	}

}
