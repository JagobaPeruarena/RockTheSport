package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Ciudad;
import modelo.dao.ModeloCiudad;

/**
 * Servlet implementation class ciudad
 */
@WebServlet("/ciudad")
public class ciudad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ciudad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   // Instanciar el modelo de ciudad
        ModeloCiudad mc= new ModeloCiudad();
        
        // Obtener la lista de ciudades desde el modelo
        ArrayList<Ciudad> ciudades = mc.getCiudades();
        
        // Pasar la lista de ciudades al JSP
        request.setAttribute("msg", request.getParameter("msg"));
        request.setAttribute("ciudades", ciudades);
        
        // Redirigir a la página JSP para mostrar los datos
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
