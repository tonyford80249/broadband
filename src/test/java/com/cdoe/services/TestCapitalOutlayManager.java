
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

import com.cdoe.services.transportation.ICapitalOutlayManager;
import com.cdoe.biz.model.transportation.CapitalOutlay;
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
public class TestCapitalOutlayManager extends AbstractTransactionalJUnit4SpringContextTests {
	
	private static final Logger logger = Logger.getLogger(TestCapitalOutlayManager.class);
	
	@Autowired
	private ICapitalOutlayManager capitalOutlayManager;
	

	@Test
	public void testCapitalOutlay() {
		final List<CapitalOutlay> list = capitalOutlayManager.findAll(CapitalOutlay.class);
		int size1 = list.size();
		
		/* test create */
		final CapitalOutlay capitalOutlay = new CapitalOutlay();
		long id = capitalOutlayManager.create(capitalOutlay);
		
		/* test find */
		final CapitalOutlay capitalOutlay2 = capitalOutlayManager.findById(CapitalOutlay.class, id);
		long id2 = capitalOutlay2.getId();
		assertEquals(id, id2);
		
		/* test find all */
		final List<CapitalOutlay> list2 = capitalOutlayManager.findAll(CapitalOutlay.class);
		int size2 = list2.size();
		assertEquals(size2, size1 + 1);
		
		/* test delete */
		capitalOutlayManager.delete(CapitalOutlay.class, id);
		final List<CapitalOutlay> list3 = capitalOutlayManager.findAll(CapitalOutlay.class);
		int size3 = list3.size();
		assertEquals(size1, size3);
	}
	
}