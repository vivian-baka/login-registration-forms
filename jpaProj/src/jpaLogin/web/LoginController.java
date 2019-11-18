package jpaLogin.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jpaLogin.dao.UserDao;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao loginDao;

    public void init() {
        loginDao = new UserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
        	System.out.println("before authenticate LoginController");
            authenticate(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response)
    throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (loginDao.validate(username, password)) {
        	//System.out.println("in authenticate->validate of LoginController");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login-success.jsp");
            dispatcher.forward(request, response);
        } else {
        	//System.out.println("in else of authenticate LoginController");
        	request.setAttribute("message", "Login failed! Register or try again...");
    		request.getRequestDispatcher("register.jsp").forward(request, response);
            throw new Exception("Login not successful..");
        }
    }
}