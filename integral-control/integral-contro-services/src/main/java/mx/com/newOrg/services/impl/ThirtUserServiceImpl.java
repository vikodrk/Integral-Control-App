package mx.com.newOrg.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.com.newOrg.commons.CustomAppCache;
import mx.com.newOrg.commons.DTO.ThirtUserDTO;
import mx.com.newOrg.commons.secureHash.StringHash;
import mx.com.newOrg.commons.transformer.ThirtUserTransformer;
import mx.com.newOrg.model.entity.ThirtUserDO;
import mx.com.newOrg.services.IThirtUserService;

public class ThirtUserServiceImpl implements IThirtUserService {

    private static int count = 0;

    private static int addressCount = 0;

    private static CustomAppCache<Long, ThirtUserDTO, ThirtUserDO> LOCAL_CACHE =
        new CustomAppCache<Long, ThirtUserDTO, ThirtUserDO>();

    public void createThirtUser(ThirtUserDTO dto) {

        ThirtUserDO userDO = ThirtUserTransformer.transformDTO(dto);
        userDO.setUserId(Long.valueOf(count++));
        userDO.setPass(StringHash.sha512(userDO.getPass()));
        userDO.getAddress().setAddressId(Long.valueOf(addressCount++));
        dto.setId(userDO.getUserId());
        dto.setPass(userDO.getPass());
        dto.getAddress().setId(userDO.getAddress().getAddressId());
        LOCAL_CACHE.putOnCache(userDO.getUserId(), dto, userDO);

    }

    public void updateThirtUser(ThirtUserDTO dto) {

        ThirtUserDO entity = ThirtUserTransformer.transformDTO(dto);
        LOCAL_CACHE.updateToCache(entity.getUserId(), dto, entity);

    }

    public void deleteThirtUser(ThirtUserDTO dto) {

        LOCAL_CACHE.deleteFromCache(dto.getId());

    }

    public List<ThirtUserDTO> findAll() {

        List<ThirtUserDTO> list = new ArrayList<ThirtUserDTO>();

        Set<Long> ids = LOCAL_CACHE.getID_MAP().keySet();

        for (Long iterator : ids) {
            list.add(LOCAL_CACHE.getFromCache(iterator));
        }

        return list;
    }

    public ThirtUserDTO findById(Long id) {

        ThirtUserDTO dto = null;

        if (LOCAL_CACHE.getID_MAP().containsKey(id)) {
            dto = LOCAL_CACHE.getFromCache(id);
        }

        return dto;
    }

    public ThirtUserDTO findByUserName(String userName) {

        ThirtUserDTO dto = null;

        Set<Long> ids = LOCAL_CACHE.getID_MAP().keySet();
        for (Long iterators : ids) {
            ThirtUserDTO tmp = LOCAL_CACHE.getFromCache(iterators);
            if (tmp.getUserName().equals(userName)) {
                dto = tmp;
                break;
            }
        }

        return dto;
    }

    public boolean loginProcessThirtUser(String userName, String password) {

        boolean flag = false;

        ThirtUserDTO dto = findByUserName(userName);
        if (dto != null) {
            flag = dto.getPass().equals(StringHash.sha512(password));
        }

        return flag;
    }

}
