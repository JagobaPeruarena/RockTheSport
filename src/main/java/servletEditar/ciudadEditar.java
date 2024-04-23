package servletEditar;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ciudadEdotar
 */
@WebServlet("/ciudadEdotar")
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
		 // Obtener el ID de la ciudad que se va a editar desde los parámetros de la solicitud
        int ciudadId = Integer.parseInt(request.getParameter("id"));
        
        // Puedes pasar el ID a la página Ciudad.jsp como un atributo de solicitud
        request.setAttribute("ciudadId", ciudadId);
        
        // Redirigir a la página Ciudad.jsp donde ya tienes el formulario de edición
        request.getRequestDispatcher("Ciudad.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
