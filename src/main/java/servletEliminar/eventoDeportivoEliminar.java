package servletEliminar;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.ModeloEventoDeportivo;

/**
 * Servlet implementation class eventoDeportivoEliminar
 */
@WebServlet("/eventoDeportivoEliminar")
public class eventoDeportivoEliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eventoDeportivoEliminar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ModeloEventoDeportivo mded = new ModeloEventoDeportivo();
		int IdEventoDeportivo = Integer.parseInt(request.getParameter("idEventoDeportivo"));
		
		boolean eliminado = mded.eliminarEventoDeportivo(IdEventoDeportivo);
		
		if (eliminado) {
			response.sendRedirect("EventoDeportivo");
			
		}else {
			response.getWriter().println("No se pudo eliminar el EventoDeportivo");
		}
	}

	

}
