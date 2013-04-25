
package com.cdoe.services;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.cdoe.services.stateequal.ICrosswalkCollectionDataManager;
import com.cdoe.ui.form.stateequal.CrosswalkCollectionForm;
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
public class TestCrosswalkCollectionDataManager extends AbstractTransactionalJUnit4SpringContextTests {
	
	private static final Logger logger = Logger.getLogger(TestCrosswalkCollectionDataManager.class);
	
	@Autowired
	private ICrosswalkCollectionDataManager crosswalkCollectionDataManager;
	CrosswalkCollectionForm crosswalkCollectionForm = new CrosswalkCollectionForm();
	
	public TestCrosswalkCollectionDataManager() {
		
		
		crosswalkCollectionForm.setFiscalYear("20122013");
	}

	@Test
	public void testCollectionType() {
	
		
	}

	@Test
	public void testAscentView() {
		crosswalkCollectionForm.setCollectionType("Ascent");
		crosswalkCollectionDataManager.viewCrosswalkData(crosswalkCollectionForm);
		
	}
	
}