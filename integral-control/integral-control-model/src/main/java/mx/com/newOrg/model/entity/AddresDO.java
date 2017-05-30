package mx.com.newOrg.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import mx.com.newOrg.model.AbstractSignedEntity;

@Entity
@Table(name = "USER_ADDRESS")
@SequenceGenerator(name = "UserAddressSeq", sequenceName = "UserAddressSeq",
    initialValue = 1, allocationSize = 2)
public class AddresDO extends AbstractSignedEntity<Long> {

    /**
     * 
     */
    private static final long serialVersionUID = -4546520423535821208L;

    @Id
    @Column(name = "ADDRESS_ID")
    @GeneratedValue(generator = "UserAddressSeq",
        strategy = GenerationType.SEQUENCE)
    private Long addressId;

    @Column(name = "STREET", nullable = false)
    private String street;

    @Column(name = "STREETS")
    private String streets;

    @Column(name = "EXTERNAL_NUMBER", nullable = false)
    private Long externalNo;

    @Column(name = "INTERNAL_NUMBER")
    private Long internalNo;

    @Column(name = "CITY", nullable = false)
    private String city;

    @Column(name = "STATE", nullable = false)
    private String state;

    @Column(name = "COUNTRY", nullable = false)
    private String country;

    @Column(name = "ZIP_CODE", nullable = false)
    private String zipCode;

    public Long getAddressId() {

        return addressId;
    }

    public void setAddressId(Long addressId) {

        this.addressId = addressId;
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

    public Long getExternalNo() {

        return externalNo;
    }

    public void setExternalNo(Long externalNo) {

        this.externalNo = externalNo;
    }

    public Long getInternalNo() {

        return internalNo;
    }

    public void setInternalNo(Long internalNo) {

        this.internalNo = internalNo;
    }

    public String getCity() {

        return city;
    }

    public void setCity(String city) {

        this.city = city;
    }

    public String getState() {

        return state;
    }

    public void setState(String state) {

        this.state = state;
    }

    public String getCountry() {

        return country;
    }

    public void setCountry(String country) {

        this.country = country;
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
                flag = new EqualsBuilder()
                    .append(addressId, ((AddresDO) obj).addressId).build();
            }
        }
        return flag;
    }

    @Override
    public int hashCode() {

        return new HashCodeBuilder().append(addressId).build();
    }

}
