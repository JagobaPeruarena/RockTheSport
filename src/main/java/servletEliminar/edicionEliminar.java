package servletEliminar;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.ModeloEdicion;

/**
 * Servlet implementation class edicionEliminar
 */
@WebServlet("/edicionEliminar")
public class edicionEliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edicionEliminar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ModeloEdicion mde = new ModeloEdicion();
		int IdEdicion = Integer.parseInt(request.getParameter("idEdicion"));
		
		Boolean eliminado = mde.eliminarEdicion(IdEdicion);
		
		if (eliminado) {
			response.sendRedirect("edicion");
		}else {
			response.getWriter().println("No se pudo eliminar la Edicion con id"+IdEdicion);
		}
	}

	
}
