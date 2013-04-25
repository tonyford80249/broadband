
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.form.audit;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.cdoe.ui.form.grid.*;

/**
 * Java bean object representing a business entity which will be used by Spring Form
 * to pass data to and from the view, controller, and service layer.
 * 
 * @author ResQSoft, Inc. (ResQSoft Engineer)
 */
public class AuditEqualForm {

	private long id;
	
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	private List<AuditEqualGrid> auditEqualGridList = new ArrayList<AuditEqualGrid>();
	
	public List<AuditEqualGrid> getAuditEqualGridList() {
	    return this.auditEqualGridList;
	}
	
		
	private String districtNumber;
	
	public String getDistrictNumber () {
        return this.districtNumber;
    }

    public void setDistrictNumber (String districtNumber) {
        this.districtNumber = districtNumber;
    }
	private String dateChanged;
	
	public String getDateChanged () {
        return this.dateChanged;
    }

    public void setDateChanged (String dateChanged) {
        this.dateChanged = dateChanged;
    }
	private String changeType;
	
	public String getChangeType () {
        return this.changeType;
    }

    public void setChangeType (String changeType) {
        this.changeType = changeType;
    }
	private String adjFpc;
	
	public String getAdjFpc () {
        return this.adjFpc;
    }

    public void setAdjFpc (String adjFpc) {
        this.adjFpc = adjFpc;
    }
	private String preschool;
	
	public String getPreschool () {
        return this.preschool;
    }

    public void setPreschool (String preschool) {
        this.preschool = preschool;
    }
	private String specedEnroll;
	
	public String getSpecedEnroll () {
        return this.specedEnroll;
    }

    public void setSpecedEnroll (String specedEnroll) {
        this.specedEnroll = specedEnroll;
    }
	private String fpc;
	
	public String getFpc () {
        return this.fpc;
    }

    public void setFpc (String fpc) {
        this.fpc = fpc;
    }
	private String assessedVal;
	
	public String getAssessedVal () {
        return this.assessedVal;
    }

    public void setAssessedVal (String assessedVal) {
        this.assessedVal = assessedVal;
    }
	private String catTrans;
	
	public String getCatTrans () {
        return this.catTrans;
    }

    public void setCatTrans (String catTrans) {
        this.catTrans = catTrans;
    }
	private String catVoced;
	
	public String getCatVoced () {
        return this.catVoced;
    }

    public void setCatVoced (String catVoced) {
        this.catVoced = catVoced;
    }
	private String catElpa;
	
	public String getCatElpa () {
        return this.catElpa;
    }

    public void setCatElpa (String catElpa) {
        this.catElpa = catElpa;
    }
	private String catSpedDis;
	
	public String getCatSpedDis () {
        return this.catSpedDis;
    }

    public void setCatSpedDis (String catSpedDis) {
        this.catSpedDis = catSpedDis;
    }
	private String catSpedGt;
	
	public String getCatSpedGt () {
        return this.catSpedGt;
    }

    public void setCatSpedGt (String catSpedGt) {
        this.catSpedGt = catSpedGt;
    }
	private String sizeAdjust;
	
	public String getSizeAdjust () {
        return this.sizeAdjust;
    }

    public void setSizeAdjust (String sizeAdjust) {
        this.sizeAdjust = sizeAdjust;
    }
	private String colAdjust;
	
	public String getColAdjust () {
        return this.colAdjust;
    }

    public void setColAdjust (String colAdjust) {
        this.colAdjust = colAdjust;
    }
	private String persCostFactor;
	
	public String getPersCostFactor () {
        return this.persCostFactor;
    }

    public void setPersCostFactor (String persCostFactor) {
        this.persCostFactor = persCostFactor;
    }
	private String totProg;
	
	public String getTotProg () {
        return this.totProg;
    }

    public void setTotProg (String totProg) {
        this.totProg = totProg;
    }
	private String freeLunch18;
	
	public String getFreeLunch18 () {
        return this.freeLunch18;
    }

    public void setFreeLunch18 (String freeLunch18) {
        this.freeLunch18 = freeLunch18;
    }
	private String freeLunchK12;
	
