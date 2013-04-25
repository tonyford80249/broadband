package com.cdoe.biz.model;

import javax.persistence.Column;

/**
 *
 * @author Tony Ford
 */
public class CountyInfoPK implements java.io.Serializable {
 @Column(name = "ORGANIZATION_CODE")
 private String organizationCode;
 @Column(name = "COUNTY_CODE")
 private String countyCode;  

    public CountyInfoPK() {
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (this.organizationCode != null ? this.organizationCode.hashCode() : 0);
        hash = 79 * hash + (this.countyCode != null ? this.countyCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CountyInfoPK other = (CountyInfoPK) obj;
        if ((this.organizationCode == null) ? (other.organizationCode != null) : !this.organizationCode.equals(other.organizationCode)) {
            return false;
        }
        if ((this.countyCode == null) ? (other.countyCode != null) : !this.countyCode.equals(other.countyCode)) {
            return false;
        }
        return true;
    }
 
 
}
