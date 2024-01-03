package com.vivek.master.model;

import com.vivek.commonutils.BaseModelwithID;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Course extends BaseModelwithID {
	
	
	private String name;
	private int branch_id;
//	private String duration;
	

}
