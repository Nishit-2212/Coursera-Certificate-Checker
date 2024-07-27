package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("Update_profile")) {
			String name = request.getParameter("name");
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println(name);
			
			LoginDao.updatename(name,id);
			
			request.getRequestDispatcher("logout.jsp").forward(request, response);
		}
		
		if (action.equalsIgnoreCase("Update_password")) {
			String email = request.getParameter("id");
			String pass = request.getParameter("pass");
			String oldp = request.getParameter("op");
			String newp = request.getParameter("np");
			String confirmp = request.getParameter("cp");
			
			
			if(pass.equals(oldp))
			{
				if(newp.equals(confirmp))
				{
					LoginDao.changePassword(email, newp);
					request.getRequestDispatcher("logout.jsp").forward(request, response);
				}
				else
				{
					request.setAttribute("msg", "new password and confirm passworn does not match");
					request.getRequestDispatcher("accountpaschange.jsp").forward(request, response);
				}
			}
			else
			{
				request.setAttribute("msg", "Incorrect old Password");
				request.getRequestDispatcher("accountpaschange.jsp").forward(request, response);
			}
			
			
			
		}
		
	}

}
