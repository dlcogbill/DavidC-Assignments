package com.dcogbill.SaveTravels.Models;

import java.text.DecimalFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="expenses")
public class Expense {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;
	
	@NotNull(message = "This field should not be empty")
	@Size(min=1, max=200, message="This field should not be empty")
    private String name;
	
	@NotNull(message = "This field should not be empty")
	@Size(min=1, max=200, message="This field should not be empty")
    private String vendor;
	
	@NotNull(message = "This field should not be empty")
	@Min(value=0, message = "This field should be more than 0.0")
	private float amount;
	
	@NotNull(message = "This field should not be empty")
	@Size(min=1, max=300, message="This field should not be empty")
    private String description;
	
	@NotNull
	private String price;
	
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date created_at;
    
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updated_at;
	
	public Expense() {
	}
	
	public Expense(String name, String vendor, float amount, String description) {
		
		this.name = name;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}
	
	@PrePersist
	protected void onCreate(){
		this.created_at = new Date();
	}
	
	@PreUpdate
	protected void onUpdate(){
		this.updated_at = new Date();
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		DecimalFormat myFormatter = new DecimalFormat("$###.00");
        this.price = myFormatter.format(this.amount);
		return price;
	}
	

}
