package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Edicion;
import modelo.bean.Genero;
import modelo.dao.ModeloEdicion;

/**
 * Servlet implementation class PanelDeInicio3
 */
@WebServlet("/PanelDeInicio3")
public class PanelDeInicio3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PanelDeInicio3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    ModeloEdicion me = new ModeloEdicion();
	    
	    int edicionId = Integer.parseInt(request.getParameter("edicionId"));
	    Genero[] generos = Genero.values();
	    Edicion edicion = me.select(edicionId);
	    
	    request.setAttribute("edicion", edicion); 
	    request.setAttribute("generos", generos);
	  
	    request.getRequestDispatcher("PanelDeInicio3.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

}
