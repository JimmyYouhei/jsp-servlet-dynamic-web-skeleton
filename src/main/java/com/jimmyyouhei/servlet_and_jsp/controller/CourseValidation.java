package com.jimmyyouhei.servlet_and_jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jimmyyouhei.servlet_and_jsp.reusable.ErrorCommand;
import com.jimmyyouhei.servlet_and_jsp.reusable.RequestCommand;
import com.jimmyyouhei.servlet_and_jsp.reusable.StringCommand;

/**
 * Servlet implementation class CourseValidation
 */
@WebServlet("/CourseValidation")
public class CourseValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(checkCourseFormNotOk(request,response)) {
			RequestCommand.redirectToPage(request, response, "CourseForm.jsp");
		} else {
			RequestCommand.redirectToPage(request, response, "showInfor.jsp");
		}

		
	}
	
	private boolean checkCourseFormNotOk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean error = false;
		
		String fullName = request.getParameter("fullName");
		Integer age = null;
		
		String nation = request.getParameter("nation");
		String [] courses = request.getParameterValues("courses");
		String [] languages = request.getParameterValues("languages");
		
		if(checkFullnameOk(fullName)) {
			request.setAttribute("fullName", fullName);
		} else {
			error = ErrorCommand.notifyError(request, "fullNameError");
		}
		
		
		if(ageInputtedNotANumber(request)) {
			error = ErrorCommand.notifyError(request, "ageError");
		} else {
			age = Integer.valueOf(request.getParameter("age"));
			
			if(age <= 18 || age>=40) {
				error = ErrorCommand.notifyError(request, "ageError");
			} else {
				request.setAttribute("age", age);
			}
		}
		
		
		if(nationIsChoosenProperly(nation)) {
			request.setAttribute("nation", nation.strip());
		} else {
			error = ErrorCommand.notifyError(request, "nationError");
		}
		
		
		if(courses == null) {
			error = ErrorCommand.notifyError(request, "courseError");
		} else {
			request.setAttribute("courses", StringCommand.convertStringArrayToText(courses));
		}
		
		if(languages == null) {
			error = ErrorCommand.notifyError(request, "languageError");
		} else {
			request.setAttribute("languages", StringCommand.convertStringArrayToText(languages));
		}
		
		return error;
		
	}

	private boolean nationIsChoosenProperly(String nation) {
		
		boolean result = true;
		
		if(nation.strip().equals("")) {
			result = false;
		}
			
		return result;
		
	}

	private boolean ageInputtedNotANumber(HttpServletRequest request) {
		
		if(request.getParameter("age").strip().equals("")) {
			return true;
		} else {
			return false;
		}
	}

	private boolean checkFullnameOk(String fullName) {
		
		if(fullName.strip().equals("")) {
			return false;
		}
		
		for(int i = 0 ; i<10 ; i++) {
			
			if(fullName.contains(String.valueOf(i))) {
				return false;
			}
	
		}
		
		return true;
		
	}
	
	private void sendBackToCourseForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("CourseForm.jsp");
		dispatcher.forward(request, response);
		
	}

}
