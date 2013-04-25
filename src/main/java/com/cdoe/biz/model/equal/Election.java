
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
@Table(name = "`ELECTION`")
public class Election implements Serializable {

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
	@SequenceGenerator(name="ELECTION_SEQ", sequenceName="ELECTION_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ELECTION_SEQ")
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
	
	
	@Column(name = "`CATEGORY_AMOUNT`")
	private Double categoryAmount;

    public Double getCategoryAmount () {
        return this.categoryAmount;
    }

    public void setCategoryAmount (Double categoryAmount) {
        this.categoryAmount = categoryAmount;
    }

	@Column(name = "`CATEGORY_VOTED`")
	private String  categoryHeld;

    public String getCategoryHeld () {
        return this.categoryHeld;
    }

    public void setCategoryHeld (String categoryHeld) {
       this.categoryHeld = categoryHeld;
    }

	@Column(name = "`VOTE_AGAINST`")
	private Long voteAgainst;

    public Long getVoteAgainst () {
        return this.voteAgainst;
    }

    public void setVoteAgainst (Long voteAgainst) {
        this.voteAgainst = voteAgainst;
    }
    
   	@Column(name = "`VOTE_FOR`")
	private Long voteFor;

    public Long getVoteFor () {
        return this.voteFor;
    }

    public void setVoteFor (Long voteFor) {
        this.voteFor = voteFor;
    }

    @Column(name = "`CATEGORY`")
	private String category;

    public String getCategory () {
        return this.category;
    }

    public void setCategory (String category) {
        this.category = category;
    }

	@Column(name = "`BALLOT_LANGUAGE`")
	private String ballotLanguage;

    public String getBallotLanguage () {
        return this.ballotLanguage;
    }

    public void setBallotLanguage (String ballotLanguage) {
        this.ballotLanguage = ballotLanguage;
    }

    @Column(name = "`ELECTION_HELD`")
	private String electionHeld;

    public String getElectionHeld () {
        return this.electionHeld;
    }

    public void setElectionHeld (String electionHeld) {
        this.electionHeld = electionHeld;
    }

    
    @Column(name="DISTRICT_NUMBER")
   	private String districtNumber;
       

   	public String getDistrictNumber() {
   		return districtNumber;
   	}
   	public void setDistrictNumber(String districtNumber) {
   		this.districtNumber = districtNumber;
   	}
   	
   	
    @Column(name="USER_ID")
    private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Column(name="FISCAL_YEAR")
	private String fiscalYear;

	public String getFiscalYear() {
		return fiscalYear;
	}

	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}
	
	@Column(name = "`BALLOT_UPLOADED`")
	private String  ballotUploaded;

    public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getBallotUploaded() {
        return this.categoryHeld;
    }

    public void setBallotUploaded (String ballotUploaded) {
       this.ballotUploaded = ballotUploaded;
    }
}