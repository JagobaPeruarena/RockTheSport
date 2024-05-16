package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Ciudad;
import modelo.bean.Organizador;
import modelo.dao.ModeloCiudad;
import modelo.dao.ModeloOrganizador;

/**
 * Servlet implementation class organizador
 */
@WebServlet("/organizador")
public class organizador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public organizador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // Instanciar el modelo de ciudad
        ModeloOrganizador mo= new ModeloOrganizador();
        
        // Obtener la lista de ciudades desde el modelo
        ArrayList<Organizador> organizadores = mo.getAll();
        
        // Pasar la lista de ciudades al JSP
        request.setAttribute("organizadores", organizadores);
        request.setAttribute("msg", request.getParameter("msg"));
        // Redirigir a la página JSP para mostrar los datos
        request.getRequestDispatcher("organizador.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
