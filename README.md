# jsp-servlet-dynamic-web-skeleton
 
 ## Introduction
 
 This is my assignment 2 of Funix about buiding an dynamic website skeleton with jsp and servlet
 
 ## Version
 
-	Java 12
-	Spring Tool Suite 4 (Version: 4.3.2.RELEASE) 
-	Maven (version 3.6.1)
-	Tomcat (version 9.0.22) but not included in this assignment. As a result please download yourself 
-	Bootstrap (version 4.3.1)
- Other components are used according to “pom.xml” in each project

## How to install
please import as a maven project

## Project detail

-	Although bootstrap is used on every page, I knew that my design skill is lacking. In fact , I hate design (except software design). As a result, I can’t think of anything so just using like that to prove I know bootstrap 
-	The project follows the MVC architecture with “MainServlet” and ”CourseValidation” as Controller and other JSP as View
-	All page is responsive except the login page
-	Other JSP file in “parts” folder is to be included inside other JSP file (as required by Funix)
-	JSTL is used inside every View JSP
-	The project is coded so that only after successfully login user can acess other page 
-	A replreasentative of session is coded . However compare to a session in Spring projects this type of “session” is awfully lacking
-	However unlike the spring projects below I forgot to restrict access of admin page to admin user only (and I saw no requirement from Funix plus making 3 extra spring projects below really hard especially the config)

## Possible issue
-	Minimal testing and only follow Funix requirement. And not yet trying to break the system by myself so there maybe bug outside of Funix Requirement

## Known Issue
-	Bad front-end design: I hate graphic design so please 
