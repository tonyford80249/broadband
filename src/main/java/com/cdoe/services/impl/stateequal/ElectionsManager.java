package com.cdoe.services.impl.stateequal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import com.cdoe.biz.model.StateEqualReference;
import com.cdoe.biz.model.equal.Election;
import com.cdoe.biz.stateequal.IElectionsDAO;
import com.cdoe.services.IReferenceDataManager;
import com.cdoe.services.impl.BaseManager;
import com.cdoe.services.stateequal.IElectionsManager;
import com.cdoe.ui.form.grid.ElectionItemGrid;
import com.cdoe.ui.form.stateequal.ElectionForm;

public class ElectionsManager extends BaseManager implements IElectionsManager {

	private static final Logger logger = Logger
			.getLogger(ElectionsManager.class);

	private IReferenceDataManager referenceDataManager;
	private IElectionsDAO electionsDAO;

	/**
	 * Sets the referenceDataManager
	 * 
	 * @param referenceDataManager
	 */
	public void setReferenceDataManager(
			IReferenceDataManager referenceDataManager) {
		this.referenceDataManager = referenceDataManager;
	}

	/**
	 * Sets the IElectionsDAO
	 * 
	 * @param IElectionsDAO
	 */
	public void setElectionsDAO(IElectionsDAO electionsDAO) {
		this.electionsDAO = electionsDAO;
	}

	public void saveOrUpdate(ElectionForm form) {
		long id = form.getId();
		if (form.getElectionHeld() != null
				&& "false".equalsIgnoreCase(form.getElectionHeld())) {
			// id = form.getId();
			Election obj = findById(Election.class, id);
			if (obj == null) {
				obj = new Election();
			}
			obj.setDistrictNumber(form.getDistrictCode());
			obj.setFiscalYear(form.getFiscalYear());
			obj.setElectionHeld(form.getElectionHeld());
			obj.setCategory("No election held");
			
			saveOrUpdate(obj);
		} else {
			
			List<ElectionItemGrid> electionItemGridList = form.getElectionItemGridList();
			for (ElectionItemGrid electionItem : electionItemGridList) {
				//if (electionItem.getCategoryHeld() != null
				//		&& "true".equalsIgnoreCase(electionItem.getCategoryHeld())) {
					id = electionItem.getId();
					Election obj = findById(Election.class, id);
					if (obj == null) {
						obj = new Election();
					}
					// Verify if the mapping is correct
					obj.setDistrictNumber(form.getDistrictCode());
					obj.setFiscalYear(form.getFiscalYear());
					obj.setCategoryHeld(electionItem.getCategoryHeld());
					obj.setVoteAgainst(electionItem.getAgainstVoteCount());
					obj.setVoteFor(electionItem.getForVoteCount());
					obj.setCategoryAmount(electionItem.getCategoryAmount());
					obj.setElectionHeld(form.getElectionHeld());
					obj.setBallotLanguage(electionItem.getBallotQuestion());
					logger.debug(electionItem.getElectionCategory());
					obj.setCategory(electionItem.getElectionCategory());
					saveOrUpdate(obj);
				//}
			}
		}
	}

	public ElectionForm setupForm() {
		ElectionForm form = new ElectionForm();
		return form;
	}

	public ElectionForm setupForm(long id) {
		Election obj = findById(Election.class, id);

		ElectionForm form = new ElectionForm();
		return form;
	}
	
	/*
	 *.. @Override
	 */
	public boolean uploadBallot (MultipartFile file, String districtNos,  String fiscalYear) {
	    boolean uploadSuccess = false;
		//InputStream is = null;
		try {
			String orgName = "Ballot" +  districtNos + fiscalYear;
			
			//String uploadFilePath = "uploadedBallot/" + orgName;
			String uploadFilePath =  orgName;
			File dest = new File(uploadFilePath);
			//is = new ByteArrayInputStream(file.getBytes());
			file.transferTo(dest);
			uploadSuccess = true;
		} catch (IOException e) {
			logger.error("Error reading  file to be uploaded: "+ file.getOriginalFilename(), e);
			uploadSuccess = false;
		}  catch (Exception e) {
			logger.error("Error loading ballot  file on upload: "+ file.getOriginalFilename(), e);
			uploadSuccess = false;
		}
		electionsDAO.updateBallotUploaded(districtNos, fiscalYear, "true");
		return uploadSuccess;
	}
	
	
	 

