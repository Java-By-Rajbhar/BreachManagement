package com.maggie.app.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.maggie.app.entity.BusinessArea;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FranchiseResponseDto implements Serializable{

	
	private static final long serialVersionUID = 7731935079293339854L;
	
	
	private Long franchiseId;
	private String franchiseName;
	private List<BusinessArea> businessArea;
	
}