	public String getFreeLunchK12 () {
        return this.freeLunchK12;
    }

    public void setFreeLunchK12 (String freeLunchK12) {
        this.freeLunchK12 = freeLunchK12;
    }
	private String member18;
	
	public String getMember18 () {
        return this.member18;
    }

    public void setMember18 (String member18) {
        this.member18 = member18;
    }
	private String totProgAtRisk;
	
	public String getTotProgAtRisk () {
        return this.totProgAtRisk;
    }

    public void setTotProgAtRisk (String totProgAtRisk) {
        this.totProgAtRisk = totProgAtRisk;
    }
	private String grandTotProg;
	
	public String getGrandTotProg () {
        return this.grandTotProg;
    }

    public void setGrandTotProg (String grandTotProg) {
        this.grandTotProg = grandTotProg;
    }
	private String specOwnTax;
	
	public String getSpecOwnTax () {
        return this.specOwnTax;
    }

    public void setSpecOwnTax (String specOwnTax) {
        this.specOwnTax = specOwnTax;
    }
	private String millLevyCalc;
	
	public String getMillLevyCalc () {
        return this.millLevyCalc;
    }

    public void setMillLevyCalc (String millLevyCalc) {
        this.millLevyCalc = millLevyCalc;
    }
	private String propertyTax;
	
	public String getPropertyTax () {
        return this.propertyTax;
    }

    public void setPropertyTax (String propertyTax) {
        this.propertyTax = propertyTax;
    }
	private String stateEqual;
	
	public String getStateEqual () {
        return this.stateEqual;
    }

    public void setStateEqual (String stateEqual) {
        this.stateEqual = stateEqual;
    }
	private String millLevyCert;
	
	public String getMillLevyCert () {
        return this.millLevyCert;
    }

    public void setMillLevyCert (String millLevyCert) {
        this.millLevyCert = millLevyCert;
    }
	private String millLevyAdj;
	
	public String getMillLevyAdj () {
        return this.millLevyAdj;
    }

    public void setMillLevyAdj (String millLevyAdj) {
        this.millLevyAdj = millLevyAdj;
    }
	private String monthEntitle;
	
	public String getMonthEntitle () {
        return this.monthEntitle;
    }

    public void setMonthEntitle (String monthEntitle) {
        this.monthEntitle = monthEntitle;
    }
	private String ytdEntitle;
	
	public String getYtdEntitle () {
        return this.ytdEntitle;
    }

    public void setYtdEntitle (String ytdEntitle) {
        this.ytdEntitle = ytdEntitle;
    }
	private String monthPayment;
	
	public String getMonthPayment () {
        return this.monthPayment;
    }

    public void setMonthPayment (String monthPayment) {
        this.monthPayment = monthPayment;
    }
	private String ytdPayment;
	
	public String getYtdPayment () {
        return this.ytdPayment;
    }

    public void setYtdPayment (String ytdPayment) {
        this.ytdPayment = ytdPayment;
    }
	private String propTxCfY0;
	
	public String getPropTxCfY0 () {
        return this.propTxCfY0;
    }

    public void setPropTxCfY0 (String propTxCfY0) {
        this.propTxCfY0 = propTxCfY0;
    }
	private String adjY0Oods;
	
	public String getAdjY0Oods () {
        return this.adjY0Oods;
    }

    public void setAdjY0Oods (String adjY0Oods) {
        this.adjY0Oods = adjY0Oods;
    }
	private String ytdY0Oods;
	
	public String getYtdY0Oods () {
        return this.ytdY0Oods;
    }

    public void setYtdY0Oods (String ytdY0Oods) {
        this.ytdY0Oods = ytdY0Oods;
    }
	private String adjY0Other;
	
	public String getAdjY0Other () {
        return this.adjY0Other;
    }

    public void setAdjY0Other (String adjY0Other) {
        this.adjY0Other = adjY0Other;
    }
	private String ytdY0Other;
	
	public String getYtdY0Other () {
        return this.ytdY0Other;
    }

    public void setYtdY0Other (String ytdY0Other) {
        this.ytdY0Other = ytdY0Other;
    }
	private String adjY0Swap;
	
