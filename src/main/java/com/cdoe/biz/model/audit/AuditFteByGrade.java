
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
@Table(name = "AUDIT_FTE_BY_GRADE")
public class AuditFteByGrade implements Serializable {

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
	@SequenceGenerator(name="AUDIT_FTE_BY_GRADE_SEQ", sequenceName="AUDIT_FTE_BY_GRADE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="AUDIT_FTE_BY_GRADE_SEQ")
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
	
	@Column(name = "ASCENT")
	private Double ascent;
	@Column(name = "AUDIT_ID")
	private Integer auditID;
	@Column(name = "CDE_MEMBER")
	private Double cdeMember;
	@Column(name = "District_Number")
	private String districtNumber;
	@Column(name = "FISCAL_YEAR")
	private String fiscalYear;
	@Column(name = "DATE_CHANGED")
	private String dateChanged;
	@Column(name = "CHANGE_TYPE")
	private String changeType;
	@Column(name = "FTE_NOT_ELIG")
	private Double fteNotElig;
	@Column(name = "FTE_ELIG")
	private Double fteElig;
	@Column(name = "MEMBER")
	private Double member;
	@Column(name="ONLINE_TOT")
	private Double onlineTot;
	@Column(name = "OUT_OF_DIST")
	private Double outOfDist;
	@Column(name = "PARTTIME_H")
	private Double parttimeH;
	@Column(name = "PARTTIME_F")
	private Double parttimeF;
	@Column(name = "FUNDED_COUNT")
	private Double fundedCount;
	@Column(name = "GRADE_LEVEL")
	private String gradeLevel;
	@Column(name = "USER_ID")
	private String userId;
	@Column(name = "UPDATE_TIMESTAMP")
        @Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date updateTimestamp;
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
	public Double getAscent() {
		return ascent;
	}
	public void setAscent(Double ascent) {
		this.ascent = ascent;
	}
	public Integer getAuditID() {
		return auditID;
	}
	public void setAuditID(Integer auditID) {
		this.auditID = auditID;
	}
	public Double getCdeMember() {
		return cdeMember;
	}
	public void setCdeMember(Double cdeMember) {
		this.cdeMember = cdeMember;
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
	public String getDateChanged() {
		return dateChanged;
	}
	public void setDateChanged(String dateChanged) {
		this.dateChanged = dateChanged;
	}
	public String getChangeType() {
		return changeType;
	}
	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}
	public Double getFteNotElig() {
		return fteNotElig;
	}
	public void setFteNotElig(Double fteNotElig) {
		this.fteNotElig = fteNotElig;
	}
	public Double getFteElig() {
		return fteElig;
	}
	public void setFteElig(Double fteElig) {
		this.fteElig = fteElig;
	}
	public Double getMember() {
		return member;
	}
	public void setMember(Double member) {
		this.member = member;
	}
	public Double getOnlineTot() {
		return onlineTot;
	}
	public void setOnlineTot(Double onlineTot) {
		this.onlineTot = onlineTot;
	}
	public Double getOutOfDist() {
		return outOfDist;
	}
	public void setOutOfDist(Double outOfDist) {
		this.outOfDist = outOfDist;
	}
	public Double getParttimeH() {
		return parttimeH;
	}
	public void setParttimeH(Double parttimeH) {
		this.parttimeH = parttimeH;
	}
	public Double getParttimeF() {
		return parttimeF;
	}
	public void setParttimeF(Double parttimeF) {
		this.parttimeF = parttimeF;
	}
	public Double getFundedCount() {
		return fundedCount;
	}
	public void setFundedCount(Double fundedCount) {
		this.fundedCount = fundedCount;
	}
	public String getGradeLevel() {
		return gradeLevel;
	}
	public void setGradeLevel(String gradeLevel) {
		this.gradeLevel = gradeLevel;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getUpdateTimestamp() {
		return updateTimestamp;
	}
	public void setUpdateTimestamp(Date updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}

}