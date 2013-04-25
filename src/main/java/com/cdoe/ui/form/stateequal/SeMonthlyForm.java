
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
public class SeMonthlyForm {

	private long id;
	
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	private String fiscalYear;
	
	public String getFiscalYear () {
        return this.fiscalYear;
    }

    public void setFiscalYear (String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }
	private String districtNumber;
	
	public String getDistrictNumber () {
        return this.districtNumber;
    }

    public void setDistrictNumber (String districtNumber) {
        this.districtNumber = districtNumber;
    }
	private Date dateChanged;
	
	public Date getDateChanged () {
        return this.dateChanged;
    }

    public void setDateChanged (Date dateChanged) {
        this.dateChanged = dateChanged;
    }
	private Long janFpc;
	
	public Long getJanFpc () {
        return this.janFpc;
    }

    public void setJanFpc (Long janFpc) {
        this.janFpc = janFpc;
    }
	private Long febFpc;
	
	public Long getFebFpc () {
        return this.febFpc;
    }

    public void setFebFpc (Long febFpc) {
        this.febFpc = febFpc;
    }
	private Long marFpc;
	
	public Long getMarFpc () {
        return this.marFpc;
    }

    public void setMarFpc (Long marFpc) {
        this.marFpc = marFpc;
    }
	private Long aprFpc;
	
	public Long getAprFpc () {
        return this.aprFpc;
    }

    public void setAprFpc (Long aprFpc) {
        this.aprFpc = aprFpc;
    }
	private Long mayFpc;
	
	public Long getMayFpc () {
        return this.mayFpc;
    }

    public void setMayFpc (Long mayFpc) {
        this.mayFpc = mayFpc;
    }
	private Long junFpc;
	
	public Long getJunFpc () {
        return this.junFpc;
    }

    public void setJunFpc (Long junFpc) {
        this.junFpc = junFpc;
    }
	private Long julFpc;
	
	public Long getJulFpc () {
        return this.julFpc;
    }

    public void setJulFpc (Long julFpc) {
        this.julFpc = julFpc;
    }
	private Long augFpc;
	
	public Long getAugFpc () {
        return this.augFpc;
    }

    public void setAugFpc (Long augFpc) {
        this.augFpc = augFpc;
    }
	private Long sepFpc;
	
	public Long getSepFpc () {
        return this.sepFpc;
    }

    public void setSepFpc (Long sepFpc) {
        this.sepFpc = sepFpc;
    }
	private Long octFpc;
	
	public Long getOctFpc () {
        return this.octFpc;
    }

    public void setOctFpc (Long octFpc) {
        this.octFpc = octFpc;
    }
	private Long novFpc;
	
	public Long getNovFpc () {
        return this.novFpc;
    }

    public void setNovFpc (Long novFpc) {
        this.novFpc = novFpc;
    }
	private Long decFpc;
	
	public Long getDecFpc () {
        return this.decFpc;
    }

    public void setDecFpc (Long decFpc) {
        this.decFpc = decFpc;
    }
	private Long janLunch18;
	
	public Long getJanLunch18 () {
        return this.janLunch18;
    }

    public void setJanLunch18 (Long janLunch18) {
        this.janLunch18 = janLunch18;
    }
	private Long febLunch18;
	
	public Long getFebLunch18 () {
        return this.febLunch18;
    }

    public void setFebLunch18 (Long febLunch18) {
        this.febLunch18 = febLunch18;
    }
	private Long marLunch18;
	
	public Long getMarLunch18 () {
        return this.marLunch18;
    }

    public void setMarLunch18 (Long marLunch18) {
        this.marLunch18 = marLunch18;
    }
	private Long aprLunch18;
	
	public Long getAprLunch18 () {
        return this.aprLunch18;
    }

    public void setAprLunch18 (Long aprLunch18) {
        this.aprLunch18 = aprLunch18;
    }
	private Long mayLunch18;
	
	public Long getMayLunch18 () {
        return this.mayLunch18;
    }

    public void setMayLunch18 (Long mayLunch18) {
        this.mayLunch18 = mayLunch18;
    }
	private Long junLunch18;
	
	public Long getJunLunch18 () {
        return this.junLunch18;
    }

    public void setJunLunch18 (Long junLunch18) {
        this.junLunch18 = junLunch18;
    }
	private Long julLunch18;
	
	public Long getJulLunch18 () {
        return this.julLunch18;
    }

    public void setJulLunch18 (Long julLunch18) {
        this.julLunch18 = julLunch18;
    }
	private Long augLunch18;
	
	public Long getAugLunch18 () {
        return this.augLunch18;
    }

    public void setAugLunch18 (Long augLunch18) {
        this.augLunch18 = augLunch18;
    }
	private Long sepLunch18;
	
	public Long getSepLunch18 () {
        return this.sepLunch18;
    }

    public void setSepLunch18 (Long sepLunch18) {
        this.sepLunch18 = sepLunch18;
    }
	private Long octLunch18;
	
	public Long getOctLunch18 () {
        return this.octLunch18;
    }

    public void setOctLunch18 (Long octLunch18) {
        this.octLunch18 = octLunch18;
    }
	private Long novLunch18;
	
	public Long getNovLunch18 () {
        return this.novLunch18;
    }

    public void setNovLunch18 (Long novLunch18) {
        this.novLunch18 = novLunch18;
    }
	private Long decLunch18;
	
	public Long getDecLunch18 () {
        return this.decLunch18;
    }

    public void setDecLunch18 (Long decLunch18) {
        this.decLunch18 = decLunch18;
    }
	private Long janLunchK12;
	
	public Long getJanLunchK12 () {
        return this.janLunchK12;
    }

    public void setJanLunchK12 (Long janLunchK12) {
        this.janLunchK12 = janLunchK12;
    }
	private Long febLunchK12;
	
	public Long getFebLunchK12 () {
        return this.febLunchK12;
    }

    public void setFebLunchK12 (Long febLunchK12) {
        this.febLunchK12 = febLunchK12;
    }
	private Long marLunchK12;
	
	public Long getMarLunchK12 () {
        return this.marLunchK12;
    }

    public void setMarLunchK12 (Long marLunchK12) {
        this.marLunchK12 = marLunchK12;
    }
	private Long aprLunchK12;
	
	public Long getAprLunchK12 () {
        return this.aprLunchK12;
    }

    public void setAprLunchK12 (Long aprLunchK12) {
        this.aprLunchK12 = aprLunchK12;
    }
	private Long mayLunchK12;
	
	public Long getMayLunchK12 () {
        return this.mayLunchK12;
    }

    public void setMayLunchK12 (Long mayLunchK12) {
        this.mayLunchK12 = mayLunchK12;
    }
	private Long junLunchK12;
	
	public Long getJunLunchK12 () {
        return this.junLunchK12;
    }

    public void setJunLunchK12 (Long junLunchK12) {
        this.junLunchK12 = junLunchK12;
    }
	private Long julLunchK12;
	
	public Long getJulLunchK12 () {
        return this.julLunchK12;
    }

    public void setJulLunchK12 (Long julLunchK12) {
        this.julLunchK12 = julLunchK12;
    }
	private Long augLunchK12;
	
	public Long getAugLunchK12 () {
        return this.augLunchK12;
    }

    public void setAugLunchK12 (Long augLunchK12) {
        this.augLunchK12 = augLunchK12;
    }
	private Long sepLunchK12;
	
	public Long getSepLunchK12 () {
        return this.sepLunchK12;
    }

    public void setSepLunchK12 (Long sepLunchK12) {
        this.sepLunchK12 = sepLunchK12;
    }
	private Long octLunchK12;
	
	public Long getOctLunchK12 () {
        return this.octLunchK12;
    }