	public String getAdjY0Swap () {
        return this.adjY0Swap;
    }

    public void setAdjY0Swap (String adjY0Swap) {
        this.adjY0Swap = adjY0Swap;
    }
	private String ytdY0Swap;
	
	public String getYtdY0Swap () {
        return this.ytdY0Swap;
    }

    public void setYtdY0Swap (String ytdY0Swap) {
        this.ytdY0Swap = ytdY0Swap;
    }
	private String allowSpend;
	
	public String getAllowSpend () {
        return this.allowSpend;
    }

    public void setAllowSpend (String allowSpend) {
        this.allowSpend = allowSpend;
    }
	private String overLevyCalc;
	
	public String getOverLevyCalc () {
        return this.overLevyCalc;
    }

    public void setOverLevyCalc (String overLevyCalc) {
        this.overLevyCalc = overLevyCalc;
    }
	private String hhLevyCalc;
	
	public String getHhLevyCalc () {
        return this.hhLevyCalc;
    }

    public void setHhLevyCalc (String hhLevyCalc) {
        this.hhLevyCalc = hhLevyCalc;
    }
	private String catLevyAdj;
	
	public String getCatLevyAdj () {
        return this.catLevyAdj;
    }

    public void setCatLevyAdj (String catLevyAdj) {
        this.catLevyAdj = catLevyAdj;
    }
	private String catLevyCert;
	
	public String getCatLevyCert () {
        return this.catLevyCert;
    }

    public void setCatLevyCert (String catLevyCert) {
        this.catLevyCert = catLevyCert;
    }
	private String catLevyCalc;
	
	public String getCatLevyCalc () {
        return this.catLevyCalc;
    }

    public void setCatLevyCalc (String catLevyCalc) {
        this.catLevyCalc = catLevyCalc;
    }
	private String propTaxCfCap;
	
	public String getPropTaxCfCap () {
        return this.propTaxCfCap;
    }

    public void setPropTaxCfCap (String propTaxCfCap) {
        this.propTaxCfCap = propTaxCfCap;
    }
	private String totProgTabor;
	
	public String getTotProgTabor () {
        return this.totProgTabor;
    }

    public void setTotProgTabor (String totProgTabor) {
        this.totProgTabor = totProgTabor;
    }
	private String totForm2;
	
	public String getTotForm2 () {
        return this.totForm2;
    }

    public void setTotForm2 (String totForm2) {
        this.totForm2 = totForm2;
    }
	private String totMax6;
	
	public String getTotMax6 () {
        return this.totMax6;
    }

    public void setTotMax6 (String totMax6) {
        this.totMax6 = totMax6;
    }
	private String totAddFund;
	
	public String getTotAddFund () {
        return this.totAddFund;
    }

    public void setTotAddFund (String totAddFund) {
        this.totAddFund = totAddFund;
    }
	private String octY1Mem;
	
	public String getOctY1Mem () {
        return this.octY1Mem;
    }

    public void setOctY1Mem (String octY1Mem) {
        this.octY1Mem = octY1Mem;
    }
	private String totAtRiskAr6;
	
	public String getTotAtRiskAr6 () {
        return this.totAtRiskAr6;
    }

    public void setTotAtRiskAr6 (String totAtRiskAr6) {
        this.totAtRiskAr6 = totAtRiskAr6;
    }
	private String fmPupFundPp7;
	
	public String getFmPupFundPp7 () {
        return this.fmPupFundPp7;
    }

    public void setFmPupFundPp7 (String fmPupFundPp7) {
        this.fmPupFundPp7 = fmPupFundPp7;
    }
	private String fmAtRiskAr20;
	
	public String getFmAtRiskAr20 () {
        return this.fmAtRiskAr20;
    }

    public void setFmAtRiskAr20 (String fmAtRiskAr20) {
        this.fmAtRiskAr20 = fmAtRiskAr20;
    }
	private String voteLevyCalc;
	
	public String getVoteLevyCalc () {
        return this.voteLevyCalc;
    }

    public void setVoteLevyCalc (String voteLevyCalc) {
        this.voteLevyCalc = voteLevyCalc;
    }
	private String othCdeAdj;
	
