package com.maggie.app.entity;

import java.io.Serializable;

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
public class Role implements Serializable{

	private static final long serialVersionUID = 7771935079393339854L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long roleId;
	private String roleName;
	
}
