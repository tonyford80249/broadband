
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

import static org.junit.Assert.*;

import com.cdoe.services.transportation.IDistributionAmountsManager;
import com.cdoe.ui.form.transportation.ProrateForm;
import com.cdoe.util.DateUtil;
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
@TransactionConfiguration(transactionManager = "defaultTransactionManger", defaultRollback=false)
public class TestDistributionAmountsManager extends AbstractTransactionalJUnit4SpringContextTests {
	
	private static final Logger logger = Logger.getLogger(TestDistributionAmountsManager.class);
	
	@Autowired
	private IDistributionAmountsManager distributionAmountsManager;
	

	@Test
	public void testProrate() {
		final List<Prorate> list = distributionAmountsManager.findAll(Prorate.class);
		int size1 = list.size();
		
		/* test create */
		final Prorate prorate = new Prorate();
		long id = distributionAmountsManager.create(prorate);
		
		/* test find */
		final Prorate prorate2 = distributionAmountsManager.findById(Prorate.class, id);
		long id2 = prorate2.getId();
		assertEquals(id, id2);
		
		/* test find all */
		final List<Prorate> list2 = distributionAmountsManager.findAll(Prorate.class);
		int size2 = list2.size();
		assertEquals(size2, size1 + 1);
		
		/* test delete */
		distributionAmountsManager.delete(Prorate.class, id);
		final List<Prorate> list3 = distributionAmountsManager.findAll(Prorate.class);
		int size3 = list3.size();
		assertEquals(size1, size3);
	}
	
	@Test
	public void testSaveOrUpdateProrate() {
		Prorate obj = new Prorate();
		obj.setFiscalYear(DateUtil.getFiscalYear());
		obj.setTotalFirstPayment(new Double(1500000.00));
		obj.setTotalDistribution(new Double(1500000.00));
		try {
			distributionAmountsManager.saveOrUpdate(obj);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		assertTrue(true);
	}
	
	@Test
	public void testSaveOrUpdateProrateForm() {
		ProrateForm obj = new ProrateForm();
		obj.setId(0);
		obj.setFiscalYear(DateUtil.getFiscalYear());
		obj.setTotalFirstPayment(new Double(1500000.00));
		obj.setTotalDistribution(new Double(1500000.00));
		try {
			distributionAmountsManager.saveOrUpdate(obj);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		assertTrue(true);
	}
	
}