package cn.myfreecloud.jedis;

import cn.myfreecloud.dto.QiniuItemDTO;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisPool;

import java.util.List;

public class JedisClient {

    @Autowired
    private JedisPool jedisPool;



    public static void main(String[] args) {

        // 使用方式



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


        JSONObject jsonObject = JSONObject.parseObject(topicFileUrls);

        String result = jsonObject.getString("result");

        JSONObject items = JSONObject.parseObject(result);

        String string = items.getString("items");

        JSONArray objects = JSON.parseArray(string);

        List<QiniuItemDTO> list = JSONObject.parseArray(objects.toJSONString(), QiniuItemDTO.class);


        System.out.println(list);

    }
}