	public String getOthCdeAdj () {
        return this.othCdeAdj;
    }

    public void setOthCdeAdj (String othCdeAdj) {
        this.othCdeAdj = othCdeAdj;
    }
	private String voterOverride;
	
	public String getVoterOverride () {
        return this.voterOverride;
    }

    public void setVoterOverride (String voterOverride) {
        this.voterOverride = voterOverride;
    }
	private String fundedCntY1;
	
	public String getFundedCntY1 () {
        return this.fundedCntY1;
    }

    public void setFundedCntY1 (String fundedCntY1) {
        this.fundedCntY1 = fundedCntY1;
    }
	private String fundedCntY2;
	
	public String getFundedCntY2 () {
        return this.fundedCntY2;
    }

    public void setFundedCntY2 (String fundedCntY2) {
        this.fundedCntY2 = fundedCntY2;
    }
	private String fundedCntY3;
	
	public String getFundedCntY3 () {
        return this.fundedCntY3;
    }

    public void setFundedCntY3 (String fundedCntY3) {
        this.fundedCntY3 = fundedCntY3;
    }
	private String minFormulaFund;
	
	public String getMinFormulaFund () {
        return this.minFormulaFund;
    }

    public void setMinFormulaFund (String minFormulaFund) {
        this.minFormulaFund = minFormulaFund;
    }
	private String totAddFundV63;
	
	public String getTotAddFundV63 () {
        return this.totAddFundV63;
    }

    public void setTotAddFundV63 (String totAddFundV63) {
        this.totAddFundV63 = totAddFundV63;
    }
	private String adjTotFundGt3;
	
	public String getAdjTotFundGt3 () {
        return this.adjTotFundGt3;
    }

    public void setAdjTotFundGt3 (String adjTotFundGt3) {
        this.adjTotFundGt3 = adjTotFundGt3;
    }
	private String adjStateAssess;
	
	public String getAdjStateAssess () {
        return this.adjStateAssess;
    }

    public void setAdjStateAssess (String adjStateAssess) {
        this.adjStateAssess = adjStateAssess;
    }
	private String fundedCntY0;
	
	public String getFundedCntY0 () {
        return this.fundedCntY0;
    }

    public void setFundedCntY0 (String fundedCntY0) {
        this.fundedCntY0 = fundedCntY0;
    }
	private String chrtrSchlCnt;
	
	public String getChrtrSchlCnt () {
        return this.chrtrSchlCnt;
    }

    public void setChrtrSchlCnt (String chrtrSchlCnt) {
        this.chrtrSchlCnt = chrtrSchlCnt;
    }
	private String smlCntrPymnts;
	
	public String getSmlCntrPymnts () {
        return this.smlCntrPymnts;
    }

    public void setSmlCntrPymnts (String smlCntrPymnts) {
        this.smlCntrPymnts = smlCntrPymnts;
    }
	private String minSizeAdjust;
	
	public String getMinSizeAdjust () {
        return this.minSizeAdjust;
    }

    public void setMinSizeAdjust (String minSizeAdjust) {
        this.minSizeAdjust = minSizeAdjust;
    }
	private String eslCsap;
	
	public String getEslCsap () {
        return this.eslCsap;
    }

    public void setEslCsap (String eslCsap) {
        this.eslCsap = eslCsap;
    }
	private String onLineCntY0;
	
	public String getOnLineCntY0 () {
        return this.onLineCntY0;
    }

    public void setOnLineCntY0 (String onLineCntY0) {
        this.onLineCntY0 = onLineCntY0;
    }
	private String onLineCntY1;
	
	public String getOnLineCntY1 () {
        return this.onLineCntY1;
    }

    public void setOnLineCntY1 (String onLineCntY1) {
        this.onLineCntY1 = onLineCntY1;
    }
	private String preschool5;
	
	public String getPreschool5 () {
        return this.preschool5;
    }

    public void setPreschool5 (String preschool5) {
        this.preschool5 = preschool5;
    }
	private String adjY0ChrtrDbt;
	
	public String getAdjY0ChrtrDbt () {
        return this.adjY0ChrtrDbt;
    }

