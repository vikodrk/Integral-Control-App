package mx.com.newOrg.commons.DTO;

import java.io.Serializable;
import java.util.Date;

public abstract class AbstractSignedDTO<T extends Serializable>
    extends AbstractDTO<T> {

    /**
     * 
     */
    private static final long serialVersionUID = 721318866207666763L;

    private long lastUserId;

    private Date lastDateEdit;

    private boolean enable;

    public long getLastUserId() {

        return lastUserId;
    }

    public void setLastUserId(long lastUserId) {

        this.lastUserId = lastUserId;
    }

    public Date getLastDateEdit() {

        return lastDateEdit == null ? null : (Date) lastDateEdit.clone();
    }

    public void setLastDateEdit(Date lastDateEdit) {

        this.lastDateEdit =
            lastDateEdit == null ? null : (Date) lastDateEdit.clone();
    }

    public boolean isEnable() {

        return enable;
    }

    public void setEnable(boolean enable) {

        this.enable = enable;
    }

}
