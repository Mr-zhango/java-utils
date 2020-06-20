package cn.myfreecloud.javautils.office;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.cglib.beans.BeanMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;


public class BeanListUtils {

    private BeanListUtils(){
        // Do nothing because Utility classes should not have public constructors
    }

    /**
     * 将List<T>转换为List<Map<String, Object>>
     * @param objList
     * @return
     */
    public static <T> List<Map<String, Object>> objectsToMaps(List<T> objList) {
        List<Map<String, Object>> list = Lists.newArrayList();
        if (objList != null && !objList.isEmpty()) {
            Map<String, Object> map = null;
            T bean = null;
            for (int i = 0,size = objList.size(); i < size; i++) {
                bean = objList.get(i);
                map = beanToMap(bean);
                list.add(map);
            }
        }
        return list;
    }


    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = Maps.newHashMap();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key+"", beanMap.get(key));
            }
        }
        return map;
    }


    /**
     * 针对list操作
     * @param list
     * @param function
     * @param <F>
     * @param <R>
     * @return
     */
    public static <F, R> List<R> listConvert(List<F> list, Function<F, R> function) {
        List<R> listN = new ArrayList<>();
        if (list == null){
            return listN;
        }
        for (F value : list) {
            R r = function.apply(value);
            if (r != null){
                listN.add(r);
            }
        }
        return listN;
    }



}
