package cn.myfreecloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * 字符串类型
 * set类型
 * @author zhangyang
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-redis.xml"})
public class TestSet {
	
	
	@Autowired
	private RedisTemplate redisTemplate;

    /**
     * 添加//修改
     * @throws Exception
     */
	@Test
	public void testAdd() throws Exception {

//		redisTemplate.opsForSet().add("set", "刘备");
		
		redisTemplate.boundSetOps("set").add("刘备");
		redisTemplate.boundSetOps("set").add("关羽");
		redisTemplate.boundSetOps("set").add("小乔");

	}
	@Test
	public void testFind() throws Exception {
		Set members = redisTemplate.boundSetOps("set").members();
		for (Object object : members) {
			System.out.println(object);
		}
	}
	//删除
	@Test
	public void testDelete() throws Exception {
		redisTemplate.boundSetOps("set").remove("刘备");
	}
	

}
