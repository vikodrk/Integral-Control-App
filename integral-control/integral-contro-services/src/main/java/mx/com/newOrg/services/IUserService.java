package mx.com.newOrg.services;

import java.util.List;

import mx.com.newOrg.commons.DTO.UserDTO;
import mx.com.newOrg.commons.commonsEnum.UserTypeEnum;

public interface IUserService {

    void createUser(UserDTO user);

    void updateUser(UserDTO user);

    void deleteUser(UserDTO user);

    UserDTO findUserById(Long userId);

    UserDTO findUserByName(String name);

    List<UserDTO> findAll();

    List<UserDTO> findByType(UserTypeEnum userType);
    
    boolean loginProcessUser(String username, String password);

}
