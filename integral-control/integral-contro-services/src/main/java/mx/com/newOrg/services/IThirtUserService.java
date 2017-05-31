package mx.com.newOrg.services;

import java.util.List;

import mx.com.newOrg.commons.DTO.ThirtUserDTO;

public interface IThirtUserService {

    void createThirtUser(ThirtUserDTO dto);

    void updateThirtUser(ThirtUserDTO dto);

    void deleteThirtUser(ThirtUserDTO dto);

    List<ThirtUserDTO> findAll();

    ThirtUserDTO findById(Long id);

    ThirtUserDTO findByUserName(String userName);

    boolean loginProcessThirtUser(String userName, String password);

}
