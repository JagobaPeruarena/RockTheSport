package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Ciudad;
import modelo.bean.Inscripcion;
import modelo.dao.ModeloCiudad;
import modelo.dao.ModeloInscripcion;

/**
 * Servlet implementation class inscripcion
 */
@WebServlet("/inscripcion")
public class inscripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inscripcion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 ModeloInscripcion mi= new ModeloInscripcion();
	        
	        // Obtener la lista de ciudades desde el modelo
	        ArrayList<Inscripcion> inscripciones = mi.getInscripcions();
	        
	        // Pasar la lista de ciudades al JSP
	        request.setAttribute("inscripciones", inscripciones);
	        request.setAttribute("msg", request.getParameter("msg"));
	        
	        // Redirigir a la página JSP para mostrar los datos
	        request.getRequestDispatcher("inscripcion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
