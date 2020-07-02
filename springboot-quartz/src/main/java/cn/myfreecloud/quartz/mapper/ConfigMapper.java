package cn.myfreecloud.quartz.mapper;

import cn.myfreecloud.quartz.entity.Config;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ConfigMapper {

    @Select("select id,cron from config where id = #{id}")
    public Config findOne(Integer id);
}