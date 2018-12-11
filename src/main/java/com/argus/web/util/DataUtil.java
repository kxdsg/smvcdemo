package com.argus.web.util;

import org.springframework.cglib.beans.BeanGenerator;
import org.springframework.cglib.beans.BeanMap;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by xingding on 18/12/11.
 */
public class DataUtil {
    public DataUtil() {
    }

    public static Object convertMapToBean(Map map) {
        if(map == null) {
            return null;
        } else {
            BeanGenerator bg = new BeanGenerator();
            Iterator bm = map.keySet().iterator();

            Object o;
            while(bm.hasNext()) {
                o = bm.next();
                Object value = map.get(o);
                if(value != null) {
                    bg.addProperty(o.toString(), value.getClass());
                }
            }

            o = bg.create();
            BeanMap bm1 = BeanMap.create(o);
            bm1.putAll(map);
            return o;
        }
    }
}

