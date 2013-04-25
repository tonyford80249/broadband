/**
 * 
 */
package com.cdoe.biz.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * This class maps to the STATE_EQUAL_REFERENCE table
 * 
 * @author dyn-8
 *
 */
@Entity
@Table(name="STATE_EQUAL_REFERENCE")
public class StateEqualReference implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="STATE_EQUAL_REFERENCE_SEQ", sequenceName="STATE_EQUAL_REFERENCE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STATE_EQUAL_REFERENCE_SEQ")
	private Long id;
	@Column(name="ELEMENT_NAME")
	private String elementName;
	@Column(name="ELEMENT_VALUE")
	private String elementValue;
	@Column(name="GROUP_NAME")
	private String groupName;
	@Column(name="ADDITIONAL_CRITERIA")
	private String additionalCriteria;
	

	private String active;
	private Long version;

	/**
	 * Default constructor
	 */
	public StateEqualReference() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	public String getElementValue() {
		return elementValue;
	}

	public void setElementValue(String elementValue) {
		this.elementValue = elementValue;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
	public String getAdditionalCriteria() {
		return additionalCriteria;
	}

	public void setAdditionalCriteria(String additionalCriteria) {
		this.additionalCriteria = additionalCriteria;
	}

	
}
