package org.smart4j.chapter2.Util;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.Collection;
import java.util.Map;

public class CollectionUtil {

    public static boolean isEmpty(Collection<?> collection){
        return CollectionUtils.isEmpty(collection);
    }

    public static boolean isEmpty(Map<?,?> map){
        return MapUtils.isEmpty(map);
    }

}
