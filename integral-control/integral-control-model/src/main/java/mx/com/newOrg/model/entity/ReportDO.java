package mx.com.newOrg.model.entity;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import mx.com.newOrg.model.AbstractEntity;

public class ReportDO extends AbstractEntity<Long> {

    /**
     * 
     */
    private static final long serialVersionUID = 2173382664685310428L;

    private Long reportId;

    private String shortMessage;

    private String message;

    private Date reviewDate;

    public Long getReportId() {

        return reportId;
    }

    public void setReportId(Long reportId) {

        this.reportId = reportId;
    }

    public String getShortMessage() {

        return shortMessage;
    }

    public void setShortMessage(String shortMessage) {

        this.shortMessage = shortMessage;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {

        this.message = message;
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
                flag = new EqualsBuilder()
                    .append(reportId, ((ReportDO) obj).reportId).build();
            }
        }
        return flag;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(reportId).build();
    }

}
