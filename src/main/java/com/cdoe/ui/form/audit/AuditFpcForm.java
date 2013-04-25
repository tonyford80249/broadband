
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
public class AuditFpcForm {

	private long id;
	
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	private List<NoNameGrid> noNameGridList = new ArrayList<NoNameGrid>();
	
	public List<NoNameGrid> getNoNameGridList() {
	    return this.noNameGridList;
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
	private String memberPs;
	
	public String getMemberPs () {
        return this.memberPs;
    }

    public void setMemberPs (String memberPs) {
        this.memberPs = memberPs;
    }
	private String parttimeHPs;
	
	public String getParttimeHPs () {
        return this.parttimeHPs;
    }

    public void setParttimeHPs (String parttimeHPs) {
        this.parttimeHPs = parttimeHPs;
    }
	private String parttimeFPs;
	
	public String getParttimeFPs () {
        return this.parttimeFPs;
    }

    public void setParttimeFPs (String parttimeFPs) {
        this.parttimeFPs = parttimeFPs;
    }
	private String outOfDistPs;
	
	public String getOutOfDistPs () {
        return this.outOfDistPs;
    }

    public void setOutOfDistPs (String outOfDistPs) {
        this.outOfDistPs = outOfDistPs;
    }
	private String secndSemHPs;
	
	public String getSecndSemHPs () {
        return this.secndSemHPs;
    }

    public void setSecndSemHPs (String secndSemHPs) {
        this.secndSemHPs = secndSemHPs;
    }
	private String secndSemFPs;
	
	public String getSecndSemFPs () {
        return this.secndSemFPs;
    }

    public void setSecndSemFPs (String secndSemFPs) {
        this.secndSemFPs = secndSemFPs;
    }
	private String nonresidentPs;
	
	public String getNonresidentPs () {
        return this.nonresidentPs;
    }

    public void setNonresidentPs (String nonresidentPs) {
        this.nonresidentPs = nonresidentPs;
    }
	private String residentPs;
	
	public String getResidentPs () {
        return this.residentPs;
    }

    public void setResidentPs (String residentPs) {
        this.residentPs = residentPs;
    }
	private String fundedCountPs;
	
	public String getFundedCountPs () {
        return this.fundedCountPs;
    }

    public void setFundedCountPs (String fundedCountPs) {
        this.fundedCountPs = fundedCountPs;
    }
	private String memberP;
	
	public String getMemberP () {
        return this.memberP;
    }

    public void setMemberP (String memberP) {
        this.memberP = memberP;
    }
	private String parttimeHP;
	
	public String getParttimeHP () {
        return this.parttimeHP;
    }

    public void setParttimeHP (String parttimeHP) {
        this.parttimeHP = parttimeHP;
    }
	private String parttimeFP;
	
	public String getParttimeFP () {
        return this.parttimeFP;
    }

    public void setParttimeFP (String parttimeFP) {
        this.parttimeFP = parttimeFP;
    }
	private String secndSemHP;
	
	public String getSecndSemHP () {
        return this.secndSemHP;
    }

    public void setSecndSemHP (String secndSemHP) {
        this.secndSemHP = secndSemHP;
    }
	private String outOfDistP;
	
	public String getOutOfDistP () {
        return this.outOfDistP;
    }

    public void setOutOfDistP (String outOfDistP) {
        this.outOfDistP = outOfDistP;
    }
	private String nonresidentP;
	
	public String getNonresidentP () {
        return this.nonresidentP;
    }

    public void setNonresidentP (String nonresidentP) {
        this.nonresidentP = nonresidentP;
    }
	private String residentP;
	
	public String getResidentP () {
        return this.residentP;
    }

    public void setResidentP (String residentP) {
        this.residentP = residentP;
    }
	private String fundedCountP;
	
	public String getFundedCountP () {
        return this.fundedCountP;
    }

    public void setFundedCountP (String fundedCountP) {
        this.fundedCountP = fundedCountP;
    }
	private String cdeMemberK;
	
	public String getCdeMemberK () {
        return this.cdeMemberK;
    }

    public void setCdeMemberK (String cdeMemberK) {
        this.cdeMemberK = cdeMemberK;
    }
	private String memberK;
	
	public String getMemberK () {
        return this.memberK;
    }

    public void setMemberK (String memberK) {
        this.memberK = memberK;
    }
	private String parttimeHK;
	
	public String getParttimeHK () {
        return this.parttimeHK;
    }

    public void setParttimeHK (String parttimeHK) {
        this.parttimeHK = parttimeHK;
    }
	private String parttimeFK;
	
	public String getParttimeFK () {
        return this.parttimeFK;
    }

    public void setParttimeFK (String parttimeFK) {
        this.parttimeFK = parttimeFK;
    }
	private String outOfDistK;
	
	public String getOutOfDistK () {
        return this.outOfDistK;
    }

    public void setOutOfDistK (String outOfDistK) {
        this.outOfDistK = outOfDistK;
    }
	private String secndChDHK;
	
	public String getSecndChDHK () {
        return this.secndChDHK;
    }

    public void setSecndChDHK (String secndChDHK) {
        this.secndChDHK = secndChDHK;
    }
	private String memberFullK;
	
	public String getMemberFullK () {
        return this.memberFullK;
    }

    public void setMemberFullK (String memberFullK) {
        this.memberFullK = memberFullK;
    }
	private String secndChBHK;
	
	public String getSecndChBHK () {
        return this.secndChBHK;
    }

    public void setSecndChBHK (String secndChBHK) {
        this.secndChBHK = secndChBHK;
    }
	private String secndChBFK;
	
	public String getSecndChBFK () {
        return this.secndChBFK;
    }

    public void setSecndChBFK (String secndChBFK) {
        this.secndChBFK = secndChBFK;
    }
	private String secndSemHK;
	
	public String getSecndSemHK () {
        return this.secndSemHK;
    }

    public void setSecndSemHK (String secndSemHK) {
        this.secndSemHK = secndSemHK;
    }
	private String secndSemFK;
	
	public String getSecndSemFK () {
        return this.secndSemFK;
    }

    public void setSecndSemFK (String secndSemFK) {
        this.secndSemFK = secndSemFK;
    }
	private String nonresidentK;
	
	public String getNonresidentK () {
        return this.nonresidentK;
    }

    public void setNonresidentK (String nonresidentK) {
        this.nonresidentK = nonresidentK;
    }
	private String residentK;
	
	public String getResidentK () {
        return this.residentK;
    }

    public void setResidentK (String residentK) {
        this.residentK = residentK;
    }
	private String fundedCountK;
	
	public String getFundedCountK () {
        return this.fundedCountK;
    }

    public void setFundedCountK (String fundedCountK) {
        this.fundedCountK = fundedCountK;
    }
	private String cdeMember1;
	
	public String getCdeMember1 () {
        return this.cdeMember1;
    }

    public void setCdeMember1 (String cdeMember1) {
        this.cdeMember1 = cdeMember1;
    }
	private String member1;
	
	public String getMember1 () {
        return this.member1;
    }

    public void setMember1 (String member1) {
        this.member1 = member1;
    }
	private String parttimeH1;
	
	public String getParttimeH1 () {
        return this.parttimeH1;
    }

    public void setParttimeH1 (String parttimeH1) {
        this.parttimeH1 = parttimeH1;
    }
	private String parttimeF1;
	
	public String getParttimeF1 () {
        return this.parttimeF1;
    }

    public void setParttimeF1 (String parttimeF1) {
        this.parttimeF1 = parttimeF1;
    }
	private String secndChDH1;
	
	public String getSecndChDH1 () {
        return this.secndChDH1;
    }

    public void setSecndChDH1 (String secndChDH1) {
        this.secndChDH1 = secndChDH1;
    }
	private String secndChDF1;
	
	public String getSecndChDF1 () {
        return this.secndChDF1;
    }

    public void setSecndChDF1 (String secndChDF1) {
        this.secndChDF1 = secndChDF1;
    }
	private String secndChBH1;
	
	public String getSecndChBH1 () {
        return this.secndChBH1;
    }

    public void setSecndChBH1 (String secndChBH1) {
        this.secndChBH1 = secndChBH1;
    }
	private String outOfDist1;
	
	public String getOutOfDist1 () {
        return this.outOfDist1;
    }

    public void setOutOfDist1 (String outOfDist1) {
        this.outOfDist1 = outOfDist1;
    }
	private String nonresident1;
	
	public String getNonresident1 () {
        return this.nonresident1;
    }

    public void setNonresident1 (String nonresident1) {
        this.nonresident1 = nonresident1;
    }
	private String resident1;
	
	public String getResident1 () {
        return this.resident1;
    }

    public void setResident1 (String resident1) {
        this.resident1 = resident1;
    }
	private String fundedCount1;
	
	public String getFundedCount1 () {
        return this.fundedCount1;
    }

    public void setFundedCount1 (String fundedCount1) {
        this.fundedCount1 = fundedCount1;
    }
	private String cdeMember2;
	
	public String getCdeMember2 () {
        return this.cdeMember2;
    }

    public void setCdeMember2 (String cdeMember2) {
        this.cdeMember2 = cdeMember2;
    }
	private String member2;
	
	public String getMember2 () {
        return this.member2;
    }

    public void setMember2 (String member2) {
        this.member2 = member2;
    }
	private String parttimeH2;
	
	public String getParttimeH2 () {
        return this.parttimeH2;
    }

    public void setParttimeH2 (String parttimeH2) {
        this.parttimeH2 = parttimeH2;
    }
	private String parttimeF2;
	
	public String getParttimeF2 () {
        return this.parttimeF2;
    }

    public void setParttimeF2 (String parttimeF2) {
        this.parttimeF2 = parttimeF2;
    }
	private String secndChDH2;
	
	public String getSecndChDH2 () {
        return this.secndChDH2;
    }

    public void setSecndChDH2 (String secndChDH2) {
        this.secndChDH2 = secndChDH2;
    }
	private String secndChDF2;
	
	public String getSecndChDF2 () {
        return this.secndChDF2;
    }

    public void setSecndChDF2 (String secndChDF2) {
        this.secndChDF2 = secndChDF2;
    }
	private String secndChBH2;
	
	public String getSecndChBH2 () {
        return this.secndChBH2;
    }

    public void setSecndChBH2 (String secndChBH2) {
        this.secndChBH2 = secndChBH2;
    }
	private String outOfDist2;
	
	public String getOutOfDist2 () {
        return this.outOfDist2;
    }

    public void setOutOfDist2 (String outOfDist2) {
        this.outOfDist2 = outOfDist2;
    }
	private String nonresident2;
	
	public String getNonresident2 () {
        return this.nonresident2;
    }

    public void setNonresident2 (String nonresident2) {
        this.nonresident2 = nonresident2;
    }
	private String resident2;
	
	public String getResident2 () {
        return this.resident2;
    }

    public void setResident2 (String resident2) {
        this.resident2 = resident2;
    }
	private String fundedCount2;
	
	public String getFundedCount2 () {
        return this.fundedCount2;
    }

    public void setFundedCount2 (String fundedCount2) {
        this.fundedCount2 = fundedCount2;
    }
	private String cdeMember3;
	
	public String getCdeMember3 () {
        return this.cdeMember3;
    }

    public void setCdeMember3 (String cdeMember3) {
        this.cdeMember3 = cdeMember3;
    }
	private String member3;
	
	public String getMember3 () {
        return this.member3;
    }

    public void setMember3 (String member3) {
        this.member3 = member3;
    }
	private String parttimeH3;
	
	public String getParttimeH3 () {
        return this.parttimeH3;
    }

    public void setParttimeH3 (String parttimeH3) {
        this.parttimeH3 = parttimeH3;
    }
	private String parttimeF3;
	
	public String getParttimeF3 () {
        return this.parttimeF3;
    }

    public void setParttimeF3 (String parttimeF3) {
        this.parttimeF3 = parttimeF3;
    }
	private String secndChDH3;
	
	public String getSecndChDH3 () {
        return this.secndChDH3;
    }

    public void setSecndChDH3 (String secndChDH3) {
        this.secndChDH3 = secndChDH3;
    }
	private String secndChDF3;
	
	public String getSecndChDF3 () {
        return this.secndChDF3;
    }

    public void setSecndChDF3 (String secndChDF3) {
        this.secndChDF3 = secndChDF3;
    }
	private String secndChBH3;
	
	public String getSecndChBH3 () {
        return this.secndChBH3;
    }

    public void setSecndChBH3 (String secndChBH3) {
        this.secndChBH3 = secndChBH3;
    }
	private String outOfDist3;
	
	public String getOutOfDist3 () {
        return this.outOfDist3;
    }

    public void setOutOfDist3 (String outOfDist3) {
        this.outOfDist3 = outOfDist3;
    }
	private String nonresident3;
	
	public String getNonresident3 () {
        return this.nonresident3;
    }

    public void setNonresident3 (String nonresident3) {
        this.nonresident3 = nonresident3;
    }
	private String resident3;
	
	public String getResident3 () {
        return this.resident3;
    }

    public void setResident3 (String resident3) {
        this.resident3 = resident3;
    }
	private String fundedCount3;
	
	public String getFundedCount3 () {
        return this.fundedCount3;
    }

    public void setFundedCount3 (String fundedCount3) {
        this.fundedCount3 = fundedCount3;
    }
	private String cdeMember4;
	
	public String getCdeMember4 () {
        return this.cdeMember4;
    }

    public void setCdeMember4 (String cdeMember4) {
        this.cdeMember4 = cdeMember4;
    }
	private String member4;
	
	public String getMember4 () {
        return this.member4;
    }

    public void setMember4 (String member4) {
        this.member4 = member4;
    }
	private String parttimeH4;
	
	public String getParttimeH4 () {
        return this.parttimeH4;
    }

    public void setParttimeH4 (String parttimeH4) {
        this.parttimeH4 = parttimeH4;
    }
	private String parttimeF4;
	
	public String getParttimeF4 () {
        return this.parttimeF4;
    }

    public void setParttimeF4 (String parttimeF4) {
        this.parttimeF4 = parttimeF4;
    }
	private String secndChDH4;
	
	public String getSecndChDH4 () {
        return this.secndChDH4;
    }

    public void setSecndChDH4 (String secndChDH4) {
        this.secndChDH4 = secndChDH4;
    }
	private String secndChDF4;
	
	public String getSecndChDF4 () {
        return this.secndChDF4;
    }

    public void setSecndChDF4 (String secndChDF4) {
        this.secndChDF4 = secndChDF4;
    }
	private String secndChBH4;
	
	public String getSecndChBH4 () {
        return this.secndChBH4;
    }

    public void setSecndChBH4 (String secndChBH4) {
        this.secndChBH4 = secndChBH4;
    }
	private String outOfDist4;
	
	public String getOutOfDist4 () {
        return this.outOfDist4;
    }

    public void setOutOfDist4 (String outOfDist4) {
        this.outOfDist4 = outOfDist4;
    }
	private String nonresident4;
	
	public String getNonresident4 () {
        return this.nonresident4;
    }

    public void setNonresident4 (String nonresident4) {
        this.nonresident4 = nonresident4;
    }
	private String resident4;
	
	public String getResident4 () {
        return this.resident4;
    }

    public void setResident4 (String resident4) {
        this.resident4 = resident4;
    }
	private String fundedCount4;
	
	public String getFundedCount4 () {
        return this.fundedCount4;
    }

    public void setFundedCount4 (String fundedCount4) {
        this.fundedCount4 = fundedCount4;
    }
	private String cdeMember5;
	
	public String getCdeMember5 () {
        return this.cdeMember5;
    }

    public void setCdeMember5 (String cdeMember5) {
        this.cdeMember5 = cdeMember5;
    }
	private String member5;
	
	public String getMember5 () {
        return this.member5;
    }

    public void setMember5 (String member5) {
        this.member5 = member5;
    }
	private String parttimeH5;
	
	public String getParttimeH5 () {
        return this.parttimeH5;
    }

    public void setParttimeH5 (String parttimeH5) {
        this.parttimeH5 = parttimeH5;
    }
	private String parttimeF5;
	
	public String getParttimeF5 () {
        return this.parttimeF5;
    }

    public void setParttimeF5 (String parttimeF5) {
        this.parttimeF5 = parttimeF5;
    }
	private String secndChDH5;
	
	public String getSecndChDH5 () {
        return this.secndChDH5;
    }

    public void setSecndChDH5 (String secndChDH5) {
        this.secndChDH5 = secndChDH5;
    }
	private String secndChDF5;
	
	public String getSecndChDF5 () {
        return this.secndChDF5;
    }

    public void setSecndChDF5 (String secndChDF5) {
        this.secndChDF5 = secndChDF5;
    }
	private String secndChBH5;
	
	public String getSecndChBH5 () {
        return this.secndChBH5;
    }

    public void setSecndChBH5 (String secndChBH5) {
        this.secndChBH5 = secndChBH5;
    }
	private String outOfDist5;
	
	public String getOutOfDist5 () {
        return this.outOfDist5;
    }

    public void setOutOfDist5 (String outOfDist5) {
        this.outOfDist5 = outOfDist5;
    }
	private String nonresident5;
	
	public String getNonresident5 () {
        return this.nonresident5;
    }

    public void setNonresident5 (String nonresident5) {
        this.nonresident5 = nonresident5;
    }
	private String resident5;
	
	public String getResident5 () {
        return this.resident5;
    }

    public void setResident5 (String resident5) {
        this.resident5 = resident5;
    }
	private String fundedCount5;
	
	public String getFundedCount5 () {
        return this.fundedCount5;
    }

    public void setFundedCount5 (String fundedCount5) {
        this.fundedCount5 = fundedCount5;
    }
	private String cdeMember6;
	
	public String getCdeMember6 () {
        return this.cdeMember6;
    }

    public void setCdeMember6 (String cdeMember6) {
        this.cdeMember6 = cdeMember6;
    }
	private String member6;
	
	public String getMember6 () {
        return this.member6;
    }

    public void setMember6 (String member6) {
        this.member6 = member6;
    }
	private String parttimeH6;
	
	public String getParttimeH6 () {
        return this.parttimeH6;
    }

    public void setParttimeH6 (String parttimeH6) {
        this.parttimeH6 = parttimeH6;
    }
	private String parttimeF6;
	
	public String getParttimeF6 () {
        return this.parttimeF6;
    }

    public void setParttimeF6 (String parttimeF6) {
        this.parttimeF6 = parttimeF6;
    }
	private String secndChDH6;
	
	public String getSecndChDH6 () {
        return this.secndChDH6;
    }

    public void setSecndChDH6 (String secndChDH6) {
        this.secndChDH6 = secndChDH6;
    }
	private String secndChDF6;
	
	public String getSecndChDF6 () {
        return this.secndChDF6;
    }

    public void setSecndChDF6 (String secndChDF6) {
        this.secndChDF6 = secndChDF6;
    }
	private String secndChBH6;
	
	public String getSecndChBH6 () {
        return this.secndChBH6;
    }

    public void setSecndChBH6 (String secndChBH6) {
        this.secndChBH6 = secndChBH6;
    }
	private String outOfDist6;
	
	public String getOutOfDist6 () {
        return this.outOfDist6;
    }

    public void setOutOfDist6 (String outOfDist6) {
        this.outOfDist6 = outOfDist6;
    }
	private String nonresident6;
	
	public String getNonresident6 () {
        return this.nonresident6;
    }

    public void setNonresident6 (String nonresident6) {
        this.nonresident6 = nonresident6;
    }
	private String resident6;
	
	public String getResident6 () {
        return this.resident6;
    }

    public void setResident6 (String resident6) {
        this.resident6 = resident6;
    }
	private String fundedCount6;
	
	public String getFundedCount6 () {
        return this.fundedCount6;
    }

    public void setFundedCount6 (String fundedCount6) {
        this.fundedCount6 = fundedCount6;
    }
	private String cdeMember7;
	
	public String getCdeMember7 () {
        return this.cdeMember7;
    }

    public void setCdeMember7 (String cdeMember7) {
        this.cdeMember7 = cdeMember7;
    }
	private String member7;
	
	public String getMember7 () {
        return this.member7;
    }

    public void setMember7 (String member7) {
        this.member7 = member7;
    }
	private String parttimeH7;
	
	public String getParttimeH7 () {
        return this.parttimeH7;
    }

    public void setParttimeH7 (String parttimeH7) {
        this.parttimeH7 = parttimeH7;
    }
	private String parttimeF7;
	
	public String getParttimeF7 () {
        return this.parttimeF7;
    }

    public void setParttimeF7 (String parttimeF7) {
        this.parttimeF7 = parttimeF7;
    }
	private String secndChDH7;
	
	public String getSecndChDH7 () {
        return this.secndChDH7;
    }

    public void setSecndChDH7 (String secndChDH7) {
        this.secndChDH7 = secndChDH7;
    }
	private String secndChDF7;
	
	public String getSecndChDF7 () {
        return this.secndChDF7;
    }

    public void setSecndChDF7 (String secndChDF7) {
        this.secndChDF7 = secndChDF7;
    }
	private String secndChBH7;
	
	public String getSecndChBH7 () {
        return this.secndChBH7;
    }

    public void setSecndChBH7 (String secndChBH7) {
        this.secndChBH7 = secndChBH7;
    }
	private String outOfDist7;
	
	public String getOutOfDist7 () {
        return this.outOfDist7;
    }

    public void setOutOfDist7 (String outOfDist7) {
        this.outOfDist7 = outOfDist7;
    }
	private String nonresident7;
	
	public String getNonresident7 () {
        return this.nonresident7;
    }

    public void setNonresident7 (String nonresident7) {
        this.nonresident7 = nonresident7;
    }
	private String resident7;
	
	public String getResident7 () {
        return this.resident7;
    }

    public void setResident7 (String resident7) {
        this.resident7 = resident7;
    }
	private String fundedCount7;
	
	public String getFundedCount7 () {
        return this.fundedCount7;
    }

    public void setFundedCount7 (String fundedCount7) {
        this.fundedCount7 = fundedCount7;
    }
	private String cdeMember8;
	
	public String getCdeMember8 () {
        return this.cdeMember8;
    }

    public void setCdeMember8 (String cdeMember8) {
        this.cdeMember8 = cdeMember8;
    }
	private String member8;
	
	public String getMember8 () {
        return this.member8;
    }

    public void setMember8 (String member8) {
        this.member8 = member8;
    }
	private String parttimeH8;
	
	public String getParttimeH8 () {
        return this.parttimeH8;
    }

    public void setParttimeH8 (String parttimeH8) {
        this.parttimeH8 = parttimeH8;
    }
	private String parttimeF8;
	
	public String getParttimeF8 () {
        return this.parttimeF8;
    }

    public void setParttimeF8 (String parttimeF8) {
        this.parttimeF8 = parttimeF8;
    }
	private String secndChDH8;
	
	public String getSecndChDH8 () {
        return this.secndChDH8;
    }

    public void setSecndChDH8 (String secndChDH8) {
        this.secndChDH8 = secndChDH8;
    }
	private String secndChDF8;
	
	public String getSecndChDF8 () {
        return this.secndChDF8;
    }

    public void setSecndChDF8 (String secndChDF8) {
        this.secndChDF8 = secndChDF8;
    }
	private String secndChBH8;
	
	public String getSecndChBH8 () {
        return this.secndChBH8;
    }

    public void setSecndChBH8 (String secndChBH8) {
        this.secndChBH8 = secndChBH8;
    }
	private String outOfDist8;
	
	public String getOutOfDist8 () {
        return this.outOfDist8;
    }

    public void setOutOfDist8 (String outOfDist8) {
        this.outOfDist8 = outOfDist8;
    }
	private String nonresident8;
	
	public String getNonresident8 () {
        return this.nonresident8;
    }

    public void setNonresident8 (String nonresident8) {
        this.nonresident8 = nonresident8;
    }
	private String resident8;
	
	public String getResident8 () {
        return this.resident8;
    }

    public void setResident8 (String resident8) {
        this.resident8 = resident8;
    }
	private String fundedCount8;
	
	public String getFundedCount8 () {
        return this.fundedCount8;
    }

    public void setFundedCount8 (String fundedCount8) {
        this.fundedCount8 = fundedCount8;
    }
	private String cdeMember9;
	
	public String getCdeMember9 () {
        return this.cdeMember9;
    }

    public void setCdeMember9 (String cdeMember9) {
        this.cdeMember9 = cdeMember9;
    }
	private String member9;
	
	public String getMember9 () {
        return this.member9;
    }

    public void setMember9 (String member9) {
        this.member9 = member9;
    }
	private String parttimeH9;
	
	public String getParttimeH9 () {
        return this.parttimeH9;
    }

    public void setParttimeH9 (String parttimeH9) {
        this.parttimeH9 = parttimeH9;
    }
	private String parttimeF9;
	
	public String getParttimeF9 () {
        return this.parttimeF9;
    }

    public void setParttimeF9 (String parttimeF9) {
        this.parttimeF9 = parttimeF9;
    }
	private String secndChDH9;
	
	public String getSecndChDH9 () {
        return this.secndChDH9;
    }

    public void setSecndChDH9 (String secndChDH9) {
        this.secndChDH9 = secndChDH9;
    }
	private String secndChDF9;
	
	public String getSecndChDF9 () {
        return this.secndChDF9;
    }

    public void setSecndChDF9 (String secndChDF9) {
        this.secndChDF9 = secndChDF9;
    }
	private String secndChBH9;
	
	public String getSecndChBH9 () {
        return this.secndChBH9;
    }

    public void setSecndChBH9 (String secndChBH9) {
        this.secndChBH9 = secndChBH9;
    }
	private String outOfDist9;
	
	public String getOutOfDist9 () {
        return this.outOfDist9;
    }

    public void setOutOfDist9 (String outOfDist9) {
        this.outOfDist9 = outOfDist9;
    }
	private String nonresident9;
	
	public String getNonresident9 () {
        return this.nonresident9;
    }

    public void setNonresident9 (String nonresident9) {
        this.nonresident9 = nonresident9;
    }
	private String resident9;
	
	public String getResident9 () {
        return this.resident9;
    }

    public void setResident9 (String resident9) {
        this.resident9 = resident9;
    }
	private String fundedCount9;
	
	public String getFundedCount9 () {
        return this.fundedCount9;
    }

    public void setFundedCount9 (String fundedCount9) {
        this.fundedCount9 = fundedCount9;
    }
	private String cdeMember10;
	
	public String getCdeMember10 () {
        return this.cdeMember10;
    }

    public void setCdeMember10 (String cdeMember10) {
        this.cdeMember10 = cdeMember10;
    }
	private String member10;
	
	public String getMember10 () {
        return this.member10;
    }

    public void setMember10 (String member10) {
        this.member10 = member10;
    }
	private String parttimeH10;
	
	public String getParttimeH10 () {
        return this.parttimeH10;
    }

    public void setParttimeH10 (String parttimeH10) {
        this.parttimeH10 = parttimeH10;
    }
	private String parttimeF10;
	
	public String getParttimeF10 () {
        return this.parttimeF10;
    }

    public void setParttimeF10 (String parttimeF10) {
        this.parttimeF10 = parttimeF10;
    }
	private String secndChDH10;
	
	public String getSecndChDH10 () {
        return this.secndChDH10;
    }

    public void setSecndChDH10 (String secndChDH10) {
        this.secndChDH10 = secndChDH10;
    }
	private String secndChDF10;
	
	public String getSecndChDF10 () {
        return this.secndChDF10;
    }

    public void setSecndChDF10 (String secndChDF10) {
        this.secndChDF10 = secndChDF10;
    }
	private String secndChBH10;
	
	public String getSecndChBH10 () {
        return this.secndChBH10;
    }

    public void setSecndChBH10 (String secndChBH10) {
        this.secndChBH10 = secndChBH10;
    }
	private String outOfDist10;
	
	public String getOutOfDist10 () {
        return this.outOfDist10;
    }

    public void setOutOfDist10 (String outOfDist10) {
        this.outOfDist10 = outOfDist10;
    }
	private String nonresident10;
	
	public String getNonresident10 () {
        return this.nonresident10;
    }

    public void setNonresident10 (String nonresident10) {
        this.nonresident10 = nonresident10;
    }
	private String resident10;
	
	public String getResident10 () {
        return this.resident10;
    }

    public void setResident10 (String resident10) {
        this.resident10 = resident10;
    }
	private String fundedCount10;
	
	public String getFundedCount10 () {
        return this.fundedCount10;
    }

    public void setFundedCount10 (String fundedCount10) {
        this.fundedCount10 = fundedCount10;
    }
	private String cdeMember11;
	
	public String getCdeMember11 () {
        return this.cdeMember11;
    }

    public void setCdeMember11 (String cdeMember11) {
        this.cdeMember11 = cdeMember11;
    }
	private String member11;
	
	public String getMember11 () {
        return this.member11;
    }

    public void setMember11 (String member11) {
        this.member11 = member11;
    }
	private String parttimeH11;
	
	public String getParttimeH11 () {
        return this.parttimeH11;
    }

    public void setParttimeH11 (String parttimeH11) {
        this.parttimeH11 = parttimeH11;
    }
	private String parttimeF11;
	
	public String getParttimeF11 () {
        return this.parttimeF11;
    }

    public void setParttimeF11 (String parttimeF11) {
        this.parttimeF11 = parttimeF11;
    }
	private String secndChDH11;
	
	public String getSecndChDH11 () {
        return this.secndChDH11;
    }

    public void setSecndChDH11 (String secndChDH11) {
        this.secndChDH11 = secndChDH11;
    }
	private String secndChDF11;
	
	public String getSecndChDF11 () {
        return this.secndChDF11;
    }

    public void setSecndChDF11 (String secndChDF11) {
        this.secndChDF11 = secndChDF11;
    }
	private String secndChBH11;
	
	public String getSecndChBH11 () {
        return this.secndChBH11;
    }

    public void setSecndChBH11 (String secndChBH11) {
        this.secndChBH11 = secndChBH11;
    }
	private String outOfDist11;
	
	public String getOutOfDist11 () {
        return this.outOfDist11;
    }

    public void setOutOfDist11 (String outOfDist11) {
        this.outOfDist11 = outOfDist11;
    }
	private String nonresident11;
	
	public String getNonresident11 () {
        return this.nonresident11;
    }

    public void setNonresident11 (String nonresident11) {
        this.nonresident11 = nonresident11;
    }
	private String resident11;
	
	public String getResident11 () {
        return this.resident11;
    }

    public void setResident11 (String resident11) {
        this.resident11 = resident11;
    }
	private String fundedCount11;
	
	public String getFundedCount11 () {
        return this.fundedCount11;
    }

    public void setFundedCount11 (String fundedCount11) {
        this.fundedCount11 = fundedCount11;
    }
	private String cdeMember12;
	
	public String getCdeMember12 () {
        return this.cdeMember12;
    }

    public void setCdeMember12 (String cdeMember12) {
        this.cdeMember12 = cdeMember12;
    }
	private String member12;
	
	public String getMember12 () {
        return this.member12;
    }

    public void setMember12 (String member12) {
        this.member12 = member12;
    }
	private String parttimeH12;
	
	public String getParttimeH12 () {
        return this.parttimeH12;
    }

    public void setParttimeH12 (String parttimeH12) {
        this.parttimeH12 = parttimeH12;
    }
	private String parttimeF12;
	
	public String getParttimeF12 () {
        return this.parttimeF12;
    }

    public void setParttimeF12 (String parttimeF12) {
        this.parttimeF12 = parttimeF12;
    }
	private String secndChDH12;
	
	public String getSecndChDH12 () {
        return this.secndChDH12;
    }

    public void setSecndChDH12 (String secndChDH12) {
        this.secndChDH12 = secndChDH12;
    }
	private String secndChDF12;
	
	public String getSecndChDF12 () {
        return this.secndChDF12;
    }

    public void setSecndChDF12 (String secndChDF12) {
        this.secndChDF12 = secndChDF12;
    }
	private String secndChBH12;
	
	public String getSecndChBH12 () {
        return this.secndChBH12;
    }

    public void setSecndChBH12 (String secndChBH12) {
        this.secndChBH12 = secndChBH12;
    }
	private String outOfDist12;
	
	public String getOutOfDist12 () {
        return this.outOfDist12;
    }

    public void setOutOfDist12 (String outOfDist12) {
        this.outOfDist12 = outOfDist12;
    }
	private String nonresident12;
	
	public String getNonresident12 () {
        return this.nonresident12;
    }

    public void setNonresident12 (String nonresident12) {
        this.nonresident12 = nonresident12;
    }
	private String resident12;
	
	public String getResident12 () {
        return this.resident12;
    }

    public void setResident12 (String resident12) {
        this.resident12 = resident12;
    }
	private String fundedCount12;
	
	public String getFundedCount12 () {
        return this.fundedCount12;
    }

    public void setFundedCount12 (String fundedCount12) {
        this.fundedCount12 = fundedCount12;
    }
	private String cdeMemberSe;
	
	public String getCdeMemberSe () {
        return this.cdeMemberSe;
    }

    public void setCdeMemberSe (String cdeMemberSe) {
        this.cdeMemberSe = cdeMemberSe;
    }
	private String memberSe;
	
	public String getMemberSe () {
        return this.memberSe;
    }

    public void setMemberSe (String memberSe) {
        this.memberSe = memberSe;
    }
	private String parttimeHSe;
	
	public String getParttimeHSe () {
        return this.parttimeHSe;
    }

    public void setParttimeHSe (String parttimeHSe) {
        this.parttimeHSe = parttimeHSe;
    }
	private String parttimeFSe;
	
	public String getParttimeFSe () {
        return this.parttimeFSe;
    }

    public void setParttimeFSe (String parttimeFSe) {
        this.parttimeFSe = parttimeFSe;
    }
	private String secndChDHSe;
	
	public String getSecndChDHSe () {
        return this.secndChDHSe;
    }

    public void setSecndChDHSe (String secndChDHSe) {
        this.secndChDHSe = secndChDHSe;
    }
	private String secndChDFSe;
	
	public String getSecndChDFSe () {
        return this.secndChDFSe;
    }

    public void setSecndChDFSe (String secndChDFSe) {
        this.secndChDFSe = secndChDFSe;
    }
	private String secndChBHSe;
	
	public String getSecndChBHSe () {
        return this.secndChBHSe;
    }

    public void setSecndChBHSe (String secndChBHSe) {
        this.secndChBHSe = secndChBHSe;
    }
	private String secndChBFSe;
	
	public String getSecndChBFSe () {
        return this.secndChBFSe;
    }

    public void setSecndChBFSe (String secndChBFSe) {
        this.secndChBFSe = secndChBFSe;
    }
	private String nonresidentSe;
	
	public String getNonresidentSe () {
        return this.nonresidentSe;
    }

    public void setNonresidentSe (String nonresidentSe) {
        this.nonresidentSe = nonresidentSe;
    }
	private String residentSe;
	
	public String getResidentSe () {
        return this.residentSe;
    }

    public void setResidentSe (String residentSe) {
        this.residentSe = residentSe;
    }
	private String fundedCountSe;
	
	public String getFundedCountSe () {
        return this.fundedCountSe;
    }

    public void setFundedCountSe (String fundedCountSe) {
        this.fundedCountSe = fundedCountSe;
    }
	private String cdeMemberSs;
	
	public String getCdeMemberSs () {
        return this.cdeMemberSs;
    }

    public void setCdeMemberSs (String cdeMemberSs) {
        this.cdeMemberSs = cdeMemberSs;
    }
	private String memberSs;
	
	public String getMemberSs () {
        return this.memberSs;
    }

    public void setMemberSs (String memberSs) {
        this.memberSs = memberSs;
    }
	private String parttimeHSs;
	
	public String getParttimeHSs () {
        return this.parttimeHSs;
    }

    public void setParttimeHSs (String parttimeHSs) {
        this.parttimeHSs = parttimeHSs;
    }
	private String parttimeFSs;
	
	public String getParttimeFSs () {
        return this.parttimeFSs;
    }

    public void setParttimeFSs (String parttimeFSs) {
        this.parttimeFSs = parttimeFSs;
    }
	private String secndChDHSs;
	
	public String getSecndChDHSs () {
        return this.secndChDHSs;
    }

    public void setSecndChDHSs (String secndChDHSs) {
        this.secndChDHSs = secndChDHSs;
    }
	private String secndChDFSs;
	
	public String getSecndChDFSs () {
        return this.secndChDFSs;
    }

    public void setSecndChDFSs (String secndChDFSs) {
        this.secndChDFSs = secndChDFSs;
    }
	private String secndChBHSs;
	
	public String getSecndChBHSs () {
        return this.secndChBHSs;
    }

    public void setSecndChBHSs (String secndChBHSs) {
        this.secndChBHSs = secndChBHSs;
    }
	private String secndChBFSs;
	
	public String getSecndChBFSs () {
        return this.secndChBFSs;
    }

    public void setSecndChBFSs (String secndChBFSs) {
        this.secndChBFSs = secndChBFSs;
    }
	private String nonresidentSs;
	
	public String getNonresidentSs () {
        return this.nonresidentSs;
    }

    public void setNonresidentSs (String nonresidentSs) {
        this.nonresidentSs = nonresidentSs;
    }
	private String residentSs;
	
	public String getResidentSs () {
        return this.residentSs;
    }

    public void setResidentSs (String residentSs) {
        this.residentSs = residentSs;
    }
	private String fundedCountSs;
	
	public String getFundedCountSs () {
        return this.fundedCountSs;
    }

    public void setFundedCountSs (String fundedCountSs) {
        this.fundedCountSs = fundedCountSs;
    }
	private String cdeMemberUn;
	
	public String getCdeMemberUn () {
        return this.cdeMemberUn;
    }

    public void setCdeMemberUn (String cdeMemberUn) {
        this.cdeMemberUn = cdeMemberUn;
    }
	private String memberUn;
	
	public String getMemberUn () {
        return this.memberUn;
    }

    public void setMemberUn (String memberUn) {
        this.memberUn = memberUn;
    }
	private String parttimeHUn;
	
	public String getParttimeHUn () {
        return this.parttimeHUn;
    }

    public void setParttimeHUn (String parttimeHUn) {
        this.parttimeHUn = parttimeHUn;
    }
	private String parttimeFUn;
	
	public String getParttimeFUn () {
        return this.parttimeFUn;
    }

    public void setParttimeFUn (String parttimeFUn) {
        this.parttimeFUn = parttimeFUn;
    }
	private String outOfDistUn;
	
	public String getOutOfDistUn () {
        return this.outOfDistUn;
    }

    public void setOutOfDistUn (String outOfDistUn) {
        this.outOfDistUn = outOfDistUn;
    }
	private String secndChDHUn;
	
	public String getSecndChDHUn () {
        return this.secndChDHUn;
    }

    public void setSecndChDHUn (String secndChDHUn) {
        this.secndChDHUn = secndChDHUn;
    }
	private String secndChDFUn;
	
	public String getSecndChDFUn () {
        return this.secndChDFUn;
    }

    public void setSecndChDFUn (String secndChDFUn) {
        this.secndChDFUn = secndChDFUn;
    }
	private String secndChBHUn;
	
	public String getSecndChBHUn () {
        return this.secndChBHUn;
    }

    public void setSecndChBHUn (String secndChBHUn) {
        this.secndChBHUn = secndChBHUn;
    }
	private String secndChBFUn;
	
	public String getSecndChBFUn () {
        return this.secndChBFUn;
    }

    public void setSecndChBFUn (String secndChBFUn) {
        this.secndChBFUn = secndChBFUn;
    }
	private String nonresidentUn;
	
	public String getNonresidentUn () {
        return this.nonresidentUn;
    }

    public void setNonresidentUn (String nonresidentUn) {
        this.nonresidentUn = nonresidentUn;
    }
	private String residentUn;
	
	public String getResidentUn () {
        return this.residentUn;
    }

    public void setResidentUn (String residentUn) {
        this.residentUn = residentUn;
    }
	private String fundedCountUn;
	
	public String getFundedCountUn () {
        return this.fundedCountUn;
    }

    public void setFundedCountUn (String fundedCountUn) {
        this.fundedCountUn = fundedCountUn;
    }
	private String cdeMember;
	
	public String getCdeMember () {
        return this.cdeMember;
    }

    public void setCdeMember (String cdeMember) {
        this.cdeMember = cdeMember;
    }
	private String member;
	
	public String getMember () {
        return this.member;
    }

    public void setMember (String member) {
        this.member = member;
    }
	private String parttimeH;
	
	public String getParttimeH () {
        return this.parttimeH;
    }

    public void setParttimeH (String parttimeH) {
        this.parttimeH = parttimeH;
    }
	private String parttimeF;
	
	public String getParttimeF () {
        return this.parttimeF;
    }

    public void setParttimeF (String parttimeF) {
        this.parttimeF = parttimeF;
    }
	private String outOfDist;
	
	public String getOutOfDist () {
        return this.outOfDist;
    }

    public void setOutOfDist (String outOfDist) {
        this.outOfDist = outOfDist;
    }
	private String secndChDH;
	
	public String getSecndChDH () {
        return this.secndChDH;
    }

    public void setSecndChDH (String secndChDH) {
        this.secndChDH = secndChDH;
    }
	private String secndChDF;
	
	public String getSecndChDF () {
        return this.secndChDF;
    }

    public void setSecndChDF (String secndChDF) {
        this.secndChDF = secndChDF;
    }
	private String secndChBH;
	
	public String getSecndChBH () {
        return this.secndChBH;
    }

    public void setSecndChBH (String secndChBH) {
        this.secndChBH = secndChBH;
    }
	private String secndChBF;
	
	public String getSecndChBF () {
        return this.secndChBF;
    }

    public void setSecndChBF (String secndChBF) {
        this.secndChBF = secndChBF;
    }
	private String secndSemH;
	
	public String getSecndSemH () {
        return this.secndSemH;
    }

    public void setSecndSemH (String secndSemH) {
        this.secndSemH = secndSemH;
    }
	private String secndSemF;
	
	public String getSecndSemF () {
        return this.secndSemF;
    }

    public void setSecndSemF (String secndSemF) {
        this.secndSemF = secndSemF;
    }
	private String nonresident;
	
	public String getNonresident () {
        return this.nonresident;
    }

    public void setNonresident (String nonresident) {
        this.nonresident = nonresident;
    }
	private String resident;
	
	public String getResident () {
        return this.resident;
    }

    public void setResident (String resident) {
        this.resident = resident;
    }
	private String fundedCount;
	
	public String getFundedCount () {
        return this.fundedCount;
    }

    public void setFundedCount (String fundedCount) {
        this.fundedCount = fundedCount;
    }
	private String ascent;
	
	public String getAscent () {
        return this.ascent;
    }

    public void setAscent (String ascent) {
        this.ascent = ascent;
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
    
}