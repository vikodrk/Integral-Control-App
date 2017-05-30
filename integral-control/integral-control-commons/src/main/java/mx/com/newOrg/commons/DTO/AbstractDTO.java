package mx.com.newOrg.commons.DTO;

import java.io.Serializable;

public abstract class AbstractDTO<T extends Serializable>
    implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -2726886437427715869L;
    
    protected T id;

    public T getId() {

        return id;
    }

    public void setId(T id) {

        this.id = id;
    }

    public abstract boolean equals(Object obj);

    public abstract int hashCode();

}
