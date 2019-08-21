package com.maggie.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Risk implements Serializable {

	private static final long serialVersionUID = 777193507939333999L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int riskId;
	private String Franchise;
	private String BusinessArea;
	private String BreachCategory;
	private String riskProfile;
}
