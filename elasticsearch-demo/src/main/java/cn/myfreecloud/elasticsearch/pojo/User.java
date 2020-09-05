package cn.myfreecloud.elasticsearch.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@AllArgsConstructor
@NoArgsConstructor //indexName 索引库名称 type 类型  shards 分片数 replicas 副本数
@Document(indexName = "user", type = "info", shards = 3, replicas = 2)
public class User {

    // id
    @Id
    private Long id;


    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String name;

    @Field(type = FieldType.Integer)
    private Integer age;

    // 不进行分词 index 不进行索引
    @Field(type = FieldType.Keyword, index = false)
    private String password;
}
