package cn.myfreecloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串类型
 * String类型
 * @author zhangyang
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-redis.xml"})
public class TestValue {
	
	
	@Autowired
	private RedisTemplate redisTemplate;

    /**
     * 添加//修改
     * @throws Exception
     */
	@Test
	public void testAdd() throws Exception {
		redisTemplate.boundValueOps("zhangsan").set(44);
		redisTemplate.boundValueOps("lisi").set(25);
		redisTemplate.boundValueOps("wangwu").set(12);
		redisTemplate.boundValueOps("zhaoliu").set( 32);
	}

    /**
     * 查询
     * @throws Exception
     */
	@Test
	public void testFind() throws Exception {
		Object age1 = redisTemplate.boundValueOps("zhangsan").get();
		System.out.println(age1);
		Object age2 = redisTemplate.boundValueOps("lisi").get();
		System.out.println(age2);
		Object age3 = redisTemplate.boundValueOps("wangwu").get();
		System.out.println(age3);
		Object age4 = redisTemplate.boundValueOps("zhaoliu").get();
		System.out.println(age4);
	
	}

    /**
     * 注意:redis没有事务,但是速度特别快
     */

    /**
     * 删除
     * @throws Exception
     */
	@Test
	public void testDelete() throws Exception {
		List<String> list = new ArrayList<>();
		list.add("zhangsan");
		list.add("lisi");
		list.add("wangwu");
		list.add("zhaoliu");
		redisTemplate.delete(list);
	}
	

}
