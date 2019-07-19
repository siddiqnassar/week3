package com.sapient.productservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@XmlRootElement
@Entity
@Table(name="Product")
@XmlAccessorType(XmlAccessType.FIELD)


public class Product implements Serializable {
	     @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @JsonProperty
	@XmlElement
	@Column(name="prod_id")
	private int id;
	  @XmlElement
	  @Column(name="name")
	 private String name;
	  @XmlElement
	  @Column
	 private double price;
	
	public Product(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	

}
