package servletEliminar;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.ModeloOrganizador;

/**
 * Servlet implementation class organizadorEliminar
 */
@WebServlet("/organizadorEliminar")
public class organizadorEliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public organizadorEliminar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ModeloOrganizador mdo = new ModeloOrganizador();
		int IdOrganizdor = Integer.parseInt(request.getParameter("idOrganizador"));
		
		boolean eliminado = mdo.eliminarOrganizador(IdOrganizdor);
		if (eliminado) {
			response.sendRedirect("organizador?msg=eliminado");
		}else {
			response.sendRedirect("organizador?msg=error");
		}
	}

	

}
