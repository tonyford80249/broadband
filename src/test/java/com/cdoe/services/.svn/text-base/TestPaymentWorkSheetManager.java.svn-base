
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

import com.cdoe.services.transportation.IPaymentWorkSheetManager;
import com.cdoe.biz.model.transportation.Transportation;
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
public class TestPaymentWorkSheetManager extends AbstractTransactionalJUnit4SpringContextTests {
	
	private static final Logger logger = Logger.getLogger(TestPaymentWorkSheetManager.class);
	
	@Autowired
	private IPaymentWorkSheetManager paymentWorkSheetManager;
	

	@Test
	public void testTransportation() {
		final List<Transportation> list = paymentWorkSheetManager.findAll(Transportation.class);
		int size1 = list.size();
		
		/* test create */
		final Transportation transportation = new Transportation();
		long id = paymentWorkSheetManager.create(transportation);
		
		/* test find */
		final Transportation transportation2 = paymentWorkSheetManager.findById(Transportation.class, id);
		long id2 = transportation2.getId();
		assertEquals(id, id2);
		
		/* test find all */
		final List<Transportation> list2 = paymentWorkSheetManager.findAll(Transportation.class);
		int size2 = list2.size();
		assertEquals(size2, size1 + 1);
		
		/* test delete */
		paymentWorkSheetManager.delete(Transportation.class, id);
		final List<Transportation> list3 = paymentWorkSheetManager.findAll(Transportation.class);
		int size3 = list3.size();
		assertEquals(size1, size3);
	}
	
}