    public void setAdjY0ChrtrDbt (String adjY0ChrtrDbt) {
        this.adjY0ChrtrDbt = adjY0ChrtrDbt;
    }
	private String ytdY0ChrtrDbt;
	
	public String getYtdY0ChrtrDbt () {
        return this.ytdY0ChrtrDbt;
    }

    public void setYtdY0ChrtrDbt (String ytdY0ChrtrDbt) {
        this.ytdY0ChrtrDbt = ytdY0ChrtrDbt;
    }
	private String csiY0Share;
	
	public String getCsiY0Share () {
        return this.csiY0Share;
    }

    public void setCsiY0Share (String csiY0Share) {
        this.csiY0Share = csiY0Share;
    }
	private String ytdY0CdeAdj;
	
	public String getYtdY0CdeAdj () {
        return this.ytdY0CdeAdj;
    }

    public void setYtdY0CdeAdj (String ytdY0CdeAdj) {
        this.ytdY0CdeAdj = ytdY0CdeAdj;
    }
	private String propertyTaxY1;
	
	public String getPropertyTaxY1 () {
        return this.propertyTaxY1;
    }

    public void setPropertyTaxY1 (String propertyTaxY1) {
        this.propertyTaxY1 = propertyTaxY1;
    }
	private String millLevyY1;
	
	public String getMillLevyY1 () {
        return this.millLevyY1;
    }

    public void setMillLevyY1 (String millLevyY1) {
        this.millLevyY1 = millLevyY1;
    }
	private String fundedCntY4;
	
	public String getFundedCntY4 () {
        return this.fundedCntY4;
    }

    public void setFundedCntY4 (String fundedCntY4) {
        this.fundedCntY4 = fundedCntY4;
    }
	private String sbsf;
	
	public String getSbsf () {
        return this.sbsf;
    }

    public void setSbsf (String sbsf) {
        this.sbsf = sbsf;
    }
	private String sbsfCatBuyout;
	
	public String getSbsfCatBuyout () {
        return this.sbsfCatBuyout;
    }

    public void setSbsfCatBuyout (String sbsfCatBuyout) {
        this.sbsfCatBuyout = sbsfCatBuyout;
    }
	private String distChrtrCntY1;
	
	public String getDistChrtrCntY1 () {
        return this.distChrtrCntY1;
    }

    public void setDistChrtrCntY1 (String distChrtrCntY1) {
        this.distChrtrCntY1 = distChrtrCntY1;
    }
	private String distChrtrCntY2;
	
	public String getDistChrtrCntY2 () {
        return this.distChrtrCntY2;
    }

    public void setDistChrtrCntY2 (String distChrtrCntY2) {
        this.distChrtrCntY2 = distChrtrCntY2;
    }
	private String distChrtrCntY3;
	
	public String getDistChrtrCntY3 () {
        return this.distChrtrCntY3;
    }

    public void setDistChrtrCntY3 (String distChrtrCntY3) {
        this.distChrtrCntY3 = distChrtrCntY3;
    }
	private String distChrtrCntY4;
	
	public String getDistChrtrCntY4 () {
        return this.distChrtrCntY4;
    }

    public void setDistChrtrCntY4 (String distChrtrCntY4) {
        this.distChrtrCntY4 = distChrtrCntY4;
    }
	private String adjY0Audit;
	
	public String getAdjY0Audit () {
        return this.adjY0Audit;
    }

    public void setAdjY0Audit (String adjY0Audit) {
        this.adjY0Audit = adjY0Audit;
    }
	private String ytdY0Audit;
	
	public String getYtdY0Audit () {
        return this.ytdY0Audit;
    }

    public void setYtdY0Audit (String ytdY0Audit) {
        this.ytdY0Audit = ytdY0Audit;
    }
	private String fiscalYear;
	
	public String getFiscalYear () {
        return this.fiscalYear;
    }

    public void setFiscalYear (String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }
	private List<String> districtNumberList = new ArrayList<String>();
	
	public List<String> getDistrictNumberList() {
        return this.districtNumberList;
    }
    
	private List<String> fiscalYearList = new ArrayList<String>();
	
	public List<String> getFiscalYearList() {
        return this.fiscalYearList;
    }
    
}