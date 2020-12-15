package br.com.msansone.mstocks.dao;

import java.time.LocalDateTime;
import java.util.List;

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

	public List<Stock> listarTudo() {	

		System.out.println("efetuando listagem... ");
		List<Stock> lista = em.createQuery("select s from Stock s", Stock.class).getResultList();

		return lista;
	
	}
	
	

}
