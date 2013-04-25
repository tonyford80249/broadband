package com.cdoe.biz.impl.stateequal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import oracle.jdbc.OracleTypes;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.connection.ConnectionProvider;
import org.hibernate.engine.SessionFactoryImplementor;
import com.cdoe.biz.model.equal.CrosswalkAscent;
import com.cdoe.biz.model.equal.CrosswalkCSI;
import com.cdoe.biz.model.equal.CrosswalkCharter;
import com.cdoe.biz.model.equal.CrosswalkESL;
import com.cdoe.biz.model.equal.CrosswalkFreeLunch;
import com.cdoe.biz.model.equal.CrosswalkFteByGrade;
import com.cdoe.biz.model.equal.CrosswalkOnline;
import com.cdoe.biz.model.equal.CrosswalkSOT;
import com.cdoe.biz.stateequal.ICrosswalkCollectionDataDAO;
import com.cdoe.db.hibernate.HibernateDAO;

@SuppressWarnings("unchecked")
public class CrosswalkCollectionDataDAO extends HibernateDAO implements
		ICrosswalkCollectionDataDAO {

	private static final Logger logger = Logger
			.getLogger(CrosswalkCollectionDataDAO.class);

	public String  callCrossWalkProc(String fiscalYear, String crossWalkType)	 {
		CallableStatement cstmt = null;
		Session session = getCurrentSession();
		Connection con = null;
		String returnedMessage = "";
		// session.connection();

		SessionFactoryImplementor sfi = (SessionFactoryImplementor) session.getSessionFactory();
		ConnectionProvider cp = sfi.getConnectionProvider();

		try {
			con = cp.getConnection();
			cstmt = con.prepareCall("Select from dual");
			if ("ASCENT".equalsIgnoreCase(crossWalkType)) {
				logger.debug(" Ascent selected ");
				getAscentData(fiscalYear, cstmt, con);
			} else if ("Charter School Count".equalsIgnoreCase(crossWalkType)) {
				logger.debug(" Charter School Count selected ");
				getCharterData(fiscalYear, cstmt, con);
			} else if ("Free Lunch".equalsIgnoreCase(crossWalkType)) {
				logger.debug(" Free Lunch selected ");
				getFreeLunchData(fiscalYear, cstmt, con);
			} else if ("SOT".equalsIgnoreCase(crossWalkType)) {
				logger.debug("SOT selected ");
				getSOTData(fiscalYear, cstmt, con);
			} else if ("ESL".equalsIgnoreCase(crossWalkType)) {
				logger.debug(" ESL selected ");
				getESLData(fiscalYear, cstmt, con);
			} else if ("Online".equalsIgnoreCase(crossWalkType)) {
				logger.debug(" Online selected ");
				getOnlineData(fiscalYear, cstmt, con);
			} else if ("CSI".equalsIgnoreCase(crossWalkType)) {
				logger.debug(" CSI selected ");
				getCSIData(fiscalYear, cstmt, con);
			} else if ("Student October".equalsIgnoreCase(crossWalkType)){
				logger.debug("Student October ");
				getFteByGradeData(fiscalYear, cstmt, con);
			}  else {
				logger.debug("Invalid option selected");
				returnedMessage = "Invalid option selected - No corresponding procedure found for execute";
			}
			if ("".equals(returnedMessage))
				returnedMessage = "Executing procedure for " + crossWalkType + " upload is successful";
		
		} catch (SQLException sqle) {
			logger.debug("exception received" + sqle);
			returnedMessage = "SQL Exception received executing procedure for " + crossWalkType + "upload is " + sqle.getMessage();
		} catch (Exception e) {
			returnedMessage = "Generic Exception received executing procedure for " + crossWalkType + " upload is " + e.getMessage();
			logger.debug("exception received" + e);
		} finally {
			try {
				if (cstmt != null)
					cstmt.close();
				con.close();
			} catch (SQLException e) {
			}
			
		}
		return returnedMessage;

	}
	
	public List<CrosswalkAscent>  getAscentCrossWalkData(String fiscalYear)	 {
		
		Session session = getCurrentSession();
		Query query = session
				.createQuery("from CrosswalkAscent se where se.fiscalYear = :fiscalYear");
		query.setString("fiscalYear", fiscalYear);
	
		List<CrosswalkAscent> results = query.list();
		if (results != null && results.size() > 0)
			return results;
		else
			return null;
	}

	public List<CrosswalkCharter>  getCharterCrossWalkData(String fiscalYear)	 {
		
		Session session = getCurrentSession();
		Query query = session.createQuery("from CrosswalkCharter se where se.fiscalYear = :fiscalYear");
		query.setString("fiscalYear", fiscalYear);
	
		List<CrosswalkCharter> results = query.list();
		if (results != null && results.size() > 0)
			return results;
		else
			return null;
	}
	
	public List<CrosswalkSOT>  getSOTCrossWalkData(String fiscalYear)	 {
		
		Session session = getCurrentSession();
		Query query = session.createQuery("from CrosswalkSOT se where se.fiscalYear = :fiscalYear");
		query.setString("fiscalYear", fiscalYear);
	
		List<CrosswalkSOT> results = query.list();
		if (results != null && results.size() > 0)
			return results;
		else
			return null;
	}
	
	public List<CrosswalkESL>  getESLCrossWalkData(String fiscalYear)	 {
		
		Session session = getCurrentSession();
		Query query = session.createQuery("from CrosswalkESL se where se.fiscalYear = :fiscalYear");
		query.setString("fiscalYear", fiscalYear);
	
		List<CrosswalkESL> results = query.list();
		if (results != null && results.size() > 0)
			return results;
		else
			return null;
	}
	
	public List<CrosswalkOnline>  getOnlineCrossWalkData(String fiscalYear)	 {
		
		Session session = getCurrentSession();
		Query query = session.createQuery("from CrosswalkOnline se where se.fiscalYear = :fiscalYear");
		query.setString("fiscalYear", fiscalYear);
	
		List<CrosswalkOnline> results = query.list();
		if (results != null && results.size() > 0)
			return results;
		else
			return null;
	}
	
	public List<CrosswalkCSI>  getCSICrossWalkData(String fiscalYear)	 {
		
		Session session = getCurrentSession();
		Query query = session.createQuery("from CrosswalkCSI se where se.fiscalYear = :fiscalYear order by districtNumber, grade_level asc ");
		query.setString("fiscalYear", fiscalYear);
	
		List<CrosswalkCSI> results = query.list();
		if (results != null && results.size() > 0)
			return results;
		else
			return null;
	}
	
	
	public List<CrosswalkFreeLunch>  getFreeLunchData(String fiscalYear)	 {
		
		Session session = getCurrentSession();
		Query query = session.createQuery("from CrosswalkFreeLunch se where se.fiscalYear = :fiscalYear order by districtNumber asc, grade_level asc ");
		query.setString("fiscalYear", fiscalYear);
	
		List<CrosswalkFreeLunch> results = query.list();
		if (results != null && results.size() > 0)
			return results;
		else
			return null;
	}
	
	public List<CrosswalkFteByGrade>  getFteByGradeData(String fiscalYear)	 {
		
		Session session = getCurrentSession();
		Query query = session.createQuery("from CrosswalkFteByGrade cwf where cwf.fiscalYear = :fiscalYear order by districtNumber, grade_level asc ");
		query.setString("fiscalYear", fiscalYear);
	
		List<CrosswalkFteByGrade> results = query.list();
		if (results != null && results.size() > 0)
			return results;
		else
			return null;
	}

	
	private void getAscentData(String fiscalYear, CallableStatement cstmt , Connection con) throws SQLException {
		cstmt = con.prepareCall("{ call STATE_EQUAL_OWNER.UP_CROSSWALK_ASCENT(?,?) }");
		cstmt.setString(1, fiscalYear);
		cstmt.registerOutParameter(2, OracleTypes.VARCHAR);
		cstmt.execute();
		String response = cstmt.getString(2);
		logger.debug(response);
		
	}
	
	private void getCharterData(String fiscalYear, CallableStatement cstmt , Connection con) throws SQLException {
		cstmt = con.prepareCall("{ call STATE_EQUAL_OWNER.UP_CROSSWALK_CHARTER(?) }");
		cstmt.setString(1, fiscalYear);
		cstmt.execute();
		
	}
	
	private void getCSIData(String fiscalYear, CallableStatement cstmt , Connection con) throws SQLException {
		cstmt = con.prepareCall("{ call STATE_EQUAL_OWNER.UP_CROSSWALK_CSI(?) }");
		cstmt.setString(1, fiscalYear);
		cstmt.execute();
		
	}
	
	private void getESLData(String fiscalYear, CallableStatement cstmt , Connection con) throws SQLException {
		cstmt = con.prepareCall("{ call STATE_EQUAL_OWNER.UP_CROSSWALK_ESL(?,?) }");
		cstmt.setString(1, fiscalYear);
		cstmt.registerOutParameter(2, OracleTypes.VARCHAR);
		cstmt.execute();
		String response = cstmt.getString(2);
		logger.debug(response);
		
		
	}
	
	private void getFteByGradeData(String fiscalYear, CallableStatement cstmt , Connection con) throws SQLException {
		cstmt = con.prepareCall("{ call STATE_EQUAL_OWNER.UP_CROSSWALK_FTE(?) }");
		cstmt.setString(1, fiscalYear);
		cstmt.execute();
			
	}
	
	private void getOnlineData(String fiscalYear, CallableStatement cstmt , Connection con) throws SQLException {
		cstmt = con.prepareCall("{ call STATE_EQUAL_OWNER.UP_CROSSWALK_ONLINE(?,?) }");
		cstmt.setString(1, fiscalYear);
		cstmt.registerOutParameter(2, OracleTypes.VARCHAR);
		cstmt.execute();
		String response = cstmt.getString(2);
		logger.debug(response);
		
	}
	
	private void getFreeLunchData(String fiscalYear, CallableStatement cstmt , Connection con) throws SQLException {
		cstmt = con.prepareCall("{ call STATE_EQUAL_OWNER.UP_CROSSWALK_FREE_LUNCH(?) }");
		cstmt.setString(1, fiscalYear);
		cstmt.execute();
		
	}
	
	private void getSOTData(String fiscalYear, CallableStatement cstmt , Connection con) throws SQLException {
		cstmt = con.prepareCall("{ call STATE_EQUAL_OWNER.UP_CROSSWALK_SOT(?) }");
		cstmt.setString(1, fiscalYear);
		cstmt.execute();
		
	}
	
	public void updateAscentTotal(final String districtNos,
			final String fiscalYear, double ascent_tot) throws SQLException {
		
		Session session = getCurrentSession();

		String hql =  "UPDATE FteByGrade set ascentTot = :ascent_tot" 
					+ "WHERE districtNumber = :districtNumber "
					+ "  AND fiscalYear = :fiscalYear ";
		Query query = session.createQuery(hql);
		query.setParameter("districtNumber", districtNos);
		query.setParameter("fiscalYear", fiscalYear);
		query.setParameter("ascentTot", ascent_tot);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
		//return result;
	}
	
	public String  callCrossWalkDataMigrationProc(String fiscalYear, String crossWalkType)	 {
		CallableStatement cstmt = null;
		Session session = getCurrentSession();
		Connection con = null;
		String returnedMessage = "";
		String calledProcedure = null;
		
		SessionFactoryImplementor sfi = (SessionFactoryImplementor) session.getSessionFactory();
		ConnectionProvider cp = sfi.getConnectionProvider();

		try {
			con = cp.getConnection();
			if ("ASCENT".equalsIgnoreCase(crossWalkType)) {
				logger.debug(" Ascent upload ");
				calledProcedure = "call STATE_EQUAL_OWNER.UP_COPY_ASCENT_CROSSWALK_DATA(?)";
			} else if ("Charter School Count".equalsIgnoreCase(crossWalkType)) {
				logger.debug(" Charter School Count upload ");
				calledProcedure = "call STATE_EQUAL_OWNER.UP_COPY_CHARTER_FPC_CS_DATA(?)";
			} else if ("Free Lunch".equalsIgnoreCase(crossWalkType)) {
				logger.debug(" Free Lunch upload ");
				calledProcedure = "call STATE_EQUAL_OWNER.UP_COPY_FREE_LUNCH_CS_DATA(?)";
			} else if ("SOT".equalsIgnoreCase(crossWalkType)) {
				logger.debug("SOT upload ");
				calledProcedure = "call STATE_EQUAL_OWNER.UP_COPY_SOT_CROSSWALK_DATA(?)";
			} else if ("ESL".equalsIgnoreCase(crossWalkType)) {
				logger.debug(" ESL upload ");
				calledProcedure = "call STATE_EQUAL_OWNER.UP_COPY_ESL_CROSSWALK_DATA(?)";
			} else if ("Online".equalsIgnoreCase(crossWalkType)) {
				logger.debug(" Online upload ");
				calledProcedure = "call STATE_EQUAL_OWNER.UP_COPY_ONLINE_CROSSWALK_DATA(?)";
			} else if ("CSI".equalsIgnoreCase(crossWalkType)) {
				logger.debug(" CSI upload ");
				calledProcedure = "call STATE_EQUAL_OWNER.UP_COPY_CSI_CROSSWALK_DATA(?)";
			} else if ("Student October".equalsIgnoreCase(crossWalkType)){
				logger.debug("Student October upload ");
				calledProcedure = "call STATE_EQUAL_OWNER.UP_COPY_FTE_BY_GRADE_CS_DATA(?)";
			}  else {
				logger.debug("Invalid option selected");
				returnedMessage = "Invalid option selected - No corresponding procedure found for execute";
			}
			cstmt = con.prepareCall(calledProcedure);
			cstmt.setString(1, fiscalYear);
			cstmt.execute();
			if ("".equals(returnedMessage))
				returnedMessage = "Execution of procedure for " + crossWalkType + " data upload is successful";
		
		} catch (SQLException sqle) {
			logger.debug("exception received" + sqle);
			returnedMessage = "SQL Exception received while executing procedure for " + crossWalkType + "upload is " + sqle.getMessage();
		} catch (Exception e) {
			returnedMessage = "Generic Exception received while executing procedure for " + crossWalkType + " upload is " + e.getMessage();
			logger.debug("exception received" + e);
		} finally {
			try {
				if (cstmt != null)
					cstmt.close();
				con.close();
			} catch (SQLException e) {
			}
			
		}
		return returnedMessage;

	}
	

	
}
