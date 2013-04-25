package com.cdoe.biz.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.cdoe.biz.IDistrictDetailDAO;
import com.cdoe.biz.model.OrganizationUnitMaster;
import com.cdoe.db.hibernate.HibernateDAO;


@SuppressWarnings("unchecked")
public class DistrictDetailDAO extends HibernateDAO  implements  IDistrictDetailDAO {
	
	public List<OrganizationUnitMaster> getAllDistricts() {
		 return getHibernateTemplate().executeFind(new HibernateCallback<List<OrganizationUnitMaster>>() {

				@Override
				public List<OrganizationUnitMaster> doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery("FROM OrganizationUnitMaster o ");
					return (List<OrganizationUnitMaster>) query.list();
				}
			});
		
	}
	
	public List<OrganizationUnitMaster> lookUpDistrict(final String districtCode) {
		 return getHibernateTemplate().executeFind(new HibernateCallback<List<OrganizationUnitMaster>>() {

				@Override
				public List<OrganizationUnitMaster> doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery("FROM OrganizationUnitMaster o where o.organizationCode = :districtCode");
					query.setParameter("districtCode", (String) districtCode);
					return (List<OrganizationUnitMaster>) query.list();
				}
			});
		
	}

}
