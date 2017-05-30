package mx.com.newOrg.commons.commonsEnum;

import mx.com.newOrg.model.entity.UserTypeDO;

public enum UserTypeEnum {

    ROOT(0l),

    ADMIN(1l),

    MOD(2l),

    USER(3l),

    GUEST(4l);

    private Long id;

    private UserTypeEnum(Long id) {
        this.id = id;
    }

    public Long getId() {

        return id;
    }

    public static UserTypeEnum obtainEnumById(Long id) {

        UserTypeEnum result = null;

        int opc = id.intValue();
        switch (opc) {
            case 0:
                result = ROOT;
                break;
            case 1:
                result = ADMIN;
                break;
            case 2:
                result = MOD;
                break;
            case 3:
                result = USER;
                break;
            default:
                result = GUEST;

        }

        return result;
    }

    public static UserTypeDO obtainEntity(Long id) {

        UserTypeDO entity = new UserTypeDO();
        entity.setIdUserType(id);
        return entity;
    }
}
