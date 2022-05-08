package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.Dao;

@WebServlet("/poistaauto")
public class PoistaAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public PoistaAuto() {
        super();
        System.out.println("PoistaAuto.PoistaAuto()");
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PoistaAuto.doGet()");
		String rekno = request.getParameter("rekno");
		Dao dao = new Dao();
		dao.poistaAuto(rekno);
		response.sendRedirect("haeautot?hakusana=");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PoistaAuto.doPost()");
		doGet(request, response);
	}

}
