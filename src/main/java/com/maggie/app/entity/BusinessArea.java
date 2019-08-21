package com.maggie.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class BusinessArea implements Serializable{

	private static final long serialVersionUID = 7731935079293339854L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long businessId;
	private String businessName;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="franchiseId")
	private Franchise franchise;
	
}
