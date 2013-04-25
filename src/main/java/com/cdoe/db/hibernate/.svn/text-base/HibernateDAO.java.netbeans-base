
package com.cdoe.db.hibernate;

import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

@SuppressWarnings("unchecked")
public class HibernateDAO extends HibernateDaoSupport implements IHibernateDAO {

	private static final Logger logger = Logger.getLogger(HibernateDAO.class);
	
	public Long save(Object object) {
		return (Long) getHibernateTemplate().save(object);
	}

	public void saveOrUpdate(Object object) {
		getHibernateTemplate().saveOrUpdate(object);
	}
	
	public void saveOrUpdateAll(Collection<?> entities) {
		getHibernateTemplate().saveOrUpdateAll(entities);
	}
	
	public void delete(Object object) {
		getHibernateTemplate().delete(object);
	}
	
	public void deleteAll(Collection<?> entities) {
		getHibernateTemplate().deleteAll(entities);
	}
	
	public <T> T findByPk(Class<T> clazz, Long pk) {
		return (T) getHibernateTemplate().get(clazz.getName(), pk);
	}
	
	public <T> List<T> loadAll(Class<T> clazz) {
		return getHibernateTemplate().loadAll(clazz);
	}
	
	public Session getCurrentSession() {
		return getHibernateTemplate().getSessionFactory().getCurrentSession();
	}
	
	public long countAll(final Class<?> clazz) {
		return getHibernateTemplate().execute(new HibernateCallback<Long>() {
			@Override
			public Long doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("SELECT COUNT(c) FROM " + clazz.getName() + " c");
				return (Long) query.uniqueResult();
			}
		});
	}
	
	public <T> List<T> loadMax(final Class<T> clazz, final int max, final boolean asc, String orderField) {
		return getHibernateTemplate().executeFind(new HibernateCallback<T>() {
			@Override
			public T doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuilder sql = new StringBuilder();
				sql.append("FROM ").append(clazz.getName()).append(" o ");
				sql.append("ORDER BY ");
				if (!asc)
					sql.append("DESC");
				Query query = session.createQuery(sql.toString());
				query.setMaxResults(max);
				return (T) query.list();
			}
		});
	}
	
}