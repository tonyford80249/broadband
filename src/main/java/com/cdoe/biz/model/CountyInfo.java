package com.cdoe.biz.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Immutable;

/**
 *
 * @author Tony Ford
 */
@XmlRootElement
@Entity
@Table(name = "ORGANIZATION_COUNTIES", schema = "DEVDETAILMGR")
@Immutable
public class CountyInfo {

    @EmbeddedId
    private CountyInfoPK countyInfoPK;
    @Column(name = "COUNTY_NAME")
    private String countyName;
    @Column(name = "PRIMARY_FLAG")
    private String primaryFlag;
    @ManyToOne
    @JoinColumn(name = "ORGANIZATION_CODE", insertable = false, updatable = false)
    @org.hibernate.annotations.ForeignKey(name = "FK_CHILD_OBJECT_PARENTID")
    private OrganizationUnitMaster organization;

    public CountyInfo() {
    }

    public CountyInfoPK getCountyInfoPK() {
        return countyInfoPK;
    }

    public void setCountyInfoPK(CountyInfoPK countyInfoPK) {
        this.countyInfoPK = countyInfoPK;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getPrimaryFlag() {
        return primaryFlag;
    }

    public void setPrimaryFlag(String primaryFlag) {
        this.primaryFlag = primaryFlag;
    }

    public OrganizationUnitMaster getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationUnitMaster organization) {
        this.organization = organization;
    }
    
    
    public Boolean isPrimaryCounty() {
        return "Y".equalsIgnoreCase(this.primaryFlag);
    }

    public void setIsPrimaryCounty(Boolean isPrimaryCounty) {
        this.primaryFlag = isPrimaryCounty ? "Y" : "N";
    }
}
