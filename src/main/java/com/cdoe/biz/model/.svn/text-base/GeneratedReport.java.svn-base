package com.cdoe.biz.model;


import java.io.Serializable;
import java.util.Date;
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
 *
 * @author Tony Ford
 */
@XmlRootElement
@Entity
@Table(name = "`GENERATED_REPORT`")
public class GeneratedReport implements ISeViewableReport {

    private static final long serialVersionUID = 1L;
    
    /**
     * primary key
     */
    @Id
    @SequenceGenerator(name = "GEN_REPORT_SEQ", sequenceName = "GEN_REPORT_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_REPORT_SEQ")
    @Column
    private Long id;
    /**
     * Hibernate provides optimistic locking through a version property on this
     * persistent object which is automatically managed by Hibernate. This
     * version number will be used by Hibernate to check that the row has not
     * been updated since the last time it was retrieved when updating the
     * persistent object. 
  *
     */
    @Version
    private Long version;
    
    /**
     * used to order reports for display
     */
    @Column(name = "`SEQUENCE`")
    private Integer sequence;
    
    /**
     * the report name
     */
    @Column(name = "`NAME`")
    private String name;
    
    /**
     * The uri/url used to retrieve the report from the web.
     */
    @Column(name = "`URL`")
    private String url;
    
    /**
     * The location of the report on the disk drive. 
     */
    @Column(name = "`LOCATION`")
    private String absolutePath;
    
    /**
     * An indicator that indicates that a report has been uploaded to the web server or published.
     */
    @Column(name = "`PUBLISHED`")
    private Boolean published;
    
    /**
     * 
     */
    @Column(name="PUBLISHED_DATE")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date publishedDate;
    
    /**
     * The fiscal year the report represents
     */
    @Column(name = "`FISCAL_YEAR`")    
    private String fiscalYear;
    
    /**
     * The fiscal month the report represents
     */
    @Column(name = "`FISCAL_MONTH`")
    private String fiscalMonth;
    
    /**
     * Report Grouping (used to group reports for viewing)
     */
    @Column(name = "`REPORT_TYPE`")
    private String reportType;
    
    /**
     * 
     */
    @Column(name="USER_ID")
    private String userId;
    
    /**
     * 
     */
    @Column(name="DATE_CREATED")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateCreated;
    
    
    

    /**
     * 
     */
    public GeneratedReport() {
    }

    /**
     * 
     * @param name
     * @param url
     * @param absolutePath 
     */
    public GeneratedReport(String name, String url, String absolutePath) {
        this.name = name;
        this.url = url;
        this.absolutePath = absolutePath;
    }

    /**
     * 
     * @param name
     * @param url
     * @param absolutePath
     * @param fiscalYear
     * @param fiscalMonth
     * @param reportType 
     */
    public GeneratedReport(String name, String url, String absolutePath, String fiscalYear, String fiscalMonth, String reportType) {
        this.name = name;
        this.url = url;
        this.absolutePath = absolutePath;
        this.fiscalYear = fiscalYear;
        this.fiscalMonth = fiscalMonth;
        this.reportType = reportType;
    }

    /**
     * 
     * @return 
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     * @return 
     */
    @Override
    public Long getVersion() {
        return version;
    }

    /**
     * 
     * @param version 
     */
    @Override
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * 
     * @return 
     */
    @Override
    public Integer getSequence() {
        return sequence;
    }

    /**
     * 
     * @param sequence 
     */
    @Override
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name 
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url 
     */
    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String getAbsolutePath() {
        return absolutePath;
    }

    /**
     * 
     * @param absolutePath 
     */
    @Override
    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    /**
     * 
     * @return 
     */
    @Override
    public Boolean getPublished() {
        return published;
    }

    /**
     * 
     * @param published 
     */
    @Override
    public void setPublished(Boolean published) {
        this.published = published;
    }

    /**
     * 
     * @return 
     */
    @Override
	public String getUserId() {
		return userId;
	}

    /**
     * 
     * @param userId 
     */
    @Override
	public void setUserId(String userId) {
		this.userId = userId;
	}

    /**
     * 
     * @return 
     */
    public String getFiscalYear() {
        return fiscalYear;
    }

    /**
     * 
     * @param fiscalYear 
     */
    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    /**
     * 
     * @return 
     */
    public String getFiscalMonth() {
        return fiscalMonth;
    }

    /**
     * 
     * @param fiscalMonth 
     */
    public void setFiscalMonth(String fiscalMonth) {
        this.fiscalMonth = fiscalMonth;
    }

    /**
     * 
     * @return 
     */
    public String getReportType() {
        return reportType;
    }

    /**
     * 
     * @param reportType 
     */
    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    /**
     * 
     * @return 
     */
    public Date getPublishedDate() {
        return publishedDate;
    }

    /**
     * 
     * @param publishedDate 
     */
    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    /**
     * 
     * @return 
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * 
     * @param dateCreated 
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
       
    
    
    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.absolutePath != null ? this.absolutePath.hashCode() : 0);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GeneratedReport other = (GeneratedReport) obj;
        if ((this.absolutePath == null) ? (other.absolutePath != null) : !this.absolutePath.equals(other.absolutePath)) {
            return false;
        }
        return true;
    }

    /**
     * 
     * @param o
     * @return 
     */
    @Override
    public int compareTo(GeneratedReport o) {
        return this.sequence - o.sequence;
    }
}
