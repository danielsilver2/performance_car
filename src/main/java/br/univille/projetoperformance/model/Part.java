package br.univille.projetoperformance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="pieces")
public class Part {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length=10000)
	private long id;
	private String name;
	@Column(length=7)
	private Double buyValue;
	@Column(length=7)
	private Double sellValue;
	private String category;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getBuyValue() {
		return buyValue;
	}
	public void setBuyValue(Double buyValue) {
		this.buyValue = buyValue;
	}
	public Double getSellValue() {
		return sellValue;
	}
	public void setSellValue(Double sellValue) {
		this.sellValue = sellValue;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}