package com.jimmyyouhei.servlet_and_jsp.reusable;

import javax.servlet.http.HttpServletRequest;

public interface ErrorCommand {

	public static boolean notifyError(HttpServletRequest request , String errorName) {
		RequestCommand.setRequestAttributeToTrue(request, errorName);
		return true;
	}
	
}
