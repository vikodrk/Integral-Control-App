package mx.com.newOrg.commons.DTO;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import mx.com.newOrg.commons.commonsEnum.UserTypeEnum;

public class UserDTO extends AbstractDTO<Long> {

    /**
     * 
     */
    private static final long serialVersionUID = 2407788594373464806L;

    private String name;

    private String userName;

    private String firstName;

    private String lastName;

    private String passwd;

    private UserTypeEnum userType;

    public UserTypeEnum getUserType() {

        return userType;
    }

    public void setUserType(UserTypeEnum userType) {

        this.userType = userType;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
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
                flag =
                    new EqualsBuilder().append(id, ((UserDTO) obj).id).build();
            }
        }

        return flag;
    }

    @Override
    public int hashCode() {

        return new HashCodeBuilder().append(id).build();
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append(" [ ").append(id).append(" ] ");
        builder.append(name).append(" ").append(firstName).append(" ")
            .append(lastName);
        builder.append(" { ").append(userName).append(" }");

        return builder.toString();
    }

}
