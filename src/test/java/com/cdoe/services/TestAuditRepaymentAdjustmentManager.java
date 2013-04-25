package com.cdoe.services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.cdoe.ui.form.stateequal.AuditRepaymentAdjustmentForm;

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
public class TestAuditRepaymentAdjustmentManager {
	
	@Autowired
	private IAuditRepaymentAdjustmentManager manager;

	@Test
	public void testSaveOrUpdateAuditRepaymentAdjustmentForm() {
		AuditRepaymentAdjustmentForm form = new AuditRepaymentAdjustmentForm();
		form.setAmount(new Double(-200.00));
		form.setFrequency("Monthly");
		form.setBeginFiscalMonth("July");
		form.setBeginFiscalYear("2012");
		form.setEndFiscalMonth("June");
		form.setEndFiscalYear("2013");
		form.setDistrictNumber("0880");
		manager.saveOrUpdate(form);
		assertTrue(true);
	}

}
