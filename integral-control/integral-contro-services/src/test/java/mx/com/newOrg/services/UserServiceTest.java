package mx.com.newOrg.services;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mx.com.newOrg.commons.DTO.UserDTO;
import mx.com.newOrg.commons.commonsEnum.UserTypeEnum;
import mx.com.newOrg.services.impl.UserServiceImpl;

public class UserServiceTest {
    
    private IUserService service;
    
    @Before
    public void init()
    {
        service = new UserServiceImpl();
    }
    
    @Test
    public void testCreateUser()
    {
        UserDTO user = new UserDTO();
        user.setFirstName("Blanco");
        user.setLastName("Romero");
        user.setName("Victor");
        user.setUserName("vblanco");
        user.setPasswd("pass");
        user.setUserType(UserTypeEnum.ROOT);
        service.createUser(user);
        assertNotNull(service.findUserByName(user.getUserName()));
    }
    
    

}
