package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Ciudad;
import modelo.bean.Edicion;
import modelo.bean.EventoDeportivo;
import modelo.dao.ModeloCiudad;
import modelo.dao.ModeloEdicion;
import modelo.dao.ModeloEventoDeportivo;

/**
 * Servlet implementation class PanelDeInicio2
 */
@WebServlet("/PanelDeInicio2")
public class PanelDeInicio2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PanelDeInicio2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ModeloEdicion me = new ModeloEdicion();
		ModeloCiudad mdc = new ModeloCiudad();
		ModeloEventoDeportivo mded = new ModeloEventoDeportivo();
		String msg = request.getParameter("msg");	
		ArrayList<Edicion> ediciones = me.getEdicions();
		ArrayList<Ciudad> ciudades = mdc.getCiudades();
		ArrayList<EventoDeportivo> eventoDeportivos = mded.getEventos();
		
		request.setAttribute("msg", msg);
		request.setAttribute("ediciones", ediciones);
		request.setAttribute("ciudades", ciudades);
		request.setAttribute("eventoDeportivos", eventoDeportivos);
		
		request.getRequestDispatcher("PanelDeInicio2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
