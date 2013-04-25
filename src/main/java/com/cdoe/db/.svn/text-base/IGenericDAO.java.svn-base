/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.db;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.resqsoft.biz.BusinessObject;
import com.resqsoft.biz.PrimaryKey;
import com.resqsoft.biz.SearchCriteria;

/*
 * ref: dao/dataaccessobject.interface.et.jsp  
 */
/**
 * Generic Data Access Object interface that provides the business layer with an ability to access data store.
 * Declares methods of general use that can be applied to any business object regardless
 * of its type. 
 * @author ResQSoft, Inc. (ResQSoft Engineer)
 */
public interface IGenericDAO {
    
    /**
     * Inserts the values of a <code>business object</code>'s 
     * instance variables into the business objects table as a new record.
     * @param <code>business object</code> object containing the values written as a new record in the business objects table
     * @return  none     
     */
    public void add(BusinessObject record);
    
    /**
    * This method deletes the record from the business objects represented by the <code>business object</code> object passed as a parameter.
    * @param a <code>business object</code> object
    * @return  none
    */
    public void delete(BusinessObject record);
    
    /**
     * Execute a named query without any parameters.
     * @param queryName
     * @return
     */
    public List<Object> executeQuery(final String queryName);
    
    /**
     * Execute a named query without any parameters.
     * @param queryName
     * @param firstResult
     * @param maxResults
     * @return
     */
    public List<Object> executeQuery(final String queryName, final Integer firstResult,
            final Integer maxResults);
    

    
    /**
     * Execute query count without any parameters.
     * @param queryName
     * @return
     */
    public Integer executeQueryCount(final String queryName);
    
    
    /**
     * Execute query count, binding a number of values to ":" named parameters
     * in the query string.
     * 
     * @param queryName
     *            name of the named query
     * @param parametersLinkedHashMap
     *            Name/value pair for each parameter
     */
    public Integer executeQueryCount(final String queryName,
            final Map<String,Object> parametersLinkedHashMap);
    
    
    /**
     * Execute a named query, binding a number of values to ":" named parameters in the query string.
     *
     * @param queryName name of the named query
     * @param parametersLinkedHashMap Name/value pair for each parameter
     */
    public List<Object> executeQuery(final String queryName,
            final Map<String,Object> parametersLinkedHashMap);
    
    /**
     * Execute a named query, binding a number of values to ":" named parameters in the query string.
     *
     * @param queryName
     * @param parametersLinkedHashMap
     * @param firstResult
     * @param maxResults
     * @return
     */
    public List<Object> executeQuery(final String queryName,
            final Map<String,Object> parametersLinkedHashMap, final Integer firstResult, final Integer maxResults);
    
    
    /**
     * Returns all objects by executing given {@link SearchCriteria}.
     * @param criteria {@link SearchCriteria}
     * @see SearchCriteria
     * @return {@link Collection} A <code>Collection</code> of <code>business</code> objects.
     */
    public <T extends BusinessObject> Collection<T> find(SearchCriteria criteria, Class<T> cls);
    
    /**
    * Returns all <code>business object</code> objects
    * @param none
    * @return  A <code>Collection</code> of <code>business object</code> objects
    */
    public <T extends BusinessObject> Collection<T> find(Class<T> cls);
    
    /**
    * Returns a <code>business object</code> object
    * for the primary key.
    * @param primary key value
    * @return  <code>business object</code> object
    */
    public <T extends BusinessObject> T find(PrimaryKey pk, Class<T> cls);
    
    /**
     * Return the count of the number of objects matching the given {@link SearchCriteria}.
     * @param <T>
     * @param searchCriteria
     * @param clazz
     * @return
     */
    public <T extends BusinessObject> int getCount(final SearchCriteria searchCriteria,
            final Class<T> clazz);
    
    /**
     * This method refreshes the given business object by reloading its data
     * from the data store again. It may be useful in particular cases, for
     * example, when we need to make sure the object does not contain stale
     * data. Another important use case of this method is to make sure that if
     * this business object has collection(s) of associated business objects
     * (for example, via a foreign key) for which lazy loading has been enabled
     * then accessing those collections will not cause problems. Such situation
     * is possible when a business object is obtained, for example, from
     * HttpSession and one of its lazy initialized collections is accessed.
     * Since lazy collection initialization is provided by underlying ORM
     * framework (e.g. Hibernate), we have to deal with this kind of issues. The
     * best a programmer can do is call this method for every business object
     * having associated objects in a collection after this business object has
     * been obtained from HttpSession or other type of context. There is no need
     * to call this method when a business object is loaded from the database
     * and then used within the boundaries of a single HTTP request.
     * @see org.hibernate.Session#refresh(Object)
     * @param bo business object to refresh.
     */
    public void refresh(BusinessObject bo);
    
    /**
     * This method synchronizes in-memory data with that in the database.
     * This is not a COMMIT.  However this operation is done
     * automatically when a transaction commits.
     * This method may need to be used in cases where the 
     * data is expected to be available in the database before a
     * stored procedure is called.
     *  
     *  @param
     *  @return
     */
    public void synchronizeWithDatabase();
    
    /**
    * This method updates an existing record in the business objects table
    * with the attributes of a <code>business object</code>'s passed in as a parameter.
    * @param a <code>business object</code> object
    * @return  none
    */
    public void update(BusinessObject record);
    
    /**
     * Return all objects matching the given example object.
     * @param <T>
     * @param firstResult
     * @param maxResults
     * @return
     */
	public <T extends BusinessObject> Collection<T> find(
        final T exampleObject, final Integer firstResult,
        final Integer maxResults);  

    /**
     * Return all objects matching the given example object.
     * @param <T>
     * @return
     */        
    public <T extends BusinessObject> Collection<T> find(final T exampleObject);          
    
}