package com.cdoe.biz.model.jasper;

/**
 *
 * @author Tony Ford
 */
public class NegativePayment {
 public static class OrderByDistrict implements java.util.Comparator<NegativePayment> {

        @Override
        public int compare(NegativePayment o1, NegativePayment o2) {
         Integer v1 = null;
         Integer v2 = null;
         
         
         try {
          v1 = Integer.valueOf(o1.getDistrictNumber());   
         }
         catch(Exception e){
          return 1;    
         }
         
         try {
          v2 = Integer.valueOf(o2.getDistrictNumber());   
         }
         catch(Exception e){
          return -1;   
         }
         
         return v1.compareTo(v2);
        }
    
 }   
 
 /**
  * 
  */
 public static class OrderByCounty extends OrderByDistrict implements java.util.Comparator<NegativePayment> {

        @Override
        public int compare(NegativePayment o1, NegativePayment o2) {
         try {
          o1.getCounty().toString();   
         }   
         catch(Exception e){
          return 1;   
         }
         
         try {
          o2.getCounty().toString();   
         }   
         catch(Exception e){
          return -1;   
         }
         
         int ans = o1.getCounty().compareTo(o2.getCounty());
         
         //if in the same county then order by district
         if (ans == 0) {
          return super.compare(o1, o2);   
         }
         
         return ans;
        }
    
 }
 
 private String county;
 private String fiscalYear;
 private String districtNumber;
 private String districtName;
 private Double monthlyEntitlement;
 private Double currentEntitlement;
 private Double previousEntitlement;

    public NegativePayment(String county, String fiscalYear, String districtNumber, String districtName, Double monthlyEntitlement, Double currentEntitlement, Double previousEntitlement) {
        this.county = county;
        this.fiscalYear = fiscalYear;
        this.districtNumber = districtNumber;
        this.districtName = districtName;
        this.monthlyEntitlement = monthlyEntitlement;
        this.currentEntitlement = currentEntitlement;
        this.previousEntitlement = previousEntitlement;
    }

   

    

    public String getDistrictNumber() {
        return districtNumber;
    }

    public void setDistrictNumber(String districtNumber) {
        this.districtNumber = districtNumber;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Double getMonthlyEntitlement() {
        return monthlyEntitlement;
    }

    public void setMonthlyEntitlement(Double monthlyEntitlement) {
        this.monthlyEntitlement = monthlyEntitlement;
    }

    public Double getCurrentEntitlement() {
        return currentEntitlement;
    }

    public void setCurrentEntitlement(Double currentEntitlement) {
        this.currentEntitlement = currentEntitlement;
    }

    public Double getPreviousEntitlement() {
        return previousEntitlement;
    }

    public void setPreviousEntitlement(Double previousEntitlement) {
        this.previousEntitlement = previousEntitlement;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }
 
 
    public static OrderByDistrict getOrderByDistrictComparator() {
     return new OrderByDistrict();    
    }
    
    public static OrderByCounty getOrderByCountyComparator() {
     return new OrderByCounty();   
    }
 
}
