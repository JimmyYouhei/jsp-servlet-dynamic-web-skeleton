package com.jimmyyouhei.servlet_and_jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jimmyyouhei.servlet_and_jsp.bean.UserBean;
import com.jimmyyouhei.servlet_and_jsp.entity.UserAuthority;
import com.jimmyyouhei.servlet_and_jsp.reusable.RequestCommand;

/**
 * Servlet implementation class A2Servlet
 */
@WebServlet("/A2Servlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserBean user = null;
       

    public MainServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String command = request.getParameter("command");
		
			switch(command) {
			
				case "firstLogin":
					toLoginPage(request,response);
					break;
					
				case "backToMainPage":
					toMainPage(request, response);
					break;
				
				case "logout":
					logout(request, response);
					break;
					
				case "page2":
					RequestCommand.redirectToPage(request, response, "page2.jsp");
					break;
			}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("userSession");
		request.setAttribute("logout", true);
		toLoginPage(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		checkUsernameAndPassword(request,response);
		
	}

	private void checkUsernameAndPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		user = UserBean.validateUser(username, password);
		
		switch(user.getUserAuthority()) {
		
			case NORMAL:
				registerUserToSession(user , request);
				toMainPage(request, response);
				break;
				
			case ADMIN:
				registerUserToSession(user , request);
				toCourseForm(request, response);
				break;
				
			default:
				sendBackToLogin(request, response);
		}
			
		
	}

	private void registerUserToSession(UserBean user2, HttpServletRequest request) {
		request.getSession().setAttribute("userSession", user2);
	}

	private void sendBackToLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("loginError", true);
		RequestCommand.redirectToPage(request, response, "login.jsp");
		
	}

	private void toMainPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestCommand.redirectToPage(request, response, "page1.jsp");
		
	}
	
	private void toLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestCommand.redirectToPage(request, response, "login.jsp");
		
	}
	
	private void toCourseForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestCommand.redirectToPage(request, response, "CourseForm.jsp");
	}
	


}
