package com.vivek.master.model;

import com.vivek.commonutils.BaseModelwithID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class State extends BaseModelwithID {
	
	private String name;

	@Override
	public String toString() {
		return "State [name=" + name + "]";
	}

	
	}
