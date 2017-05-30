package mx.com.newOrg.commons.DTO;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class AddressDTO extends AbstractDTO<Long> {

    /**
     * 
     */
    private static final long serialVersionUID = -2949725323607949376L;

    private String city;

    private String country;

    private long externalNo;

    private long internalNo;

    private String state;

    private String street;

    private String streets;

    private String zipCode;

    public String getCity() {

        return city;
    }

    public void setCity(String city) {

        this.city = city;
    }

    public String getCountry() {

        return country;
    }

    public void setCountry(String country) {

        this.country = country;
    }

    public long getExternalNo() {

        return externalNo;
    }

    public void setExternalNo(long externalNo) {

        this.externalNo = externalNo;
    }

    public long getInternalNo() {

        return internalNo;
    }

    public void setInternalNo(long internalNo) {

        this.internalNo = internalNo;
    }

    public String getState() {

        return state;
    }

    public void setState(String state) {

        this.state = state;
    }

    public String getStreet() {

        return street;
    }

    public void setStreet(String street) {

        this.street = street;
    }

    public String getStreets() {

        return streets;
    }

    public void setStreets(String streets) {

        this.streets = streets;
    }

    public String getZipCode() {

        return zipCode;
    }

    public void setZipCode(String zipCode) {

        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object obj) {

        boolean flag = false;
        if (obj != null) {
            if (obj == this) {
                flag = true;
            } else if (obj.getClass() == this.getClass()) {
                flag = new EqualsBuilder().append(id, ((AddressDTO) obj).id)
                    .build();
            }
        }
        return flag;
    }

    @Override
    public int hashcode() {

        return new HashCodeBuilder().append(id).build();
    }

}
