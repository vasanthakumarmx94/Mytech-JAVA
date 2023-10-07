package com.neosoft;

import java.io.IOException;
import java.io.StringWriter;
import java.time.LocalTime;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TimeBodyTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		
		StringWriter sw=new StringWriter();
		getJspBody().invoke(sw);
		
		JspWriter out=getJspContext().getOut();
		out.print(sw.toString()+":"+LocalTime.now());
		
		
		
		
	}
	
	
}
