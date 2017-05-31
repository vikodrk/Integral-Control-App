package mx.com.newOrg.commons.DTO;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ReportDTO extends AbstractSignedDTO<Long> {

    /**
     * 
     */
    private static final long serialVersionUID = 3632397733277513899L;

    private long assignedId;

    private String message;

    private String shortMessage;

    private Date reviewDate;

    public long getAssignedId() {

        return assignedId;
    }

    public void setAssignedId(long assignedId) {

        this.assignedId = assignedId;
    }

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

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append(" [ ").append(id).append(" ] ");
        builder.append("\t -- ").append(shortMessage).append(" - ")
            .append(reviewDate).append(" - ").append(" --\n");
        builder.append(message).append("\n").append(" { ")
            .append(getLastUserId()).append(" - ").append(getLastDateEdit())
            .append(" } ");

        return builder.toString();
    }

}
