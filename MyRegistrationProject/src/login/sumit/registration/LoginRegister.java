package login.sumit.registration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginRegister")
public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginRegister() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDAO ud = new UserDAOImpl();
		String userName = request.getParameter("username");
		String password = request.getParameter("password1");
		String submitType = request.getParameter("submit");
		
		User u = ud.getUser(userName, password);
		User su = ud.searchUser(userName);
		
		if(submitType.equals("login") && (u != null) && (u.getName() != null) ) {
			request.setAttribute("message", u.getName());
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
			
		}else if(submitType.equals("register") && (su.getName() == null)) {
			u.setName(request.getParameter("name"));
			u.setPassword(password);
			u.setUsername(userName);
			ud.insertUser(u);
			
			request.setAttribute("successMessage", "Registration successful! Please login ^^");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}else if(submitType.equals("register") && (su.getName() != null)) {
			request.setAttribute("message", su.getUsername() + " aleady exists. Please select another username or login.");
			//request.setAttribute("message", "User name already exists. Please select another or login.");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "Data NOT found, please register first!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
