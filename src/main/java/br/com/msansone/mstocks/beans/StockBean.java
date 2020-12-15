package br.com.msansone.mstocks.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.msansone.mstocks.dao.SegmentoDao;
import br.com.msansone.mstocks.dao.StockDao;
import br.com.msansone.mstocks.models.Segmento;
import br.com.msansone.mstocks.models.Stock;

@Named
@RequestScoped
public class StockBean {
	
	@Inject
	private StockDao stockDao;
	
	@Inject 
	private SegmentoDao segmentoDao;
	
	private Stock stock= new Stock();
	
	private List<Long> autoresId = new ArrayList<Long>(); 
	
	@Transactional
	public String salvar() {	
		autoresId.stream().forEach(s -> stock.getSegmentos().add(new Segmento(s)));
		stockDao.salvar(stock);
		System.out.println("Stock salva: " + stock);
		//stock= new Stock();
		//autoresId= new ArrayList<Long>();
		
		
		/*
		 * ?faces-redirect=true transforma forward em redirect
		 * no forward o post é refeito e o dado diplicado
		 * no redirext o browser faz o redirect
		 * */
		return "/stock/lista?faces-redirect=true";
	}
	
	public List<Segmento> getSegmentos(){
		List<Segmento> lista = segmentoDao.listaTodos();
		return lista;
	}
	

	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public List<Long> getAutoresId() {
		return autoresId;
	}
	public void setAutoresId(List<Long> autoresId) {
		this.autoresId = autoresId;
	}
	
	

}
