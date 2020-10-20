package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Patient;

public class AddPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddPatientServlet() {
		super();
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		List<Patient> listPatient = new ArrayList<Patient>();

		if (session.getAttribute("listPatient") != null) {
			listPatient = (List<Patient>) session.getAttribute("listPatient");
		}

		listPatient.add(new Patient(request.getParameter("name").toUpperCase(), request.getParameter("dob"),
				request.getParameter("address").toUpperCase(), request.getParameter("phone")));

		session.setAttribute("listPatient", listPatient);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/confirm.jsp");
		dispatcher.forward(request, response);
	}

}
