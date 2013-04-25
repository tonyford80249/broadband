package com.cdoe.services;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.cdoe.biz.model.equal.Csi;
import com.cdoe.biz.model.equal.FteByGrade;
import com.cdoe.biz.model.equal.MillLevy;
import com.cdoe.biz.model.equal.StateEqual;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:applicationContext.xml",
	"classpath:applicationContext-tx.xml",
	"classpath:applicationContext-data.xml",
	"classpath:applicationContext-dao.xml",
	"classpath:applicationContext-hbm.xml",
	"classpath:applicationContext-service.xml",
	"classpath:applicationContext.xml"}, inheritLocations = true)
@TransactionConfiguration(transactionManager = "defaultTransactionManger")
public class TestSE360CalculationManager {
	
	@Autowired 
	private ISE360CalculationManager se360CalcManager;

	@Test
	public void testGetStateEqual() {
		List<StateEqual> equalData = se360CalcManager.getStateEqualByDistrictAndYears("2000", "20112012", 4);
		assertNotNull(equalData);
		System.out.println("State Equal Data: " + (equalData.get(0) != null ? equalData.get(0).getFiscalYear() : "No data found"));
	}
	
	@Test
	public void testGetFteByGradeByDistrictAndYears() {
		List<FteByGrade> fteByGradeData = se360CalcManager.getFteByGradeByDistrictAndYears("2000", "20112012", 4);
		assertNotNull(fteByGradeData);
		System.out.println("FTE By Grade Data: " + (fteByGradeData.get(0) != null ? fteByGradeData.get(0).getFiscalYear() + fteByGradeData.get(0).getGradeLevel() : "No data found"));
	}
	
	@Test
	public void testGetMillLevyByDistrictAndYears() {
		MillLevy millLevy = se360CalcManager.getMillLevyByDistrictAndYear("2000", "20112012");
		assertNotNull(millLevy);
		System.out.println("Mill Data: " + (millLevy != null ? millLevy.getFiscalYear() : "No data found"));
	}
	
	@Test
	public void testGetCsiByDistrictAndYear() {
		Csi csi = se360CalcManager.getCsiByDistrictAndYear("2000", "20112012");
		assertNotNull(csi);
		System.out.println("CSI  Data: " + (csi != null ? csi.getFiscalYear() : "No data found"));
	}


}