    public void setOctLunchK12 (Long octLunchK12) {
        this.octLunchK12 = octLunchK12;
    }
	private Long novLunchK12;
	
	public Long getNovLunchK12 () {
        return this.novLunchK12;
    }

    public void setNovLunchK12 (Long novLunchK12) {
        this.novLunchK12 = novLunchK12;
    }
	private Long decLunchK12;
	
	public Long getDecLunchK12 () {
        return this.decLunchK12;
    }

    public void setDecLunchK12 (Long decLunchK12) {
        this.decLunchK12 = decLunchK12;
    }
	private Long janSpecOwnTax;
	
	public Long getJanSpecOwnTax () {
        return this.janSpecOwnTax;
    }

    public void setJanSpecOwnTax (Long janSpecOwnTax) {
        this.janSpecOwnTax = janSpecOwnTax;
    }
	private Long febSpecOwnTax;
	
	public Long getFebSpecOwnTax () {
        return this.febSpecOwnTax;
    }

    public void setFebSpecOwnTax (Long febSpecOwnTax) {
        this.febSpecOwnTax = febSpecOwnTax;
    }
	private Long marSpecOwnTax;
	
	public Long getMarSpecOwnTax () {
        return this.marSpecOwnTax;
    }

    public void setMarSpecOwnTax (Long marSpecOwnTax) {
        this.marSpecOwnTax = marSpecOwnTax;
    }
	private Long aprSpecOwnTax;
	
	public Long getAprSpecOwnTax () {
        return this.aprSpecOwnTax;
    }

    public void setAprSpecOwnTax (Long aprSpecOwnTax) {
        this.aprSpecOwnTax = aprSpecOwnTax;
    }
	private Long maySpecOwnTax;
	
	public Long getMaySpecOwnTax () {
        return this.maySpecOwnTax;
    }

    public void setMaySpecOwnTax (Long maySpecOwnTax) {
        this.maySpecOwnTax = maySpecOwnTax;
    }
	private Long junSpecOwnTax;
	
	public Long getJunSpecOwnTax () {
        return this.junSpecOwnTax;
    }

    public void setJunSpecOwnTax (Long junSpecOwnTax) {
        this.junSpecOwnTax = junSpecOwnTax;
    }
	private Long julSpecOwnTax;
	
	public Long getJulSpecOwnTax () {
        return this.julSpecOwnTax;
    }

    public void setJulSpecOwnTax (Long julSpecOwnTax) {
        this.julSpecOwnTax = julSpecOwnTax;
    }
	private Long augSpecOwnTax;
	
	public Long getAugSpecOwnTax () {
        return this.augSpecOwnTax;
    }

    public void setAugSpecOwnTax (Long augSpecOwnTax) {
        this.augSpecOwnTax = augSpecOwnTax;
    }
	private Long sepSpecOwnTax;
	
	public Long getSepSpecOwnTax () {
        return this.sepSpecOwnTax;
    }

    public void setSepSpecOwnTax (Long sepSpecOwnTax) {
        this.sepSpecOwnTax = sepSpecOwnTax;
    }
	private Long octSpecOwnTax;
	
	public Long getOctSpecOwnTax () {
        return this.octSpecOwnTax;
    }

    public void setOctSpecOwnTax (Long octSpecOwnTax) {
        this.octSpecOwnTax = octSpecOwnTax;
    }
	private Long novSpecOwnTax;
	
	public Long getNovSpecOwnTax () {
        return this.novSpecOwnTax;
    }

    public void setNovSpecOwnTax (Long novSpecOwnTax) {
        this.novSpecOwnTax = novSpecOwnTax;
    }
	private Long decSpecOwnTax;
	
	public Long getDecSpecOwnTax () {
        return this.decSpecOwnTax;
    }

    public void setDecSpecOwnTax (Long decSpecOwnTax) {
        this.decSpecOwnTax = decSpecOwnTax;
    }
	private Long janAssessedVal;
	
	public Long getJanAssessedVal () {
        return this.janAssessedVal;
    }

    public void setJanAssessedVal (Long janAssessedVal) {
        this.janAssessedVal = janAssessedVal;
    }
	private Long febAssessedVal;
	
	public Long getFebAssessedVal () {
        return this.febAssessedVal;
    }

    public void setFebAssessedVal (Long febAssessedVal) {
        this.febAssessedVal = febAssessedVal;
    }
	private Long marAssessedVal;
	
	public Long getMarAssessedVal () {
        return this.marAssessedVal;
    }

    public void setMarAssessedVal (Long marAssessedVal) {
        this.marAssessedVal = marAssessedVal;
    }
	private Long aprAssessedVal;
	
	public Long getAprAssessedVal () {
        return this.aprAssessedVal;
    }

    public void setAprAssessedVal (Long aprAssessedVal) {
        this.aprAssessedVal = aprAssessedVal;
    }
	private Long mayAssessedVal;
	
	public Long getMayAssessedVal () {
        return this.mayAssessedVal;
    }

    public void setMayAssessedVal (Long mayAssessedVal) {
        this.mayAssessedVal = mayAssessedVal;
    }
	private Long junAssessedVal;
	
	public Long getJunAssessedVal () {
        return this.junAssessedVal;
    }

    public void setJunAssessedVal (Long junAssessedVal) {
        this.junAssessedVal = junAssessedVal;
    }
	private Long julAssessedVal;
	
	public Long getJulAssessedVal () {
        return this.julAssessedVal;
    }

    public void setJulAssessedVal (Long julAssessedVal) {
        this.julAssessedVal = julAssessedVal;
    }
	private Long augAssessedVal;
	
	public Long getAugAssessedVal () {
        return this.augAssessedVal;
    }

    public void setAugAssessedVal (Long augAssessedVal) {
        this.augAssessedVal = augAssessedVal;
    }
	private Long sepAssessedVal;
	
	public Long getSepAssessedVal () {
        return this.sepAssessedVal;
    }

    public void setSepAssessedVal (Long sepAssessedVal) {
        this.sepAssessedVal = sepAssessedVal;
    }
	private Long octAssessedVal;
	
	public Long getOctAssessedVal () {
        return this.octAssessedVal;
    }

    public void setOctAssessedVal (Long octAssessedVal) {
        this.octAssessedVal = octAssessedVal;
    }
	private Long novAssessedVal;
	
	public Long getNovAssessedVal () {
        return this.novAssessedVal;
    }

    public void setNovAssessedVal (Long novAssessedVal) {
        this.novAssessedVal = novAssessedVal;
    }
	private Long decAssessedVal;
	
	public Long getDecAssessedVal () {
        return this.decAssessedVal;
    }

    public void setDecAssessedVal (Long decAssessedVal) {
        this.decAssessedVal = decAssessedVal;
    }
	private Long janTotalCats;
	
	public Long getJanTotalCats () {
        return this.janTotalCats;
    }

    public void setJanTotalCats (Long janTotalCats) {
        this.janTotalCats = janTotalCats;
    }
	private Long febTotalCats;
	
	public Long getFebTotalCats () {
        return this.febTotalCats;
    }

    public void setFebTotalCats (Long febTotalCats) {
        this.febTotalCats = febTotalCats;
    }
	private Long marTotalCats;
	
	public Long getMarTotalCats () {
        return this.marTotalCats;
    }

    public void setMarTotalCats (Long marTotalCats) {
        this.marTotalCats = marTotalCats;
    }
	private Long aprTotalCats;
	
	public Long getAprTotalCats () {
        return this.aprTotalCats;
    }

    public void setAprTotalCats (Long aprTotalCats) {
        this.aprTotalCats = aprTotalCats;
    }
	private Long mayTotalCats;
	
	public Long getMayTotalCats () {
        return this.mayTotalCats;
    }

