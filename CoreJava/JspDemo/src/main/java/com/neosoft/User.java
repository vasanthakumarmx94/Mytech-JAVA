package com.neosoft;

import java.io.Serializable;

public class User  implements Serializable{

	private static final long serialVersionUID=1L;
	
	private String uname;
	private String upass;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	
	
	
	
	
}
