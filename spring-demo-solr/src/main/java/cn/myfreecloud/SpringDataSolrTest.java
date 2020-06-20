package cn.myfreecloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangyang
 * @date: 2019/4/27 15:21
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-solr.xml"})
public class SpringDataSolrTest {
    @Autowired
    private SolrTemplate solrTemplate;

    /**
     * 添加方法
     *
     * @throws Exception
     */
    @Test
    public void testAdd() throws Exception {

        /*

        原生态的使用方法
        SolrInputDocument document = new SolrInputDocument();
        document.addField("id",1);
        document.addField("name","jack");
        solrTemplate.saveBean(document);

        */


        Item item = new Item();
        item.setId(1L);
        item.setBrand("华为6666");
        item.setCategory("手机111");
        item.setGoodsId(1L);
        item.setSeller("华为2号专卖店");
        item.setTitle("华为Mate30");
        item.setPrice(new BigDecimal(2000));
        solrTemplate.saveBean(item);

        solrTemplate.commit();


    }


    /**
     * 按主键查询
     */
    @Test
    public void testFindOne() {
        Item item = solrTemplate.getById(1, Item.class);
        System.out.println(item);
        System.out.println(item.getTitle());
    }

    /**
     * 按主键删除
     */
    @Test
    public void testDelete() {
        solrTemplate.deleteById("111");
        solrTemplate.commit();
    }


    @Test
    public void testAddList() {
        List<Item> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Item item = new Item();
            item.setId(i + 1L);
            item.setBrand("华为");
            item.setCategory("手机");
            item.setGoodsId(1L);
            item.setSeller("华为2号专卖店");
            item.setTitle("华为Mate" + i);
            item.setPrice(new BigDecimal(2000 + i));
            list.add(item);
        }
        solrTemplate.saveBeans(list);
        solrTemplate.commit();
    }


    /**
     * 分页查询
     */
    @Test
    public void testPageQuery() {
        /**查询所有**/
        Query query = new SimpleQuery("*:*");
        //开始索引（默认0 第一页）
        query.setOffset(0);
        //每页记录数(默认10)
        query.setRows(5);

        ScoredPage<Item> page = solrTemplate.queryForPage(query, Item.class);
        System.out.println("总记录数：" + page.getTotalElements());
        List<Item> list = page.getContent();


        System.out.println(list);
        showList(list);
    }

    /**
     * 显示记录数据
     * @param list
     */
    private void showList(List<Item> list) {
        for (Item item : list) {
            System.out.println(item);
        }
    }


    /**
     * 条件查询
     */
    @Test
    public void testPageQueryMutil(){

        Query query = new SimpleQuery("*:*");
        Criteria criteria = new Criteria();
        criteria = criteria.or("item_title").contains("2");
        criteria = criteria.or("item_title").contains("5");
        query.addCriteria(criteria);
        ScoredPage<Item> page = solrTemplate.queryForPage(query, Item.class);
        System.out.println("总记录数："+page.getTotalElements());
        List<Item> list = page.getContent();
        showList(list);
    }


    /**
     * 清空solr索引库的内容
     */
    @Test
    public void testDeleteAll(){
        Query query=new SimpleQuery("*:*");
        solrTemplate.delete(query);
        solrTemplate.commit();
    }


}
