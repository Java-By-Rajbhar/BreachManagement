package com.maggie.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
public class User implements Serializable{

	private static final long serialVersionUID = 7771935079393339853L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	@OneToOne
	private Role role;
	private String password;
	
}
