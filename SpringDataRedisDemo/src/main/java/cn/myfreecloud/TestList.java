package cn.myfreecloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author: zhangyang
 * @date: 2019/4/27 11:00
 * @description: list集合类型测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-redis.xml"})
public class TestList {


    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * redis底层的list实现是一个链表,
     *  所以在操作redis的时候,可以分为左推和右推入
     * arrayList底层的实现是一个链表加数组
     */
    @Test
    public void add(){
        /**左添加**/
        redisTemplate.boundListOps("list").rightPush("张飞");
        redisTemplate.boundListOps("list").rightPush("关羽");
        redisTemplate.boundListOps("list").rightPush("刘备");
        redisTemplate.boundListOps("list").rightPush("曹操");
        redisTemplate.boundListOps("list").rightPush("关羽");
        redisTemplate.boundListOps("list").rightPush("关羽");

    }


    @Test
    public void query(){
        /**只查看三个**/
        List list = redisTemplate.boundListOps("list").range(0, 3);
        for (Object o : list) {
            System.out.println(o);
        }

        System.out.println("------------------------------");
        /**查看全部**/
        List list1 = redisTemplate.boundListOps("list").range(0, -1);
        for (Object o : list1) {

            System.out.println(o);
        }
    }

    @Test
    public void update(){
        redisTemplate.boundListOps("list").set(3,"一代枭雄曹操");
    }

    @Test
    public void delete(){
        /**
         * i先写删除的个数,在指定删除谁+2删除前两个,-2删除后两个
         *
         * i:i>0从左开始算起,i<0,从右开始算起 i = 0全部删除
         */
        //redisTemplate.boundListOps("list").remove(0,"关羽");

        //Object object = redisTemplate.boundListOps("list").rightPop();

        Object object = redisTemplate.boundListOps("list").leftPop();

        System.out.println("删除的是:"+object);

    }
}
