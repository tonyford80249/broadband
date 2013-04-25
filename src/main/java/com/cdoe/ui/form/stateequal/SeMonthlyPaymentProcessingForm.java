package com.cdoe.ui.form.stateequal;

import com.cdoe.biz.model.District;
import com.cdoe.biz.model.Payee;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Tony Ford
 */
public class SeMonthlyPaymentProcessingForm {
 private List<String> availableMonths = new ArrayList<String>();
 private Map<String,String> availableYears = new TreeMap<String,String>(Collections.reverseOrder());   
 private List<Payee> candidatePayees  = new ArrayList<Payee>();
 private List<String> selectCandidates  = new ArrayList<String>();
 private List<Payee> approvedPayees  = new ArrayList<Payee>();
 private List<String> selectApprovedPayees  = new ArrayList<String>();
 private List<Payee> missingPayees  = new ArrayList<Payee>();
 private String year;
 private String month;

    public SeMonthlyPaymentProcessingForm() {
    }

    public List<String> getAvailableMonths() {
        return availableMonths;
    }

    public void setAvailableMonths(List<String> availableMonths) {
        this.availableMonths = availableMonths;
    }

    public Map<String, String> getAvailableYears() {
        return availableYears;
    }

    public void setAvailableYears(Map<String, String> availableYears) {
        this.availableYears = availableYears;
    }
    
    public List<Payee> getCandidatePayees() {
        return candidatePayees;
    }

    public void setCandidatePayees(List<Payee> candidatePayees) {
        this.candidatePayees = candidatePayees;
    }

    public List<Payee> getApprovedPayees() {
        return approvedPayees;
    }

    public void setApprovedPayees(List<Payee> approvedPayees) {
        this.approvedPayees = approvedPayees;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public List<String> getSelectCandidates() {
        return selectCandidates;
    }

    public void setSelectCandidates(List<String> selectCandidates) {
        this.selectCandidates = selectCandidates;
    }

    public List<String> getSelectApprovedPayees() {
        return selectApprovedPayees;
    }

    public void setSelectApprovedPayees(List<String> selectApprovedPayees) {
        this.selectApprovedPayees = selectApprovedPayees;
    }

    public List<Payee> getMissingPayees() {
        return missingPayees;
    }

    public void setMissingPayees(List<Payee> missingPayees) {
        this.missingPayees = missingPayees;
    }
 
 
}
