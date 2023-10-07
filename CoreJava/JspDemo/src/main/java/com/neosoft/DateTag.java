package com.neosoft;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//custom tag class
public class DateTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		
		JspWriter out=getJspContext().getOut();
		out.print("Now:"+new Date().toString());
	}
}
