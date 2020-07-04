package cn.myfreecloud.elasticsearch.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "item",type ="docs" ,shards = 1 ,replicas = 0)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    Long id;
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    String title; //标题 不需要进行分词
    @Field(type = FieldType.Keyword)
    String category;// 分类 不需要进行分词
    @Field(type = FieldType.Keyword)
    String brand; // 品牌
    @Field(type = FieldType.Double)
    Double price; // 价格
    @Field(type = FieldType.Keyword,index = false)
    String images; // 图片地址 不需要创建索引
}