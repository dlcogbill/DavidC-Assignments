package com.dcogbill.DojosNinjasAssignment.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ninjas")
public class Ninja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;
	
	@NotNull
    @Size(min = 2, max = 20)
    private String firstName;
	
	@NotNull
    @Size(min = 2, max = 20)
    private String lastName;
	
	@NotNull
    private Integer age;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    private Dojo dojo;
	
	public Ninja() {
	}
	
	public Ninja( String firstName, String lastName, Integer age) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		
	}

	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}

	public Dojo getDojo() {
		return dojo;
	}

	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String last_name) {
		this.lastName = last_name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	

}
