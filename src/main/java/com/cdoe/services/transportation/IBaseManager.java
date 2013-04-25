
package com.cdoe.services.transportation;

import java.util.List;

public interface IBaseManager {

	long create(Object obj);

	void saveOrUpdate(Object obj);

	<T> T findById(Class<T> clazz, long id);

	<T> List<T> findAll(Class<T> clazz);

	void delete(Class clazz, long id);

}