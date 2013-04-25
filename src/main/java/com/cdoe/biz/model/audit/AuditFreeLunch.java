
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
import javax.persistence.Temporal;
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
@Table(name = "AUDIT_FREE_LUNCH")
public class AuditFreeLunch implements Serializable {

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
	@SequenceGenerator(name="AUDIT_FREE_LUNCH_SEQ", sequenceName="AUDIT_FREE_LUNCH_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="AUDIT_FREE_LUNCH_SEQ")
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
	
	@Column(name="AUDIT_ID")
	private Integer auditID;
	@Column(name="CHANGE_TYPE")
	private String changeType;
	@Column(name="DATE_CHANGED")
	private String dateChange;
	@Column(name="DISTRICT_NUMBER")
	private String districtNumber;
	@Column(name="FISCAL_YEAR")
	private String fiscalYear;
	@Column(name="LUNCH_F")
	private Double lunchF;
	@Column(name="GRADE_LEVEL")
	private String gradeLevel;
	//@Column(name="MONTH_NOS")
	//private String monthNos;
	
	@Column(name="UPDATE_TIMESTAMP")
        @Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date updateTimestamp;
	@Column(name="USER_ID")
	private String userId;
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
	public Integer getAuditID() {
		return auditID;
	}
	public void setAuditID(Integer auditID) {
		this.auditID = auditID;
	}
	public String getChangeType() {
		return changeType;
	}
	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}
	public String getDateChange() {
		return dateChange;
	}
	public void setDateChange(String dateChange) {
		this.dateChange = dateChange;
	}
	public String getDistrictNumber() {
		return districtNumber;
	}
	public void setDistrictNumber(String districtNumber) {
		this.districtNumber = districtNumber;
	}
	public String getFiscalYear() {
		return fiscalYear;
	}
	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}
	public Double getLunchF() {
		return lunchF;
	}
	public void setLunchF(Double lunchF) {
		this.lunchF = lunchF;
	}
	public String getGradeLevel() {
		return gradeLevel;
	}
	public void setGradeLevel(String gradeLevel) {
		this.gradeLevel = gradeLevel;
	}
        /*
	public String getMonthNos() {
		return monthNos;
	}
	public void setMonthNos(String monthNos) {
		this.monthNos = monthNos;
	}*/
	public Date getUpdateTimestamp() {
		return updateTimestamp;
	}
	public void setUpdateTimestamp(Date updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}