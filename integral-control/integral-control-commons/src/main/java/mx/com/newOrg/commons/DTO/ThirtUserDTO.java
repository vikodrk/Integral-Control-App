package mx.com.newOrg.commons.DTO;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ThirtUserDTO extends AbstractSignedDTO<Long> {

    /**
     * 
     */
    private static final long serialVersionUID = -3794873579532376902L;

    private AddressDTO address;

    private List<ReportDTO> asignedReports;

    private String cellPhone;

    private String email;

    private String firstName;

    private String lastName;

    private String name;

    private String pass;

    private String phoneNumber;

    private String userName;

    public AddressDTO getAddress() {

        return address;
    }

    public void setAddress(AddressDTO address) {

        this.address = address;
    }

    public List<ReportDTO> getAsignedReports() {

        return asignedReports;
    }

    public void setAsignedReports(List<ReportDTO> asignedReports) {

        this.asignedReports = asignedReports;
    }

    public String getCellPhone() {

        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {

        this.cellPhone = cellPhone;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
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

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getPass() {

        return pass;
    }

    public void setPass(String pass) {

        this.pass = pass;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    @Override
    public boolean equals(Object obj) {

        boolean flag = false;
        if (obj != null) {
            if (obj == this) {
                flag = true;
            } else if (obj.getClass() == this.getClass()) {
                flag = new EqualsBuilder().append(id, ((ThirtUserDTO) obj).id)
                    .build();
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

        builder.append(" [ ").append(id == null ? " -- " : id).append(" ] - ");
        builder.append(name).append(" ").append(firstName).append(" ")
            .append(lastName);
        builder.append(" { ").append(userName).append(" } ");

        return builder.toString();
    }

}
