package mx.com.newOrg.commons.transformer;

import mx.com.newOrg.commons.DTO.ThirtUserDTO;
import mx.com.newOrg.model.entity.ThirtUserDO;

public final class ThirtUserTransformer {

    public static ThirtUserDTO transformDO(ThirtUserDO entity) {

        ThirtUserDTO dto = new ThirtUserDTO();

        dto.setAddress(AddressTransformer.transformDO(entity.getAddress()));
        dto.setAsignedReports(
            ReportTransformer.transformDO(entity.getAsignedReports()));
        dto.setCellPhone(entity.getCellPhone());
        dto.setEmail(entity.getEmail());
        dto.setEnable(entity.getActive());
        dto.setFirstName(entity.getFirstName());
        dto.setId(entity.getUserId());
        dto.setLastDateEdit(entity.getLastModifiedDate());
        dto.setLastName(entity.getLastName());
        dto.setLastUserId(entity.getLastUserModified());
        dto.setName(entity.getName());
        dto.setPass(entity.getPass());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setUserName(entity.getUserName());

        return dto;
    }

    public static ThirtUserDO transformDTO(ThirtUserDTO dto) {

        ThirtUserDO entity = new ThirtUserDO();

        entity.setActive(dto.isEnable());
        entity.setAddress(AddressTransformer.transformDTO(dto.getAddress()));
        entity.setAsignedReports(
            ReportTransformer.transformDTO(dto.getAsignedReports()));
        entity.setCellPhone(dto.getCellPhone());
        entity.setEmail(dto.getEmail());
        entity.setFirstName(dto.getFirstName());
        entity.setLastModifiedDate(dto.getLastDateEdit());
        entity.setLastName(dto.getLastName());
        entity.setLastUserModified(dto.getLastUserId());
        entity.setName(dto.getName());
        entity.setPass(dto.getPass());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setUserId(dto.getId());
        entity.setUserName(dto.getUserName());

        return entity;
    }

}
