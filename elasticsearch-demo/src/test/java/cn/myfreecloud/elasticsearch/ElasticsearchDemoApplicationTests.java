package cn.myfreecloud.elasticsearch;

import cn.myfreecloud.elasticsearch.pojo.User;
import cn.myfreecloud.elasticsearch.repository.UserRepository;
import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
class ElasticsearchDemoApplicationTests {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Test
    void contextLoads() {

    }

    // 创建数据库 index
    @Test
    void test1() {
        elasticsearchRestTemplate.createIndex(User.class);
        elasticsearchRestTemplate.putMapping(User.class);

    }

    @Test
    void testDocument() {

        userRepository.save(new User(1L, "蔡徐坤,唱跳rap打篮球", 20, "123456"));


    }

    @Test
    void testAddAll() {
        List<User> users = new ArrayList<>();
        users.add(new User(1l, "柳岩", 18, "123456"));
        users.add(new User(2l, "范冰冰", 19, "123456"));
        users.add(new User(3l, "李冰冰", 20, "123456"));
        users.add(new User(4l, "锋哥", 21, "123456"));
        users.add(new User(5l, "小鹿", 22, "22222"));
        users.add(new User(6l, "韩红", 23, "11111"));
        this.userRepository.saveAll(users);
    }


    @Test
    void testFindByAgeBetween() {
        this.userRepository.findByAgeBetween(20, 30).forEach(System.out::println);
    }

    @Test
    void testFindByQuery() {
        this.userRepository.findByQuery(20, 30).forEach(System.out::println);
    }


    @Test
    void testNative() {
        // 初始化自定义查询构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 构建查询
        queryBuilder.withQuery(QueryBuilders.matchQuery("name", "冰冰"));
        // 排序
        queryBuilder.withSort(SortBuilders.fieldSort("age").order(SortOrder.ASC));
        // 分页
        queryBuilder.withPageable(PageRequest.of(0, 2));
        // 高亮 添加前置标签和后置标签
        queryBuilder.withHighlightBuilder(new HighlightBuilder().field("name").preTags("<em>").postTags("</em>"));
        // 聚合
        queryBuilder.addAggregation(AggregationBuilders.terms("passwordAgg").field("password"));
        // 执行查询，获取分页结果集
        Page<User> userPage = this.userRepository.search(queryBuilder.build());
        // 总页数
        System.out.println(userPage.getTotalPages());
        // 总记录数
        System.out.println(userPage.getTotalElements());
        // 当前页数据
        userPage.getContent().forEach(System.out::println);


        AggregatedPage<User> page = (AggregatedPage) userRepository.search(queryBuilder.build());

        page.getContent().forEach(System.out::println);


        ParsedStringTerms stringTerms = (ParsedStringTerms) page.getAggregation("passwordAgg");

        stringTerms.getBuckets().forEach(bucket -> System.out.println(bucket.getKeyAsString()));

    }


    @Test
    void testHeightLevelClient() throws IOException {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        sourceBuilder.query(QueryBuilders.matchQuery("name", "冰冰").operator(Operator.AND));
        sourceBuilder.sort("age", SortOrder.DESC);

        sourceBuilder.from(0);
        sourceBuilder.size(0);
        sourceBuilder.highlighter(new HighlightBuilder().field("name").preTags("<em>").postTags("</em>"));
        sourceBuilder.aggregation(AggregationBuilders.terms("passwordAgg").field("password"));


        SearchResponse response = this.restHighLevelClient.search(new SearchRequest(new String[]{"user"}, sourceBuilder), RequestOptions.DEFAULT);

        SearchHit[] hits = response.getHits().getHits();

        for (SearchHit hit : hits) {
            String userJson = hit.getSourceAsString();

            User user = JSON.parseObject(userJson, User.class);

            System.out.println(user);

            Map<String, HighlightField> highlightFields = hit.getHighlightFields();

            HighlightField highlightField = highlightFields.get("name");

            user.setName(highlightField.getFragments()[0].string());
            System.out.println(user);

            Map<String, Aggregation> asMap = response.getAggregations().getAsMap();

            ParsedStringTerms passwordAgg = (ParsedStringTerms) asMap.get("passwordAgg");

            passwordAgg.getBuckets().forEach(bucket -> System.out.println(bucket.getKeyAsString()));

        }

    }

}
