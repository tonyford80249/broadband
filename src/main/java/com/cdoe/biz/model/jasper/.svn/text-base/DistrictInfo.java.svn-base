package com.cdoe.biz.model.jasper;

/**
 *
 * @author Tony Ford
 */
public class DistrictInfo {
 private String districtName;
 private String districtNumber;

    public DistrictInfo(String districtName, String districtNumber) {
        this.districtName = districtName;
        this.districtNumber = districtNumber;
    }

    public String getDistrictName() {
        return districtName;
    }

    public String getDistrictNumber() {
        return districtNumber;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.districtNumber != null ? this.districtNumber.hashCode() : 0);
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
        final DistrictInfo other = (DistrictInfo) obj;
        if ((this.districtNumber == null) ? (other.districtNumber != null) : !this.districtNumber.equals(other.districtNumber)) {
            return false;
        }
        return true;
    }
 
}
