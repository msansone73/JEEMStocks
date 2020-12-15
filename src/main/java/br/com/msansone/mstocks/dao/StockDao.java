package br.com.msansone.mstocks.dao;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.msansone.mstocks.models.Stock;


public class StockDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void salvar(Stock stock) {
		if (stock.getLastValue()!=null) {
			System.out.println("setting last value date");
			stock.setLastValueDate(LocalDateTime.now());
		}
		System.out.println("stock to save = "+ stock);
		em.persist(stock);
	}
	
	

}
