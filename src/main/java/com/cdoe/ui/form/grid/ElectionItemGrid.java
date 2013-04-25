
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.form.grid;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.cdoe.ui.form.grid.*;

/**
 * Java bean object representing a business entity which will be used by Spring Form
 * to pass data to and from the view, controller, and service layer.
 * 
 * @author ResQSoft, Inc. (ResQSoft Engineer)
 */
public class ElectionItemGrid {

	private long id;
	private String ballotQuestion;
	private String electionTopic;
	private String categoryHeld;
	private String electionOutcome;
	private String electionCategory;
	private double categoryAmount;
	private long forVoteCount;
	private long againstVoteCount;
	
	
	public long getForVoteCount() {
		return forVoteCount;
	}

	public void setForVoteCount(long forVoteCount) {
		this.forVoteCount = forVoteCount;
	}

	public long getAgainstVoteCount() {
		return againstVoteCount;
	}

	public void setAgainstVoteCount(long againstVoteCount) {
		this.againstVoteCount = againstVoteCount;
	}

	
	public double getCategoryAmount() {
		return categoryAmount;
	}

	public void setCategoryAmount(double categoryAmount) {
		this.categoryAmount = categoryAmount;
	}

	public String getElectionCategory() {
		return electionCategory;
	}

	public void setElectionCategory(String electionCategory) {
		this.electionCategory = electionCategory;
	}

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getElectionOutcome() {
		return electionOutcome;
	}

	public void setElectionOutcome(String electionOutcome) {
		this.electionOutcome = electionOutcome;
	}

	public String getBallotQuestion() {
		return ballotQuestion;
	}

	public void setBallotQuestion(String ballotQuestion) {
		this.ballotQuestion = ballotQuestion;
	}

	
	public String getElectionTopic() {
		return electionTopic;
	}

	 public void setElectionTopic(String electionTopic) {
		this.electionTopic = electionTopic;
	 }
	
	public String getCategoryHeld () {
        return this.categoryHeld;
    }

    public void setCategoryHeld (String categoryHeld) {
        this.categoryHeld = categoryHeld;
    }
  
}