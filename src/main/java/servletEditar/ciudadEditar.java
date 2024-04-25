package servletEditar;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Ciudad;
import modelo.bean.Deportista;
import modelo.dao.ModeloCiudad;
import modelo.dao.ModeloDeportista;

/**
 * Servlet implementation class ciudadEdotar
 */
@WebServlet("/ciudadEditar")
public class ciudadEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ciudadEditar() {
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
		String nombre = request.getParameter("editNombre");
		String ubicacionGeografica = request.getParameter("editUbicacion");
		int poblacion = Integer.parseInt(request.getParameter("editPoblacion"));
		int id = Integer.parseInt(request.getParameter("editId"));
		
		ModeloCiudad mc = new ModeloCiudad();
		Ciudad ciudad = new Ciudad(id, nombre, ubicacionGeografica, poblacion);
		
		if(mc.editarCiudad(ciudad)) {
			System.out.println("editado");
			
		}else {
			System.out.println("error");
		}
		response.sendRedirect("ciudad");
		
		
	}
	}


