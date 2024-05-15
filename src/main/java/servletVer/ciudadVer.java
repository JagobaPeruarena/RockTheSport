package servletVer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Ciudad;
import modelo.bean.Edicion;
import modelo.dao.ModeloCiudad;
import modelo.dao.ModeloEdicion;

/**
 * Servlet implementation class ciudadVer
 */
@WebServlet("/ciudadVer")
public class ciudadVer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ciudadVer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Instanciar el modelo de ciudad
        ModeloCiudad mc= new ModeloCiudad();
        ModeloEdicion mde = new ModeloEdicion();
        int idCiudad = Integer.parseInt(request.getParameter("ciudadId"));
        // Obtener la lista de ciudades desde el modelo
        Ciudad ciudad = mc.select(idCiudad);
        ArrayList<Edicion> edicions = mde.getEdicionsCiudad(idCiudad);
        
        // Pasar la lista de ciudades al JSP
        request.setAttribute("ciudad", ciudad);
        request.setAttribute("ediciones", edicions);
        // Redirigir a la página JSP para mostrar los datos
        request.getRequestDispatcher("verciudad.jsp").forward(request, response);
        }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
