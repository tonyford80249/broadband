package com.cdoe.services.impl.stateequal;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.multipart.MultipartFile;

import com.cdoe.biz.model.equal.FteByGrade;
import com.cdoe.biz.model.equal.StateEqual;
import com.cdoe.biz.stateequal.IFteByGradeDAO;
import com.cdoe.biz.stateequal.IStateEqualDAO;
import com.cdoe.services.impl.BaseManager;
import com.cdoe.services.stateequal.IUploadVariablesManager;
import com.cdoe.ui.form.grid.UploadVariablesGrid;
import com.cdoe.ui.form.stateequal.SaveVariableForm;
import com.cdoe.ui.form.stateequal.UploadVariablesForm;
import com.cdoe.util.DateUtil;

public class UploadVariablesManager extends BaseManager implements
		IUploadVariablesManager {

	private static final Logger logger = Logger
			.getLogger(UploadVariablesManager.class);

	private IStateEqualDAO stateEqualDao;
	
	private IFteByGradeDAO fteByGradeDao;

	public void setStateEqualDao(IStateEqualDAO stateEqualDao) {
		this.stateEqualDao = stateEqualDao;
	}

	public void setFteByGradeDao(IFteByGradeDAO fteByGradeDao) {
		this.fteByGradeDao = fteByGradeDao;
	}

	public UploadVariablesForm setupUploadVariablesForm() {
		UploadVariablesForm form = new UploadVariablesForm();
		return form;
	}

	@Override
	public UploadVariablesGrid processFile(MultipartFile file) {
		UploadVariablesGrid results = null;
		InputStream is = null;
		try {
			is = new ByteArrayInputStream(file.getBytes());
			Workbook workbook = WorkbookFactory.create(is);
			Sheet sheet = workbook.getSheetAt(0);
			if (sheet != null) {
				results = new UploadVariablesGrid();
				// The first row has the column names
				Row firstRow = sheet.getRow(sheet.getFirstRowNum());
				// Put these in the column header list
				List<String> columnHeaders = new ArrayList<String>();
				for (Cell cell : firstRow) {
					columnHeaders.add(cell.getStringCellValue());
				}
				// Now put the rest of the rows into the grid
				Map<String, List<Double>> rowmap = new HashMap<String, List<Double>>();
				for (int i = sheet.getFirstRowNum() + 1; i <= sheet
						.getLastRowNum(); i++) {
					Row row = sheet.getRow(i);
					// District code is in the first cell - this is our key
					String districtCode = row.getCell(row.getFirstCellNum())
							.getStringCellValue();
					List<Double> rowList = new ArrayList<Double>();
					for (Cell cell : row) {
						// Skip the first cell
						if (cell.getColumnIndex() == row.getFirstCellNum())
							continue;
						rowList.add(new Double(cell.getNumericCellValue()));
					}
					rowmap.put(districtCode, rowList);
				}
				results.setColumnHeaders(columnHeaders);
				results.setRowGrid(rowmap);
			}
		} catch (Exception e) {
			logger.error(
					"Error reading uploaded file: "
							+ file.getOriginalFilename(), e);
			results = null;
		}
		return results;
	}

	@Override
	public void saveUploadVariablesGrid(UploadVariablesGrid grid,
			String fiscalYear) {
		String fullFiscalYear = DateUtil.getFullFiscalYearFromShort(fiscalYear);
		for (String districtCode : grid.getRowGrid().keySet()) {
			/*if (districtCode == null || "".equals(districtCode))
				continue;
			else if (!isInteger(districtCode)) {
				
			}*/
			StateEqual stateEqualDto = new StateEqual();
			stateEqualDto.setDistrictNumber(districtCode);
			stateEqualDto.setFiscalYear(fullFiscalYear);
			List<Double> row = grid.getRowGrid().get(districtCode);
			for (String column : grid.getColumnHeaders()) {
				if (column.contentEquals("DISTRICT_CODE")) continue;
				Double value = row.get(grid.getColumnHeaders().indexOf(column) - 1);
//				if (value.doubleValue() > 9999999999.999999) {
//					throw new RuntimeException("Precision error - value for field: " + column + " is too large - districtNumber: " + districtCode + " value: " + value);
//				}
				if (column.contentEquals("FTE"))
					stateEqualDto.setFte(value);
				if (column.contentEquals("MULTI_DISTRICT_ONLINE_FTE"))
					stateEqualDto.setMultiDistrictOnlineFte(value);
				if (column.contentEquals("CHARTER_SCHOOL_FPC"))
					stateEqualDto.setCharterSchoolFpc(value);
				if (column.contentEquals("FREE_LUNCH_1_8"))
					stateEqualDto.setFreeLunch18(value);
				if (column.contentEquals("FREE_LUNCH_K_12"))
					stateEqualDto.setFreeLunchK12(value);
				if (column.contentEquals("MEMBER_1_8"))
					stateEqualDto.setMember18(value);
				if (column.contentEquals("MEMBER_K_12"))
					stateEqualDto.setMemberK12(value);
				if (column.contentEquals("SOT_NET"))
					stateEqualDto.setSotNet((value));
				if (column.contentEquals("ASSESSED_VAL"))
					stateEqualDto.setAssessedVal(value);
				if (column.contentEquals("ALLOW_SPEND"))
					stateEqualDto.setAllowSpend(value);
				if (column.contentEquals("TOTAL_ADD_FUND"))
					stateEqualDto.setTotalAddFund(value);
				if (column.contentEquals("FUNDED_PUPIL_COUNT"))
					stateEqualDto.setFundedPupilCount(value);
				if (column.contentEquals("NEG_FACTOR"))
					stateEqualDto.setNegFactor(value);
				if (column.contentEquals("COST_OF_LIVING_FACTOR"))
					stateEqualDto.setCostOfLivingFactor(value);
				if (column.contentEquals("CAT_TRANSPORTATION"))
					stateEqualDto.setCatTransportation(value);
				if (column.contentEquals("CAT_VOCED"))
					stateEqualDto.setCatVoced(value);
				if (column.contentEquals("CAT_ELPA"))
					stateEqualDto.setCatElpa(value);
				if (column.contentEquals("CAT_SPED_DISABILITIES"))
					stateEqualDto.setCatSpedDisabilities(value);
				if (column.contentEquals("CAT_SPED_GIFTED_TALENTED"))
					stateEqualDto.setCatSpedGiftedTalented(value);
				if (column.contentEquals("SMALL_CENTER_PAYMENTS"))
					stateEqualDto.setSmallCenterPayments(value);
				if (column.contentEquals("TOTAL_PROGRAM_CAT_BUYOUT"))
					stateEqualDto.setTotalProgramCatBuyout(value);
				if (column.contentEquals("ASCENT_TOT")) {
					// TODO - save in totals table
				}
				if (column.contentEquals("FUNDED_COUNT-K")) {
					updateFteByGrade(districtCode, fullFiscalYear, "K", value);
				}
				if (column.contentEquals("FUNDED_COUNT_CPP"))
					updateFteByGrade(districtCode, fullFiscalYear, "CPP", value);
				if (column.contentEquals("FUNDED_COUNT_PS"))
					updateFteByGrade(districtCode, fullFiscalYear, "PS", value);
			}
			stateEqualDao.saveOrUpdate(stateEqualDto);
		}

	}

	@Override
	public void saveSingleVariableForm(SaveVariableForm form) {

		if (form.getDataElement().contentEquals("ASCENT_TOT")
				|| form.getDataElement().contentEquals("FUNDED_COUNT-K")
				|| form.getDataElement().contentEquals("FUNDED_COUNT_CPP")
				|| form.getDataElement().contentEquals("FUNDED_COUNT_PS")) {
			FteByGrade fteByGrade = new FteByGrade();
			fteByGrade.setDistrictNumber(form.getDistrictCode());
			fteByGrade.setFiscalYear(DateUtil.getFullFiscalYearFromShort(DateUtil
					.getFullFiscalYearFromShort(form.getFiscalYear())));
			if (form.getDataElement().contentEquals("ASCENT_TOT"))
				//fteByGrade.setAscentTot(form.getValue());
				//TODO figure out where to put this
			if (form.getDataElement().contentEquals("FUNDED_COUNT-K"))
				updateFteByGrade(form.getDistrictCode(), DateUtil.getFullFiscalYearFromShort(form.getFiscalYear()), "K", form.getValue());
			if (form.getDataElement().contentEquals("FUNDED_COUNT_CPP"))
				updateFteByGrade(form.getDistrictCode(), DateUtil.getFullFiscalYearFromShort(form.getFiscalYear()), "CPP", form.getValue());
			if (form.getDataElement().contentEquals("FUNDED_COUNT_PS"))
				updateFteByGrade(form.getDistrictCode(), DateUtil.getFullFiscalYearFromShort(form.getFiscalYear()), "PS", form.getValue());
		} else {
			StateEqual stateEqualDto = new StateEqual();
			stateEqualDto.setDistrictNumber(form.getDistrictCode());
			stateEqualDto.setFiscalYear(DateUtil
					.getFullFiscalYearFromShort(form.getFiscalYear()));

			if (form.getDataElement().contentEquals("FTE"))
				stateEqualDto.setFte(form.getValue());
			if (form.getDataElement()
					.contentEquals("MULTI_DISTRICT_ONLINE_FTE"))
				stateEqualDto.setMultiDistrictOnlineFte(form.getValue());
			if (form.getDataElement().contentEquals("CHARTER_SCHOOL_FPC"))
				stateEqualDto.setCharterSchoolFpc(form.getValue());
			if (form.getDataElement().contentEquals("FREE_LUNCH_1_8"))
				stateEqualDto.setFreeLunch18(form.getValue());
			if (form.getDataElement().contentEquals("FREE_LUNCH_K_12"))
				stateEqualDto.setFreeLunchK12(form.getValue());
			if (form.getDataElement().contentEquals("MEMBER_1_8"))
				stateEqualDto.setMember18(form.getValue());
			if (form.getDataElement().contentEquals("MEMBER_K_12"))
				stateEqualDto.setMemberK12(form.getValue());
			if (form.getDataElement().contentEquals("SOT_NET"))
				stateEqualDto.setSotNet(form.getValue());
			if (form.getDataElement().contentEquals("ASSESSED_VAL"))
				stateEqualDto.setAssessedVal(form.getValue());
			if (form.getDataElement().contentEquals("ALLOW_SPEND"))
				stateEqualDto.setAllowSpend(form.getValue());
			if (form.getDataElement().contentEquals("TOTAL_ADD_FUND"))
				stateEqualDto.setTotalAddFund(form.getValue());
			if (form.getDataElement().contentEquals("FUNDED_PUPIL_COUNT"))
				stateEqualDto.setFundedPupilCount(form.getValue());
			if (form.getDataElement().contentEquals("NEG_FACTOR"))
				stateEqualDto.setNegFactor(form.getValue());
			if (form.getDataElement().contentEquals("COST_OF_LIVING_FACTOR"))
				stateEqualDto.setCostOfLivingFactor(form.getValue());
			if (form.getDataElement().contentEquals("CAT_TRANSPORTATION"))
				stateEqualDto.setCatTransportation(form.getValue());
			if (form.getDataElement().contentEquals("CAT_VOCED"))
				stateEqualDto.setCatVoced(form.getValue());
			if (form.getDataElement().contentEquals("CAT_ELPA"))
				stateEqualDto.setCatElpa(form.getValue());
			if (form.getDataElement().contentEquals("CAT_SPED_DISABILITIES"))
				stateEqualDto.setCatSpedDisabilities(form.getValue());
			if (form.getDataElement().contentEquals("CAT_SPED_GIFTED_TALENTED"))
				stateEqualDto.setCatSpedGiftedTalented(form.getValue());
			if (form.getDataElement().contentEquals("SMALL_CENTER_PAYMENTS"))
				stateEqualDto.setSmallCenterPayments(form.getValue());
			if (form.getDataElement().contentEquals("TOTAL_PROGRAM_CAT_BUYOUT"))
				stateEqualDto.setTotalProgramCatBuyout(form.getValue());
			
			stateEqualDao.saveOrUpdate(stateEqualDto);
		}

	}
	
	private void updateFteByGrade(String districtNumber, String fiscalYear, String gradeLevel, Double value) {
		FteByGrade fteByGrade = fteByGradeDao.findByUniqueKey(districtNumber, fiscalYear, gradeLevel);
		if (fteByGrade == null) {
			fteByGrade = new FteByGrade();
			fteByGrade.setDistrictNumber(districtNumber);
			fteByGrade.setFiscalYear(fiscalYear);
			fteByGrade.setGradeLevel(gradeLevel);
		}
		fteByGrade.setFundedCount(value);
		fteByGradeDao.saveOrUpdate(fteByGrade);
	}
	
	private  static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    // only got here if we didn't return false
	    return true;
	}
}
