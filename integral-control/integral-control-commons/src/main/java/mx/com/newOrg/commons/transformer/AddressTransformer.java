package mx.com.newOrg.commons.transformer;

import mx.com.newOrg.commons.DTO.AddressDTO;
import mx.com.newOrg.model.entity.AddresDO;

public final class AddressTransformer {

    private AddressTransformer() {

    }

    public static AddressDTO transformDO(AddresDO entity) {

        AddressDTO dto = new AddressDTO();

        dto.setCity(entity.getCity());
        dto.setCountry(entity.getCountry());
        dto.setExternalNo(entity.getExternalNo());
        dto.setId(entity.getAddressId());
        dto.setInternalNo(entity.getInternalNo());
        dto.setState(entity.getState());
        dto.setStreet(entity.getStreet());
        dto.setStreets(entity.getStreets());
        dto.setZipCode(entity.getZipCode());

        return dto;
    }

    public static AddresDO transformDTO(AddressDTO dto) {

        AddresDO entity = new AddresDO();
        
        entity.setAddressId(dto.getId());
        entity.setCity(dto.getCity());
        entity.setCountry(dto.getCountry());
        entity.setExternalNo(dto.getExternalNo());
        entity.setInternalNo(dto.getInternalNo());
        entity.setState(dto.getState());
        entity.setStreet(dto.getStreet());
        entity.setStreets(dto.getStreets());
        entity.setZipCode(dto.getZipCode());

        return entity;
    }

}
