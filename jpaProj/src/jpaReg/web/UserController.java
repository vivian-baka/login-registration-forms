package jpaReg.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jpaReg.dao.UserDao;
import jpaReg.model.User;


@WebServlet("/UserController")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        register(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.sendRedirect("register.jsp");
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(userDao.userExists(username)) {
        	request.setAttribute("message", "Registration failed. Username already exists.");
    		request.getRequestDispatcher("register.jsp").forward(request, response);
        }
        else {
        	
        	User user = new User();
        	user.setFirstName(firstName);
        	user.setLastName(lastName);
        	user.setUsername(username);
        	user.setPassword(password);

        	userDao.saveUser(user);
        	request.setAttribute("successMessage", "Registration successful! Please login.");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			// RequestDispatcher dispatcher = request.getRequestDispatcher("register-success.jsp");
			// dispatcher.forward(request, response);
        }
    }
}