
package com.cdoe.services;

import org.apache.log4j.Logger;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import static org.junit.Assert.assertEquals;

import com.cdoe.services.stateequal.IDistrictPaymentReportManager;
import com.cdoe.biz.model.transportation.Prorate;
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
public class TestDistrictPaymentReportManager extends AbstractTransactionalJUnit4SpringContextTests {
	
	private static final Logger logger = Logger.getLogger(TestDistrictPaymentReportManager.class);
	
	@Autowired
	private IDistrictPaymentReportManager districtPaymentReportManager;
	

	@Test
	public void testProrate() {
		final List<Prorate> list = districtPaymentReportManager.findAll(Prorate.class);
		int size1 = list.size();
		
		/* test create */
		final Prorate prorate = new Prorate();
		long id = districtPaymentReportManager.create(prorate);
		
		/* test find */
		final Prorate prorate2 = districtPaymentReportManager.findById(Prorate.class, id);
		long id2 = prorate2.getId();
		assertEquals(id, id2);
		
		/* test find all */
		final List<Prorate> list2 = districtPaymentReportManager.findAll(Prorate.class);
		int size2 = list2.size();
		assertEquals(size2, size1 + 1);
		
		/* test delete */
		districtPaymentReportManager.delete(Prorate.class, id);
		final List<Prorate> list3 = districtPaymentReportManager.findAll(Prorate.class);
		int size3 = list3.size();
		assertEquals(size1, size3);
	}
	
}