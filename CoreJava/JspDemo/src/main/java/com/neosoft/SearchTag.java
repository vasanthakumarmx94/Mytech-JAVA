package com.neosoft;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SearchTag extends SimpleTagSupport {

	private String text;
	private String Case;

	public String getCase() {
		return Case;
	}

	public void setCase(String case1) {
		this.Case = case1;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void doTag() throws JspException, IOException {

		StringWriter sw = new StringWriter();
		getJspBody().invoke(sw);

		JspWriter out = getJspContext().getOut();
		String msg = sw.toString();

		StringBuffer temp = new StringBuffer(" ");
		String searchtext = (text);
		int Case01 = Integer.parseInt(Case);

//		int lastIndex = 0;
//		int count = 0;
//		if(Case01==0) {
//		while (lastIndex != -1) {
//		    lastIndex = msg.indexOf(searchtext,lastIndex);
//
//		    if( lastIndex != -1)
//		        count++;
//
//		    lastIndex += searchtext.length();
//		}
//		System.out.println(count);
//		}
		if (Case01 == 0) {
			int counter = 0;
			String[] splitedmsg = msg.split(" ");
			for (String smg : splitedmsg) {
				if (smg == searchtext) {
					counter++;
				}
			}
			out.print("Number of times java word:" + counter);
		}

	}

}