    public void setMayTotalCats (Long mayTotalCats) {
        this.mayTotalCats = mayTotalCats;
    }
	private Long junTotalCats;
	
	public Long getJunTotalCats () {
        return this.junTotalCats;
    }

    public void setJunTotalCats (Long junTotalCats) {
        this.junTotalCats = junTotalCats;
    }
	private Long julTotalCats;
	
	public Long getJulTotalCats () {
        return this.julTotalCats;
    }

    public void setJulTotalCats (Long julTotalCats) {
        this.julTotalCats = julTotalCats;
    }
	private Long augTotalCats;
	
	public Long getAugTotalCats () {
        return this.augTotalCats;
    }

    public void setAugTotalCats (Long augTotalCats) {
        this.augTotalCats = augTotalCats;
    }
	private Long sepTotalCats;
	
	public Long getSepTotalCats () {
        return this.sepTotalCats;
    }

    public void setSepTotalCats (Long sepTotalCats) {
        this.sepTotalCats = sepTotalCats;
    }
	private Long octTotalCats;
	
	public Long getOctTotalCats () {
        return this.octTotalCats;
    }

    public void setOctTotalCats (Long octTotalCats) {
        this.octTotalCats = octTotalCats;
    }
	private Long novTotalCats;
	
	public Long getNovTotalCats () {
        return this.novTotalCats;
    }

    public void setNovTotalCats (Long novTotalCats) {
        this.novTotalCats = novTotalCats;
    }
	private Long decTotalCats;
	
	public Long getDecTotalCats () {
        return this.decTotalCats;
    }

    public void setDecTotalCats (Long decTotalCats) {
        this.decTotalCats = decTotalCats;
    }
	private Long janTotFundTp3;
	
	public Long getJanTotFundTp3 () {
        return this.janTotFundTp3;
    }

    public void setJanTotFundTp3 (Long janTotFundTp3) {
        this.janTotFundTp3 = janTotFundTp3;
    }
	private Long febTotFundTp3;
	
	public Long getFebTotFundTp3 () {
        return this.febTotFundTp3;
    }

    public void setFebTotFundTp3 (Long febTotFundTp3) {
        this.febTotFundTp3 = febTotFundTp3;
    }
	private Long marTotFundTp3;
	
	public Long getMarTotFundTp3 () {
        return this.marTotFundTp3;
    }

    public void setMarTotFundTp3 (Long marTotFundTp3) {
        this.marTotFundTp3 = marTotFundTp3;
    }
	private Long aprTotFundTp3;
	
	public Long getAprTotFundTp3 () {
        return this.aprTotFundTp3;
    }

    public void setAprTotFundTp3 (Long aprTotFundTp3) {
        this.aprTotFundTp3 = aprTotFundTp3;
    }
	private Long mayTotFundTp3;
	
	public Long getMayTotFundTp3 () {
        return this.mayTotFundTp3;
    }

    public void setMayTotFundTp3 (Long mayTotFundTp3) {
        this.mayTotFundTp3 = mayTotFundTp3;
    }
	private Long junTotFundTp3;
	
	public Long getJunTotFundTp3 () {
        return this.junTotFundTp3;
    }

    public void setJunTotFundTp3 (Long junTotFundTp3) {
        this.junTotFundTp3 = junTotFundTp3;
    }
	private Long julTotFundTp3;
	
	public Long getJulTotFundTp3 () {
        return this.julTotFundTp3;
    }

    public void setJulTotFundTp3 (Long julTotFundTp3) {
        this.julTotFundTp3 = julTotFundTp3;
    }
	private Long augTotFundTp3;
	
	public Long getAugTotFundTp3 () {
        return this.augTotFundTp3;
    }

    public void setAugTotFundTp3 (Long augTotFundTp3) {
        this.augTotFundTp3 = augTotFundTp3;
    }
	private Long sepTotFundTp3;
	
	public Long getSepTotFundTp3 () {
        return this.sepTotFundTp3;
    }

    public void setSepTotFundTp3 (Long sepTotFundTp3) {
        this.sepTotFundTp3 = sepTotFundTp3;
    }
	private Long octTotFundTp3;
	
	public Long getOctTotFundTp3 () {
        return this.octTotFundTp3;
    }

    public void setOctTotFundTp3 (Long octTotFundTp3) {
        this.octTotFundTp3 = octTotFundTp3;
    }
	private Long novTotFundTp3;
	
	public Long getNovTotFundTp3 () {
        return this.novTotFundTp3;
    }

    public void setNovTotFundTp3 (Long novTotFundTp3) {
        this.novTotFundTp3 = novTotFundTp3;
    }
	private Long decTotFundTp3;
	
	public Long getDecTotFundTp3 () {
        return this.decTotFundTp3;
    }

    public void setDecTotFundTp3 (Long decTotFundTp3) {
        this.decTotFundTp3 = decTotFundTp3;
    }
	private Long janStateEqual;
	
	public Long getJanStateEqual () {
        return this.janStateEqual;
    }

    public void setJanStateEqual (Long janStateEqual) {
        this.janStateEqual = janStateEqual;
    }
	private Long febStateEqual;
	
	public Long getFebStateEqual () {
        return this.febStateEqual;
    }

    public void setFebStateEqual (Long febStateEqual) {
        this.febStateEqual = febStateEqual;
    }
	private Long marStateEqual;
	
	public Long getMarStateEqual () {
        return this.marStateEqual;
    }

    public void setMarStateEqual (Long marStateEqual) {
        this.marStateEqual = marStateEqual;
    }
	private Long aprStateEqual;
	
	public Long getAprStateEqual () {
        return this.aprStateEqual;
    }

    public void setAprStateEqual (Long aprStateEqual) {
        this.aprStateEqual = aprStateEqual;
    }
	private Long mayStateEqual;
	
	public Long getMayStateEqual () {
        return this.mayStateEqual;
    }

    public void setMayStateEqual (Long mayStateEqual) {
        this.mayStateEqual = mayStateEqual;
    }
	private Long junStateEqual;
	
	public Long getJunStateEqual () {
        return this.junStateEqual;
    }

    public void setJunStateEqual (Long junStateEqual) {
        this.junStateEqual = junStateEqual;
    }
	private Long julStateEqual;
	
	public Long getJulStateEqual () {
        return this.julStateEqual;
    }

    public void setJulStateEqual (Long julStateEqual) {
        this.julStateEqual = julStateEqual;
    }
	private Long augStateEqual;
	
	public Long getAugStateEqual () {
        return this.augStateEqual;
    }

    public void setAugStateEqual (Long augStateEqual) {
        this.augStateEqual = augStateEqual;
    }
	private Long sepStateEqual;
	
	public Long getSepStateEqual () {
        return this.sepStateEqual;
    }

    public void setSepStateEqual (Long sepStateEqual) {
        this.sepStateEqual = sepStateEqual;
    }
	private Long octStateEqual;
	
	public Long getOctStateEqual () {
        return this.octStateEqual;
    }

    public void setOctStateEqual (Long octStateEqual) {
        this.octStateEqual = octStateEqual;
    }
	private Long novStateEqual;
	
	public Long getNovStateEqual () {
        return this.novStateEqual;
    }

    public void setNovStateEqual (Long novStateEqual) {
        this.novStateEqual = novStateEqual;
    }
	private Long decStateEqual;
	
	public Long getDecStateEqual () {
        return this.decStateEqual;
    }

    public void setDecStateEqual (Long decStateEqual) {
        this.decStateEqual = decStateEqual;
    }
	private Long janMillLevy;
	
	public Long getJanMillLevy () {
        return this.janMillLevy;
    }

    public void setJanMillLevy (Long janMillLevy) {
        this.janMillLevy = janMillLevy;
    }
	private Long febMillLevy;
	
	public Long getFebMillLevy () {
        return this.febMillLevy;
    }

