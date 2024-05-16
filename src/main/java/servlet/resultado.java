package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Ciudad;
import modelo.bean.Resultado;
import modelo.dao.ModeloCiudad;
import modelo.dao.ModeloResultado;

/**
 * Servlet implementation class resultado
 */
@WebServlet("/resultado")
public class resultado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public resultado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   // Instanciar el modelo de ciudad
        ModeloResultado mr= new ModeloResultado();
        
        // Obtener la lista de ciudades desde el modelo
        ArrayList<Resultado> resultados = mr.getResultados();
        
        // Pasar la lista de ciudades al JSP
        request.setAttribute("resultados", resultados);
        request.setAttribute("msg", request.getParameter("msg"));
        
        // Redirigir a la página JSP para mostrar los datos
        request.getRequestDispatcher("resultado.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
