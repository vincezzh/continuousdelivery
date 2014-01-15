package com.vince.cd.cd_dao.dao;

import org.junit.runner.RunWith;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
  
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })  
/* 
 * if change the name of transactionManager,it need add code as bellow: for 
 * example you define the transactionManager's name is txManager,you must add 
 * the following code 
 *  
 * @Transactional 
 *  
 * @TransactionConfiguration(transactionManager = "txManager", defaultRollback 
 * =true) 
 */  
public abstract class AbstractTestCase extends AbstractTransactionalJUnit4SpringContextTests {  
  
} 