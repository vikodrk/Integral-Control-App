package mx.com.newOrg.model;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractSignedEntity<T extends Serializable> implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = -3728325900174944944L;

    public abstract boolean equals(Object obj);
    
    public abstract int hashCode();
    

}
