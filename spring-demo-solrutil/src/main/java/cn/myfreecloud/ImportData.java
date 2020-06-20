package cn.myfreecloud;

import cn.myfreecloud.core.dao.item.ItemDao;
import cn.myfreecloud.core.pojo.item.Item;
import cn.myfreecloud.core.pojo.item.ItemQuery;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * @author: zhangyang
 * @date: 2019/4/27 16:05
 * @description:
 */

/**
 * 导入数据
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-solr.xml", "classpath*:spring/applicationContext*.xml"})
public class ImportData {

    @Autowired
    private SolrTemplate solrTemplate;

    @Autowired
    private ItemDao itemDao;

    /**
     * 导入所有数据
     * @throws Exception
     */
    @Test
    public void importSolr() throws Exception {
        ItemQuery itemQuery = new ItemQuery();

        itemQuery.createCriteria().andStatusEqualTo("1");


        List<Item> itemList = itemDao.selectByExample(itemQuery);

        //把数据库中存储的json数据转化为map输出
        if (null != itemList && itemList.size() > 0) {
            for (Item item : itemList) {
                Map<String, String> specMap = JSON.parseObject(item.getSpec(), Map.class);
                item.setSpecMap(specMap);
            }
            solrTemplate.saveBeans(itemList);
            solrTemplate.commit();
        }
    }
}


