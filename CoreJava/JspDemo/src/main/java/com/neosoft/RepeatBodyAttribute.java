package com.neosoft;

import java.io.IOException;
import java.io.StringWriter;
import java.time.LocalTime;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class RepeatBodyAttribute extends SimpleTagSupport {

	private String frequency;
	
	
	public String getFrequency() {
		return frequency;
	}


	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}


	@Override
	public void doTag() throws JspException, IOException {
		
		StringWriter sw=new StringWriter();
		getJspBody().invoke(sw);
		
		JspWriter out=getJspContext().getOut();
		String msg=sw.toString();
		StringBuffer temp=new StringBuffer(" ");
		int count =Integer.parseInt(frequency);
		for(int i=1;i<=count;i++) {
			temp=temp.append(msg);
		}
		out.print(temp);
		
	}
	
	
	
}
