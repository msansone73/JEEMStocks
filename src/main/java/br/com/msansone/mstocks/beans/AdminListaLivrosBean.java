package br.com.msansone.mstocks.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.msansone.mstocks.dao.StockDao;
import br.com.msansone.mstocks.models.Stock;


//@Named
//@RequestScoped
@Model
public class AdminListaLivrosBean {

	@Inject 
	StockDao stockDao;
	
	private List<Stock> stocks = new ArrayList<Stock>();
		

	public List<Stock> getStocks() {
		return stockDao.listarTudo();
	}

	
	
}