    public void setFebMillLevy (Long febMillLevy) {
        this.febMillLevy = febMillLevy;
    }
	private Long marMillLevy;
	
	public Long getMarMillLevy () {
        return this.marMillLevy;
    }

    public void setMarMillLevy (Long marMillLevy) {
        this.marMillLevy = marMillLevy;
    }
	private Long aprMillLevy;
	
	public Long getAprMillLevy () {
        return this.aprMillLevy;
    }

    public void setAprMillLevy (Long aprMillLevy) {
        this.aprMillLevy = aprMillLevy;
    }
	private Long mayMillLevy;
	
	public Long getMayMillLevy () {
        return this.mayMillLevy;
    }

    public void setMayMillLevy (Long mayMillLevy) {
        this.mayMillLevy = mayMillLevy;
    }
	private Long junMillLevy;
	
	public Long getJunMillLevy () {
        return this.junMillLevy;
    }

    public void setJunMillLevy (Long junMillLevy) {
        this.junMillLevy = junMillLevy;
    }
	private Long julMillLevy;
	
	public Long getJulMillLevy () {
        return this.julMillLevy;
    }

    public void setJulMillLevy (Long julMillLevy) {
        this.julMillLevy = julMillLevy;
    }
	private Long augMillLevy;
	
	public Long getAugMillLevy () {
        return this.augMillLevy;
    }

    public void setAugMillLevy (Long augMillLevy) {
        this.augMillLevy = augMillLevy;
    }
	private Long sepMillLevy;
	
	public Long getSepMillLevy () {
        return this.sepMillLevy;
    }

    public void setSepMillLevy (Long sepMillLevy) {
        this.sepMillLevy = sepMillLevy;
    }
	private Long octMillLevy;
	
	public Long getOctMillLevy () {
        return this.octMillLevy;
    }

    public void setOctMillLevy (Long octMillLevy) {
        this.octMillLevy = octMillLevy;
    }
	private Long novMillLevy;
	
	public Long getNovMillLevy () {
        return this.novMillLevy;
    }

    public void setNovMillLevy (Long novMillLevy) {
        this.novMillLevy = novMillLevy;
    }
	private Long decMillLevy;
	
	public Long getDecMillLevy () {
        return this.decMillLevy;
    }

    public void setDecMillLevy (Long decMillLevy) {
        this.decMillLevy = decMillLevy;
    }
	private Long janCatMlLevy;
	
	public Long getJanCatMlLevy () {
        return this.janCatMlLevy;
    }

    public void setJanCatMlLevy (Long janCatMlLevy) {
        this.janCatMlLevy = janCatMlLevy;
    }
	private Long febCatMlLevy;
	
	public Long getFebCatMlLevy () {
        return this.febCatMlLevy;
    }

    public void setFebCatMlLevy (Long febCatMlLevy) {
        this.febCatMlLevy = febCatMlLevy;
    }
	private Long marCatMlLevy;
	
	public Long getMarCatMlLevy () {
        return this.marCatMlLevy;
    }

    public void setMarCatMlLevy (Long marCatMlLevy) {
        this.marCatMlLevy = marCatMlLevy;
    }
	private Long aprCatMlLevy;
	
	public Long getAprCatMlLevy () {
        return this.aprCatMlLevy;
    }

    public void setAprCatMlLevy (Long aprCatMlLevy) {
        this.aprCatMlLevy = aprCatMlLevy;
    }
	private Long mayCatMlLevy;
	
	public Long getMayCatMlLevy () {
        return this.mayCatMlLevy;
    }

    public void setMayCatMlLevy (Long mayCatMlLevy) {
        this.mayCatMlLevy = mayCatMlLevy;
    }
	private Long junCatMlLevy;
	
	public Long getJunCatMlLevy () {
        return this.junCatMlLevy;
    }

    public void setJunCatMlLevy (Long junCatMlLevy) {
        this.junCatMlLevy = junCatMlLevy;
    }
	private Long julCatMlLevy;
	
	public Long getJulCatMlLevy () {
        return this.julCatMlLevy;
    }

    public void setJulCatMlLevy (Long julCatMlLevy) {
        this.julCatMlLevy = julCatMlLevy;
    }
	private Long augCatMlLevy;
	
	public Long getAugCatMlLevy () {
        return this.augCatMlLevy;
    }

    public void setAugCatMlLevy (Long augCatMlLevy) {
        this.augCatMlLevy = augCatMlLevy;
    }
	private Long sepCatMlLevy;
	
	public Long getSepCatMlLevy () {
        return this.sepCatMlLevy;
    }

    public void setSepCatMlLevy (Long sepCatMlLevy) {
        this.sepCatMlLevy = sepCatMlLevy;
    }
	private Long octCatMlLevy;
	
	public Long getOctCatMlLevy () {
        return this.octCatMlLevy;
    }

    public void setOctCatMlLevy (Long octCatMlLevy) {
        this.octCatMlLevy = octCatMlLevy;
    }
	private Long novCatMlLevy;
	
	public Long getNovCatMlLevy () {
        return this.novCatMlLevy;
    }

    public void setNovCatMlLevy (Long novCatMlLevy) {
        this.novCatMlLevy = novCatMlLevy;
    }
	private Long decCatMlLevy;
	
	public Long getDecCatMlLevy () {
        return this.decCatMlLevy;
    }

    public void setDecCatMlLevy (Long decCatMlLevy) {
        this.decCatMlLevy = decCatMlLevy;
    }
	private Long janMmEntitle;
	
	public Long getJanMmEntitle () {
        return this.janMmEntitle;
    }

    public void setJanMmEntitle (Long janMmEntitle) {
        this.janMmEntitle = janMmEntitle;
    }
	private Long febMmEntitle;
	
	public Long getFebMmEntitle () {
        return this.febMmEntitle;
    }

    public void setFebMmEntitle (Long febMmEntitle) {
        this.febMmEntitle = febMmEntitle;
    }
	private Long marMmEntitle;
	
	public Long getMarMmEntitle () {
        return this.marMmEntitle;
    }

    public void setMarMmEntitle (Long marMmEntitle) {
        this.marMmEntitle = marMmEntitle;
    }
	private Long aprMmEntitle;
	
	public Long getAprMmEntitle () {
        return this.aprMmEntitle;
    }

    public void setAprMmEntitle (Long aprMmEntitle) {
        this.aprMmEntitle = aprMmEntitle;
    }
	private Long mayMmEntitle;
	
	public Long getMayMmEntitle () {
        return this.mayMmEntitle;
    }

    public void setMayMmEntitle (Long mayMmEntitle) {
        this.mayMmEntitle = mayMmEntitle;
    }
	private Long junMmEntitle;
	
	public Long getJunMmEntitle () {
        return this.junMmEntitle;
    }

    public void setJunMmEntitle (Long junMmEntitle) {
        this.junMmEntitle = junMmEntitle;
    }
	private Long julMmEntitle;
	
	public Long getJulMmEntitle () {
        return this.julMmEntitle;
    }

    public void setJulMmEntitle (Long julMmEntitle) {
        this.julMmEntitle = julMmEntitle;
    }
	private Long augMmEntitle;
	
	public Long getAugMmEntitle () {
        return this.augMmEntitle;
    }

    public void setAugMmEntitle (Long augMmEntitle) {
        this.augMmEntitle = augMmEntitle;
    }
	private Long sepMmEntitle;
	
	public Long getSepMmEntitle () {
        return this.sepMmEntitle;
    }

    public void setSepMmEntitle (Long sepMmEntitle) {
        this.sepMmEntitle = sepMmEntitle;
    }
	private Long octMmEntitle;
	
	public Long getOctMmEntitle () {
        return this.octMmEntitle;
    }

