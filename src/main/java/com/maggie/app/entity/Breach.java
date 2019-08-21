package com.maggie.app.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
public class Breach {
	
	private static final long serialVersionUID = 7771935079393339855L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long breachId;
	private String raisedBy;
	private String riskType;
	private String franchise;
	private String businessArea;
	private String status;
	private String breachState;
	private Date reportedDate;
	private String breachCategory;
}




 

