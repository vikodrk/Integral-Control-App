package mx.com.newOrg.commons.DTO;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ReportDTO extends AbstractSignedDTO<Long> {

    /**
     * 
     */
    private static final long serialVersionUID = 3632397733277513899L;

    private String message;

    private String shortMessage;

    private Date reviewDate;

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }

    public String getShortMessage() {

        return shortMessage;
    }

    public void setShortMessage(String shortMessage) {

        this.shortMessage = shortMessage;
    }

    public Date getReviewDate() {

        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {

        this.reviewDate = reviewDate;
    }

    @Override
    public boolean equals(Object obj) {

        boolean flag = false;
        if (obj != null) {
            if (obj == this) {
                flag = true;
            } else if (obj.getClass() == this.getClass()) {
                flag = new EqualsBuilder().append(id, ((ReportDTO) obj).id)
                    .build();
            }
        }
        return flag;
    }

    @Override
    public int hashCode() {

        return new HashCodeBuilder().append(id).build();
    }

}
