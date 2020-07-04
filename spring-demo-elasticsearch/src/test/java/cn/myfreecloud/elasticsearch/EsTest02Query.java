package cn.myfreecloud.elasticsearch;

import cn.myfreecloud.elasticsearch.pojo.Item;
import cn.myfreecloud.elasticsearch.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EsTest02Query {
    @Autowired
    private ItemRepository itemRepository;


    @Test
    public void testFind() {

        Optional<Item> byId = itemRepository.findById(1L);
        Item item = byId.get();
        System.out.println(item);

    }



    // 查询全部
    @Test
    public void testFindAll() {

        Iterable<Item> itemRepositoryAll = itemRepository.findAll(Sort.by("price").ascending());

        itemRepositoryAll.forEach(System.out::println);

    }

    // 查询全部
    @Test
    public void testFindByTitle() {

        Iterable<Item> itemRepositoryAll = itemRepository.findByTitle("手机");

        itemRepositoryAll.forEach(System.out::println);
    }

    // 查询全部
    @Test
    public void testFindByPriceBetween() {
        Iterable<Item> itemRepositoryAll = itemRepository.findByPriceBetween(3699d,4499d);

        itemRepositoryAll.forEach(System.out::println);
    }


    @Test
    public void indexList() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(1L, "小米手机7", "手机", "小米", 3299.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(2L, "坚果手机R1", "手机", "锤子", 3699.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(3L, "华为META10", "手机", "华为", 4499.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(4L, "小米Mix2S", "手机", "小米", 4299.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(5L, "荣耀V10", "手机", "华为", 2799.00, "http://image.leyou.com/13123.jpg"));
        // 接收对象集合，实现批量新增
        itemRepository.saveAll(list);
    }


}
