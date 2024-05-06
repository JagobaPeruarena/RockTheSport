package servletEditar;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Organizador;
import modelo.dao.ModeloOrganizador;

/**
 * Servlet implementation class organizadorEditar
 */
@WebServlet("/organizadorEditar")
public class organizadorEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public organizadorEditar() {
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
		// TODO Auto-generated method stub
		String nombre = request.getParameter("editNombre");
		String email = request.getParameter("editEmail");
		int telefono = Integer.parseInt(request.getParameter("editTelefono"));
		String dni = request.getParameter("editDNI");
		int id = Integer.parseInt(request.getParameter("editId"));
		
		ModeloOrganizador mdo = new ModeloOrganizador();
		Organizador organizador = new Organizador(id, nombre, email, telefono, dni);
		
		if (mdo.actualizarOrganizador(organizador)) {
			System.out.println("editado");
		}else {
			System.out.println("error");
		}
		response.sendRedirect("organizador");
		
	}

}
