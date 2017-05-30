package mx.com.newOrg.commons;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public final class GlobalAppCache {

    private static final Logger LOG = Logger.getLogger(GlobalAppCache.class);

    private static Map<Long, String> ID_MAP = new HashMap<Long, String>();

    private static Map<String, Serializable> OBJECT_MAP =
        new HashMap<String, Serializable>();

    private GlobalAppCache() {

    }

    public static void putOnCache(Long id, String name, Serializable dto) {

        ID_MAP.put(id, name);
        LOG.info("ID on cache: " + id + "\nName on cache: " + name);
        putOnCache(name, dto);
    }

    public static void putOnCache(String name, Serializable dto) {

        OBJECT_MAP.put(name, dto);
    }

    public static Serializable getFromCache(Long id) {

        Serializable obj = null;

        if (ID_MAP.containsKey(id)) {
            obj = getFromCache(ID_MAP.get(id));
        }

        return obj;
    }

    public static Serializable getFromCache(String name) {

        Serializable obj = null;

        obj = OBJECT_MAP.get(name);

        return obj;
    }

    public static void deleteElement(Long id, String name) {

        ID_MAP.remove(id);
        deleteElement(name);
    }

    public static void deleteElement(String name) {

        OBJECT_MAP.remove(name);
    }

    public static void updateElement(Long id, String name, Serializable obj) {

        deleteElement(id, name);
        putOnCache(id, name, obj);
    }

    public static void updateElement(String name, Serializable obj) {

        deleteElement(name);
        putOnCache(name, obj);
    }

}
