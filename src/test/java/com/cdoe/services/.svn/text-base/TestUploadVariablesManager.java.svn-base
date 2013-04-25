
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

import com.cdoe.services.stateequal.IUploadVariablesManager;
import com.cdoe.biz.model.Variable;
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
public class TestUploadVariablesManager extends AbstractTransactionalJUnit4SpringContextTests {
	
	private static final Logger logger = Logger.getLogger(TestUploadVariablesManager.class);
	
	@Autowired
	private IUploadVariablesManager uploadVariablesManager;
	

	@Test
	public void testVariable() {
		final List<Variable> list = uploadVariablesManager.findAll(Variable.class);
		int size1 = list.size();
		
		/* test create */
		final Variable variable = new Variable();
		long id = uploadVariablesManager.create(variable);
		
		/* test find */
		final Variable variable2 = uploadVariablesManager.findById(Variable.class, id);
		long id2 = variable2.getId();
		assertEquals(id, id2);
		
		/* test find all */
		final List<Variable> list2 = uploadVariablesManager.findAll(Variable.class);
		int size2 = list2.size();
		assertEquals(size2, size1 + 1);
		
		/* test delete */
		uploadVariablesManager.delete(Variable.class, id);
		final List<Variable> list3 = uploadVariablesManager.findAll(Variable.class);
		int size3 = list3.size();
		assertEquals(size1, size3);
	}

	@Test
	public void testStateEqual() {
		final List<StateEqual> list = uploadVariablesManager.findAll(StateEqual.class);
		int size1 = list.size();
		
		/* test create */
		final StateEqual stateEqual = new StateEqual();
		long id = uploadVariablesManager.create(stateEqual);
		
		/* test find */
		final StateEqual stateEqual2 = uploadVariablesManager.findById(StateEqual.class, id);
		long id2 = stateEqual2.getId();
		assertEquals(id, id2);
		
		/* test find all */
		final List<StateEqual> list2 = uploadVariablesManager.findAll(StateEqual.class);
		int size2 = list2.size();
		assertEquals(size2, size1 + 1);
		
		/* test delete */
		uploadVariablesManager.delete(StateEqual.class, id);
		final List<StateEqual> list3 = uploadVariablesManager.findAll(StateEqual.class);
		int size3 = list3.size();
		assertEquals(size1, size3);
	}
	
}