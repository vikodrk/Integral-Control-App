package mx.com.newOrg.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class AbstractEntity<T extends Serializable>
    extends AbstractSignedEntity<T> {

    /**
     * 
     */
    private static final long serialVersionUID = -9053581082297612928L;

    @Column(name = "ENABLE", nullable = false)
    private Boolean active;

    @Column(name = "LAST_USER_MODIFIED", nullable = false)
    private Long lastUserModified;

    @Column(name = "LAST_DATE_MODIFIED", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    public Boolean getActive() {

        return active;
    }

    public void setActive(Boolean active) {

        this.active = active;
    }

    public Long getLastUserModified() {

        return lastUserModified;
    }

    public void setLastUserModified(Long lastUserModified) {

        this.lastUserModified = lastUserModified;
    }

    public Date getLastModifiedDate() {

        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {

        this.lastModifiedDate = lastModifiedDate;
    }

}
