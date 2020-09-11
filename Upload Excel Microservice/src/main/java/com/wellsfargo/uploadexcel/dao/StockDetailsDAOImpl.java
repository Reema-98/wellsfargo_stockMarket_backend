package com.wellsfargo.uploadexcel.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.wellsfargo.uploadexcel.entity.StockDetailsEntity;

@Repository
public class StockDetailsDAOImpl implements StockDetailsDAO {

	// define field for entity manager
	private EntityManager entityManager;
	
	@Autowired
	public StockDetailsDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<StockDetailsEntity> save(List<StockDetailsEntity> stockDetailsFromExcelList) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		for(StockDetailsEntity singleObjectDetail : stockDetailsFromExcelList) {
		    currentSession.save(singleObjectDetail);
		}
		Query<StockDetailsEntity> theQuery = currentSession.createQuery("from stock_price", StockDetailsEntity.class); 
		List<StockDetailsEntity> stockDetails = theQuery.getResultList();
		return stockDetailsFromExcelList;
	}

//	@Override
//	public List<StockDetailsEntity> findAll() {
//		// Get the current hibernate session
//		Session currentSession = entityManager.unwrap(Session.class);
//		//JPA Alternative: Session is not required, if JPA is used
//		
//		//Create a query 
//		Query<StockDetailsEntity> theQuery = currentSession.createQuery("from stock_price", StockDetailsEntity.class); 
//			//JPA Alternative for Query: import from javax persistence
//			// Query query = entityManager.createQuery("from Employee");
//		
//		//execute query and get result list
//		List<StockDetailsEntity> employees = theQuery.getResultList();
//			//JPA Alternative: employees = query.getResults();
//		
//		//return the results
//		return employees;
//	}
}