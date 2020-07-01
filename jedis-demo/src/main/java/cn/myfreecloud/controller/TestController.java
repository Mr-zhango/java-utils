package cn.myfreecloud.controller;

import cn.myfreecloud.dto.QiniuItemDTO;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

@RestController
@RequestMapping("/jedis")
public class TestController {


    @Autowired
    private JedisPool jedisPool;

    @GetMapping("/test")
    public String testJedis() {

        String topicFileUrls = "{\n" +
                "    \"result\":{\n" +
                "        \"items\":[\n" +
                "            {\n" +
                "                \"key\":\"career/topic/1250123321434927106/0/topic.png\",\n" +
                "                \"url\":\"http://img.cnd.wanxue.cn/career/topic/1250123321434927106/0/topic.png\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"status\":200\n" +
                "}";


        // 获取连接
        Jedis jedisClient = jedisPool.getResource();

        // 放入缓存中
        jedisClient.set("topicFileUrls_topicId:1", topicFileUrls);
        // 设置缓存的超时时间 60s
        jedisClient.expire("topicFileUrls_topicId:1", 60);


        String stringResult = jedisClient.get("topicFileUrls_topicId:1");

        jedisClient.close();

        // 获取缓存
        JSONObject jsonObject = JSONObject.parseObject(stringResult);

        String result = jsonObject.getString("result");

        JSONObject items = JSONObject.parseObject(result);

        String string = items.getString("items");

        JSONArray objects = JSON.parseArray(string);

        List<QiniuItemDTO> fileUrls = JSONObject.parseArray(objects.toJSONString(), QiniuItemDTO.class);

        System.out.println(fileUrls);

        return fileUrls.toString();
    }

}
