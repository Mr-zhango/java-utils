package cn.myfreecloud.javautils.memocache;

import cn.myfreecloud.javautils.memocache.entity.CatalogEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CataLogDao {

    public List<CatalogEntity> selectAll() {
        return new ArrayList<>();
    }

    public CatalogEntity insertSelective() {
        return new CatalogEntity();
    }

    public int updatBySelective(CatalogEntity catalogEntity) {
        return 1;
    }

    public int deleteByPrimaryKey(Integer catalogId) {
        return 1;
    }
}
