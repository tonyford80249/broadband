
package com.cdoe.db.hibernate;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

public interface IHibernateDAO {

	Long save(Object object);

	void saveOrUpdate(Object object);

	void delete(Object object);

	<T> T findByPk(Class<T> clazz, Long pk);

	<T> List<T> loadAll(Class<T> clazz);

	Session getCurrentSession();

	void saveOrUpdateAll(Collection<?> entities);

	void deleteAll(Collection<?> entities);

	long countAll(Class<?> clazz);

	<T> List<T> loadMax(Class<T> clazz, int max, boolean asc, String orderField);
	
}