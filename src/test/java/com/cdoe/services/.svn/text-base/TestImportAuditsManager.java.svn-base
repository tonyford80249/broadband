
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

import com.cdoe.services.stateequal.IImportAuditsManager;
import com.cdoe.biz.model.audit.AuditEqual;
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
public class TestImportAuditsManager extends AbstractTransactionalJUnit4SpringContextTests {
	
	private static final Logger logger = Logger.getLogger(TestImportAuditsManager.class);
	
	@Autowired
	private IImportAuditsManager importAuditsManager;
	

	@Test
	public void testAuditEqual() {
		final List<AuditEqual> list = importAuditsManager.findAll(AuditEqual.class);
		int size1 = list.size();
		
		/* test create */
		final AuditEqual auditEqual = new AuditEqual();
		long id = importAuditsManager.create(auditEqual);
		
		/* test find */
		final AuditEqual auditEqual2 = importAuditsManager.findById(AuditEqual.class, id);
		long id2 = auditEqual2.getId();
		assertEquals(id, id2);
		
		/* test find all */
		final List<AuditEqual> list2 = importAuditsManager.findAll(AuditEqual.class);
		int size2 = list2.size();
		assertEquals(size2, size1 + 1);
		
		/* test delete */
		importAuditsManager.delete(AuditEqual.class, id);
		final List<AuditEqual> list3 = importAuditsManager.findAll(AuditEqual.class);
		int size3 = list3.size();
		assertEquals(size1, size3);
	}
	
}