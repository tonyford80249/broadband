
package com.cdoe.biz.model.equal;

import java.util.Map;

/**
 *
 * @author Tony Ford
 */
public class CsiPaymentAdapter extends Csi {
 private static Map<String, String> districtMap;    
 private Double totalFunding;
 private Double monthlyEntitlement;
 private Double administrativeOverhead;
 private Double assistanceFund;
 private Double instituteAdminOverhead;
 private Double charterSchoolDistribution;
 

    private CsiPaymentAdapter() {
    }
    
    
    public CsiPaymentAdapter(Csi info) {
     this.setChangeType(info.getChangeType());
     this.setCsiAscentCnt(info.getCsiAscentCnt());
     this.setCsiCppCnt(info.getCsiCppCnt());
     this.setCsiFl18Cnt(info.getCsiFl18Cnt());
     this.setCsiFlK12Cnt(info.getCsiFlK12Cnt());
     this.setCsiK12FteCnt(info.getCsiK12FteCnt());
     this.setCsiMem18Cnt(info.getCsiMem18Cnt());
     this.setCsiMemK12Cnt(info.getCsiMemK12Cnt());
     this.setCsiNumber(info.getCsiNumber());
     this.setCsiOnlineCnt(info.getCsiOnlineCnt());
     this.setCsiSupplementalK(info.getCsiSupplementalK());
     this.setDateChanged(info.getDateChanged());
     this.setDistrictNumber(info.getDistrictNumber());
     this.setFiscalYear(info.getFiscalYear());  
     this.setPerPupilRevenue(info.getPerPupilRevenue());
     this.setInterceptProgramWithholding(info.getInterceptProgramWithholding());
     this.setPprFdkFactor(info.getPprFdkFactor());
    }

    public Double getTotalFunding() {
        return totalFunding;
    }

    public void setTotalFunding(Double totalFunding) {
        this.totalFunding = totalFunding;
    }

    public Double getMonthlyEntitlement() {
        return monthlyEntitlement;
    }

    public void setMonthlyEntitlement(Double monthlyEntitlement) {
        this.monthlyEntitlement = monthlyEntitlement;
    }

    public Double getAdministrativeOverhead() {
        return administrativeOverhead;
    }

    public void setAdministrativeOverhead(Double administrativeOverhead) {
        this.administrativeOverhead = administrativeOverhead;
    }

    public Double getAssistanceFund() {
        return assistanceFund;
    }

    public void setAssistanceFund(Double assistanceFund) {
        this.assistanceFund = assistanceFund;
    }

    public Double getInstituteAdminOverhead() {
        return instituteAdminOverhead;
    }

    public void setInstituteAdminOverhead(Double instituteAdminOverhead) {
        this.instituteAdminOverhead = instituteAdminOverhead;
    }

    public Double getCharterSchoolDistribution() {
        return charterSchoolDistribution;
    }

    public void setCharterSchoolDistribution(Double charterSchoolDistribution) {
        this.charterSchoolDistribution = charterSchoolDistribution;
    }

    public String getDistrictName() {
        return districtMap.get(this.getDistrictNumber());
    }

    public String getChaterSchoolOrInstitute() {
        return districtMap.get(this.getCsiNumber());
    }
    
    
 
     public void computePayment() {
      final double ipWithholding = this.getInterceptProgramWithholding() != null ? this.getInterceptProgramWithholding() : 0.0;   
      
      this.totalFunding = (this.getCsiCppCnt() != null ? this.getCsiCppCnt() : 0.0) * (this.getPerPupilRevenue() != null ? this.getPerPupilRevenue() : 0.0);
      this.monthlyEntitlement = this.totalFunding  / 12;
      this.administrativeOverhead = this.monthlyEntitlement  * .01;
      this.assistanceFund = this.monthlyEntitlement  * .01;
      this.instituteAdminOverhead = this.monthlyEntitlement * .03;
      this.charterSchoolDistribution = this.monthlyEntitlement + this.administrativeOverhead + this.assistanceFund + this.instituteAdminOverhead + ipWithholding;
      
     }
     
     

    public static void setDistrictMap(Map<String, String> districtMap) {
        CsiPaymentAdapter.districtMap = districtMap;
    }
     
     
}