	/*
	 * (non-Javadoc)
	 * @see com.cdoe.services.stateequal.IElectionsManager #setupForm(java.lang.String, java.lang.String)
	 */
	public ElectionForm setupForm(String districtNos, String fiscalYear) {

		ElectionForm form = new ElectionForm();
		form.setElectionItemGridList(new ArrayList<ElectionItemGrid>());
		form.setDistrictCode(districtNos);
		form.setFiscalYear(fiscalYear);
		//form.setElectionHeld("true");

		List<StateEqualReference> stateEqualReference = referenceDataManager.findByGroupName("ELECTION_CATEGORY");
		for (StateEqualReference seReference : stateEqualReference) {
			ElectionItemGrid electionItemGrid = new ElectionItemGrid();
			String topic = seReference.getElementValue();
			electionItemGrid.setElectionTopic(topic);
			electionItemGrid.setElectionCategory(seReference.getElementName());
			electionItemGrid.setBallotQuestion("");
			Election electionItem = electionsDAO.getElectionByDistrictYearCategory(districtNos, fiscalYear,
							seReference.getElementName());
			if (electionItem != null) {
				electionItemGrid.setId(electionItem.getId());
				electionItemGrid.setForVoteCount(electionItem.getVoteFor());
				electionItemGrid.setAgainstVoteCount(electionItem.getVoteAgainst());
				if (electionItem.getBallotLanguage() == null)
					electionItemGrid.setBallotQuestion("");
				else
					 electionItemGrid.setBallotQuestion(electionItem.getBallotLanguage());
				electionItemGrid.setCategoryHeld(electionItem.getCategoryHeld());
				electionItemGrid.setCategoryAmount(electionItem.getCategoryAmount());
				

			} else if (form.getElectionItemGridList().size() == 0) {
				electionItem = electionsDAO.getElectionByDistrictYearCategory(districtNos, fiscalYear,"No election held");
				
			}
			form.getElectionItemGridList().add(electionItemGrid);
			if (form.getElectionItemGridList().size() == 1) {
				if (electionItem != null) {
					form.setElectionHeld(electionItem.getElectionHeld());
					form.setBallotUploaded(electionItem.getBallotUploaded());
					if ("false".equalsIgnoreCase(form.getElectionHeld()))
						form.setErrorMessage("Form already saved before with the selection 'Election was not held for this district, for the selected year'. Uncheck the checkbox to change the selection and enter election information");
					else
						form.setErrorMessage("Form already saved before with election information for this district, for the selected year.  One may modify the election information");
				} else {
					form.setErrorMessage("Please choose or provide election information");
					form.setBallotUploaded("false");
				}
				
			}
			

		}
		form.setSize(form.getElectionItemGridList().size());
		return form;

	}

	/*
	 * List<Object[]> electionDetails =
	 * electionsDAO.getElectionByDistrictYear(districtNos, fiscalYear); //double
	 * grandTotalProg = ((Double)res[0]).doubleValue(); for (Object[]
	 * electionItem:electionDetails) { ElectionItemGrid electionItemGrid = new
	 * ElectionItemGrid(); Object[] res = electionItem;
	 * electionItemGrid.setId(((Long)res[0]).longValue());
	 * electionItemGrid.setElectionTopic((String)res[1]);
	 * electionItemGrid.setForVoteCount(((Long)res[0]).longValue());
	 * electionItemGrid.setAgainstVoteCount(((Long)res[0]).longValue());
	 * 
	 * }
	 */

}
