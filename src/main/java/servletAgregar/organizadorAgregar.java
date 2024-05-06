package servletAgregar;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Organizador;
import modelo.dao.ModeloOrganizador;

/**
 * Servlet implementation class organizadorAgregar
 */
@WebServlet("/organizadorAgregar")
public class organizadorAgregar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public organizadorAgregar() {
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
		String email = request.getParameter("addEmail");
		int telefono = Integer.parseInt(request.getParameter("addTelefono"));
		String dni = request.getParameter("addDNI");
		
		ModeloOrganizador mdo = new ModeloOrganizador();
		Organizador organizador = new Organizador(nombre, email, telefono, dni);
		
		if (mdo.crearOrganizador(organizador)) {
			System.out.println("creado");
		}else {
			System.out.println("error");
		}
		response.sendRedirect("organizador");
	}

}
