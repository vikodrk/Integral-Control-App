package mx.com.newOrg.commons;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import mx.com.newOrg.commons.DTO.AbstractDTO;
import mx.com.newOrg.model.AbstractSignedEntity;

/**
 * <code>CustomAppCache</code>.
 *
 * @version 1.0
 * @param <ID>
 *            generic type
 * @param <DTO>
 *            generic type
 * @param <DO>
 *            generic type
 */
public final class CustomAppCache<ID extends Serializable, DTO extends AbstractDTO<?>, DO extends AbstractSignedEntity<?>> {

    /** The constant LOG. */
    private static final Logger LOG = Logger.getLogger(CustomAppCache.class);

    /** La constante ID_MAP. */
    private Map<ID, DTO> ID_MAP = new HashMap<ID, DTO>();

    /** La constante OBJECT_MAP. */
    private Map<DTO, DO> OBJECT_MAP = new HashMap<DTO, DO>();

    /** La constante OBJECT_LIST_MAP. */
    private Map<DTO, List<DO>> OBJECT_LIST_MAP = new HashMap<DTO, List<DO>>();

    public void clear() {

        ID_MAP.clear();
        OBJECT_MAP.clear();
        OBJECT_LIST_MAP.clear();
        LOG.info("Cache cleared!");
    }

    public DTO getFromCache(ID id) {

        DTO dto = null;
        if (ID_MAP.containsKey(id)) {
            dto = ID_MAP.get(id);
        }
        return dto;
    }

    public DO getFromCache(DTO dto) {

        DO entity = null;
        if (OBJECT_MAP.containsKey(dto)) {
            entity = OBJECT_MAP.get(dto);
        }
        return entity;
    }

    public List<DO> getListFromCache(DTO dto) {

        List<DO> list = null;
        if (OBJECT_LIST_MAP.containsKey(dto)) {
            list = OBJECT_LIST_MAP.get(dto);
        }
        return list;
    }

    /**
     * Put on cache.
     *
     * @param id
     *            id
     * @param dto
     *            dto
     * @param entity
     *            entity
     */
    public void putOnCache(ID id, DTO dto, DO entity) {

        LOG.info("Id on cache->" + id + "\nDTO on cache->" + dto);
        ID_MAP.put(id, dto);
        putOnCache(dto, entity);

    }

    /**
     * Put on cache.
     *
     * @param id
     *            id
     * @param dto
     *            dto
     * @param list
     *            list
     */
    public void putOnCache(ID id, DTO dto, List<DO> list) {

        LOG.info("Id on cache->" + id + "\nDTO on cache->" + dto);
        ID_MAP.put(id, dto);
        putOnCache(dto, list);

    }

    /**
     * Put on cache.
     *
     * @param dto
     *            dto
     * @param entity
     *            entity
     */
    public void putOnCache(DTO dto, DO entity) {

        LOG.info("DTO on cache->" + dto + "\nDO on cache->" + entity);
        OBJECT_MAP.put(dto, entity);

    }

    /**
     * Put on cache.
     *
     * @param dto
     *            dto
     * @param list
     *            list
     */
    public void putOnCache(DTO dto, List<DO> list) {

        LOG.info("DTO on cache->" + dto + "\nDO list on cache->" + list);
        OBJECT_LIST_MAP.put(dto, list);

    }

    /**
     * Delete from cache.
     *
     * @param id
     *            id
     */
    public void deleteFromCache(ID id) {

        LOG.info("ID to delete->" + id);
        if (ID_MAP.containsKey(id)) {
            deleteFromCache(ID_MAP.get(id));
            LOG.info("DTO deleted->" + ID_MAP.get(id));
            ID_MAP.remove(id);
        }
    }

    /**
     * Delete from cache.
     *
     * @param dto
     *            dto
     */
    public void deleteFromCache(DTO dto) {

        if (OBJECT_MAP.containsKey(dto)) {
            LOG.info("DO to delete->" + OBJECT_MAP.get(dto));
            OBJECT_MAP.remove(dto);
        }
        if (OBJECT_LIST_MAP.containsKey(dto)) {
            LOG.info("DO list to delete->" + OBJECT_LIST_MAP.get(dto));
            OBJECT_LIST_MAP.remove(dto);
        }
    }

    /**
     * Update to cache.
     *
     * @param id
     *            id
     * @param dto
     *            dto
     * @param entity
     *            entity
     */
    public void updateToCache(ID id, DTO dto, DO entity) {

        deleteFromCache(id);
        putOnCache(id, dto, entity);
    }

    /**
     * Update to cache.
     *
     * @param id
     *            id
     * @param dto
     *            dto
     * @param list
     *            list
     */
    public void updateToCache(ID id, DTO dto, List<DO> list) {

        deleteFromCache(id);
        putOnCache(id, dto, list);
    }

    public Map<ID, DTO> getID_MAP() {

        return ID_MAP;
    }

}
