package com.neosoft;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class greatingDemo extends SimpleTagSupport{

	@Override
	public void doTag() throws JspException, IOException {
		
		
		StringWriter sw=new StringWriter();
		getJspBody().invoke(sw);
		
		JspWriter out=getJspContext().getOut();
		String msg=sw.toString();
		
		
		Date dt = new Date();
        int hours = dt.getHours();
        int min = dt.getMinutes();

        if(hours>=1 || hours<=12){
            out.print("Hi "+msg+" Good Morning");
        }else if(hours>=12 || hours<=16){
        	out.print("Hi "+msg+" Good Afternoon");
        }else if(hours>=16 || hours<=21){
        	out.print("Hi "+msg+" Good Evening");
        }else if(hours>=21 || hours<=24){
        	out.print("Hi "+msg+" Good Night");
        }
		
		
	}
	
	
}
