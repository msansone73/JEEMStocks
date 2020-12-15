package br.com.msansone.mstocks.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Stock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code;
	private String name;
	@Lob
	private String description;
	private BigDecimal lastValue;
	private LocalDateTime lastValueDate;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	private List<Segmento> segmentos= new ArrayList<Segmento>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getLastValue() {
		return lastValue;
	}
	public void setLastValue(BigDecimal lastValue) {
		this.lastValue = lastValue;
	}
	public LocalDateTime getLastValueDate() {
		return lastValueDate;
	}
	public void setLastValueDate(LocalDateTime lastValueDate) {
		this.lastValueDate = lastValueDate;
	}
	public List<Segmento> getSegmentos() {
		return segmentos;
	}
	public void setSegmentos(List<Segmento> segmentos) {
		this.segmentos = segmentos;
	}
	@Override
	public String toString() {
		return "Stock [id=" + id + ", code=" + code + ", name=" + name + ", description=" + description + ", lastValue="
				+ lastValue + ", lastValueDate=" + lastValueDate + ", segmentos=" + segmentos + "]";
	}
	
	

}
