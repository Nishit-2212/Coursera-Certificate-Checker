package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;
import model.Faculty;
import model.Student;
import services.Servicess;


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
		
		if (action.equalsIgnoreCase("login")) {
			
			
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			
			System.out.println(name);
			System.out.println(password);
			
			
			Student s  = LoginDao.loginUser(name);
			if(s != null) 
			{
				if(s.getPassword().equals(request.getParameter("password")))
				{
					HttpSession session = request.getSession();
					session.setAttribute("s",s);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				else
				{
					request.setAttribute("msg", "Incorrect Password");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}
			else 
			{
				request.setAttribute("msg", "Email not registered");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		
		else if(action.equalsIgnoreCase("login as faculty")) {
			
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			
			System.out.println(name);
			System.out.println(password);
			
			Faculty s = LoginDao.loginFaculty(name);
			
			if(s != null) 
			{
				if(s.getPassword().equals(request.getParameter("password")))
				{
					HttpSession session = request.getSession();
					session.setAttribute("s",s);
					request.getRequestDispatcher("adminhome.jsp").forward(request, response);
				}
				else
				{
					request.setAttribute("msg", "Incorrect Password");
					request.getRequestDispatcher("facultylogin.jsp").forward(request, response);
				}
			}
			else 
			{
				request.setAttribute("msg", "Email not registered");
				request.getRequestDispatcher("facultylogin.jsp").forward(request, response);
			}
		}
		
		else if(action.equalsIgnoreCase("send otp")) {
			String email = request.getParameter("email");
			Boolean flag = LoginDao.checkemail(email);
			
			
			
			if(flag == true) { 
				Random t = new Random();
		    	int minRange = 1000, maxRange= 9999;
	        	int otp = t.nextInt(maxRange - minRange) + minRange;
	        	System.out.println(otp);
	        	Servicess.sendMail(email, otp);
	        	request.setAttribute("otp1", otp);
	        	request.setAttribute("email", request.getParameter("email"));
	        	request.getRequestDispatcher("verify-otp.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("msg", "Email Not Registered");
	        	request.getRequestDispatcher("forgot-password.jsp").forward(request, response);
			}
		}
		
		else if(action.equalsIgnoreCase("verify otp"))
		{
			String email=request.getParameter("email");
			int otp1=Integer.parseInt(request.getParameter("otp1"));
			int otp2=Integer.parseInt(request.getParameter("otp2"));
			if(otp1==otp2)
			{
				request.setAttribute("email", email);
				request.getRequestDispatcher("new-password.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("msg", "Invalid OTP");
				request.setAttribute("otp1", otp1);
	        	request.setAttribute("email", email);
	        	request.getRequestDispatcher("otp.jsp").forward(request, response);
			}
		}
		
		else if(action.equalsIgnoreCase("update password"))
		{
			if(request.getParameter("new_password").equals(request.getParameter("cnew_password")))
			{
				LoginDao.changePassword(request.getParameter("email"), request.getParameter("new_password"));
				request.setAttribute("msg", "Password Updated Successfully");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("msg", "New Password & Confirm New Password Does Not Matched");
				request.getRequestDispatcher("new-password.jsp").forward(request, response);
			}
		}
		
	}

}
