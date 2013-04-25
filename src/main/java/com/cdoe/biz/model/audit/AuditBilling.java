
package com.cdoe.biz.model.audit;

import java.util.Date;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A persistable business object which is a part of the application's domain
 * model. Normally, but not necessarily a business object represents a mapping
 * to a database table in Web applications generated by ResQSoft Engineer.
 * 
 * @author ResQSoft, Inc. (ResQSoft Engineer)
 * @version $Revision: $
 */
@XmlRootElement
@Entity
@Table(name = "`AUDIT_BILLING`")
public class AuditBilling implements Serializable {

	/**
	 * Explicit serialVersionUID is considered a best practice, but may not
	 * matter to developers in many cases. Explicit serialVersionUID generated
	 * to guard against risk of "unexpected InvalidClassExceptions during
	 * deserialization" due to variations in compiler implementations. Should be
	 * changed when definition (i.e. serializable attributes) of class changes
	 * _if_ there is any chance that an instance of this class has been
	 * serialized and will be deserialized later. This value should not be
	 * changed if the class definition has not changed.
	 * 
	 * References:
	 * http://java.sun.com/j2se/1.5.0/docs/api/java/io/Serializable.html
	 * http://www.javaworld.com/javaworld/javaqa/2003-06/02-qa-0627-mythser.html
	 * http://www.javapractices.com/Topic45.cjp
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * Autogenerated field
	 */
	@Id
	@SequenceGenerator(name="AUDIT_BILLING_SEQ", sequenceName="AUDIT_BILLING_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="AUDIT_BILLING_SEQ")
	@Column
	private Long id;
	
	/**
	 * Hibernate provides optimistic locking through a version property on this persistent 
	 * object which is automatically managed by Hibernate. This version number will be used 
	 * by Hibernate to check that the row has not been updated since the last time it was 
	 * retrieved when updating the persistent object. 
	 * */
	@Version
	private Long version;
	
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	

	@Column(name = "`USER_ID`")
	private String userId;

    public String getUserId () {
        return this.userId;
    }

    public void setUserId (String userId) {
        this.userId = userId;
    }

	@Column(name = "`UPDATE_TIMESTAMP`")
	private Date updateTimestamp;

    public Date getUpdateTimestamp () {
        return this.updateTimestamp;
    }

    public void setUpdateTimestamp (Date updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

	@Column(name = "`TOTAL_ALLOCATION_DIFFERENCE`")
	private Double totalAllocationDifference;

    public Double getTotalAllocationDifference () {
        return this.totalAllocationDifference;
    }

    public void setTotalAllocationDifference (Double totalAllocationDifference) {
        this.totalAllocationDifference = totalAllocationDifference;
    }

	@Column(name = "`DAILY_RATE`")
	private Double dailyRate;

    public Double getDailyRate () {
        return this.dailyRate;
    }

    public void setDailyRate (Double dailyRate) {
        this.dailyRate = dailyRate;
    }

	@Column(name = "`ORG_DAYS`")
	private Double orgDays;

    public Double getOrgDays () {
        return this.orgDays;
    }

    public void setOrgDays (Double orgDays) {
        this.orgDays = orgDays;
    }

	@Column(name = "`ORG_TOTAL_ALLOCATION`")
	private Double orgTotalAllocation;

    public Double getOrgTotalAllocation () {
        return this.orgTotalAllocation;
    }

    public void setOrgTotalAllocation (Double orgTotalAllocation) {
        this.orgTotalAllocation = orgTotalAllocation;
    }

	@Column(name = "`AUDIT_DAYS`")
	private Double auditDays;

    public Double getAuditDays () {
        return this.auditDays;
    }

    public void setAuditDays (Double auditDays) {
        this.auditDays = auditDays;
    }

	@Column(name = "`AUDIT_TOTAL_ALLOCATION`")
	private Double auditTotalAllocation;

    public Double getAuditTotalAllocation () {
        return this.auditTotalAllocation;
    }

    public void setAuditTotalAllocation (Double auditTotalAllocation) {
        this.auditTotalAllocation = auditTotalAllocation;
    }

	@Column(name = "`ORGANIZATION_CODE`")
	private String organizationCode;

    public String getOrganizationCode () {
        return this.organizationCode;
    }

    public void setOrganizationCode (String organizationCode) {
        this.organizationCode = organizationCode;
    }

	@Column(name = "`AUDIT_ID`")
	private Integer auditId;

    public Integer getAuditId () {
        return this.auditId;
    }

    public void setAuditId (Integer auditId) {
        this.auditId = auditId;
    }

	@Column(name = "`FISCAL_YEAR`")
	private String fiscalYear;

    public String getFiscalYear () {
        return this.fiscalYear;
    }

    public void setFiscalYear (String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

}