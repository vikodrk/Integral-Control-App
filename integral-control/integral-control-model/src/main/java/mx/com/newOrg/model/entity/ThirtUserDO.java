package mx.com.newOrg.model.entity;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import mx.com.newOrg.model.AbstractEntity;

public class ThirtUserDO extends AbstractEntity<Long> {

    /**
     * 
     */
    private static final long serialVersionUID = -3764086320779521631L;

    private Long userId;

    private String userName;

    private String pass;

    private String email;

    private String phoneNumber;

    private String cellPhone;

    private String name;

    private String firstName;

    private String lastName;

    private AddresDO address;

    private List<ReportDO> asignedReports;

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

    public String getPass() {

        return pass;
    }

    public void setPass(String pass) {

        this.pass = pass;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }

    public String getCellPhone() {

        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {

        this.cellPhone = cellPhone;
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

    public AddresDO getAddress() {

        return address;
    }

    public void setAddress(AddresDO address) {

        this.address = address;
    }

    public List<ReportDO> getAsignedReports() {

        return asignedReports;
    }

    public void setAsignedReports(List<ReportDO> asignedReports) {

        this.asignedReports = asignedReports;
    }

    @Override
    public boolean equals(Object obj) {

        boolean flag = false;
        if (obj != null) {
            if (obj == this) {
                flag = true;
            } else if (obj.getClass() == this.getClass()) {
                flag = new EqualsBuilder()
                    .append(userId, ((ThirtUserDO) obj).userId).build();
            }
        }
        return flag;
    }

    @Override
    public int hashCode() {

        return new HashCodeBuilder().append(userId).build();
    }

}
