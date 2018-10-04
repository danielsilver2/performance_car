package br.univille.projetoperformance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity(name="clients")
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length=10000)
	private long id;
	private String name;
	private String cpf;
	private String phone;
	@Column(length=100)
	private long postal_code;
	@Column(length=100)
	private long house_number;

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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public long getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(long postal_code) {
		this.postal_code = postal_code;
	}
	public long getHouse_number() {
		return house_number;
	}
	public void setHouse_number(long house_number) {
		this.house_number = house_number;
	}
}
