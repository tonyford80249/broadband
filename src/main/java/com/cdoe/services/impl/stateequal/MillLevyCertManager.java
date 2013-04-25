package com.cdoe.services.impl.stateequal;

import java.util.List;

import org.apache.log4j.Logger;

import com.cdoe.services.impl.BaseManager;
import com.cdoe.services.stateequal.IMillLevyCertManager;
import com.cdoe.biz.model.equal.MillLevy;
import com.cdoe.biz.model.equal.StateEqual;
import com.cdoe.biz.model.jasper.SeMillLevyCertificationCalculation;
import com.cdoe.biz.model.jasper.SeMillLevyCertificationCollection;
import com.cdoe.biz.model.jasper.SeMillLevyCertificationDatasource;
import com.cdoe.biz.stateequal.IMillLevyDAO;
import com.cdoe.biz.stateequal.IStateEqualDAO;
import com.cdoe.ui.form.stateequal.MillLevyForm;
import com.cdoe.util.AdvanceFilenameConstructor;

import com.cdoe.util.DateUtil;
import com.cdoe.util.FilenameConstructor;
import java.io.File;

import java.util.Date;
import java.util.Map;

public class MillLevyCertManager extends BaseManager implements IMillLevyCertManager {

    private static final Logger logger = Logger.getLogger(MillLevyCertManager.class);
    private IMillLevyDAO millLevyCertDAO;
    private IStateEqualDAO stateEqualDAO;
    
