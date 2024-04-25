package servletAgregar;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Deportista;
import modelo.dao.ModeloDeportista;

/**
 * Servlet implementation class deportistaAgregar
 */
@WebServlet("/deportistaAgregar")
public class deportistaAgregar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deportistaAgregar() {
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
		String nombre = request.getParameter("addNombre");
		int edad = Integer.parseInt(request.getParameter("addEdad"));
		String genero =request.getParameter("addGenero");
		String email = request.getParameter("addEmail");
		int telefono = Integer.parseInt(request.getParameter("addTelefono"));
		String dni = request.getParameter("addDNI");
		
		
		ModeloDeportista mdd = new ModeloDeportista();
		Deportista deportista = new Deportista( nombre, edad, genero, email, telefono, dni);
		
		if(mdd.insertDeportista(deportista)) {
			System.out.println("creado");
			
		}else {
			System.out.println("error");
		}
		response.sendRedirect("deportista");
		
		
	}

}