    public void setOctMmEntitle (Long octMmEntitle) {
        this.octMmEntitle = octMmEntitle;
    }
	private Long novMmEntitle;
	
	public Long getNovMmEntitle () {
        return this.novMmEntitle;
    }

    public void setNovMmEntitle (Long novMmEntitle) {
        this.novMmEntitle = novMmEntitle;
    }
	private Long decMmEntitle;
	
	public Long getDecMmEntitle () {
        return this.decMmEntitle;
    }

    public void setDecMmEntitle (Long decMmEntitle) {
        this.decMmEntitle = decMmEntitle;
    }
	private Long decActEntitle;
	
	public Long getDecActEntitle () {
        return this.decActEntitle;
    }

    public void setDecActEntitle (Long decActEntitle) {
        this.decActEntitle = decActEntitle;
    }
	private Long junActEntitle;
	
	public Long getJunActEntitle () {
        return this.junActEntitle;
    }

    public void setJunActEntitle (Long junActEntitle) {
        this.junActEntitle = junActEntitle;
    }
	private Long janMmOodsAdj;
	
	public Long getJanMmOodsAdj () {
        return this.janMmOodsAdj;
    }

    public void setJanMmOodsAdj (Long janMmOodsAdj) {
        this.janMmOodsAdj = janMmOodsAdj;
    }
	private Long febMmOodsAdj;
	
	public Long getFebMmOodsAdj () {
        return this.febMmOodsAdj;
    }

    public void setFebMmOodsAdj (Long febMmOodsAdj) {
        this.febMmOodsAdj = febMmOodsAdj;
    }
	private Long marMmOodsAdj;
	
	public Long getMarMmOodsAdj () {
        return this.marMmOodsAdj;
    }

    public void setMarMmOodsAdj (Long marMmOodsAdj) {
        this.marMmOodsAdj = marMmOodsAdj;
    }
	private Long aprMmOodsAdj;
	
	public Long getAprMmOodsAdj () {
        return this.aprMmOodsAdj;
    }

    public void setAprMmOodsAdj (Long aprMmOodsAdj) {
        this.aprMmOodsAdj = aprMmOodsAdj;
    }
	private Long mayMmOodsAdj;
	
	public Long getMayMmOodsAdj () {
        return this.mayMmOodsAdj;
    }

    public void setMayMmOodsAdj (Long mayMmOodsAdj) {
        this.mayMmOodsAdj = mayMmOodsAdj;
    }
	private Long junMmOodsAdj;
	
	public Long getJunMmOodsAdj () {
        return this.junMmOodsAdj;
    }

    public void setJunMmOodsAdj (Long junMmOodsAdj) {
        this.junMmOodsAdj = junMmOodsAdj;
    }
	private Long julMmOodsAdj;
	
	public Long getJulMmOodsAdj () {
        return this.julMmOodsAdj;
    }

    public void setJulMmOodsAdj (Long julMmOodsAdj) {
        this.julMmOodsAdj = julMmOodsAdj;
    }
	private Long augMmOodsAdj;
	
	public Long getAugMmOodsAdj () {
        return this.augMmOodsAdj;
    }

    public void setAugMmOodsAdj (Long augMmOodsAdj) {
        this.augMmOodsAdj = augMmOodsAdj;
    }
	private Long sepMmOodsAdj;
	
	public Long getSepMmOodsAdj () {
        return this.sepMmOodsAdj;
    }

    public void setSepMmOodsAdj (Long sepMmOodsAdj) {
        this.sepMmOodsAdj = sepMmOodsAdj;
    }
	private Long octMmOodsAdj;
	
	public Long getOctMmOodsAdj () {
        return this.octMmOodsAdj;
    }

    public void setOctMmOodsAdj (Long octMmOodsAdj) {
        this.octMmOodsAdj = octMmOodsAdj;
    }
	private Long novMmOodsAdj;
	
	public Long getNovMmOodsAdj () {
        return this.novMmOodsAdj;
    }

    public void setNovMmOodsAdj (Long novMmOodsAdj) {
        this.novMmOodsAdj = novMmOodsAdj;
    }
	private Long decMmOodsAdj;
	
	public Long getDecMmOodsAdj () {
        return this.decMmOodsAdj;
    }

    public void setDecMmOodsAdj (Long decMmOodsAdj) {
        this.decMmOodsAdj = decMmOodsAdj;
    }
	private Long janMmSwapAdj;
	
	public Long getJanMmSwapAdj () {
        return this.janMmSwapAdj;
    }

    public void setJanMmSwapAdj (Long janMmSwapAdj) {
        this.janMmSwapAdj = janMmSwapAdj;
    }
	private Long febMmSwapAdj;
	
	public Long getFebMmSwapAdj () {
        return this.febMmSwapAdj;
    }

    public void setFebMmSwapAdj (Long febMmSwapAdj) {
        this.febMmSwapAdj = febMmSwapAdj;
    }
	private Long marMmSwapAdj;
	
	public Long getMarMmSwapAdj () {
        return this.marMmSwapAdj;
    }

    public void setMarMmSwapAdj (Long marMmSwapAdj) {
        this.marMmSwapAdj = marMmSwapAdj;
    }
	private Long aprMmSwapAdj;
	
	public Long getAprMmSwapAdj () {
        return this.aprMmSwapAdj;
    }

    public void setAprMmSwapAdj (Long aprMmSwapAdj) {
        this.aprMmSwapAdj = aprMmSwapAdj;
    }
	private Long mayMmSwapAdj;
	
	public Long getMayMmSwapAdj () {
        return this.mayMmSwapAdj;
    }

    public void setMayMmSwapAdj (Long mayMmSwapAdj) {
        this.mayMmSwapAdj = mayMmSwapAdj;
    }
	private Long junMmSwapAdj;
	
	public Long getJunMmSwapAdj () {
        return this.junMmSwapAdj;
    }

    public void setJunMmSwapAdj (Long junMmSwapAdj) {
        this.junMmSwapAdj = junMmSwapAdj;
    }
	private Long julMmSwapAdj;
	
	public Long getJulMmSwapAdj () {
        return this.julMmSwapAdj;
    }

    public void setJulMmSwapAdj (Long julMmSwapAdj) {
        this.julMmSwapAdj = julMmSwapAdj;
    }
	private Long augMmSwapAdj;
	
	public Long getAugMmSwapAdj () {
        return this.augMmSwapAdj;
    }

    public void setAugMmSwapAdj (Long augMmSwapAdj) {
        this.augMmSwapAdj = augMmSwapAdj;
    }
	private Long sepMmSwapAdj;
	
	public Long getSepMmSwapAdj () {
        return this.sepMmSwapAdj;
    }

    public void setSepMmSwapAdj (Long sepMmSwapAdj) {
        this.sepMmSwapAdj = sepMmSwapAdj;
    }
	private Long octMmSwapAdj;
	
	public Long getOctMmSwapAdj () {
        return this.octMmSwapAdj;
    }

    public void setOctMmSwapAdj (Long octMmSwapAdj) {
        this.octMmSwapAdj = octMmSwapAdj;
    }
	private Long novMmSwapAdj;
	
	public Long getNovMmSwapAdj () {
        return this.novMmSwapAdj;
    }

    public void setNovMmSwapAdj (Long novMmSwapAdj) {
        this.novMmSwapAdj = novMmSwapAdj;
    }
	private Long decMmSwapAdj;
	
	public Long getDecMmSwapAdj () {
        return this.decMmSwapAdj;
    }

    public void setDecMmSwapAdj (Long decMmSwapAdj) {
        this.decMmSwapAdj = decMmSwapAdj;
    }
	private Long janMmOtherAdj;
	
	public Long getJanMmOtherAdj () {
        return this.janMmOtherAdj;
    }

