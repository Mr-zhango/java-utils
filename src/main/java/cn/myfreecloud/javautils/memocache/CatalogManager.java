package cn.myfreecloud.javautils.memocache;

import cn.myfreecloud.javautils.beanconvert.ConvertBeanUtils;
import cn.myfreecloud.javautils.memocache.dto.CatalogDTO;
import cn.myfreecloud.javautils.memocache.entity.CatalogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class CatalogManager {
    // (分类信息)内存缓存(线程安全的)
    private ConcurrentHashMap<Integer, CatalogEntity> catalogCache = new ConcurrentHashMap<>();

    @Autowired
    private CataLogDao cataLogDao;

    /**
     * 在项目启动的时候就加载缓存
     */
    @PostConstruct
    public void initCache() {
        List<CatalogEntity> entityList = cataLogDao.selectAll();

        for (CatalogEntity catalogEntity : entityList) {
            catalogCache.put(catalogEntity.getId(), catalogEntity);
        }
    }

    /**
     * 添加一种分类
     */
    public void addCatalog(String catalogName) {
        CatalogEntity catalogEntity = new CatalogEntity();
        catalogEntity.setName(catalogName);


        CatalogEntity entity = cataLogDao.insertSelective();
        // 加入缓存
        catalogCache.put(entity.getId(), entity);
    }

    /**
     * 更新分类信息
     *
     * @param catalogEntity
     */
    public void updateCatalog(CatalogEntity catalogEntity) {
        int row = cataLogDao.updatBySelective(catalogEntity);

        // 更新成功了
        if (row > 0) {
            // 防止对象被别人 操作 篡改值
            catalogCache.put(catalogEntity.getId(), ConvertBeanUtils.copy(catalogEntity, CatalogEntity.class));
        }
    }


    /**
     * 查询所有分类信息
     */
    public List<CatalogDTO> queryAllCatalog() {
        return catalogCache.values().stream().map(
                e -> ConvertBeanUtils.copy(e, CatalogDTO.class)
        ).collect(Collectors.toList());
    }

    /**
     * 查询某一个分类信息
     */
    public CatalogDTO getCatalog(Integer catalogId) {
        return ConvertBeanUtils.copy(catalogCache.get(catalogId), CatalogDTO.class);
    }

    /**
     * 删除缓存
     */
    public void removeCatalog(Integer catalogId) {

        int row = cataLogDao.deleteByPrimaryKey(catalogId);

        // 更新成功了
        if (row > 0) {

            catalogCache.remove(catalogId);
        }
    }


}
