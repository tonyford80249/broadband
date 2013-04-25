package com.cdoe.biz.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.cdoe.biz.IOrganizationUnitMasterDAO;
import com.cdoe.biz.model.OrganizationUnitMaster;
import com.cdoe.db.hibernate.HibernateDAO;

@SuppressWarnings("unchecked")
public class OrganizationUnitMasterDAO extends HibernateDAO implements
		IOrganizationUnitMasterDAO {

	/**
	 * Returns a list of all organizations of type 'DISTRICT', and some other
	 * qualifying districts
	 * 
	 * @return
	 */
	public List<OrganizationUnitMaster> getAllOrganizations() {
		Session session = getCurrentSession();
		Query query = session
				.createQuery("FROM OrganizationUnitMaster o where o.organizationUnitType in ('DISTRICT', 'CSI', 'SFATRAN')  and   substr(o.organizationCode, 0,1) != 't' OR organizationCode = '9025'");
		return (List<OrganizationUnitMaster>) query.list();
	}

	/**
	 * Returns an OrganizationUnitMaster based on its code
	 * 
	 * @param organizationCode
	 * @return
	 */
	public OrganizationUnitMaster lookUpOrganization(String organizationCode) {
		Session session = getCurrentSession();
		Query query = session
				.createQuery("FROM OrganizationUnitMaster o where o.organizationCode = :organizationCode");
		query.setParameter("organizationCode", organizationCode);
		return (OrganizationUnitMaster) query.uniqueResult();
	}

	@Override
	public List<OrganizationUnitMaster> getOrganizationsByType(
			String organizationType) {
		
		 Session session = getCurrentSession(); 
                 Query query = session.createQuery("FROM OrganizationUnitMaster o where o.organizationUnitType in(:organizationType, 'CSI') and   substr(o.organizationCode, 0,1) != 't'"); query.setParameter("organizationType", organizationType); 
                 return (List<OrganizationUnitMaster>) query.list();
		 
            
		//return getOrganizations(organizationType);
	}

//	private Connection getConnection() throws Exception {
//		Connection c = null;
//		try {
//		 c = DriverManager.getConnection(
//				"jdbc:oracle:thin:@ods-dev:1521:odsd", "STATE_EQUAL_OWNER","state_equal_owner");
//		} catch (Exception e) {
//			System.out.println(e);
//
//		}
//		return c;
//	}
//
//	private void closeConnection(Connection c) throws Exception {
//		c.close();
//	}

//	public List<OrganizationUnitMaster> getOrganizations(String organizationType) {
//		ResultSet rs = null;
//		List<OrganizationUnitMaster> distList = new ArrayList<OrganizationUnitMaster>();
//		try {
//			Connection connection = getConnection();
//
//			String sql = "Select * FROM DEVDETAILMGR.Organization_Unit_Master o where o.organization_Unit_Type in (?, 'CSI') and   substr(o.organization_Code, 0,1) != 't'";
//			PreparedStatement s = connection.prepareStatement(sql);
//
//			s.setString(1, organizationType);
//			rs = s.executeQuery();
//			while (rs.next()) {
//				OrganizationUnitMaster distInfo = new OrganizationUnitMaster();
//				distInfo.setOrganizationCode(rs.getString("ORGANIZATION_CODE"));
//				distInfo.setOrganizationName(rs.getString("ORGANIZATION_NAME"));
//				distList.add(distInfo);
//			}
//
//		} catch (Exception e) {
//
//		} finally {
//			try {
//				rs.close();
//
//			} catch (Exception e) {
//				System.out.println(e);
//
//			}
//
//		}
//
//		// Statement s = Statement.;
//		return distList;
//
//	}
}
