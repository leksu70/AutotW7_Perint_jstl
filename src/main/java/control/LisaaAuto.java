package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Auto;
import model.dao.Dao;

@WebServlet("/lisaaauto")
public class LisaaAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
          
    public LisaaAuto() {
        super(); 
        System.out.println("LisaaAuto.LisaaAuto()");
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LisaaAuto.doGet()");		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LisaaAuto.doPost()");
		
		// POST v�litt�� skandit oikein, jota url (GET) tee
		Auto auto = new Auto();
		auto.setRekno(request.getParameter("rekno"));
		auto.setMerkki(request.getParameter("merkki"));
		auto.setMalli(request.getParameter("malli"));
		auto.setVuosi(Integer.parseInt(request.getParameter("vuosi")));
		Dao dao = new Dao();
		dao.lisaaAuto(auto);
		response.sendRedirect("haeautot?hakusana=" + auto.getRekno());
	}

}