    public void setJanMmOtherAdj (Long janMmOtherAdj) {
        this.janMmOtherAdj = janMmOtherAdj;
    }
	private Long febMmOtherAdj;
	
	public Long getFebMmOtherAdj () {
        return this.febMmOtherAdj;
    }

    public void setFebMmOtherAdj (Long febMmOtherAdj) {
        this.febMmOtherAdj = febMmOtherAdj;
    }
	private Long marMmOtherAdj;
	
	public Long getMarMmOtherAdj () {
        return this.marMmOtherAdj;
    }

    public void setMarMmOtherAdj (Long marMmOtherAdj) {
        this.marMmOtherAdj = marMmOtherAdj;
    }
	private Long aprMmOtherAdj;
	
	public Long getAprMmOtherAdj () {
        return this.aprMmOtherAdj;
    }

    public void setAprMmOtherAdj (Long aprMmOtherAdj) {
        this.aprMmOtherAdj = aprMmOtherAdj;
    }
	private Long mayMmOtherAdj;
	
	public Long getMayMmOtherAdj () {
        return this.mayMmOtherAdj;
    }

    public void setMayMmOtherAdj (Long mayMmOtherAdj) {
        this.mayMmOtherAdj = mayMmOtherAdj;
    }
	private Long junMmOtherAdj;
	
	public Long getJunMmOtherAdj () {
        return this.junMmOtherAdj;
    }

    public void setJunMmOtherAdj (Long junMmOtherAdj) {
        this.junMmOtherAdj = junMmOtherAdj;
    }
	private Long julMmOtherAdj;
	
	public Long getJulMmOtherAdj () {
        return this.julMmOtherAdj;
    }

    public void setJulMmOtherAdj (Long julMmOtherAdj) {
        this.julMmOtherAdj = julMmOtherAdj;
    }
	private Long augMmOtherAdj;
	
	public Long getAugMmOtherAdj () {
        return this.augMmOtherAdj;
    }

    public void setAugMmOtherAdj (Long augMmOtherAdj) {
        this.augMmOtherAdj = augMmOtherAdj;
    }
	private Long sepMmOtherAdj;
	
	public Long getSepMmOtherAdj () {
        return this.sepMmOtherAdj;
    }

    public void setSepMmOtherAdj (Long sepMmOtherAdj) {
        this.sepMmOtherAdj = sepMmOtherAdj;
    }
	private Long octMmOtherAdj;
	
	public Long getOctMmOtherAdj () {
        return this.octMmOtherAdj;
    }

    public void setOctMmOtherAdj (Long octMmOtherAdj) {
        this.octMmOtherAdj = octMmOtherAdj;
    }
	private Long novMmOtherAdj;
	
	public Long getNovMmOtherAdj () {
        return this.novMmOtherAdj;
    }

    public void setNovMmOtherAdj (Long novMmOtherAdj) {
        this.novMmOtherAdj = novMmOtherAdj;
    }
	private Long decMmOtherAdj;
	
	public Long getDecMmOtherAdj () {
        return this.decMmOtherAdj;
    }

    public void setDecMmOtherAdj (Long decMmOtherAdj) {
        this.decMmOtherAdj = decMmOtherAdj;
    }
	private Long janPayment;
	
	public Long getJanPayment () {
        return this.janPayment;
    }

    public void setJanPayment (Long janPayment) {
        this.janPayment = janPayment;
    }
	private Long febPayment;
	
	public Long getFebPayment () {
        return this.febPayment;
    }

    public void setFebPayment (Long febPayment) {
        this.febPayment = febPayment;
    }
	private Long marPayment;
	
	public Long getMarPayment () {
        return this.marPayment;
    }

    public void setMarPayment (Long marPayment) {
        this.marPayment = marPayment;
    }
	private Long aprPayment;
	
	public Long getAprPayment () {
        return this.aprPayment;
    }

    public void setAprPayment (Long aprPayment) {
        this.aprPayment = aprPayment;
    }
	private Long mayPayment;
	
	public Long getMayPayment () {
        return this.mayPayment;
    }

    public void setMayPayment (Long mayPayment) {
        this.mayPayment = mayPayment;
    }
	private Long junPayment;
	
	public Long getJunPayment () {
        return this.junPayment;
    }

    public void setJunPayment (Long junPayment) {
        this.junPayment = junPayment;
    }
	private Long julPayment;
	
	public Long getJulPayment () {
        return this.julPayment;
    }

    public void setJulPayment (Long julPayment) {
        this.julPayment = julPayment;
    }
	private Long augPayment;
	
	public Long getAugPayment () {
        return this.augPayment;
    }

    public void setAugPayment (Long augPayment) {
        this.augPayment = augPayment;
    }
	private Long sepPayment;
	
	public Long getSepPayment () {
        return this.sepPayment;
    }

    public void setSepPayment (Long sepPayment) {
        this.sepPayment = sepPayment;
    }
	private Long octPayment;
	
	public Long getOctPayment () {
        return this.octPayment;
    }

    public void setOctPayment (Long octPayment) {
        this.octPayment = octPayment;
    }
	private Long novPayment;
	
	public Long getNovPayment () {
        return this.novPayment;
    }

    public void setNovPayment (Long novPayment) {
        this.novPayment = novPayment;
    }
	private Long decPayment;
	
	public Long getDecPayment () {
        return this.decPayment;
    }

    public void setDecPayment (Long decPayment) {
        this.decPayment = decPayment;
    }
	private Long decVariance1;
	
	public Long getDecVariance1 () {
        return this.decVariance1;
    }

    public void setDecVariance1 (Long decVariance1) {
        this.decVariance1 = decVariance1;
    }
	private Long decVariance2;
	
	public Long getDecVariance2 () {
        return this.decVariance2;
    }

    public void setDecVariance2 (Long decVariance2) {
        this.decVariance2 = decVariance2;
    }
	private Long decVariance3;
	
	public Long getDecVariance3 () {
        return this.decVariance3;
    }

    public void setDecVariance3 (Long decVariance3) {
        this.decVariance3 = decVariance3;
    }
	private Long janVariance1;
	
	public Long getJanVariance1 () {
        return this.janVariance1;
    }

    public void setJanVariance1 (Long janVariance1) {
        this.janVariance1 = janVariance1;
    }
	private Long janVariance2;
	
	public Long getJanVariance2 () {
        return this.janVariance2;
    }

    public void setJanVariance2 (Long janVariance2) {
        this.janVariance2 = janVariance2;
    }
	private Long janVariance3;
	
	public Long getJanVariance3 () {
        return this.janVariance3;
    }

    public void setJanVariance3 (Long janVariance3) {
        this.janVariance3 = janVariance3;
    }
	private Long junVariance1;
	
	public Long getJunVariance1 () {
        return this.junVariance1;
    }

    public void setJunVariance1 (Long junVariance1) {
        this.junVariance1 = junVariance1;
    }
	private Long junVariance2;
	
	public Long getJunVariance2 () {
        return this.junVariance2;
    }

    public void setJunVariance2 (Long junVariance2) {
        this.junVariance2 = junVariance2;
    }
	private Long junVariance3;
	
	public Long getJunVariance3 () {
        return this.junVariance3;
    }

    public void setJunVariance3 (Long junVariance3) {
        this.junVariance3 = junVariance3;
    }
	private Long janStateAssess;
	
	public Long getJanStateAssess () {
        return this.janStateAssess;
    }

    public void setJanStateAssess (Long janStateAssess) {
        this.janStateAssess = janStateAssess;
    }
	private Long febStateAssess;
	
	public Long getFebStateAssess () {
        return this.febStateAssess;
    }

    public void setFebStateAssess (Long febStateAssess) {
        this.febStateAssess = febStateAssess;
    }
	private Long marStateAssess;
	
