package servletAgregar;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Ciudad;
import modelo.dao.ModeloCiudad;

/**
 * Servlet implementation class ciudadAgregar
 */
@WebServlet("/ciudadAgregar")
public class ciudadAgregar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ciudadAgregar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("addNombre");
		String ubicacionGeografica = request.getParameter("addUbicacion");
		int poblacion = Integer.parseInt(request.getParameter("addPoblacion"));
		
		
		ModeloCiudad mc = new ModeloCiudad();
		Ciudad ciudad = new Ciudad( nombre, ubicacionGeografica, poblacion);
		
		if(mc.insertCiudad(ciudad)) {
			System.out.println("creado");
			response.sendRedirect("ciudad?msg=agregado");
			
		}else {
			System.out.println("error");
			response.sendRedirect("ciudad?msg=error");
		}
		
	}

}
