package hibernate;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Userdao;
import model.user;



/**
 * Servlet implementation class loginControler
 */
@WebServlet("/login")
public class loginControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("username");
		String password = request.getParameter("password");		
	    System.out.println(name);
	    user user= new user();
	    user.setName(name);
	    user.setPassword(password);
	    Userdao userdao=new Userdao();
	   if(userdao.login(user))
	   {
		    System.out.println("Connect");
		    RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
	   }   
		}

}
