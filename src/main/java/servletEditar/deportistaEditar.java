package servletEditar;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Deportista;
import modelo.dao.ModeloDeportista;

/**
 * Servlet implementation class deportistaGuardar
 */
@WebServlet("/deportistaEditar")
public class deportistaEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deportistaEditar() {
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
		int edad = Integer.parseInt(request.getParameter("editEdad"));
		String genero =request.getParameter("editGenero");
		String email = request.getParameter("editEmail");
		int telefono = Integer.parseInt(request.getParameter("editTelefono"));
		String dni = request.getParameter("editDNI");
		int id = Integer.parseInt(request.getParameter("editId"));
		
		ModeloDeportista mdd = new ModeloDeportista();
		Deportista deportista = new Deportista(id, nombre, edad, genero, email, telefono, dni);
		
		if(mdd.modificarDeportista(deportista)) {
			System.out.println("editado");
			
		}else {
			System.out.println("error");
		}
		response.sendRedirect("deportista");
		
		
	}

}
