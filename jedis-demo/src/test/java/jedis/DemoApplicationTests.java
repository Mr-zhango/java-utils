package jedis;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class DemoApplicationTests {


    @Test
    public void myTest() throws UnsupportedEncodingException {

        Jedis jedis = new Jedis("127.0.0.1", 6379);//redis的地址以及连接端口
        // 判断key否存在
        System.out.println(jedis.exists("foo"));

        jedis.set("key", "values");
        System.out.println(jedis.exists("key"));    // 判断是否存在

        // 设置60秒后该key过期
        jedis.expire("key", 60);

    }

    @Test
    public void keyTest() throws UnsupportedEncodingException {

        Jedis jedis = new Jedis("127.0.0.1", 6379);//redis的地址以及连接端口
        System.out.println("链接redis成功");

        System.out.println(jedis.flushDB());// 清空数据

        System.out.println("以及清空redis数据");// 清空数据

        System.out.println(jedis.echo("hello"));

        // 判断key否存在
        System.out.println(jedis.exists("foo"));

        jedis.set("key", "values");
        jedis.set("key2", "values");
        System.out.println(jedis.exists("key"));    // 判断是否存在

        // 如果数据库没有任何key，返回nil，否则返回数据库中一个随机的key。
        String randomKey = jedis.randomKey();
        System.out.println("randomKey: " + randomKey);

        // 设置60秒后该key过期
        jedis.expire("key", 60);

        // key有效毫秒数
        System.out.println(jedis.pttl("key"));

        // 移除key的过期时间
        jedis.persist("key");

        // 获取key的类型, "string", "list", "set". "none" none表示key不存在
        System.out.println("type: " + jedis.type("key"));

        // 导出key的值
        byte[] bytes = jedis.dump("key");
        System.out.println(new String(bytes));

        // 将key重命名
        jedis.renamenx("key", "keytest");
        System.out.println("key是否存在: " + jedis.exists("key"));// 判断是否存在
        System.out.println("keytest是否存在: " + jedis.exists("keytest"));// 判断是否存在

        // 查询匹配的key
        // KEYS       * 匹配数据库中所有 key 。
        // KEYS       h?llo 匹配 hello ， hallo 和 hxllo 等。
        // KEYS       h*llo 匹配 hllo 和 heeeeello 等。
        // KEYS       h[ae]llo 匹配 hello 和 hallo ，但不匹配 hillo 。
        // 特殊符号用 \ 隔开。
        Set<String> set = jedis.keys("k*");
        System.out.println(set);

        // 删除key
        jedis.del("key");

        System.out.println(jedis.exists("key"));


    }

    @Test
    public void listTest() {

        Jedis jedis = new Jedis("127.0.0.1", 6379);//redis的地址以及连接端口
        String key = "mylist";
        jedis.del(key);

        // 队列添加元素
        jedis.rpush(key, "aaaa");
        jedis.rpush(key, "aaaa");
        jedis.rpush(key, "bbbb");
        jedis.rpush(key, "cccc");
        jedis.rpush(key, "cccc");

        // 队列长度
        System.out.println("lenth: " + jedis.llen(key));

        // 打印队列，从索引0开始，到倒数第1个（全部元素）
        System.out.println("all elements: " + jedis.lrange(key, 0, -1));

        // 索引为1的元素
        System.out.println("index of 1: " + jedis.lindex(key, 1));

        // 设置队列里面一个元素的值，当index超出范围时会返回一个error。
        jedis.lset(key, 1, "aa22");
        System.out.println("index of 1: " + jedis.lindex(key, 1));

        // 从队列的右边入队一个元素
        jedis.rpush(key, "-2", "-1");// 先-2，后-1入队列
        System.out.println("all elements: " + jedis.lrange(key, 0, -1));

        // 从队列的左边入队一个或多个元素
        jedis.lpush(key, "second element", "first element");// 先second
        // element，后first
        // elementF入队列
        System.out.println("all elements: " + jedis.lrange(key, 0, -1));

        // 从队列的右边出队一个元素
        System.out.println(jedis.rpop(key));
        // 从队列的左边出队一个元素
        System.out.println(jedis.lpop(key));
        System.out.println("all elements: " + jedis.lrange(key, 0, -1));

        // count > 0: 从头往尾移除值为 value 的元素，count为移除的个数。
        // count < 0: 从尾往头移除值为 value 的元素，count为移除的个数。
        // count = 0: 移除所有值为 value 的元素。
        jedis.lrem(key, 1, "cccc");
        System.out.println("all elements: " + jedis.lrange(key, 0, -1));

        // 即最右边的那个元素也会被包含在内。 如果start比list的尾部下标大的时候，会返回一个空列表。
        // 如果stop比list的实际尾部大的时候，Redis会当它是最后一个元素的下标。
        System.out.println(jedis.lrange(key, 0, 2));
        System.out.println("all elements: " + jedis.lrange(key, 0, -1));

        // 删除区间以外的元素
        System.out.println(jedis.ltrim(key, 0, 2));
        System.out.println("all elements: " + jedis.lrange(key, 0, -1));
    }

    @Test
    public void listTest1() {

        Jedis jedis = new Jedis("127.0.0.1", 6379);//redis的地址以及连接端口
        String key = "mylist";
        jedis.del(key);

        // 队列添加元素
        jedis.rpush(key, "aaaa");
        jedis.rpush(key, "bbbb");
        jedis.rpush(key, "cccc");
        jedis.rpush(key, "dddd");
        jedis.rpush(key, "eeee");

        // 队列长度
        System.out.println("lenth: " + jedis.llen(key));

        // 打印队列，从索引0开始，到倒数第1个（全部元素）
        System.out.println("all elements: " + jedis.lrange(key, 0, -1));

    }

    @Test
    public void listTest2() {

        ArrayList<String> arrayList = new ArrayList<>();

        Jedis jedis = new Jedis("127.0.0.1", 6379);//redis的地址以及连接端口
        String key = "mylist";
        jedis.del(key);

        // 队列添加元素
        arrayList.add( "1");
        arrayList.add( "2");
        arrayList.add( "3");
        arrayList.add( "4");
        arrayList.add( "5");

        String jsonObject = JSONObject.toJSONString(arrayList);


        System.out.println(jsonObject);


        JSONArray objects = JSONObject.parseArray(jsonObject);

        List<String> lists = JSONObject.parseArray(objects.toJSONString(), String.class);

        for (String list : lists) {
            System.out.println(list);
        }


    }

}
