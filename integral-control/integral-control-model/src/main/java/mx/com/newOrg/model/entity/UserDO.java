package mx.com.newOrg.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import mx.com.newOrg.model.AbstractSignedEntity;

@Entity
@Table(name = "USERS")
@SequenceGenerator(name = "UserIdGenerator", sequenceName = "UserIdGenerator",
    initialValue = 1, allocationSize = 2)
public class UserDO extends AbstractSignedEntity<Long> {

    /**
     * 
     */
    private static final long serialVersionUID = 3331212952290191521L;

    @Id
    @GeneratedValue(generator = "userIdGenerator",
        strategy = GenerationType.SEQUENCE)
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "NAME")
    private String name;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "PASSWORD")
    private String passwd;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_TYPE_ID")
    private UserTypeDO userType;

    public UserTypeDO getUserType() {

        return userType;
    }

    public void setUserType(UserTypeDO userType) {

        this.userType = userType;
    }

    public Long getUserId() {

        return userId;
    }

    public void setUserId(Long userId) {

        this.userId = userId;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getPasswd() {

        return passwd;
    }

    public void setPasswd(String passwd) {

        this.passwd = passwd;
    }

    @Override
    public boolean equals(Object obj) {

        boolean flag = false;

        if (obj != null) {
            if (obj == this) {
                flag = true;
            } else if (obj.getClass() == this.getClass()) {
                flag = new EqualsBuilder().append(userId, ((UserDO) obj).userId)
                    .isEquals();
            }
        }

        return flag;
    }

    @Override
    public int hashCode() {

        return new HashCodeBuilder().append(userId).build();
    }

}
