package cn.myfreecloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * 字符串类型
 * Hash类型测试案例
 * @author zhangyang
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-redis.xml"})
public class TestHash {


    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 添加//修改
     * @throws Exception
     */
    @Test
    public void testAdd() throws Exception {
        redisTemplate.boundHashOps("name").put("zhangsan", 22);
        redisTemplate.boundHashOps("name").put("lisi", 66);
    }

    @Test
    public void testFind() throws Exception {
		Object age = redisTemplate.boundHashOps("name").get("zhangsan");
		System.out.println(age);
		//获取所有的value
		List values = redisTemplate.boundHashOps("name").values();

		//获取所有的key
		Set keys = redisTemplate.boundHashOps("name").keys();



        for (Object value : values) {
            System.out.println(value);
        }


        //entry形式
        Map<String, Long> entries = redisTemplate.boundHashOps("name").entries();

        //接受形式
        Set<Entry<String, Long>> entrySet = entries.entrySet();
        for (Entry<String, Long> entry : entrySet) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }


    }

    /**
     * 删除
     * @throws Exception
     */
    @Test
    public void testDelete() throws Exception {
        //只删除一个
		redisTemplate.boundHashOps("name").delete("zhangsan");

		//删除所有键是name的
        redisTemplate.delete("name");
    }


}
