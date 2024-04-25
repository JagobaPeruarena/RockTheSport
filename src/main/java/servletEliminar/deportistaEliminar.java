package servletEliminar;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.ModeloDeportista;

/**
 * Servlet implementation class deportistaEliminar
 */
@WebServlet("/deportistaEliminar")
public class deportistaEliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deportistaEliminar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ModeloDeportista mdd = new ModeloDeportista();
		 int IdDeportista = Integer.parseInt(request.getParameter("idDeportista"));

	        boolean eliminado =mdd.eliminarDeportista(IdDeportista);

	        if (eliminado) {
	            // Redireccionar a alguna p�gina despu�s de eliminar exitosamente el alumno
	        	
	            response.sendRedirect("deportista");
	        } else {
	            // Manejo si no se puede eliminar el alumno
	            response.getWriter().println("No se pudo eliminar el deportista con ID: " + IdDeportista);
	        }
	}

}
