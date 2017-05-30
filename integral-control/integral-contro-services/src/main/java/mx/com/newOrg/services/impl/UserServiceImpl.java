package mx.com.newOrg.services.impl;

import java.util.List;

import mx.com.newOrg.commons.GlobalAppCache;
import mx.com.newOrg.commons.DTO.UserDTO;
import mx.com.newOrg.commons.commonsEnum.UserTypeEnum;
import mx.com.newOrg.commons.transformer.UserTransformer;
import mx.com.newOrg.model.entity.UserDO;
import mx.com.newOrg.services.IUserService;

public class UserServiceImpl implements IUserService {

    private static int userCount = 0;

    public void createUser(UserDTO user) {

        UserDO entity = UserTransformer.transformDTO(user);
        entity.setUserId(Long.valueOf(userCount++));
        GlobalAppCache.putOnCache(entity.getUserId(), entity.getUserName(),
            entity);

    }

    public void updateUser(UserDTO user) {

        UserDO entity = UserTransformer.transformDTO(user);
        GlobalAppCache.updateElement(entity.getUserId(), entity.getUserName(),
            entity);

    }

    public void deleteUser(UserDTO user) {

        UserDO entity = UserTransformer.transformDTO(user);
        GlobalAppCache.deleteElement(entity.getUserId(), entity.getUserName());

    }

    public UserDTO findUserById(Long userId) {

        return UserTransformer.transformEntity((UserDO) GlobalAppCache.getFromCache(userId));
    }

    public UserDTO findUserByName(String name) {

        
        return UserTransformer.transformEntity((UserDO) GlobalAppCache.getFromCache(name));
    }

    public List<UserDTO> findAll() {

        // TODO Auto-generated method stub
        return null;
    }

    public List<UserDTO> findByType(UserTypeEnum userType) {

        // TODO Auto-generated method stub
        return null;
    }

}