	public Long getMarStateAssess () {
        return this.marStateAssess;
    }

    public void setMarStateAssess (Long marStateAssess) {
        this.marStateAssess = marStateAssess;
    }
	private Long aprStateAssess;
	
	public Long getAprStateAssess () {
        return this.aprStateAssess;
    }

    public void setAprStateAssess (Long aprStateAssess) {
        this.aprStateAssess = aprStateAssess;
    }
	private Long mayStateAssess;
	
	public Long getMayStateAssess () {
        return this.mayStateAssess;
    }

    public void setMayStateAssess (Long mayStateAssess) {
        this.mayStateAssess = mayStateAssess;
    }
	private Long junStateAssess;
	
	public Long getJunStateAssess () {
        return this.junStateAssess;
    }

    public void setJunStateAssess (Long junStateAssess) {
        this.junStateAssess = junStateAssess;
    }
	private Long julStateAssess;
	
	public Long getJulStateAssess () {
        return this.julStateAssess;
    }

    public void setJulStateAssess (Long julStateAssess) {
        this.julStateAssess = julStateAssess;
    }
	private Long augStateAssess;
	
	public Long getAugStateAssess () {
        return this.augStateAssess;
    }

    public void setAugStateAssess (Long augStateAssess) {
        this.augStateAssess = augStateAssess;
    }
	private Long sepStateAssess;
	
	public Long getSepStateAssess () {
        return this.sepStateAssess;
    }

    public void setSepStateAssess (Long sepStateAssess) {
        this.sepStateAssess = sepStateAssess;
    }
	private Long octStateAssess;
	
	public Long getOctStateAssess () {
        return this.octStateAssess;
    }

    public void setOctStateAssess (Long octStateAssess) {
        this.octStateAssess = octStateAssess;
    }
	private Long novStateAssess;
	
	public Long getNovStateAssess () {
        return this.novStateAssess;
    }

    public void setNovStateAssess (Long novStateAssess) {
        this.novStateAssess = novStateAssess;
    }
	private Long decStateAssess;
	
	public Long getDecStateAssess () {
        return this.decStateAssess;
    }

    public void setDecStateAssess (Long decStateAssess) {
        this.decStateAssess = decStateAssess;
    }
	private Long janTotFundGt3;
	
	public Long getJanTotFundGt3 () {
        return this.janTotFundGt3;
    }

    public void setJanTotFundGt3 (Long janTotFundGt3) {
        this.janTotFundGt3 = janTotFundGt3;
    }
	private Long febTotFundGt3;
	
	public Long getFebTotFundGt3 () {
        return this.febTotFundGt3;
    }

    public void setFebTotFundGt3 (Long febTotFundGt3) {
        this.febTotFundGt3 = febTotFundGt3;
    }
	private Long marTotFundGt3;
	
	public Long getMarTotFundGt3 () {
        return this.marTotFundGt3;
    }

    public void setMarTotFundGt3 (Long marTotFundGt3) {
        this.marTotFundGt3 = marTotFundGt3;
    }
	private Long aprTotFundGt3;
	
	public Long getAprTotFundGt3 () {
        return this.aprTotFundGt3;
    }

    public void setAprTotFundGt3 (Long aprTotFundGt3) {
        this.aprTotFundGt3 = aprTotFundGt3;
    }
	private Long mayTotFundGt3;
	
	public Long getMayTotFundGt3 () {
        return this.mayTotFundGt3;
    }

    public void setMayTotFundGt3 (Long mayTotFundGt3) {
        this.mayTotFundGt3 = mayTotFundGt3;
    }
	private Long junTotFundGt3;
	
	public Long getJunTotFundGt3 () {
        return this.junTotFundGt3;
    }

    public void setJunTotFundGt3 (Long junTotFundGt3) {
        this.junTotFundGt3 = junTotFundGt3;
    }
	private Long julTotFundGt3;
	
	public Long getJulTotFundGt3 () {
        return this.julTotFundGt3;
    }

    public void setJulTotFundGt3 (Long julTotFundGt3) {
        this.julTotFundGt3 = julTotFundGt3;
    }
	private Long augTotFundGt3;
	
	public Long getAugTotFundGt3 () {
        return this.augTotFundGt3;
    }

    public void setAugTotFundGt3 (Long augTotFundGt3) {
        this.augTotFundGt3 = augTotFundGt3;
    }
	private Long sepTotFundGt3;
	
	public Long getSepTotFundGt3 () {
        return this.sepTotFundGt3;
    }

    public void setSepTotFundGt3 (Long sepTotFundGt3) {
        this.sepTotFundGt3 = sepTotFundGt3;
    }
	private Long octTotFundGt3;
	
	public Long getOctTotFundGt3 () {
        return this.octTotFundGt3;
    }

    public void setOctTotFundGt3 (Long octTotFundGt3) {
        this.octTotFundGt3 = octTotFundGt3;
    }
	private Long novTotFundGt3;
	
	public Long getNovTotFundGt3 () {
        return this.novTotFundGt3;
    }

    public void setNovTotFundGt3 (Long novTotFundGt3) {
        this.novTotFundGt3 = novTotFundGt3;
    }
	private Long decTotFundGt3;
	
	public Long getDecTotFundGt3 () {
        return this.decTotFundGt3;
    }

    public void setDecTotFundGt3 (Long decTotFundGt3) {
        this.decTotFundGt3 = decTotFundGt3;
    }
	private Long janMmChrtAdj;
	
	public Long getJanMmChrtAdj () {
        return this.janMmChrtAdj;
    }

    public void setJanMmChrtAdj (Long janMmChrtAdj) {
        this.janMmChrtAdj = janMmChrtAdj;
    }
	private Long febMmChrtAdj;
	
	public Long getFebMmChrtAdj () {
        return this.febMmChrtAdj;
    }

    public void setFebMmChrtAdj (Long febMmChrtAdj) {
        this.febMmChrtAdj = febMmChrtAdj;
    }
	private Long marMmChrtAdj;
	
	public Long getMarMmChrtAdj () {
        return this.marMmChrtAdj;
    }

    public void setMarMmChrtAdj (Long marMmChrtAdj) {
        this.marMmChrtAdj = marMmChrtAdj;
    }
	private Long aprMmChrtAdj;
	
	public Long getAprMmChrtAdj () {
        return this.aprMmChrtAdj;
    }

    public void setAprMmChrtAdj (Long aprMmChrtAdj) {
        this.aprMmChrtAdj = aprMmChrtAdj;
    }
	private Long mayMmChrtAdj;
	
	public Long getMayMmChrtAdj () {
        return this.mayMmChrtAdj;
    }

    public void setMayMmChrtAdj (Long mayMmChrtAdj) {
        this.mayMmChrtAdj = mayMmChrtAdj;
    }
	private Long junMmChrtAdj;
	
	public Long getJunMmChrtAdj () {
        return this.junMmChrtAdj;
    }

    public void setJunMmChrtAdj (Long junMmChrtAdj) {
        this.junMmChrtAdj = junMmChrtAdj;
    }
	private Long julMmChrtAdj;
	
	public Long getJulMmChrtAdj () {
        return this.julMmChrtAdj;
    }

    public void setJulMmChrtAdj (Long julMmChrtAdj) {
        this.julMmChrtAdj = julMmChrtAdj;
    }
	private Long augMmChrtAdj;
	
	public Long getAugMmChrtAdj () {
        return this.augMmChrtAdj;
    }

    public void setAugMmChrtAdj (Long augMmChrtAdj) {
        this.augMmChrtAdj = augMmChrtAdj;
    }
	private Long sepMmChrtAdj;
	
	public Long getSepMmChrtAdj () {
        return this.sepMmChrtAdj;
    }

