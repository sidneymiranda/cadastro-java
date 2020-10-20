package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public LoginServlet() {
		super();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("login");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();
		
		session.setAttribute("login", name);
		session.setAttribute("password", password);

		Cookie cookieLogin = new Cookie("login", name);
		cookieLogin.setMaxAge(60 * 60 * 24 * 3);
		
		response.addCookie(cookieLogin);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
		dispatcher.forward(request, response);
	
	}
}
