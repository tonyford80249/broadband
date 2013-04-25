
package com.cdoe.services;

import org.apache.log4j.Logger;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import static org.junit.Assert.assertEquals;

import com.cdoe.services.stateequal.ICommentsManager;
import com.cdoe.biz.model.equal.CommentInfo;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:applicationContext.xml",
	"classpath:applicationContext-tx.xml",
	"classpath:applicationContext-data.xml",
	"classpath:applicationContext-dao.xml",
	"classpath:applicationContext-hbm.xml",
	"classpath:applicationContext-service.xml",
	"classpath:applicationContext.xml"}, inheritLocations = true)
@TransactionConfiguration(transactionManager = "defaultTransactionManger")
public class TestCommentsManager extends AbstractTransactionalJUnit4SpringContextTests {
	
	private static final Logger logger = Logger.getLogger(TestCommentsManager.class);
	
	@Autowired
	private ICommentsManager commentsManager;
	

	@Test
	public void testCommentInfo() {
		final List<CommentInfo> list = commentsManager.findAll(CommentInfo.class);
		int size1 = list.size();
		
		/* test create */
		final CommentInfo commentInfo = new CommentInfo();
		long id = commentsManager.create(commentInfo);
		
		/* test find */
		final CommentInfo commentInfo2 = commentsManager.findById(CommentInfo.class, id);
		long id2 = commentInfo2.getId();
		assertEquals(id, id2);
		
		/* test find all */
		final List<CommentInfo> list2 = commentsManager.findAll(CommentInfo.class);
		int size2 = list2.size();
		assertEquals(size2, size1 + 1);
		
		/* test delete */
		commentsManager.delete(CommentInfo.class, id);
		final List<CommentInfo> list3 = commentsManager.findAll(CommentInfo.class);
		int size3 = list3.size();
		assertEquals(size1, size3);
	}
	
}