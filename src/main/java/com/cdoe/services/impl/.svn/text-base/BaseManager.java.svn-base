
package com.cdoe.services.impl;

import java.util.List;

import com.cdoe.services.transportation.IBaseManager;
import com.cdoe.db.hibernate.IHibernateDAO;

public class BaseManager implements IBaseManager {

	private IHibernateDAO hibernateDAO;

	public IHibernateDAO getHibernateDAO() {
		return hibernateDAO;
	}

	public void setHibernateDAO(IHibernateDAO hibernateDAO) {
		this.hibernateDAO = hibernateDAO;
	}
	
	@Override
	public long create(Object obj) {
		return getHibernateDAO().save(obj);
	}
	
	@Override
	public void saveOrUpdate(Object obj) {
		getHibernateDAO().saveOrUpdate(obj);
	}
	
	@Override
	public void delete(Class clazz, long id) {
		Object obj = findById(clazz, id);
		getHibernateDAO().delete(obj);
	}
	
	@Override
	public <T> T findById(Class<T> clazz, long id) {
		return getHibernateDAO().findByPk(clazz, id);
	}
	
	@Override
	public <T> List<T> findAll(Class<T> clazz) {
		return getHibernateDAO().loadAll(clazz);
	}
	
}