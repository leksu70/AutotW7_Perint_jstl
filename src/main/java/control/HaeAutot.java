package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Auto;
import model.dao.Dao;

@WebServlet("/haeautot")
public class HaeAutot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public HaeAutot() {
        super();
        System.out.println("HaeAutot.HaeAutot()");
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HaeAutot.doGet()");
		String hakusana = request.getParameter("hakusana");			
		Dao dao = new Dao();			
		try {
			ArrayList<Auto> autot = dao.listaaKaikki(hakusana);
			System.out.println(autot);			
			request.setAttribute("autot", autot);			
			String jsp = "/listaaautot.jsp"; 
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);			   
		} catch (Exception e) {				
			e.printStackTrace();
		}					
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HaeAutot.doPost()");
	}

}
