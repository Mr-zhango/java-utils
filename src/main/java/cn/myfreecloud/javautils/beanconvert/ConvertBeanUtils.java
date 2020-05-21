package cn.myfreecloud.javautils.beanconvert;

import org.springframework.beans.BeanUtils;

public class ConvertBeanUtils extends BeanUtils {

    public final static <T> T copy(Object source, Class<T> tclass) {

        if (source == null) {
            return null;
        }

        T t = null;
        try {
            t = tclass.newInstance();
            copyProperties(source, t);
            return t;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}