    /**
     * 
     * @param form
     * @return 
     */
    public SeMillLevyCertificationDatasource createDataSource(MillLevyForm form) {
     final String REGULAR_TYPE = "%12d";
     final String FLOATING_TYPE = "%12.6f";
     final String MILLS_TYPE = "%12.6f mills";
     final String MONEY_TYPE = "$ %,12.2f";
     final String MILEAGE_TYPE = "%12.1f miles";
     final String COUNT_TYPE = "%12.1f";
     
     SeMillLevyCertificationCollection collection = new SeMillLevyCertificationCollection();
     
     
     collection.setDistrictNumber(form.getDistrictNumber());
     collection.setDistrictName(form.getDistrictName());
     collection.setCounty(form.getCounty());
     collection.setTaxYear(form.getTaxYear());
     collection.setApproverName(form.getEntrCompletedBy());
     collection.setApproverPhone(form.getEntrPhoneNumber());
     collection.setColumn1CertificationDate(form.getCalcAssessedValuationDate() != null ? form.getCalcAssessedValuationDate() : new Date());
     collection.setColumn3CertificationDate(form.getCertAssessedValuationDate() != null ? form.getCertAssessedValuationDate() : new Date());     
     
     //(String title, Number column1Value, Number column2Value, Number column3Value, String formatString)
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("1. Total Program", form.getCalcTotalProgram(),null, form.getCertTotalProgram(), MILLS_TYPE));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("2. Categorical Buyout",form.getCalcCategoricalBuyout(),null, form.getCertCategoricalBuyout(), MILLS_TYPE));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("3. Overrides: ",null,null,null, null));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("a. Voter Approved",form.getCalcVoterApproved(),form.getEntrVoterApproved(),form.getCertVoterApproved(), MILLS_TYPE, MONEY_TYPE, MILLS_TYPE,false,true));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("b. Hold Harmless",form.getCalcHoldHarmless(),null,form.getCertHoldHarmless(), MILLS_TYPE,false,true));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("c. Excess Hold Harmless",form.getCalcExcessHold(),null,form.getCertExcessHold(), MILLS_TYPE,false,true));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("4. Abatement",form.getCalcAbatement(),null,form.getCertAbatement(), MILLS_TYPE));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("5. Total General Fund",form.getSumLines1Thru4(),form.getEntrGeneralFund(),form.getCertTotal1(), MILLS_TYPE, MONEY_TYPE, MILLS_TYPE));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("6. Bond Redemption Fund",form.getCalcBondRedemption(),form.getEntrBondRedemption(),form.getCertBondRedemption(), MILLS_TYPE, MONEY_TYPE, MILLS_TYPE));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("7. Transportation Fund",form.getCalcTransportationFund(),form.getEntrTransportationFund(), form.getCertTransportationFund(), MILLS_TYPE, MONEY_TYPE, MILLS_TYPE));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("8. Special Building and Technology Fund",form.getCalcSpecialFund(),form.getEntrSpecialFund(),form.getCalcSpecialFund(), MILLS_TYPE, MONEY_TYPE, MILLS_TYPE));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("9. Full Day Kindergarten Fund",form.getCalcKindergarten(),form.getEntrKindergarten(),form.getCertKindergarten(), MILLS_TYPE, MONEY_TYPE, MILLS_TYPE));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("10. Other (Loan, Charter School)",form.getCalcOther(),form.getEntrOther(),form.getCertOther(), MILLS_TYPE, MONEY_TYPE, MILLS_TYPE));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("11. Total",form.getSumLines1Thru4(),null,form.getCertTotal1(), MILLS_TYPE));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("Assessed Valuation",null,null,null, null,true,false));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("Gross Assessed Valuation",form.getCalcGrossAssessed(),null,form.getEntrGrossAssessed(), MONEY_TYPE,false,true));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("Tax Increamenting Financing",form.getCalcTaxIncreament(),null,form.getEntrTaxincreament(), MONEY_TYPE,false,true));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("Net Assessed Valuation",form.getCalcNetAssessed(),null,form.getEntrNetAssessed(), MONEY_TYPE,false,true));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("Abatements (Total across all counties)",form.getCalcAssessedAbatement(),null,form.getEntrAssessedAbatement(), MONEY_TYPE,false,true));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("Information for certification to county treasurer:",null,null,null, null,true,false));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("Full Funding mill levy",form.getCalcMillLevy(),null,form.getEntrMillLevy(), MILLS_TYPE,false,true));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("Funding rceived from state",form.getCalcStateFunding(),null,form.getEntrStateFunding(), MONEY_TYPE,false,true));
                
     
     return new SeMillLevyCertificationDatasource(collection);
    }

    /**
     * 
     * @param form 
     */
    public void performCalculations(MillLevyForm form) {
     
     if (form.getEntrGrossAssessed() != null && form.getEntrTaxincreament() != null) {
      form.setEntrNetAssessed(form.getEntrGrossAssessed() + form.getEntrTaxincreament());         
     }
        
     if (!form.getCalcAssessedAbatement().equals(form.getEntrAssessedAbatement())) {
       double newCalculatedValue = (form.getEntrAssessedAbatement() / form.getEntrNetAssessed()) * 1000;  
       
       form.setCertAbatement(newCalculatedValue);
     }
     if (form.getEntrBondRedemption() != null && form.getEntrBondRedemption() > 0.00) {
      double newCalculatedValue = (form.getEntrBondRedemption() / form.getEntrNetAssessed()) * 1000;  
       
       form.setCertBondRedemption(newCalculatedValue);   
     }
     if (form.getEntrGeneralFund() != null && form.getEntrGeneralFund() > 0.00) {
      double newCalculatedValue = (form.getEntrGeneralFund() / form.getEntrNetAssessed()) * 1000;  
       
       form.setCertGeneralFund(newCalculatedValue);   
     }
     if (form.getEntrKindergarten() != null && form.getEntrKindergarten() > 0.00) {
      double newCalculatedValue = (form.getEntrKindergarten() / form.getEntrNetAssessed()) * 1000;  
       
       form.setCertKindergarten(newCalculatedValue);   
     }
     if (form.getEntrOther() != null && form.getEntrOther() > 0.00) {
      double newCalculatedValue = (form.getEntrOther() / form.getEntrNetAssessed()) * 1000;  
       
       form.setCertOther(newCalculatedValue);   
     }
     if (form.getEntrSpecialFund() != null && form.getEntrSpecialFund() > 0.00) {
      double newCalculatedValue = (form.getEntrSpecialFund() / form.getEntrNetAssessed()) * 1000;  
       
       form.setCertSpecialFund(newCalculatedValue);   
     }
     if (form.getEntrTransportationFund() != null && form.getEntrTransportationFund() > 0.00) {
      double newCalculatedValue = (form.getEntrTransportationFund() / form.getEntrNetAssessed()) * 1000;  
       
       form.setCertTransportationFund(newCalculatedValue);   
     }
     if (form.getEntrVoterApproved() != null && form.getEntrVoterApproved() > 0.00) {
      double newCalculatedValue = (form.getEntrVoterApproved() / form.getEntrNetAssessed()) * 1000;  
       
       form.setCertVoterApproved(newCalculatedValue);   
     }
     
     
    }
    
    /**
     * 
     * @param form 
     */
    public void saveOrUpdate(MillLevyForm form) {

        MillLevy millLevyInfo = millLevyCertDAO.findByDistrict(form.getDistrictNumber(), DateUtil.convertCalendarYearToFiscalYear(form.getTaxYear()));
          
        
         if (millLevyInfo == null) {
          millLevyInfo = new MillLevy();
         }
         
         
         millLevyInfo.setApproverName(form.getEntrCompletedBy());
         millLevyInfo.setApproverPhone(form.getEntrPhoneNumber());
         millLevyInfo.setCertifiedAbateMillLevy(form.getCertAbatement());
         millLevyInfo.setCertifiedBondMillLevy(form.getCertBondRedemption());
         millLevyInfo.setCertifiedCatbuyMillLevy(form.getCertCategoricalBuyout());
         millLevyInfo.setCertifiedEhhMillLevy(form.getCertExcessHold());
         millLevyInfo.setCertifiedFdkMillLevy(form.getCertKindergarten());
         millLevyInfo.setCertifiedHhMillLevy(form.getCertHoldHarmless());
         millLevyInfo.setCertifiedOtherMillLevy(form.getCertOther());         
         millLevyInfo.setCertifiedOverrideMillLevy(form.getCertVoterApproved());
         millLevyInfo.setCertifiedSbtMillLevy(form.getCalcSpecialFund());
         millLevyInfo.setCertifiedTpMillLevy(form.getCertTotalProgram());
         millLevyInfo.setCertifiedTransportMillLevy(form.getCertTransportationFund());
         millLevyInfo.setTotalAllCertifiedMills(form.getCertTotal2());
         millLevyInfo.setCertifiedValuationDate(new Date());
         millLevyInfo.setGrossAssessedValuation(form.getEntrGrossAssessed());
         millLevyInfo.setNetAssessedValuation(form.getEntrNetAssessed());
         millLevyInfo.setTaxIncrementFinancing(form.getEntrTaxincreament());
         millLevyInfo.setAbatement(form.getEntrAssessedAbatement());
         
                           
         saveOrUpdate(millLevyInfo);
    }

    /**
     * 
     * @return 
     */
    @Override
    public MillLevyForm setupForm() {
        MillLevyForm form = new MillLevyForm();
        return form;
    }

    /**
     * 
     * @param id
     * @return 
     */
    @Override
    public MillLevyForm setupForm(long id) {
        /*VData obj = findById(VData.class, id); */

        MillLevyForm form = new MillLevyForm();
        /*form.setId(obj.getId());
         form.setVPage(obj.getVPage());
         form.setVTextstring(obj.getVTextstring());
         form.setVDate(obj.getVDate());
         form.setVNumber(obj.getVNumber());*/
        return form;
    }

    /**
     * 
     * @param districtNumber
     * @param districtName
     * @param fiscalYear
     * @return 
     */
    @Override
    public MillLevyForm setupForm(String districtNumber, String districtName, String primaryCounty, String fiscalYear) {


        MillLevyForm form = new MillLevyForm();
        form.init();

        try {
            StateEqual stateEqualInfo = stateEqualDAO.findLatest(districtNumber, fiscalYear);
            MillLevy millLevyInfo = millLevyCertDAO.findByDistrict(districtNumber, fiscalYear);


            form.setValid(true);
            form.setDistrictNumber(districtNumber);
            form.setDistrictName(districtName);
            form.setTaxYear(fiscalYear.substring(4));
            form.setCounty(primaryCounty != null ? primaryCounty : "<unknown>");

            if (millLevyInfo != null && stateEqualInfo != null) {                
                if (millLevyInfo.getCalculatedValuationDate() != null) {
                 form.setCalcAssessedValuationDate(millLevyInfo.getCalculatedValuationDate());   
                }
                else {
                 form.setCalcAssessedValuationDate(new Date());
                }
                
                if (millLevyInfo.getCertifiedValuationDate() != null) {
                 form.setCertAssessedValuationDate(millLevyInfo.getCertifiedValuationDate());   
                }
                else {
                 form.setCertAssessedValuationDate(new Date());
                }
                
                if (millLevyInfo.getApproverName() != null) {
                 form.setEntrCompletedBy(millLevyInfo.getApproverName());    
                }
                
                if (millLevyInfo.getApproverPhone() != null) {
                 form.setEntrPhoneNumber(millLevyInfo.getApproverPhone());   
                }

                if (millLevyInfo.getBond() != null) {
                    form.setCalcBondRedemption(millLevyInfo.getBond()); //????
                }

                if (stateEqualInfo.getCalcCatBuyMillLevy() != null) {
                    form.setCalcCategoricalBuyout(stateEqualInfo.getCalcCatBuyMillLevy());
                }

                if (millLevyInfo.getCalculatedEhhMillLevy() != null) {
                    form.setCalcExcessHold(millLevyInfo.getCalculatedEhhMillLevy());
                }

                if (millLevyInfo.getFullFundingMillLevy() != null) {
                    form.setCalcGeneralFund(millLevyInfo.getFullFundingMillLevy()); //where should this value come from ????
                }
                

                if (millLevyInfo.getCalculatedHhMillLevy() != null) {
                    form.setCalcHoldHarmless(millLevyInfo.getCalculatedHhMillLevy());
                }

                if (millLevyInfo.getCalculatedFdkMillLevy() != null) {
                    form.setCalcKindergarten(millLevyInfo.getCalculatedFdkMillLevy());
                }                
                
                if (millLevyInfo.getOther() != null) {
                    form.setCalcOther(millLevyInfo.getOther());
                }

                if (millLevyInfo.getSpecialBuildingAndTech() != null) {
                    form.setCalcSpecialFund(millLevyInfo.getSpecialBuildingAndTech());
                }
                                        

                if (stateEqualInfo.getCalcTotalProgramMillLevy() != null) {
                    form.setCalcTotalProgram(stateEqualInfo.getCalcTotalProgramMillLevy());
                }

                if (millLevyInfo.getCalculatedTransportMillLevy() != null) {
                    form.setCalcTransportationFund(millLevyInfo.getCalculatedTransportMillLevy());
                }

                if (millLevyInfo.getVoterApprovedOverride() != null) {
                    form.setCalcVoterApproved(millLevyInfo.getVoterApprovedOverride());
                }
                
                /**
                 * Assessments
                 */
                if (millLevyInfo.getGrossAssessedValuation() != null) {
                    form.setCalcGrossAssessed(millLevyInfo.getGrossAssessedValuation());
                }
                
                if (millLevyInfo.getNetAssessedValuation() != null) {
                    form.setCalcNetAssessed(millLevyInfo.getNetAssessedValuation());
                }
                
                if (millLevyInfo.getAbatement() != null) {
                    form.setCalcAssessedAbatement(millLevyInfo.getAbatement());
                }
                
                if (millLevyInfo.getTaxIncrementFinancing() != null) {
                    form.setCalcTaxIncreament(millLevyInfo.getTaxIncrementFinancing());
                }
                
                if (stateEqualInfo.getFullFundingMill() != null) {
                    form.setCalcMillLevy(stateEqualInfo.getFullFundingMill());
                }
                
                if (stateEqualInfo.getStateEqual() != null) {
                    form.setCalcStateFunding(stateEqualInfo.getStateEqual());
                }
                
                if (millLevyInfo.getAbatement() != null && millLevyInfo.getNetAssessedValuation() != null) {
                    double calcAbabtement = (millLevyInfo.getAbatement() /millLevyInfo.getNetAssessedValuation()) * 1000;
                    
                    form.setCalcAbatement(calcAbabtement);
                }
                
                /**
                 * 
                 */
                
                if (millLevyInfo.getCertifiedValuationDate() != null) {
                    form.setCertAssessedValuationDate(millLevyInfo.getCertifiedValuationDate());
                }
                
                if (millLevyInfo.getCertifiedBondMillLevy() != null) {
                    form.setCertBondRedemption(millLevyInfo.getCertifiedBondMillLevy());
                } else if (millLevyInfo.getBond() != null) {
                    form.setCertBondRedemption(millLevyInfo.getBond()); //????
                  }
                
                if (millLevyInfo.getCertifiedCatbuyMillLevy() != null) {
                    form.setCertCategoricalBuyout(millLevyInfo.getCertifiedCatbuyMillLevy());
                } else if (stateEqualInfo.getCalcCatBuyMillLevy() != null) {
                    form.setCertCategoricalBuyout(stateEqualInfo.getCalcCatBuyMillLevy());
                  }
                
                if (millLevyInfo.getCertifiedEhhMillLevy() != null) {
                    form.setCertExcessHold(millLevyInfo.getCertifiedEhhMillLevy());
                } else if (millLevyInfo.getCalculatedEhhMillLevy() != null) {
                    form.setCertExcessHold(millLevyInfo.getCalculatedEhhMillLevy());
                  }
                
                if (millLevyInfo.getFullFundingMillLevy() != null) {
                    form.setCertGeneralFund(millLevyInfo.getFullFundingMillLevy()); //where should this come from????
                } 
                 
                
                if (millLevyInfo.getCertifiedHhMillLevy() != null) {
                    form.setCertHoldHarmless(millLevyInfo.getCertifiedHhMillLevy());
                } else if (millLevyInfo.getCalculatedHhMillLevy() != null) {
                    form.setCertHoldHarmless(millLevyInfo.getCalculatedHhMillLevy());
                  }
                
                if (millLevyInfo.getCertifiedFdkMillLevy() != null) {
                    form.setCertKindergarten(millLevyInfo.getCertifiedFdkMillLevy());
                } else if (millLevyInfo.getCalculatedFdkMillLevy() != null) {
                    form.setCertKindergarten(millLevyInfo.getCalculatedFdkMillLevy());
                  }   
                
                if (millLevyInfo.getCertifiedOtherMillLevy() != null) {
                    form.setCertOther(millLevyInfo.getCertifiedOtherMillLevy());
                } else if (millLevyInfo.getOther() != null) {
                    form.setCertOther(millLevyInfo.getOther());
                  }
                
                if (millLevyInfo.getCertifiedSbtMillLevy() != null) {
                    form.setCertSpecialFund(millLevyInfo.getCertifiedSbtMillLevy());
                } else if (millLevyInfo.getSpecialBuildingAndTech() != null) {
                    form.setCertSpecialFund(millLevyInfo.getSpecialBuildingAndTech());
                  }
                
                if (millLevyInfo.getCertifiedTpMillLevy() != null) {
                    form.setCertTotalProgram(millLevyInfo.getCertifiedTpMillLevy());
                } else if (stateEqualInfo.getCalcTotalProgramMillLevy() != null) {
                    form.setCertTotalProgram(stateEqualInfo.getCalcTotalProgramMillLevy());
                  }
                
                if (millLevyInfo.getCertifiedTransportMillLevy() != null) {
                    form.setCertTransportationFund(millLevyInfo.getCertifiedTransportMillLevy());
                } else if (millLevyInfo.getCalculatedTransportMillLevy() != null) {
                    form.setCertTransportationFund(millLevyInfo.getCalculatedTransportMillLevy());
                  }
                
                if (millLevyInfo.getCertifiedOverrideMillLevy() != null) {
                    form.setCertVoterApproved(millLevyInfo.getCertifiedOverrideMillLevy());
                } else if (millLevyInfo.getVoterApprovedOverride() != null) {
                    form.setCertVoterApproved(millLevyInfo.getVoterApprovedOverride());
                  }
                
                if (millLevyInfo.getCertifiedValuationDate() != null) {
                    form.setCertAssessedValuationDate(millLevyInfo.getCertifiedValuationDate());
                }
                
                
                 /**
                 * Assessments
                 */
                if (millLevyInfo.getGrossAssessedValuation() != null) {
                    form.setEntrGrossAssessed(millLevyInfo.getGrossAssessedValuation());
                }
                
                if (millLevyInfo.getNetAssessedValuation() != null) {
                    form.setEntrNetAssessed(millLevyInfo.getNetAssessedValuation());
                }
                
                if (millLevyInfo.getAbatement() != null) {
                    form.setEntrAssessedAbatement(millLevyInfo.getAbatement());
                }
                
                if (millLevyInfo.getTaxIncrementFinancing() != null) {
                    form.setEntrTaxincreament(millLevyInfo.getTaxIncrementFinancing());
                }
                
                if (stateEqualInfo.getFullFundingMill() != null) {
                    form.setEntrMillLevy(stateEqualInfo.getFullFundingMill());
                }
                
                if (stateEqualInfo.getStateEqual() != null) {
                    form.setEntrStateFunding(stateEqualInfo.getStateEqual());
                }      
                
                if (millLevyInfo.getCertifiedAbateMillLevy() != null) {
                    form.setCertAbatement(millLevyInfo.getCertifiedAbateMillLevy());
                }
                else if (millLevyInfo.getAbatement() != null && millLevyInfo.getNetAssessedValuation() != null) {
                    double calcAbabtement = (millLevyInfo.getAbatement() /millLevyInfo.getNetAssessedValuation()) * 1000;
                    
                    form.setCertAbatement(calcAbabtement);
                }
            }

        } catch (Exception e) {
            logger.error("Exception occurred", e);
        }

        return form;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public FilenameConstructor createFilenameConstructor() {
     return new  AdvanceFilenameConstructor() {
            private String uniqueFilename;

            @Override
            public String construct(String defaultDirectory, String defaultFileName, String defaultExtention) {
             try {   
              File f = File.createTempFile("$$$", defaultExtention, new File(defaultDirectory));             
              
              uniqueFilename = f.getAbsolutePath();
              
              f.delete();;
              
              return uniqueFilename;
             }
             catch(Exception e) {   
              logger.error("Exception occurred.", e);   
             }
             
              return null;
            }

            @Override
            public File construct(String defaultPath) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public String getFilename() {
                return uniqueFilename;
            }
         
     };   
    }

    /**
     *
     * @param districtMap
     */
    public void saveSpawnData(Map<String, String> districtMap) {
        try {
            final double[] randomEvaluations = {2359807724.00, 1909122503.00, 3784582341.00, 3417394129.00, 4834502384.00, 2483456931.00, 2311449363.00};
            final double[] randomNumbers = {24.995, 23.0123, 28.98756, 30.6253, 20.2384, 21.997, 22.7654, 19.7853, 40.3746};
            final double[] percentages = {0.01, 0.02, 0.014, 0.054, 0.056, 0.078, 0.91, 0.092, 0.33, 0.45, 0.56, 0.78, 0.83, 0.912, 0.99, 1.0, 0.001, 0.0222, 0.41};
            final String currentFiscalYear = DateUtil.getCurrentFiscalYear();

            int entitlementSelector = 0;
            for (String districtNumber : districtMap.keySet()) {
                int percentageSelector = 0;

                MillLevy millLevy = new MillLevy();

                millLevy.setDistrictNumber(districtNumber);
                millLevy.setFiscalYear(currentFiscalYear);
                millLevy.setAbatement(randomNumbers[entitlementSelector % randomNumbers.length] * percentages[percentageSelector++ % percentages.length]);
                millLevy.setBond(randomNumbers[entitlementSelector % randomNumbers.length] * percentages[percentageSelector++ % percentages.length]);
                millLevy.setCalculatedAbateMillLevy(randomEvaluations[entitlementSelector % randomEvaluations.length] * percentages[percentageSelector++ % percentages.length]);
                millLevy.setCalculatedCatbuyMillLevy(randomNumbers[entitlementSelector % randomNumbers.length] * percentages[percentageSelector++ % percentages.length]);
                millLevy.setCalculatedEhhMillLevy(randomNumbers[entitlementSelector % randomNumbers.length] * percentages[percentageSelector++ % percentages.length]);
                millLevy.setCalculatedFdkMillLevy(randomNumbers[entitlementSelector % randomNumbers.length] * percentages[percentageSelector++ % percentages.length]);
                millLevy.setCalculatedHhMillLevy(randomNumbers[entitlementSelector % randomNumbers.length] * percentages[percentageSelector++ % percentages.length]);
                millLevy.setCalculatedOverrideMillLevy(randomNumbers[entitlementSelector % randomNumbers.length] * percentages[percentageSelector++ % percentages.length]);
                //millLevy.setCalculatedOverrideMillLevy(randomNumbers[entitlementSelector % randomNumbers.length] * percentages[percentageSelector++ % percentages.length]);
                millLevy.setCalculatedSbtMillLevy(randomNumbers[entitlementSelector % randomNumbers.length] * percentages[percentageSelector++ % percentages.length]);
                millLevy.setCalculatedTpMillLevy(randomNumbers[entitlementSelector % randomNumbers.length] * percentages[percentageSelector++ % percentages.length]);
                millLevy.setCalculatedTransportMillLevy(randomNumbers[entitlementSelector % randomNumbers.length] * percentages[percentageSelector++ % percentages.length]);
                //millLevy.setCertifiedAbateMillLevy(Double.MAX_VALUE);
                // millLevy.setCertifiedBondMillLevy(Double.MIN_NORMAL);
                // millLevy.setCertifiedCatbuyMillLevy(Double.MIN_NORMAL);
                // millLevy.setCertifiedEhhMillLevy(Double.MIN_NORMAL);
                // millLevy.setCertifiedFdkMillLevy(Double.MIN_NORMAL);
                // millLevy.setCertifiedHhMillLevy(Double.MIN_NORMAL);
                // millLevy.setCertifiedOtherMillLevy(Double.MIN_NORMAL);
                // millLevy.setCertifiedSbtMillLevy(Double.MIN_NORMAL);
                // millLevy.setCertifiedTpMillLevy(Double.MIN_NORMAL);
                // millLevy.setCertifiedTransportMillLevy(Double.MIN_NORMAL);
                // millLevy.setCostOfLiving(Double.MAX_VALUE);
                millLevy.setExcessHoldHarmless(randomNumbers[entitlementSelector % randomNumbers.length] * percentages[percentageSelector++ % percentages.length]);
                millLevy.setFullDayKindergarten(randomNumbers[entitlementSelector % randomNumbers.length] * percentages[percentageSelector++ % percentages.length]);
                millLevy.setFullFundingMillLevy(randomNumbers[entitlementSelector % randomNumbers.length] * percentages[percentageSelector++ % percentages.length]);
                millLevy.setGrossAssessedValuation(randomEvaluations[entitlementSelector % randomEvaluations.length] * percentages[percentageSelector++ % percentages.length]);
                millLevy.setHoldHarmless(randomNumbers[entitlementSelector % randomNumbers.length] * percentages[percentageSelector++ % percentages.length]);
                millLevy.setNetAssessedValuation(randomEvaluations[entitlementSelector % randomEvaluations.length] * percentages[percentageSelector++ % percentages.length]);
                millLevy.setOther(randomNumbers[entitlementSelector % randomNumbers.length] * percentages[percentageSelector++ % percentages.length]);
                // millLevy.setSotAdjPercent(Double.MAX_VALUE);
                millLevy.setSpecialBuildingAndTech(randomNumbers[entitlementSelector % randomNumbers.length] * percentages[percentageSelector++ % percentages.length]);
                // millLevy.setTaborMillLevy(Double.NaN);
                millLevy.setTaxIncrementFinancing(randomEvaluations[entitlementSelector % randomEvaluations.length] * percentages[percentageSelector++ % percentages.length] * -1);
                // millLevy.setTotalAllCertifiedMills(Double.NEGATIVE_INFINITY);
                //millLevy.setTransportation(Double.NaN);
                millLevy.setUserId("<tnyf>");
                millLevy.setVoterApprovedOverride(randomNumbers[entitlementSelector % randomNumbers.length] * percentages[percentageSelector++ % percentages.length]);


                millLevyCertDAO.save(millLevy);

                ++entitlementSelector;
            }

        } catch (Exception e) {
            logger.error("Exception while spawning mill levy data.", e);
        }
    }

    /**
     *
     * @param millLevyCertDAO
     */
    public void setMillLevyCertDAO(IMillLevyDAO millLevyCertDAO) {
        this.millLevyCertDAO = millLevyCertDAO;
    }

    /**
     *
     * @param stateEqualDAO
     */
    public void setStateEqualDAO(IStateEqualDAO stateEqualDAO) {
        this.stateEqualDAO = stateEqualDAO;
    }
}
