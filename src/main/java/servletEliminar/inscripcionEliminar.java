package servletEliminar;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.ModeloInscripcion;
import modelo.dao.ModeloResultado;

/**
 * Servlet implementation class inscripcionEliminar
 */
@WebServlet("/inscripcionEliminar")
public class inscripcionEliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inscripcionEliminar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ModeloInscripcion mdo = new ModeloInscripcion();
		int idIncrip = Integer.parseInt(request.getParameter("idInscripcion"));

		boolean eliminado = mdo.eliminarInscripcion(idIncrip);
		if (eliminado) {
			response.sendRedirect("inscripcion?msg=eliminado");
		} else {
			response.sendRedirect("inscripcion?msg=error");
		}	}

	

}
