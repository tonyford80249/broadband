
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.form.stateequal;

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
public class StateEqualForm {

	private long id;
	
	String collectionType;
	
    public String getCollectionType() {
		return collectionType;
	}

	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	private List<StateEqualGrid> stateEqualGridList = new ArrayList<StateEqualGrid>();
	
	public List<StateEqualGrid> getStateEqualGridList() {
	    return this.stateEqualGridList;
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
	private Long adjFpc;
	
	public Long getAdjFpc () {
        return this.adjFpc;
    }

    public void setAdjFpc (Long adjFpc) {
        this.adjFpc = adjFpc;
    }
	private Long preschool;
	
	public Long getPreschool () {
        return this.preschool;
    }

    public void setPreschool (Long preschool) {
        this.preschool = preschool;
    }
	private Long specedEnroll;
	
	public Long getSpecedEnroll () {
        return this.specedEnroll;
    }

    public void setSpecedEnroll (Long specedEnroll) {
        this.specedEnroll = specedEnroll;
    }
	private Long fpc;
	
	public Long getFpc () {
        return this.fpc;
    }

    public void setFpc (Long fpc) {
        this.fpc = fpc;
    }
	private Long assessedVal;
	
	public Long getAssessedVal () {
        return this.assessedVal;
    }

    public void setAssessedVal (Long assessedVal) {
        this.assessedVal = assessedVal;
    }
	private Long catTrans;
	
	public Long getCatTrans () {
        return this.catTrans;
    }

    public void setCatTrans (Long catTrans) {
        this.catTrans = catTrans;
    }
	private Long catVoced;
	
	public Long getCatVoced () {
        return this.catVoced;
    }

    public void setCatVoced (Long catVoced) {
        this.catVoced = catVoced;
    }
	private Long catElpa;
	
	public Long getCatElpa () {
        return this.catElpa;
    }

    public void setCatElpa (Long catElpa) {
        this.catElpa = catElpa;
    }
	private Long catSpedDis;
	
	public Long getCatSpedDis () {
        return this.catSpedDis;
    }

    public void setCatSpedDis (Long catSpedDis) {
        this.catSpedDis = catSpedDis;
    }
	private Long catSpedGt;
	
	public Long getCatSpedGt () {
        return this.catSpedGt;
    }

    public void setCatSpedGt (Long catSpedGt) {
        this.catSpedGt = catSpedGt;
    }
	private Long sizeAdjust;
	
	public Long getSizeAdjust () {
        return this.sizeAdjust;
    }

    public void setSizeAdjust (Long sizeAdjust) {
        this.sizeAdjust = sizeAdjust;
    }
	private Long colAdjust;
	
	public Long getColAdjust () {
        return this.colAdjust;
    }

    public void setColAdjust (Long colAdjust) {
        this.colAdjust = colAdjust;
    }
	private Long persCostFactor;
	
	public Long getPersCostFactor () {
        return this.persCostFactor;
    }

    public void setPersCostFactor (Long persCostFactor) {
        this.persCostFactor = persCostFactor;
    }
	private Long totProg;
	
	public Long getTotProg () {
        return this.totProg;
    }

    public void setTotProg (Long totProg) {
        this.totProg = totProg;
    }
	private Long freeLunch18;
	
	public Long getFreeLunch18 () {
        return this.freeLunch18;
    }

    public void setFreeLunch18 (Long freeLunch18) {
        this.freeLunch18 = freeLunch18;
    }
	private Long freeLunchK12;
	
	public Long getFreeLunchK12 () {
        return this.freeLunchK12;
    }

    public void setFreeLunchK12 (Long freeLunchK12) {
        this.freeLunchK12 = freeLunchK12;
    }
	private Long member18;
	
	public Long getMember18 () {
        return this.member18;
    }

    public void setMember18 (Long member18) {
        this.member18 = member18;
    }
	private Long totProgAtRisk;
	
	public Long getTotProgAtRisk () {
        return this.totProgAtRisk;
    }

    public void setTotProgAtRisk (Long totProgAtRisk) {
        this.totProgAtRisk = totProgAtRisk;
    }
	private Long grandTotProg;
	
	public Long getGrandTotProg () {
        return this.grandTotProg;
    }

    public void setGrandTotProg (Long grandTotProg) {
        this.grandTotProg = grandTotProg;
    }
	private Long specOwnTax;
	
	public Long getSpecOwnTax () {
        return this.specOwnTax;
    }

    public void setSpecOwnTax (Long specOwnTax) {
        this.specOwnTax = specOwnTax;
    }
	private Long millLevyCalc;
	
	public Long getMillLevyCalc () {
        return this.millLevyCalc;
    }

    public void setMillLevyCalc (Long millLevyCalc) {
        this.millLevyCalc = millLevyCalc;
    }
	private Long propertyTax;
	
	public Long getPropertyTax () {
        return this.propertyTax;
    }

    public void setPropertyTax (Long propertyTax) {
        this.propertyTax = propertyTax;
    }
	private Long stateEqual;
	
	public Long getStateEqual () {
        return this.stateEqual;
    }

    public void setStateEqual (Long stateEqual) {
        this.stateEqual = stateEqual;
    }
	private Long millLevyCert;
	
	public Long getMillLevyCert () {
        return this.millLevyCert;
    }

    public void setMillLevyCert (Long millLevyCert) {
        this.millLevyCert = millLevyCert;
    }
	private Long millLevyAdj;
	
	public Long getMillLevyAdj () {
        return this.millLevyAdj;
    }

    public void setMillLevyAdj (Long millLevyAdj) {
        this.millLevyAdj = millLevyAdj;
    }
	private Long monthEntitle;
	
	public Long getMonthEntitle () {
        return this.monthEntitle;
    }

    public void setMonthEntitle (Long monthEntitle) {
        this.monthEntitle = monthEntitle;
    }
	private Long ytdEntitle;
	
	public Long getYtdEntitle () {
        return this.ytdEntitle;
    }

    public void setYtdEntitle (Long ytdEntitle) {
        this.ytdEntitle = ytdEntitle;
    }
	private Long propTxCfY0;
	
	public Long getPropTxCfY0 () {
        return this.propTxCfY0;
    }

    public void setPropTxCfY0 (Long propTxCfY0) {
        this.propTxCfY0 = propTxCfY0;
    }
	private Long adjY0Oods;
	
	public Long getAdjY0Oods () {
        return this.adjY0Oods;
    }

    public void setAdjY0Oods (Long adjY0Oods) {
        this.adjY0Oods = adjY0Oods;
    }
	private Long ytdY0Oods;
	
	public Long getYtdY0Oods () {
        return this.ytdY0Oods;
    }

    public void setYtdY0Oods (Long ytdY0Oods) {
        this.ytdY0Oods = ytdY0Oods;
    }
	private Long adjY0Other;
	
	public Long getAdjY0Other () {
        return this.adjY0Other;
    }

    public void setAdjY0Other (Long adjY0Other) {
        this.adjY0Other = adjY0Other;
    }
	private Long ytdY0Other;
	
	public Long getYtdY0Other () {
        return this.ytdY0Other;
    }

    public void setYtdY0Other (Long ytdY0Other) {
        this.ytdY0Other = ytdY0Other;
    }
	private Long adjY0Swap;
	
	public Long getAdjY0Swap () {
        return this.adjY0Swap;
    }

    public void setAdjY0Swap (Long adjY0Swap) {
        this.adjY0Swap = adjY0Swap;
    }
	private Long ytdY0Swap;
	
	public Long getYtdY0Swap () {
        return this.ytdY0Swap;
    }

    public void setYtdY0Swap (Long ytdY0Swap) {
        this.ytdY0Swap = ytdY0Swap;
    }
	private Long allowSpend;
	
	public Long getAllowSpend () {
        return this.allowSpend;
    }

    public void setAllowSpend (Long allowSpend) {
        this.allowSpend = allowSpend;
    }
	private Long overLevyCalc;
	
	public Long getOverLevyCalc () {
        return this.overLevyCalc;
    }

    public void setOverLevyCalc (Long overLevyCalc) {
        this.overLevyCalc = overLevyCalc;
    }
	private Long hhLevyCalc;
	
	public Long getHhLevyCalc () {
        return this.hhLevyCalc;
    }

    public void setHhLevyCalc (Long hhLevyCalc) {
        this.hhLevyCalc = hhLevyCalc;
    }
	private Long catLevyAdj;
	
	public Long getCatLevyAdj () {
        return this.catLevyAdj;
    }

    public void setCatLevyAdj (Long catLevyAdj) {
        this.catLevyAdj = catLevyAdj;
    }
	private Long catLevyCert;
	
	public Long getCatLevyCert () {
        return this.catLevyCert;
    }

    public void setCatLevyCert (Long catLevyCert) {
        this.catLevyCert = catLevyCert;
    }
	private Long catLevyCalc;
	
	public Long getCatLevyCalc () {
        return this.catLevyCalc;
    }

    public void setCatLevyCalc (Long catLevyCalc) {
        this.catLevyCalc = catLevyCalc;
    }
	private Long propTaxCfCap;
	
	public Long getPropTaxCfCap () {
        return this.propTaxCfCap;
    }

    public void setPropTaxCfCap (Long propTaxCfCap) {
        this.propTaxCfCap = propTaxCfCap;
    }
	private Long totProgTabor;
	
	public Long getTotProgTabor () {
        return this.totProgTabor;
    }

    public void setTotProgTabor (Long totProgTabor) {
        this.totProgTabor = totProgTabor;
    }
	private Long totForm2;
	
	public Long getTotForm2 () {
        return this.totForm2;
    }

    public void setTotForm2 (Long totForm2) {
        this.totForm2 = totForm2;
    }
	private Long totMax6;
	
	public Long getTotMax6 () {
        return this.totMax6;
    }

    public void setTotMax6 (Long totMax6) {
        this.totMax6 = totMax6;
    }
	private Long totAddFund;
	
	public Long getTotAddFund () {
        return this.totAddFund;
    }

    public void setTotAddFund (Long totAddFund) {
        this.totAddFund = totAddFund;
    }
	private Long octY1Mem;
	
	public Long getOctY1Mem () {
        return this.octY1Mem;
    }

    public void setOctY1Mem (Long octY1Mem) {
        this.octY1Mem = octY1Mem;
    }
	private Long totAtRiskAr6;
	
	public Long getTotAtRiskAr6 () {
        return this.totAtRiskAr6;
    }

    public void setTotAtRiskAr6 (Long totAtRiskAr6) {
        this.totAtRiskAr6 = totAtRiskAr6;
    }
	private Long fmPupFundPp7;
	
	public Long getFmPupFundPp7 () {
        return this.fmPupFundPp7;
    }

    public void setFmPupFundPp7 (Long fmPupFundPp7) {
        this.fmPupFundPp7 = fmPupFundPp7;
    }
	private Long fmAtRiskAr20;
	
	public Long getFmAtRiskAr20 () {
        return this.fmAtRiskAr20;
    }

    public void setFmAtRiskAr20 (Long fmAtRiskAr20) {
        this.fmAtRiskAr20 = fmAtRiskAr20;
    }
	private Long voteLevyCalc;
	
	public Long getVoteLevyCalc () {
        return this.voteLevyCalc;
    }

    public void setVoteLevyCalc (Long voteLevyCalc) {
        this.voteLevyCalc = voteLevyCalc;
    }
	private Long othCdeAdj;
	
	public Long getOthCdeAdj () {
        return this.othCdeAdj;
    }

    public void setOthCdeAdj (Long othCdeAdj) {
        this.othCdeAdj = othCdeAdj;
    }
	private Long voterOverride;
	
	public Long getVoterOverride () {
        return this.voterOverride;
    }

    public void setVoterOverride (Long voterOverride) {
        this.voterOverride = voterOverride;
    }
	private Long fundedCntY2;
	
	public Long getFundedCntY2 () {
        return this.fundedCntY2;
    }

    public void setFundedCntY2 (Long fundedCntY2) {
        this.fundedCntY2 = fundedCntY2;
    }
	private Long fundedCntY1;
	
	public Long getFundedCntY1 () {
        return this.fundedCntY1;
    }

    public void setFundedCntY1 (Long fundedCntY1) {
        this.fundedCntY1 = fundedCntY1;
    }
	private Long fundedCntY0;
	
	public Long getFundedCntY0 () {
        return this.fundedCntY0;
    }

    public void setFundedCntY0 (Long fundedCntY0) {
        this.fundedCntY0 = fundedCntY0;
    }
	private Long minFormulaFund;
	
	public Long getMinFormulaFund () {
        return this.minFormulaFund;
    }

    public void setMinFormulaFund (Long minFormulaFund) {
        this.minFormulaFund = minFormulaFund;
    }
	private Long totAddFundV63;
	
	public Long getTotAddFundV63 () {
        return this.totAddFundV63;
    }

    public void setTotAddFundV63 (Long totAddFundV63) {
        this.totAddFundV63 = totAddFundV63;
    }
	private Long adjTotFundGt3;
	
	public Long getAdjTotFundGt3 () {
        return this.adjTotFundGt3;
    }

    public void setAdjTotFundGt3 (Long adjTotFundGt3) {
        this.adjTotFundGt3 = adjTotFundGt3;
    }
	private Long adjStateAssess;
	
	public Long getAdjStateAssess () {
        return this.adjStateAssess;
    }

    public void setAdjStateAssess (Long adjStateAssess) {
        this.adjStateAssess = adjStateAssess;
    }
	private Long fundedCntY3;
	
	public Long getFundedCntY3 () {
        return this.fundedCntY3;
    }

    public void setFundedCntY3 (Long fundedCntY3) {
        this.fundedCntY3 = fundedCntY3;
    }
	private Long chrtrSchlCnt;
	
	public Long getChrtrSchlCnt () {
        return this.chrtrSchlCnt;
    }

    public void setChrtrSchlCnt (Long chrtrSchlCnt) {
        this.chrtrSchlCnt = chrtrSchlCnt;
    }
	private Long smlCntrPymnts;
	
	public Long getSmlCntrPymnts () {
        return this.smlCntrPymnts;
    }

    public void setSmlCntrPymnts (Long smlCntrPymnts) {
        this.smlCntrPymnts = smlCntrPymnts;
    }
	private Long minSizeAdjust;
	
	public Long getMinSizeAdjust () {
        return this.minSizeAdjust;
    }

    public void setMinSizeAdjust (Long minSizeAdjust) {
        this.minSizeAdjust = minSizeAdjust;
    }
	private Long eslCsap;
	
	public Long getEslCsap () {
        return this.eslCsap;
    }

    public void setEslCsap (Long eslCsap) {
        this.eslCsap = eslCsap;
    }
	private Long onLineCntY0;
	
	public Long getOnLineCntY0 () {
        return this.onLineCntY0;
    }

    public void setOnLineCntY0 (Long onLineCntY0) {
        this.onLineCntY0 = onLineCntY0;
    }
	private Long onLineCntY1;
	
	public Long getOnLineCntY1 () {
        return this.onLineCntY1;
    }

    public void setOnLineCntY1 (Long onLineCntY1) {
        this.onLineCntY1 = onLineCntY1;
    }
	private Long preschool5;
	
	public Long getPreschool5 () {
        return this.preschool5;
    }

    public void setPreschool5 (Long preschool5) {
        this.preschool5 = preschool5;
    }
	private Long adjY0ChrtrDbt;
	
	public Long getAdjY0ChrtrDbt () {
        return this.adjY0ChrtrDbt;
    }

    public void setAdjY0ChrtrDbt (Long adjY0ChrtrDbt) {
        this.adjY0ChrtrDbt = adjY0ChrtrDbt;
    }
	private Long ytdY0ChrtrDbt;
	
	public Long getYtdY0ChrtrDbt () {
        return this.ytdY0ChrtrDbt;
    }

    public void setYtdY0ChrtrDbt (Long ytdY0ChrtrDbt) {
        this.ytdY0ChrtrDbt = ytdY0ChrtrDbt;
    }
	private Long ytdY0CdeAdj;
	
	public Long getYtdY0CdeAdj () {
        return this.ytdY0CdeAdj;
    }

    public void setYtdY0CdeAdj (Long ytdY0CdeAdj) {
        this.ytdY0CdeAdj = ytdY0CdeAdj;
    }
	private Long propertyTaxY1;
	
	public Long getPropertyTaxY1 () {
        return this.propertyTaxY1;
    }

    public void setPropertyTaxY1 (Long propertyTaxY1) {
        this.propertyTaxY1 = propertyTaxY1;
    }
	private Long millLevyY1;
	
	public Long getMillLevyY1 () {
        return this.millLevyY1;
    }

    public void setMillLevyY1 (Long millLevyY1) {
        this.millLevyY1 = millLevyY1;
    }
	private Long monthPayment;
	
	public Long getMonthPayment () {
        return this.monthPayment;
    }

    public void setMonthPayment (Long monthPayment) {
        this.monthPayment = monthPayment;
    }
	private Long ytdPayment;
	
	public Long getYtdPayment () {
        return this.ytdPayment;
    }

    public void setYtdPayment (Long ytdPayment) {
        this.ytdPayment = ytdPayment;
    }
	private Long adjY0Audit;
	
	public Long getAdjY0Audit () {
        return this.adjY0Audit;
    }

    public void setAdjY0Audit (Long adjY0Audit) {
        this.adjY0Audit = adjY0Audit;
    }
	private Long csiY0Share;
	
	public Long getCsiY0Share () {
        return this.csiY0Share;
    }

    public void setCsiY0Share (Long csiY0Share) {
        this.csiY0Share = csiY0Share;
    }
	private Long distChrtrCntY1;
	
	public Long getDistChrtrCntY1 () {
        return this.distChrtrCntY1;
    }

    public void setDistChrtrCntY1 (Long distChrtrCntY1) {
        this.distChrtrCntY1 = distChrtrCntY1;
    }
	private Long distChrtrCntY2;
	
	public Long getDistChrtrCntY2 () {
        return this.distChrtrCntY2;
    }

    public void setDistChrtrCntY2 (Long distChrtrCntY2) {
        this.distChrtrCntY2 = distChrtrCntY2;
    }
	private Long distChrtrCntY3;
	
	public Long getDistChrtrCntY3 () {
        return this.distChrtrCntY3;
    }

    public void setDistChrtrCntY3 (Long distChrtrCntY3) {
        this.distChrtrCntY3 = distChrtrCntY3;
    }
	private Long distChrtrCntY4;
	
	public Long getDistChrtrCntY4 () {
        return this.distChrtrCntY4;
    }

    public void setDistChrtrCntY4 (Long distChrtrCntY4) {
        this.distChrtrCntY4 = distChrtrCntY4;
    }
	private Long fundedCntY4;
	
	public Long getFundedCntY4 () {
        return this.fundedCntY4;
    }

    public void setFundedCntY4 (Long fundedCntY4) {
        this.fundedCntY4 = fundedCntY4;
    }
	private Long sbsf;
	
	public Long getSbsf () {
        return this.sbsf;
    }

    public void setSbsf (Long sbsf) {
        this.sbsf = sbsf;
    }
	private Long ytdY0Audit;
	
	public Long getYtdY0Audit () {
        return this.ytdY0Audit;
    }

    public void setYtdY0Audit (Long ytdY0Audit) {
        this.ytdY0Audit = ytdY0Audit;
    }
	private Long sbsfCatBuyout;
	
	public Long getSbsfCatBuyout () {
        return this.sbsfCatBuyout;
    }

    public void setSbsfCatBuyout (Long sbsfCatBuyout) {
        this.sbsfCatBuyout = sbsfCatBuyout;
    }
	private String fiscalYear;
	
	public String getFiscalYear () {
        return this.fiscalYear;
    }

    public void setFiscalYear (String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }
	private List<String> fiscalYearList = new ArrayList<String>();
	
	public List<String> getFiscalYearList() {
        return this.fiscalYearList;
    }
    
}