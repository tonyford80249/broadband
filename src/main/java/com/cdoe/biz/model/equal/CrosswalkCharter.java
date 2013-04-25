
package com.cdoe.biz.model.equal;

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
@Table(name = "CROSSWALK_CHARTER")
public class CrosswalkCharter implements Serializable {

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
	@SequenceGenerator(name="CROSSWALK_CHARTER_SEQ", sequenceName="CROSSWALK_CHARTER_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CROSSWALK_CHARTER_SEQ")
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
	
	@Column(name="FTE_ELIG")
	private Integer fteElig;
	@Column(name="CDE_MEMBER")
	private String cdeMember;
	@Column(name="MEMBER")
	private String member;
	@Column(name="FTE_NOT_ELIG")
	private Double fteNotElig;
	@Column(name="DISTRICT_NUMBER")
	private String districtNumber;
	@Column(name="FISCAL_YEAR")
	private String fiscalYear;
	@Column(name="FUNDED_COUNT")
	private Double fundedCount;
	@Column(name="GRADE_LEVEL")
	private String gradeLevel;
	@Column(name="PARTTIME_F")
	private Double partTimeF;
	@Column(name="PARTTIME_H")
	private Double partTimeH;
	@Column(name="SCHOOL_CODE")
	private long schoolCode;
	
	
	@Column(name="UPDATE_TIMESTAMP")
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
	
	public Date getUpdateTimestamp() {
		return updateTimestamp;
	}
	public void setUpdateTimestamp(Date updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
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
	
	public Integer getFteElig() {
		return fteElig;
	}
	public void setFteElig(Integer fteElig) {
		this.fteElig = fteElig;
	}
	public String getCdeMember() {
		return cdeMember;
	}
	public void setCdeMember(String cdeMember) {
		this.cdeMember = cdeMember;
	}
	
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	public Double getFteNotElig() {
		return fteNotElig;
	}
	public void setFteNotElig(Double fteNotElig) {
		this.fteNotElig = fteNotElig;
	}
	
	public Double getFundedCount() {
		return fundedCount;
	}
	public void setFundedCount(Double fundedCount) {
		this.fundedCount = fundedCount;
	}
	
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getGradeLevel() {
		return gradeLevel;
	}
	public void setGradeLevel(String gradeLevel) {
		this.gradeLevel = gradeLevel;
	}
	public Double getPartTimeF() {
		return partTimeF;
	}
	public void setPartTimeF(Double partTimeF) {
		this.partTimeF = partTimeF;
	}
	public Double getPartTimeH() {
		return partTimeH;
	}
	public void setPartTimeH(Double partTimeH) {
		this.partTimeH = partTimeH;
	}
	
	public long getSchoolCode() {
		return schoolCode;
	}
	public void setSchoolCode(long schoolCode) {
		this.schoolCode = schoolCode;
	}
	
}