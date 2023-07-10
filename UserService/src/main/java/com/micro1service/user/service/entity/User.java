package com.micro1service.user.service.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "User-microservice")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	
	@Id
	@Column(name="ID")
	private String userId;
	
	@Column(name = "NAME", length = 20)
	private String name;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name = "ABOUT")
	private String about;
	
	@Transient
	private List<Rating> ratings; 
}	
	
	
