package servletEliminar;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.ModeloOrganizador;
import modelo.dao.ModeloResultado;

/**
 * Servlet implementation class resultadoEliminar
 */
@WebServlet("/resultadoEliminar")
public class resultadoEliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public resultadoEliminar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ModeloResultado mdo = new ModeloResultado();
		int idResultado = Integer.parseInt(request.getParameter("idResultado"));

		boolean eliminado = mdo.eliminarResultado(idResultado);
		if (eliminado) {
			response.sendRedirect("resultado?msg=eliminado");
		} else {
			response.sendRedirect("resultado?msg=error");
		}
	}

}
