package br.com.msansone.mstocks.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.msansone.mstocks.models.Segmento;

public class SegmentoDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Segmento> listaTodos(){

		List<Segmento> lista = em.createQuery("SELECT b FROM Segmento b").getResultList();
		return lista;
	}

}
