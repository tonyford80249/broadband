package com.resqsoft.biz;

import java.io.Serializable;

import org.apache.commons.lang.builder.CompareToBuilder;

/**
 * Store a sequence of objects that act as the elements of the primary key for a
 * domain object/business object. The key behavior is equality. It's also useful
 * to get parts of the key when you're mapping to the database.
 *
 * The need for this class especially arose when we met a task to support
 * composite primary keys in a legacy database schema.
 *
 * The BusinessObject, which is the base class for all domain (i.e. business)
 * objects uses this class so that all domain objects have a primary key without
 * concern in the base BusinessObject class for the differences in the primary
 * key for each domain object (i.e. composite pk or single field pk and what
 * type of each field in the pk. By having the same basic structure for all
 * primary keys, all of the key handling can be done in the BusinessObject base
 * class.
 *
 * Based on the Identity Field pattern described in the book "Patterns of
 * Enterprise Architecture" ISBN: 0-321-12742-0 (available online at
 * http://safari.informit.com). See the subsection entitled: "Example: Using a
 * Compound Key (Java)"
 *
 *
 * @author ResQSoft Engineer
 * @version 1.0
 */
public class PrimaryKey implements Comparable, Serializable, Cloneable {

	private static final long serialVersionUID = -232813677697824506L;

	private Object[] fields;

	public PrimaryKey() {
		this.fields = new Object[0];
	}

	/*
	 * Convenience constructor for single field integer primary keys.
	 */
	public PrimaryKey(final int pk) {
		this(Integer.valueOf(pk));
	}

	public PrimaryKey(final Integer pk) {
		this.fields = new Object[1];
		this.fields[0] = pk;
	}

	/*
	 * Convenience constructor for single field String primary keys.
	 */
	public PrimaryKey(final String pk) {
		this.fields = new Object[1];
		this.fields[0] = (pk);
	}

	/*
	 * The most elemental way to create a key is with an array parameter.
	 */
	public PrimaryKey(final Object[] fields) {
		this.checkKeyNotNull(fields);
		this.fields = fields;
	}

	private void checkKeyNotNull(final Object[] fields) {
		if (fields == null) {
			throw new IllegalArgumentException("Cannot have a null key");
		}
		for (int i = 0; i < fields.length; i++) {
			if (fields[i] == null) {
				throw new IllegalArgumentException(
						"Cannot have a null element of key");
			}
		}
	}

	private void checkSingleKey() {
		if (this.fields.length > 1) {
			throw new IllegalStateException(
					"Cannot take value on composite Key");
		}
	}


	public boolean equals(final Object obj) {
		if (!(obj instanceof PrimaryKey)) {
			return false;
		}
		final PrimaryKey otherKey = (PrimaryKey) obj;
		if (this.fields.length != otherKey.fields.length) {
			return false;
		}
		for (int i = 0; i < this.fields.length; i++) {
			if (!((this.fields[i] != null) && (otherKey.fields[i] != null) && this.fields[i]
					.equals(otherKey.fields[i]))) {
				return false;
			}
		}
		return true;
	}


	public int hashCode() {
		if ((this.fields == null) || (this.fields.length == 0)) {
			return 0;
		}
		int result = 17;
		for (int i = 0; i < this.fields.length; i++) {
			result = 37 * result
					+ (this.fields[i] == null ? 0 : this.fields[i].hashCode());
		}
		return result;

	}

	/**
	 * Convenience method to get the value in the case that the primary key
	 * consists of a single long value.
	 */
	public long intValue() {
		this.checkSingleKey();
		return this.intValue(0);
	}

	/**
	 * Convenience method to get the long value at a given field/index position.
     * Zero is returned if the given index is out of range.
	 */
	public long intValue(final int i) {
        if (this.fields.length <= i) {
            return 0;
        }
		if (!(this.fields[i] instanceof Integer)) {
			throw new IllegalStateException(
					"Cannot take intValue on non-int key");
		}
		return ((Integer) this.fields[i]).intValue();
	}

	/**
	 * Convenience method to get the value in the case that the primary key
	 * consists of a single String value.
	 */
	public String getStringValue() {
		this.checkSingleKey();
		return this.getStringValue(0);
	}

	/**
	 * Convenience method to get the String value at a given field/index
	 * position.
     * Null is returned if the given index is out of range.
	 */
	public String getStringValue(final int i) throws IllegalStateException {
		if (this.fields == null) {
			throw new IllegalStateException("PrimaryKey has no fields.");
		}
		if (this.fields.length <= i) {
		       return null;
		}
		if (!(this.fields[i] instanceof String)) {
			throw new IllegalStateException(
					"Cannot take stringValue on non-String key");
		}
		return ((String) this.fields[i]);
	}

	/**
	 * Convenience method to get the single value in the case that the primary
	 * key consists of a single value.
	 */
	public Object getValue() {
		this.checkSingleKey();
		return this.fields[0];
	}

	/**
	 * Returns the size of the array holding primary key field which is
	 * essentially the number of fields that this primary key consists of.
	 */
	public int getSize() {
		return this.fields.length;
	}

	/**
	 * Accessor method to get the value in the field for a given index. Useful
	 * for mapping to a persistence mechanism.
	 * Null is returned if the given index is out of range.
	 * @param i
	 */
	public Object getValue(final int i) {
        if (this.fields.length <= i) {
            return null;
        }
		return this.fields[i];
	}

	/**
	 * Method to set the value in the field for a given index. Index can be any
	 * non-negative integer, the internal array of fields will be automatically
	 * expanded as needed.
	 *
	 * This method is created already deprecated and will be replaced in future.
	 * Primary key is supposed to be immutable, while this method allows
	 * changing primary key values. But at this time it is convenient to
	 * implement new Engineer feature...
	 *
	 * @param i
	 * @param o
	 */
	public void setValue(final int i, final Object o) {
		if (i > this.fields.length - 1) {
			this.resizeFieldsArray(i + 1);
		}
		this.fields[i] = o;
	}

	/**
	 * @param i
	 */
	private void resizeFieldsArray(final int i) {
		final Object[] newArr = new Object[i];
		System.arraycopy(this.fields, 0, newArr, 0, this.fields.length);
		this.fields = newArr;
	}

	/**
	 * @see java.lang.Object#toString()
	 */

	public String toString() {
		if ((this.fields == null) || (this.fields.length == 0)) {
			return "Primary key with no fields";
		}
		final StringBuffer sb = new StringBuffer(
				"Primary key with field values: ");
		for (int i = 0; i < this.fields.length; i++) {
			final Object o = this.fields[i];
			sb.append(o);
			if (i < this.fields.length - 1) {
				sb.append(',');
			}
		}
		return sb.toString();
	}

	public Object clone() {
	    final PrimaryKey newPrimaryKey = new PrimaryKey();
	    for (int i = 0; i < this.fields.length; i++) {
	        newPrimaryKey.setValue(i, this.fields[i]);
	    }
	    return newPrimaryKey;
	}

	/**
	 * @see java.lang.Comparable#compareTo(Object)
	 */
	public int compareTo(final Object object) {
		final PrimaryKey myClass = (PrimaryKey) object;
		return new CompareToBuilder().append(this.fields, myClass.fields)
				.toComparison();
	}

}
