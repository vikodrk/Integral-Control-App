package mx.com.newOrg.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import mx.com.newOrg.model.AbstractSignedEntity;

@Entity
@Table(name = "USER_ROLL")
public class UserTypeDO extends AbstractSignedEntity<Long> {

    /**
     * 
     */
    private static final long serialVersionUID = 156213206203976777L;

    @Id
    @Column(name = "USER_TYPE_ID")
    private Long idUserType;

    @Column(name = "TYPE_DESC")
    private String userTypeDescription;

    public Long getIdUserType() {

        return idUserType;
    }

    public void setIdUserType(Long idUserType) {

        this.idUserType = idUserType;
    }

    public String getUserTypeDescription() {

        return userTypeDescription;
    }

    public void setUserTypeDescription(String userTypeDescription) {

        this.userTypeDescription = userTypeDescription;
    }

    @Override
    public boolean equals(Object obj) {

        boolean flag = false;

        if (obj != null) {
            if (obj == this) {
                flag = true;
            } else if (obj.getClass() == this.getClass()) {
                flag = new EqualsBuilder()
                    .append(idUserType, ((UserTypeDO) obj).idUserType)
                    .isEquals();
            }
        }

        return flag;
    }

    @Override
    public int hashCode() {

        return new HashCodeBuilder().append(idUserType).build();
    }

}
