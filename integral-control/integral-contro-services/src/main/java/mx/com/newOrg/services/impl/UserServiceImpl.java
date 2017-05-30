package mx.com.newOrg.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.com.newOrg.commons.CustomAppCache;
import mx.com.newOrg.commons.DTO.UserDTO;
import mx.com.newOrg.commons.commonsEnum.UserTypeEnum;
import mx.com.newOrg.commons.secureHash.StringHash;
import mx.com.newOrg.commons.transformer.UserTransformer;
import mx.com.newOrg.model.entity.UserDO;
import mx.com.newOrg.services.IUserService;

public class UserServiceImpl implements IUserService {

    private static CustomAppCache<Long, UserDTO, UserDO> USER_CACHE =
        new CustomAppCache<Long, UserDTO, UserDO>();

    private static int userCount = 0;

    public void createUser(UserDTO user) {

        UserDO entity = UserTransformer.transformDTO(user);
        entity.setUserId(Long.valueOf(userCount++));
        entity.setPasswd(StringHash.sha384S(entity.getPasswd()));
        user.setId(entity.getUserId());
        USER_CACHE.putOnCache(entity.getUserId(), user, entity);

    }

    public void updateUser(UserDTO user) {

        UserDO entity = UserTransformer.transformDTO(user);
        USER_CACHE.updateToCache(user.getId(), user, entity);

    }

    public void deleteUser(UserDTO user) {

        USER_CACHE.deleteFromCache(user.getId());

    }

    public UserDTO findUserById(Long userId) {

        return USER_CACHE.getFromCache(userId);
    }

    public UserDTO findUserByName(String name) {

        Set<Long> ids = USER_CACHE.getID_MAP().keySet();

        for (Long idIterator : ids) {
            UserDTO dto = USER_CACHE.getFromCache(idIterator);
            if (dto.getUserName().equals(name)) {
                return dto;
            }
        }

        return null;
    }

    public List<UserDTO> findAll() {

        Set<Long> ids = USER_CACHE.getID_MAP().keySet();
        List<UserDTO> list = new ArrayList<UserDTO>();
        for (Long idIterator : ids) {

            list.add(USER_CACHE.getFromCache(idIterator));

        }

        return list;
    }

    public List<UserDTO> findByType(UserTypeEnum userType) {

        // TODO Auto-generated method stub
        return null;
    }

}
