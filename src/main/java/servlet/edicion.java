package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Ciudad;
import modelo.bean.EventoDeportivo;
import modelo.bean.Edicion;
import modelo.bean.Genero;
import modelo.dao.ModeloCiudad;
import modelo.dao.ModeloDeportista;
import modelo.dao.ModeloEdicion;
import modelo.dao.ModeloEventoDeportivo;

/**
 * Servlet implementation class edicion
 */
@WebServlet("/edicion")
public class edicion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edicion() {
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
		
		ArrayList<Edicion> ediciones = me.getEdicions();
		ArrayList<Ciudad> ciudades = mdc.getCiudades();
		ArrayList<EventoDeportivo> eventoDeportivos = mded.getEventos();
		
		request.setAttribute("msg", request.getParameter("msg"));
		request.setAttribute("ediciones", ediciones);
		request.setAttribute("ciudades", ciudades);
		request.setAttribute("eventoDeportivos", eventoDeportivos);
		
		request.getRequestDispatcher("edicion.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
