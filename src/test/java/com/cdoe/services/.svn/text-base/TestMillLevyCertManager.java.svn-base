
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

import com.cdoe.services.stateequal.IMillLevyCertManager;
import com.cdoe.biz.model.VData;
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
public class TestMillLevyCertManager extends AbstractTransactionalJUnit4SpringContextTests {
	
	private static final Logger logger = Logger.getLogger(TestMillLevyCertManager.class);
	
	@Autowired
	private IMillLevyCertManager millLevyCertManager;
	

	@Test
	public void testStateEqual() {
		final List<StateEqual> list = millLevyCertManager.findAll(StateEqual.class);
		int size1 = list.size();
		
		/* test create */
		final StateEqual stateEqual = new StateEqual();
		long id = millLevyCertManager.create(stateEqual);
		
		/* test find */
		final StateEqual stateEqual2 = millLevyCertManager.findById(StateEqual.class, id);
		long id2 = stateEqual2.getId();
		assertEquals(id, id2);
		
		/* test find all */
		final List<StateEqual> list2 = millLevyCertManager.findAll(StateEqual.class);
		int size2 = list2.size();
		assertEquals(size2, size1 + 1);
		
		/* test delete */
		millLevyCertManager.delete(StateEqual.class, id);
		final List<StateEqual> list3 = millLevyCertManager.findAll(StateEqual.class);
		int size3 = list3.size();
		assertEquals(size1, size3);
	}

	@Test
	public void testVData() {
		final List<VData> list = millLevyCertManager.findAll(VData.class);
		int size1 = list.size();
		
		/* test create */
		final VData vData = new VData();
		long id = millLevyCertManager.create(vData);
		
		/* test find */
		final VData vData2 = millLevyCertManager.findById(VData.class, id);
		long id2 = vData2.getId();
		assertEquals(id, id2);
		
		/* test find all */
		final List<VData> list2 = millLevyCertManager.findAll(VData.class);
		int size2 = list2.size();
		assertEquals(size2, size1 + 1);
		
		/* test delete */
		millLevyCertManager.delete(VData.class, id);
		final List<VData> list3 = millLevyCertManager.findAll(VData.class);
		int size3 = list3.size();
		assertEquals(size1, size3);
	}
	
}