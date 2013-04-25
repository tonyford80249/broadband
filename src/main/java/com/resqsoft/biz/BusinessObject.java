package com.resqsoft.biz;

import com.resqsoft.biz.PrimaryKey;


/**
 * This is the base interface for all business objects. It declares only those
 * methods that get and set a business object' primary key. A primary key is a
 * business object's unique identifier. A primary key may be null, which is the
 * case when a new business object has been created but not yet persisted to a
 * data store.
 * <br><br>
 * The meaning of a primary key is defined by the application's business domain,
 * but typically, especially in Engineer-generated applications, a primary key
 * will tie to the buiness object's underlying database table's primary key value,
 * which may be made up of one or more ("composite") fields.
 * <br><br>
 * For legacy databases, the PrimaryKey class supports composite natural keys as
 * well.
 *
 * @author ResQSoft Engineer
 * @version 1.0
 *
 */
public interface BusinessObject {
    /**
     * Gets the primary key value. Typically, this value is an Integer since
     * it is common practice to use integer datatypes as primary keys in a
     * database.
     */
    public PrimaryKey getPrimaryKey();

    /**
     * Sets the primary key. The business object may throw an exception if the
     * primary key value has the wrong type.
     */
    public void setPrimaryKey(PrimaryKey pk);

    /**
     * Returns a String representing the display value that user's use as the
     * natural key or identifier for a given type of business object.
     *
     * The section entitled "Useing business key equality" in the book
     * "Hibernate In Action" describes the concept of a "business key", which is
     * the same as the logical key used here. The relevant portion of the book
     * is included below:
     *
     * <pre>
     *           A business key is a property, or some combination of properties, that is unique for
     *           each instance with the same database identity. Essentially, it's the natural key you'd
     *           use if you weren't using a surrogate key. Unlike a natural primary key, it isn't an
     *           absolute requirement that the business key never change'as long as it changes
     *           rarely, that's enough.
     *
     *           We argue that every entity should have a business key, even if it includes all properties
     *           of the class (this would be appropriate for some immutable classes). The
     *           business key is what the user thinks of as uniquely identifying a particular record,
     *           whereas the surrogate key is what the application and database use.
     *
     *           Business key equality means that the equals() method compares only the properties
     *           that form the business key. This is a perfect solution that avoids all the problems
     *           described earlier. The only downside is that it requires extra thought to
     *           identify the correct business key in the first place. But this effort is required anyway;
     *           it's important to identify any unique keys if you want your database to help ensure
     *           data integrity via constraint checking.
     * </pre>
     */
    public String getLogicalKey();
}
