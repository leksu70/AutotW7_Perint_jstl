package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Auto;
import model.dao.Dao;

@WebServlet("/muutaauto")
public class MuutaAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
          
    public MuutaAuto() {
        super();
        System.out.println("MuutaAuto.MuutaAuto()");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MuutaAuto.doGet()");
		String rekno = request.getParameter("rekno");
		Dao dao = new Dao();
		Auto auto = dao.etsiAuto(rekno);
		request.setAttribute("auto", auto);			
		String jsp = "/muutaauto.jsp"; 
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MuutaAuto.doPost()");
		Auto auto = new Auto();
		auto.setRekno(request.getParameter("rekno"));
		auto.setMerkki(request.getParameter("merkki"));
		auto.setMalli(request.getParameter("malli"));
		auto.setVuosi(Integer.parseInt(request.getParameter("vuosi")));
		Dao dao = new Dao();
		dao.muutaAuto(auto, request.getParameter("vanharekno"));
		response.sendRedirect("haeautot?hakusana=" + auto.getRekno());
	}

}
