package mx.com.newOrg.commons.transformer;

import mx.com.newOrg.commons.DTO.UserDTO;
import mx.com.newOrg.commons.commonsEnum.UserTypeEnum;
import mx.com.newOrg.model.entity.UserDO;

public final class UserTransformer {

    private UserTransformer() {

    }

    public static UserDTO transformEntity(UserDO entity) {

        UserDTO dto = new UserDTO();

        dto.setFirstName(entity.getFirstName());
        dto.setId(entity.getUserId());
        dto.setLastName(entity.getLastName());
        dto.setName(entity.getName());
        dto.setPasswd(entity.getPasswd());
        dto.setUserName(entity.getUserName());
        dto.setUserType(
            UserTypeEnum.obtainEnumById(entity.getUserType().getIdUserType()));

        return dto;
    }

    public static UserDO transformDTO(UserDTO dto) {

        UserDO entity = new UserDO();

        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setName(dto.getName());
        entity.setPasswd(dto.getPasswd());
        entity.setUserName(dto.getUserName());
        entity.setUserType(UserTypeEnum.obtainEntity(dto.getUserType().getId()));

        return entity;
    }

}