    public void setSepMmChrtAdj (Long sepMmChrtAdj) {
        this.sepMmChrtAdj = sepMmChrtAdj;
    }
	private Long octMmChrtAdj;
	
	public Long getOctMmChrtAdj () {
        return this.octMmChrtAdj;
    }

    public void setOctMmChrtAdj (Long octMmChrtAdj) {
        this.octMmChrtAdj = octMmChrtAdj;
    }
	private Long novMmChrtAdj;
	
	public Long getNovMmChrtAdj () {
        return this.novMmChrtAdj;
    }

    public void setNovMmChrtAdj (Long novMmChrtAdj) {
        this.novMmChrtAdj = novMmChrtAdj;
    }
	private Long decMmChrtAdj;
	
	public Long getDecMmChrtAdj () {
        return this.decMmChrtAdj;
    }

    public void setDecMmChrtAdj (Long decMmChrtAdj) {
        this.decMmChrtAdj = decMmChrtAdj;
    }
	private Long janMmOCdeAdj;
	
	public Long getJanMmOCdeAdj () {
        return this.janMmOCdeAdj;
    }

    public void setJanMmOCdeAdj (Long janMmOCdeAdj) {
        this.janMmOCdeAdj = janMmOCdeAdj;
    }
	private Long febMmOCdeAdj;
	
	public Long getFebMmOCdeAdj () {
        return this.febMmOCdeAdj;
    }

    public void setFebMmOCdeAdj (Long febMmOCdeAdj) {
        this.febMmOCdeAdj = febMmOCdeAdj;
    }
	private Long marMmOCdeAdj;
	
	public Long getMarMmOCdeAdj () {
        return this.marMmOCdeAdj;
    }

    public void setMarMmOCdeAdj (Long marMmOCdeAdj) {
        this.marMmOCdeAdj = marMmOCdeAdj;
    }
	private Long aprMmOCdeAdj;
	
	public Long getAprMmOCdeAdj () {
        return this.aprMmOCdeAdj;
    }

    public void setAprMmOCdeAdj (Long aprMmOCdeAdj) {
        this.aprMmOCdeAdj = aprMmOCdeAdj;
    }
	private Long mayMmOCdeAdj;
	
	public Long getMayMmOCdeAdj () {
        return this.mayMmOCdeAdj;
    }

    public void setMayMmOCdeAdj (Long mayMmOCdeAdj) {
        this.mayMmOCdeAdj = mayMmOCdeAdj;
    }
	private Long junMmOCdeAdj;
	
	public Long getJunMmOCdeAdj () {
        return this.junMmOCdeAdj;
    }

    public void setJunMmOCdeAdj (Long junMmOCdeAdj) {
        this.junMmOCdeAdj = junMmOCdeAdj;
    }
	private Long julMmOCdeAdj;
	
	public Long getJulMmOCdeAdj () {
        return this.julMmOCdeAdj;
    }

    public void setJulMmOCdeAdj (Long julMmOCdeAdj) {
        this.julMmOCdeAdj = julMmOCdeAdj;
    }
	private Long augMmOCdeAdj;
	
	public Long getAugMmOCdeAdj () {
        return this.augMmOCdeAdj;
    }

    public void setAugMmOCdeAdj (Long augMmOCdeAdj) {
        this.augMmOCdeAdj = augMmOCdeAdj;
    }
	private Long sepMmOCdeAdj;
	
	public Long getSepMmOCdeAdj () {
        return this.sepMmOCdeAdj;
    }

    public void setSepMmOCdeAdj (Long sepMmOCdeAdj) {
        this.sepMmOCdeAdj = sepMmOCdeAdj;
    }
	private Long octMmOCdeAdj;
	
	public Long getOctMmOCdeAdj () {
        return this.octMmOCdeAdj;
    }

    public void setOctMmOCdeAdj (Long octMmOCdeAdj) {
        this.octMmOCdeAdj = octMmOCdeAdj;
    }
	private Long novMmOCdeAdj;
	
	public Long getNovMmOCdeAdj () {
        return this.novMmOCdeAdj;
    }

    public void setNovMmOCdeAdj (Long novMmOCdeAdj) {
        this.novMmOCdeAdj = novMmOCdeAdj;
    }
	private Long decMmOCdeAdj;
	
	public Long getDecMmOCdeAdj () {
        return this.decMmOCdeAdj;
    }

    public void setDecMmOCdeAdj (Long decMmOCdeAdj) {
        this.decMmOCdeAdj = decMmOCdeAdj;
    }
	private Long janMmAuditAdj;
	
	public Long getJanMmAuditAdj () {
        return this.janMmAuditAdj;
    }

    public void setJanMmAuditAdj (Long janMmAuditAdj) {
        this.janMmAuditAdj = janMmAuditAdj;
    }
	private Long febMmAuditAdj;
	
	public Long getFebMmAuditAdj () {
        return this.febMmAuditAdj;
    }

    public void setFebMmAuditAdj (Long febMmAuditAdj) {
        this.febMmAuditAdj = febMmAuditAdj;
    }
	private Long marMmAuditAdj;
	
	public Long getMarMmAuditAdj () {
        return this.marMmAuditAdj;
    }

    public void setMarMmAuditAdj (Long marMmAuditAdj) {
        this.marMmAuditAdj = marMmAuditAdj;
    }
	private Long aprMmAuditAdj;
	
	public Long getAprMmAuditAdj () {
        return this.aprMmAuditAdj;
    }

    public void setAprMmAuditAdj (Long aprMmAuditAdj) {
        this.aprMmAuditAdj = aprMmAuditAdj;
    }
	private Long mayMmAuditAdj;
	
	public Long getMayMmAuditAdj () {
        return this.mayMmAuditAdj;
    }

    public void setMayMmAuditAdj (Long mayMmAuditAdj) {
        this.mayMmAuditAdj = mayMmAuditAdj;
    }
	private Long junMmAuditAdj;
	
	public Long getJunMmAuditAdj () {
        return this.junMmAuditAdj;
    }

    public void setJunMmAuditAdj (Long junMmAuditAdj) {
        this.junMmAuditAdj = junMmAuditAdj;
    }
	private Long julMmAuditAdj;
	
	public Long getJulMmAuditAdj () {
        return this.julMmAuditAdj;
    }

    public void setJulMmAuditAdj (Long julMmAuditAdj) {
        this.julMmAuditAdj = julMmAuditAdj;
    }
	private Long augMmAuditAdj;
	
	public Long getAugMmAuditAdj () {
        return this.augMmAuditAdj;
    }

    public void setAugMmAuditAdj (Long augMmAuditAdj) {
        this.augMmAuditAdj = augMmAuditAdj;
    }
	private Long sepMmAuditAdj;
	
	public Long getSepMmAuditAdj () {
        return this.sepMmAuditAdj;
    }

    public void setSepMmAuditAdj (Long sepMmAuditAdj) {
        this.sepMmAuditAdj = sepMmAuditAdj;
    }
	private Long octMmAuditAdj;
	
	public Long getOctMmAuditAdj () {
        return this.octMmAuditAdj;
    }

    public void setOctMmAuditAdj (Long octMmAuditAdj) {
        this.octMmAuditAdj = octMmAuditAdj;
    }
	private Long novMmAuditAdj;
	
	public Long getNovMmAuditAdj () {
        return this.novMmAuditAdj;
    }

    public void setNovMmAuditAdj (Long novMmAuditAdj) {
        this.novMmAuditAdj = novMmAuditAdj;
    }
	private Long decMmAuditAdj;
	
	public Long getDecMmAuditAdj () {
        return this.decMmAuditAdj;
    }

    public void setDecMmAuditAdj (Long decMmAuditAdj) {
        this.decMmAuditAdj = decMmAuditAdj;
    }
}