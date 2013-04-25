package com.cdoe.util;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

public class DateUtilTest {
	
	private Logger logger = Logger.getLogger(DateUtilTest.class);

	@Test
	public void testGetFullMonthList() {
		List<String> longMonths = DateUtil.getFullMonthList(false);
		assertNotNull(longMonths);
		for (String month : longMonths) {
			logger.debug(month);
		}
		List<String> shortMonths = DateUtil.getFullMonthList(true);
		assertNotNull(shortMonths);
		for (String month : shortMonths) {
			logger.debug(month);
		}
	}

	@Test
	public void testGetShortYears() {
		List<String> years = DateUtil.getShortYears(new Date(), 5);
		assertNotNull(years);
		for (String year : years) {
			logger.debug(year);
		}
	}
	
	@Test
	public void testGetCurrentFiscalYear() {
		String cfy = DateUtil.getCurrentFiscalYear();
		assertNotNull(cfy);
		logger.debug(cfy);
	}

	@Test
	public void testGetFiscalYear() {
		String cfy = DateUtil.getFiscalYear();
		assertNotNull(cfy);
		logger.debug(cfy);
	}
	
	@Test
	public void testGetPrevFiscalYear() throws ParseException {
		String year = DateUtil.getPrevFiscalYear();
		assertNotNull(year);
		logger.debug(year);
	}

	@Test
	public void testGetFiscalYearFormattedShort() {
		String year = DateUtil.getFiscalYearFormattedShort();
		assertNotNull(year);
		logger.debug(year);
	}
	
	@Test
	public void testGetLongFiscalYearsCurrent() {
		List<String> years = DateUtil.getLongFiscalYears(5);
		assertNotNull(years);
		for (String year : years) {
			logger.debug(year);
		}
	}
	
}
