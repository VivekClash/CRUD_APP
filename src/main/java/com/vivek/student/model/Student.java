package com.vivek.student.model;

import com.vivek.master.model.City;
import com.vivek.master.model.State;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	private String First_name;
	private String Last_name;
	private String Contact_no;
	private String Email;
	private String Gender;
	private String Address;
	private State state;
	private City city;
	private int date_of_birth;
	

}
